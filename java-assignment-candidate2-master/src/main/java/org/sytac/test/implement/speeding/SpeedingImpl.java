package org.sytac.test.implement.speeding;


import com.google.auto.service.AutoService;
import java.util.List;
import org.sytac.test.internal.Speeding;

@AutoService(Speeding.class)
public class SpeedingImpl implements Speeding {
    /**
     * Complete the method below.
     */
    @Override
    public List<String> process(int distance, int speedLimit, List<String> sensorReadings) {
        return null;
    }
}
