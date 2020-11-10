package org.sytac.test.implement.boxes;


import com.google.auto.service.AutoService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.sytac.test.internal.Boxes;

@AutoService(Boxes.class)
public class BoxesImpl implements Boxes {
    /**
     * Complete the method below.
     *
     * @param boxes a list of egg boxes with their capacities
     */
    @Override
    public int process(int totalNumberOfEggs, List<String> boxes) {
        final int result;
        // Input validation / parsing.
        if (totalNumberOfEggs < 0) {
            //throw new IllegalArgumentException("Invalid totalNumberOfEgg. Must be non-null and positive.");
            // I'd throw an Exception here but the unit-tests seem to require a zero returned.
            result = 0;
        }
        else {
            // Parse the strings into Integers.
            // This is conceptually a set, since each size is present in an infinite number.
            // (the problem statement specifies that the sizes are unique but: defensive coding > let's assert it )
            final Set<Integer> boxSizes = new HashSet<>();
            for (final String box : boxes) {
                // Catch the checked Exception since out signature has no exception
                try {
                    final int bSize = Integer.parseInt(box);
                    if (bSize > 0) {
                        boxSizes.add(bSize);
                    }
                }
                catch (NumberFormatException nfe) {
                    //throw new IllegalArgumentException("Invalid input: " + box);
                }
            }
            result = getMinimumNumberOfBoxes(totalNumberOfEggs, boxSizes);
        }
        return result;
    }

    private static int getMinimumNumberOfBoxes(final int pTotalNumberOfEggs, final Set<Integer> pBoxSizes) {
        int boxCount = 0;
        int remaingEggCount = pTotalNumberOfEggs;
        // Sort the sizes from largest to smallest (reverse order)
        final List<Integer> capacities = new ArrayList<>(pBoxSizes);
        Collections.sort(capacities, Collections.reverseOrder());
        // Consume the boxes from the largest to the smallest until no egg remain
        for (final int capacity : capacities) {
            if (capacity == 0 || capacity > remaingEggCount) {
                continue; // cannot use this box, it is too big
            }
            // Integer division
            final int thisCapacityBoxCount = remaingEggCount / capacity; // auto-unboxed
            assert thisCapacityBoxCount > 0;
            
            remaingEggCount = remaingEggCount % capacity;
            boxCount += thisCapacityBoxCount;
        }
        return boxCount;
    }
}

