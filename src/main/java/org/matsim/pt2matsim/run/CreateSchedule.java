package org.matsim.pt2matsim.run;

import org.matsim.core.utils.geometry.transformations.TransformationFactory;
import org.matsim.pt2matsim.gtfs.GtfsConverter;
import org.matsim.pt2matsim.run.Gtfs2TransitSchedule;

public class CreateSchedule {
///Users/wei/Documents/JavaProjects/pt2matsim/example/fabilut2/berlin_brandenburg
    public static void main(String[] args) {
//        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_berlinBrandenburg_regionalRail_weekday.zip",
//                GtfsConverter.DAY_WITH_MOST_SERVICES,
//                TransformationFactory.DHDN_GK4,
//                "example/gtfs/berlinBrandenburg_schedule_regionalRail_unmapped.xml",
//                "example/gtfs/berlinBrandenburg_vehicles_regionalRail.xml");
//
//        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_berlinBrandenburg_urbanRail_weekday.zip",
//                GtfsConverter.DAY_WITH_MOST_SERVICES,
//                TransformationFactory.DHDN_GK4,
//                "example/gtfs/berlinBrandenburg_schedule_urbanRail_unmapped.xml",
//                "example/gtfs/berlinBrandenburg_vehicles_urbanRail.xml");
//
//        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_berlinBrandenburg_bus_weekday.zip",
//                GtfsConverter.DAY_WITH_MOST_SERVICES,
//                TransformationFactory.DHDN_GK4,
//                "example/gtfs/berlinBrandenburg_schedule_bus_unmapped.xml",
//                "example/gtfs/berlinBrandenburg_vehicles_bus.xml");

        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_munichBavaria_bus_weekday_20261115.zip",
                GtfsConverter.DAY_WITH_MOST_SERVICES,
                TransformationFactory.DHDN_GK4,
                "example/gtfs/munichBavaria_schedule_bus_unmapped.xml",
                "example/gtfs/munichBavaria_vehicles_bus.xml",
                null,
                true);

        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_munichBavaria_bus_metroTram_weekday_20261115.zip",
                GtfsConverter.DAY_WITH_MOST_SERVICES,
                TransformationFactory.DHDN_GK4,
                "example/gtfs/munichBavaria_schedule_bus_metroTram_unmapped.xml",
                "example/gtfs/munichBavaria_vehicles_bus_metroTram.xml",
                null,
                true);

        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_munichBavaria_bus_metroTram_regionalRail_weekday_20261115.zip",
                GtfsConverter.DAY_WITH_MOST_SERVICES,
                TransformationFactory.DHDN_GK4,
                "example/gtfs/munichBavaria_schedule_bus_metroTram_rail_unmapped.xml",
                "example/gtfs/munichBavaria_vehicles_bus_metroTram_rail.xml",
                null,
                true);

//        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_helsinkiSouthSavo_regionalRail_weekday.zip",
//                GtfsConverter.DAY_WITH_MOST_SERVICES,
//                "EPSG:3067",
//                "example/gtfs/helsinkiSouthSavo_schedule_regionalRail_unmapped.xml",
//                "example/gtfs/helsinkiSouthSavo_vehicles_regionalRail.xml");

//        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_helsinkiSouthSavo_urbanRail_weekday.zip",
//                GtfsConverter.DAY_WITH_MOST_SERVICES,
//                "EPSG:3067",
//                "example/gtfs/helsinkiSouthSavo_schedule_urbanRail_unmapped.xml",
//                "example/gtfs/helsinkiSouthSavo_vehicles_urbanRail.xml");

//        Gtfs2TransitSchedule.run("/Users/wei/Documents/Data/gtfsGermany/data/gtfs_helsinkiSouthSavo_bus_weekday.zip",
//                GtfsConverter.DAY_WITH_MOST_SERVICES,
//                "EPSG:3067",
//                "example/gtfs/helsinkiSouthSavo_schedule_bus_unmapped.xml",
//                "example/gtfs/helsinkiSouthSavo_vehicles_bus.xml");

    }
}
