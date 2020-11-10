package org.sytac.test.internal;

import java.util.List;

/**
 * There's a road in which the speed limit needs to be enforced. Officers decide to measure the average speed of cars
 * passing on it: they set up two sensors, which can read cars' plates and timestamp of their passage. They then
 * measure the distance between the two sensors.
 * Your task is to take the input from the sensors, calculate the average speed of each car and decide whether a ticket
 * needs to be given.
 *
 * Following rules apply:
 * 1. The street is two-way
 * 2. Speed limit has a tolerance of 5%, round up to the next integer; for instance 1.007 becomes 2
 * 3. Average speed is to be calculated as an integer, truncated; for instance 99.998 becomes 99
 * 4. A ticket is given when speed is strictly greater than the limit
 * 5. Cars are guaranteed to pass only once in the street
 *
 * Your input is:
 * - Integer distance (in meters), automatically read from input
 * - Integer speedLimit (in kph), automatically read from input
 * - A list of strings, representing a single read from a sensor which contains the following values, comma separated:
 *      - sensor name
 *      - plate number
 *      - timestamp in milliseconds
 *
 * The expected output is a list of the plates of the cars that were speeding. Sort the plates alphabetically and
 * print each one on a new line on standard output.
 *
 * Expected time to complete the assignment: 30-45min.
 */
public interface Speeding {
    /**
     * @param distance
     * @param speedLimit
     * @param sensorReadings, eg. A,AKP Z58,1584394993000
     * @return
     */
    List<String> process(int distance, int speedLimit, List<String> sensorReadings);
}
