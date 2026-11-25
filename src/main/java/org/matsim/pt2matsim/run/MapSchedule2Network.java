package org.matsim.pt2matsim.run;

import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.ConfigWriter;
import org.matsim.core.utils.collections.CollectionUtils;
import org.matsim.pt2matsim.config.PublicTransitMappingConfigGroup;
import org.matsim.pt2matsim.run.CreateDefaultPTMapperConfig;
import org.matsim.pt2matsim.run.PublicTransitMapper;

import java.util.concurrent.ExecutionException;

public class MapSchedule2Network {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //PublicTransitMapper.run("example/fabilut2/berlinBrandenburg/bus/config.xml");
        //PublicTransitMapper.run("example/fabilut2/berlinBrandenburg/urbanRail/config.xml");
        //PublicTransitMapper.run("example/fabilut2/berlinBrandenburg/regionalRail/config.xml");
        PublicTransitMapper.run("example/fabilut2/munichBavaria/bus/config.xml");
        PublicTransitMapper.run("example/fabilut2/munichBavaria/bus_metroTram/config.xml");
        PublicTransitMapper.run("example/fabilut2/munichBavaria/bus_metroTram_rail/config.xml");
//        PublicTransitMapper.run("example/fabilut2/helsinkiSouthSavo/bus/config.xml");
//        PublicTransitMapper.run("example/fabilut2/helsinkiSouthSavo/urbanRail/config.xml");
//        PublicTransitMapper.run("example/fabilut2/helsinkiSouthSavo/regionalRail/config.xml");
    }
}
