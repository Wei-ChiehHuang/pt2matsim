package org.matsim.pt2matsim.run.validation;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordUtils;
import org.matsim.pt.transitSchedule.TransitScheduleReaderV1;
import org.matsim.pt.transitSchedule.api.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class CheckTransitRouteShape {

    private static final Logger log = Logger.getLogger(CheckTransitRouteShape.class);
    private static final Scenario scenario = ScenarioUtils.createScenario(ConfigUtils.createConfig());
    private static TransitScheduleReaderV1 transitScheduleReader;
    //private static final String transitScheduleFile = "D:/code/pt_germany/input/transitSchedule/schedule_de_busMetroTram_220428_unmapped.xml";
    //private static final String transitScheduleFile = "D:/code/pt_germany/input/transitSchedule/schedule_de_busMetroTram_220428_unmapped_modified_v1.xml";
    private static final String transitScheduleFile = "D:/code/pt_germany/input/transitSchedule/schedule_de_busMetroTram_220428_unmapped_modified_v2.xml";

    //private static final String outputCsvFile = "D:/code/pt_germany/input/transitSchedule/linesInfoWithDist_de_busMetroTram_220428_v1.csv";
    //private static final String outputCsvFile = "D:/code/pt_germany/input/transitSchedule/linesInfoWithDist_de_busMetroTram_220428_v2.csv";
    private static final String outputCsvFile = "D:/code/pt_germany/input/transitSchedule/linesInfoWithDist_de_busMetroTram_220428_v3.csv";
    private static int numScannedStops = 0;
    private static int numScannedLines = 0;
    private static int numScannedRoutes = 0;

    public static void main(String[] args) throws FileNotFoundException {

        readTransitSchedule();
        analyzeTransitRoute();

    }

    private static void analyzeTransitRoute() throws FileNotFoundException {

        TransitSchedule transitSchedule = scenario.getTransitSchedule();

        PrintWriter pw = new PrintWriter(outputCsvFile);
        pw.println("line,route,mode,seq,stop_id,stop_x,stop_y," +
                "distPrevious2Current,distPrevious2Next,speedPrevious2Current,speedPrevious2Next," +
                "suspicious,inspected,offRatio,offDiff,speedRatio");

        log.info("Starting calculating.");

        Map<Id<TransitLine>, TransitLine> transitLineMap = transitSchedule.getTransitLines();



        for (Id<TransitLine> transitLineId : transitLineMap.keySet()) {

            Map<Id<TransitRoute>, TransitRoute> transitRouteMap = transitSchedule.getTransitLines().get(transitLineId).getRoutes();

            for (Id<TransitRoute> transitRouteId : transitRouteMap.keySet()) {

                List<TransitRouteStop> transitStopFacilityMap = transitRouteMap.get(transitRouteId).getStops();
                String mode = transitRouteMap.get(transitRouteId).getTransportMode();

                if (transitStopFacilityMap.size() < 2) {
                    log.info("Line:" + transitLineId);
                    log.info("Route: " + transitRouteId);
                    log.info("has " + transitStopFacilityMap.size() + " stops.");
                }

                for (int i = 0; i <= transitStopFacilityMap.size() - 1; i++) {

                    TransitStopFacility currentStop = transitStopFacilityMap.get(i).getStopFacility();
                    TransitStopFacility previousStop;
                    TransitStopFacility nextStop;

                    Coord coordCurrentStop = currentStop.getCoord();
                    Coord coordPreviousStop;
                    Coord coordNextStop;

                    double distPrevious2Current_m = 0.01;
                    double distPrevious2Next_m = 0.01;

                    double timeCurrentStop_sec = transitStopFacilityMap.get(i).getDepartureOffset().seconds();
                    double timePreviousStop_sec;
                    double timeNextStop_sec;

                    double speedPrevious2Current = 0.01;
                    double speedPrevious2Next = 0.01;

                    boolean isSuspiciousStop = false;
                    boolean isInspectedStop = false;

                    if (i > 0 && i < transitStopFacilityMap.size() - 1) {
                        previousStop = transitStopFacilityMap.get(i - 1).getStopFacility();
                        nextStop = transitStopFacilityMap.get(i + 1).getStopFacility();
                        coordPreviousStop = previousStop.getCoord();
                        coordNextStop = nextStop.getCoord();
                        distPrevious2Current_m = CoordUtils.calcEuclideanDistance(coordPreviousStop, coordCurrentStop);
                        distPrevious2Next_m = CoordUtils.calcEuclideanDistance(coordPreviousStop, coordNextStop);
                        timePreviousStop_sec = transitStopFacilityMap.get(i - 1).getDepartureOffset().seconds();
                        timeNextStop_sec = transitStopFacilityMap.get(i + 1).getArrivalOffset().seconds();
                        speedPrevious2Current = (distPrevious2Current_m / (timeCurrentStop_sec - timePreviousStop_sec)) * 3.6;
                        speedPrevious2Next = (distPrevious2Next_m / (timeNextStop_sec - timePreviousStop_sec)) * 3.6;

                        //Todo Check this one first and see whether the threshold for speed is reasonable or not
                        isSuspiciousStop = (((distPrevious2Current_m - distPrevious2Next_m) >= (10 * 1000)) &&
                                (distPrevious2Current_m / distPrevious2Next_m >= 3));

                        //Todo Check this one second
//                        isSuspiciousStop = (((distPrevious2Current_m - distPrevious2Next_m) >= (10 * 1000)) &&
//                                (distPrevious2Current_m / distPrevious2Next_m >= 3)) &&
//                                (speedPrevious2Current / speedPrevious2Next >= 1.5);

                        isInspectedStop = true;

                    } else if (i == transitStopFacilityMap.size() - 1) {
                        previousStop = transitStopFacilityMap.get(i - 1).getStopFacility();
                        coordPreviousStop = previousStop.getCoord();
                        distPrevious2Current_m = CoordUtils.calcEuclideanDistance(coordPreviousStop, coordCurrentStop);
                        timePreviousStop_sec = transitStopFacilityMap.get(i - 1).getDepartureOffset().seconds();
                        speedPrevious2Current = (distPrevious2Current_m / (timeCurrentStop_sec - timePreviousStop_sec)) * 3.6;
                    }

                    StringBuilder sb = new StringBuilder();
                    sb.append("\"").append(transitLineId.toString()).append("\"").append(",");
                    sb.append("\"").append(transitRouteId.toString()).append("\"").append(",");
                    sb.append(mode).append(",");
                    sb.append(i + 1).append(",");
                    sb.append("\"").append(transitStopFacilityMap.get(i).getStopFacility().getId().toString()).append("\"").append(",");
                    sb.append(transitStopFacilityMap.get(i).getStopFacility().getCoord().getX()).append(",");
                    sb.append(transitStopFacilityMap.get(i).getStopFacility().getCoord().getY()).append(",");
                    sb.append(distPrevious2Current_m).append(",");
                    sb.append(distPrevious2Next_m).append(",");
                    sb.append(speedPrevious2Current).append(",");
                    sb.append(speedPrevious2Next).append(",");
                    sb.append(isSuspiciousStop).append(",");
                    sb.append(isInspectedStop).append(",");
                    sb.append(distPrevious2Current_m / distPrevious2Next_m).append(",");
                    sb.append(distPrevious2Current_m - distPrevious2Next_m).append(",");
                    sb.append(speedPrevious2Current / speedPrevious2Next);
                    pw.println(sb);

                }
                numScannedStops += transitStopFacilityMap.size();
            }
            numScannedRoutes += transitRouteMap.size();
        }
        numScannedLines += transitLineMap.size();
        pw.close();
        log.info("Calculating completed.");
        log.info(numScannedLines + " lines are scanned.");
        log.info(numScannedRoutes + " routes are scanned.");
        log.info(numScannedStops + " stops are scanned.");
    }

    private static void readTransitSchedule() {
        log.info("Starting reading transit schedule.");
        transitScheduleReader = new TransitScheduleReaderV1(scenario);
        transitScheduleReader.readFile(transitScheduleFile);
        log.info("Transit schedule read completely: " + transitScheduleFile);
    }


}
