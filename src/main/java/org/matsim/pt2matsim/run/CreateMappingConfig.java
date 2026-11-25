package org.matsim.pt2matsim.run;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.ConfigWriter;
import org.matsim.core.utils.collections.CollectionUtils;
import org.matsim.pt2matsim.config.PublicTransitMappingConfigGroup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateMappingConfig {

    public static void main(String[] args) {
        //Create a mapping config:
        //If you want to see the default config, please uncomment and run the code below
        //CreateDefaultPTMapperConfig.main(new String[]{ "example/berlin/defaultConfig.xml"});

//        Config config = ConfigUtils.loadConfig(
//                "example/fabilut2/berlinBrandenburg/bus/config.xml",
//                PublicTransitMappingConfigGroup.createDefaultConfig());
//
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Berlin-Brandenburg_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/berlinBrandenburg/bus/network_Berlin-Brandenburg_multimodal_motorway2tertiary_bus.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/berlinBrandenburg/bus/network_Berlin-Brandenburg_carOnly_motorway2tertiary_bus.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/berlinBrandenburg_schedule_bus_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/berlinBrandenburg/bus/berlinBrandenburg_schedule_bus_mapped.xml.gz");
//
//        ptmConfig.setScheduleFreespeedModes(CollectionUtils.stringToSet("rail, light_rail"));
//
//        new ConfigWriter(config).write("example/fabilut2/berlinBrandenburg/bus/config.xml");

//        Config config = ConfigUtils.loadConfig(
//                "example/fabilut2/berlinBrandenburg/urbanRail/config.xml",
//                PublicTransitMappingConfigGroup.createDefaultConfig());
//
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Berlin-Brandenburg_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/berlinBrandenburg/urbanRail/network_Berlin-Brandenburg_multimodal_motorway2tertiary_urbanRail.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/berlinBrandenburg/urbanRail/network_Berlin-Brandenburg_carOnly_motorway2tertiary_urbanRail.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/berlinBrandenburg_schedule_urbanRail_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/berlinBrandenburg/urbanRail/berlinBrandenburg_schedule_urbanRail_mapped.xml.gz");
//
//        ptmConfig.setScheduleFreespeedModes(CollectionUtils.stringToSet("rail, light_rail"));
//
//        new ConfigWriter(config).write("example/fabilut2/berlinBrandenburg/urbanRail/config.xml");

//        Config config = ConfigUtils.loadConfig(
//                "example/fabilut2/berlinBrandenburg/regionalRail/config.xml",
//                PublicTransitMappingConfigGroup.createDefaultConfig());
//
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Berlin-Brandenburg_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/berlinBrandenburg/regionalRail/network_Berlin-Brandenburg_multimodal_motorway2tertiary_regionalRail.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/berlinBrandenburg/regionalRail/network_Berlin-Brandenburg_carOnly_motorway2tertiary_regionalRail.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/berlinBrandenburg_schedule_regionalRail_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/berlinBrandenburg/regionalRail/berlinBrandenburg_schedule_regionalRail_mapped.xml.gz");
//
//        ptmConfig.setScheduleFreespeedModes(CollectionUtils.stringToSet("rail"));
//
//        new ConfigWriter(config).write("example/fabilut2/berlinBrandenburg/regionalRail/config.xml");

//        Config config = ConfigUtils.createConfig(PublicTransitMappingConfigGroup.createDefaultConfig());
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Munich-Bavaria_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/munichBavaria/bus/network_Munich-Bavaria_multimodal_motorway2tertiary_bus.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/munichBavaria/bus/network_Munich-Bavaria_carOnly_motorway2tertiary_bus.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/munichBavaria_schedule_bus_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/munichBavaria/bus/munichBavaria_schedule_bus_mapped.xml.gz");
//
//        new ConfigWriter(config).write("example/fabilut2/munichBavaria/bus/config.xml");

//        Config config = ConfigUtils.createConfig(PublicTransitMappingConfigGroup.createDefaultConfig());
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Munich-Bavaria_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/munichBavaria/bus_metroTram/network_Munich-Bavaria_multimodal_motorway2tertiary_bus_metroTram.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/munichBavaria/bus_metroTram/network_Munich-Bavaria_carOnly_motorway2tertiary_bus_metroTram.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/munichBavaria_schedule_bus_metroTram_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/munichBavaria/bus_metroTram/munichBavaria_schedule_bus_metroTram_mapped.xml.gz");
//
//        new ConfigWriter(config).write("example/fabilut2/munichBavaria/bus_metroTram/config.xml");

        Config config = ConfigUtils.createConfig(PublicTransitMappingConfigGroup.createDefaultConfig());

        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Munich-Bavaria_car_motorway2tertiary_intensed_connectors.xml.gz");
        ptmConfig.setOutputNetworkFile("example/fabilut2/munichBavaria/bus_metroTram_rail/network_Munich-Bavaria_multimodal_motorway2tertiary_bus_metroTram_rail.xml.gz");
        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/munichBavaria/bus_metroTram_rail/network_Munich-Bavaria_carOnly_motorway2tertiary_bus_metroTram_rail.xml.gz");
        ptmConfig.setInputScheduleFile("example/gtfs/munichBavaria_schedule_bus_metroTram_rail_unmapped.xml");
        ptmConfig.setOutputScheduleFile("example/fabilut2/munichBavaria/bus_metroTram_rail/munichBavaria_schedule_bus_metroTram_rail_mapped.xml.gz");

        new ConfigWriter(config).write("example/fabilut2/munichBavaria/bus_metroTram_rail/config.xml");

//        Config config = ConfigUtils.loadConfig(
//                "example/fabilut2/helsinkiSouthSavo/bus/config.xml",
//                PublicTransitMappingConfigGroup.createDefaultConfig());
//
//        config.global().setCoordinateSystem("EPSG:3067");
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Helsinki-SouthSavo_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/helsinkiSouthSavo/bus/network_Helsinki-SouthSavo_multimodal_motorway2tertiary_bus.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/helsinkiSouthSavo/bus/network_Helsinki-SouthSavo_carOnly_motorway2tertiary_bus.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/helsinkiSouthSavo_schedule_bus_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/helsinkiSouthSavo/bus/helsinkiSouthSavo_schedule_bus_mapped.xml.gz");
//
//        new ConfigWriter(config).write("example/fabilut2/helsinkiSouthSavo/bus/config.xml");

//        Config config = ConfigUtils.loadConfig(
//                "example/fabilut2/helsinkiSouthSavo/regionalRail/config.xml",
//                PublicTransitMappingConfigGroup.createDefaultConfig());
//
//        config.global().setCoordinateSystem("EPSG:3067");
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Helsinki-SouthSavo_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/helsinkiSouthSavo/regionalRail/network_Helsinki-SouthSavo_multimodal_motorway2tertiary_regionalRail.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/helsinkiSouthSavo/regionalRail/network_Helsinki-SouthSavo_carOnly_motorway2tertiary_regionalRail.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/helsinkiSouthSavo_schedule_regionalRail_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/helsinkiSouthSavo/regionalRail/helsinkiSouthSavo_schedule_regionalRail_mapped.xml.gz");
//
//        new ConfigWriter(config).write("example/fabilut2/helsinkiSouthSavo/regionalRail/config.xml");

//        Config config = ConfigUtils.loadConfig(
//                "example/fabilut2/helsinkiSouthSavo/urbanRail/config.xml",
//                PublicTransitMappingConfigGroup.createDefaultConfig());
//
//        config.global().setCoordinateSystem("EPSG:3067");
//
//        PublicTransitMappingConfigGroup ptmConfig = ConfigUtils.addOrGetModule(config, PublicTransitMappingConfigGroup.class);
//
//        ptmConfig.setInputNetworkFile("example/josmNetwork/network_Helsinki-SouthSavo_car_motorway2tertiary_intensed_connectors.xml.gz");
//        ptmConfig.setOutputNetworkFile("example/fabilut2/helsinkiSouthSavo/urbanRail/network_Helsinki-SouthSavo_multimodal_motorway2tertiary_urbanRail.xml.gz");
//        ptmConfig.setOutputStreetNetworkFile("example/fabilut2/helsinkiSouthSavo/urbanRail/network_Helsinki-SouthSavo_carOnly_motorway2tertiary_urbanRail.xml.gz");
//        ptmConfig.setInputScheduleFile("example/gtfs/helsinkiSouthSavo_schedule_urbanRail_unmapped.xml");
//        ptmConfig.setOutputScheduleFile("example/fabilut2/helsinkiSouthSavo/urbanRail/helsinkiSouthSavo_schedule_urbanRail_mapped.xml.gz");
//
//        new ConfigWriter(config).write("example/fabilut2/helsinkiSouthSavo/urbanRail/config.xml");


    }
}
