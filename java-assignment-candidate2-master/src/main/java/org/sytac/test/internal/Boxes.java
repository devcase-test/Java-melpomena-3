package org.sytac.test.internal;

import java.util.List;

/**
 * We are given a certain number of eggs, and we want to package them into boxes.
 * Boxes have different capacities, for each capacity we can assume we have an infinite amount of boxes.
 * The available capacities are provided as an n size list. For instance, given the input [2, 4, 8], it means that we have:
 * - unlimited boxes that contains 2 eggs
 * - unlimited boxes that contains 4 eggs
 * - unlimited boxes that contains 8 eggs
 *
 * Given the number eggs and the capacities of the boxes, your task is to calculate the minimum number of boxes that will be completely filled.
 *
 * Following rules apply:
 * 1. Fit as many eggs as possible with minimum number of boxes.
 * 2. Boxes must be fully used, you cannot leave empty slots in a box.
 * 3. If there are any remaining eggs which were not possible to fit, they must be ignored.
 *
 * Your input is:
 * - Total number of eggs (Integer), automatically read from input.
 * - A list of Strings, representing the capacities of boxes. Each capacity is guaranteed to be unique.
 *
 * Fill in the method to print the 'minimum number of boxes needed' on a new line on standard output.
 *
 * Expected time to complete the assignment: 30-45min.
 */
public interface Boxes {
    int process(int totalNumberOfEggs, List<String> boxes);
}
