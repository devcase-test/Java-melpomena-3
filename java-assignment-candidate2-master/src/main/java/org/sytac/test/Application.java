package org.sytac.test;

import java.util.List;
import java.util.ServiceLoader;
import org.sytac.test.internal.Boxes;
import org.sytac.test.internal.Speeding;
import org.sytac.test.internal.Tennis;


/**
 * Main application to test your implementations.
 * <p>
 * Takes a command line parameter the following input parameters:
 * - name of assignment (boxes,tennis,speeding)
 * - input parameters for the selected assignment
 * and writes the result to the standard output.
 * <p>
 * DO NOT MODIFY THIS FILE
 */
public final class Application {
    public static void main(String[] args) {
        if (args.length <= 1) {
            System.err.printf("Usage:%n  java -jar application.jar <assignment> <input_parameters>%n");
            System.exit(1);
        }

        String assignment = args[0];
        switch (assignment.toLowerCase()) {
            case "boxes":
                testBoxes(args[1], args[2]);
                break;
            case "tennis":
                testTennis(args[1]);
                break;
            case "speeding":
                testSpeeding(args[1], args[2], args[3]);
                break;
            default:
                System.err.printf("Unknown assignment %s. Supported values: boxes, tennis, speeding", assignment);
                System.exit(-1);
        }
    }

    private static void testBoxes(String numberOfEggs, String boxesList) {
        int totalNumberOfEggs = Integer.parseInt(numberOfEggs);

        List<String> boxes = List.of(boxesList.split(","));

        Boxes boxesAssignment = ServiceLoader.load(Boxes.class).findFirst()
                .orElseThrow(() -> new IllegalStateException("No assignment implementation found"));

        int output = boxesAssignment.process(totalNumberOfEggs, boxes);

        System.out.println(output);
    }

    private static void testTennis(String pointsList) {
        final List<String> points = List.of(pointsList.split(","));

        Tennis tennis = ServiceLoader.load(Tennis.class).findFirst().orElseThrow(() -> new IllegalStateException("No assignment implementation found"));
        String output = tennis.process(points);
        System.out.println(output);
    }

    private static void testSpeeding(String distanceString, String speedLimitString, String readingsString) {
        int distance = Integer.parseInt(distanceString);
        int speedLimit = Integer.parseInt(speedLimitString);

        List<String> readings = List.of(readingsString.split(";"));

        Speeding speeding = ServiceLoader.load(Speeding.class).findFirst().orElseThrow(() -> new IllegalStateException("No assignment implementation found"));

        List<String> output = speeding.process(distance,speedLimit,readings);
        System.out.println(output);
    }
}
