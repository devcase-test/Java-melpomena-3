package org.sytac.test.implement.tennis;

import com.google.auto.service.AutoService;
import java.util.List;
import org.sytac.test.internal.Tennis;

@AutoService(Tennis.class)
public class TennisImpl implements Tennis {

    /**
     * Implement this method, please add as many helper methods or classes as you need
     * @param points a list of players who scored each point, eg. "P1,P2,P2,P2,P1"
     */
    @Override
    public String process(List<String> points) {
        return "sets: 2-1 games: 1-1 points: 40-15";
    }
}
