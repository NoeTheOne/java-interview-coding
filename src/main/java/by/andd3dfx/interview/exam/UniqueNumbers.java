package by.andd3dfx.interview.exam;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Write a method that finds all numbers that occur exactly once in the input collection
 * <p>
 * For example, findUniqueNumbers(Arrays.asList(1, 2, 1, 3)) should return { 2, 3 }.
 */
public class UniqueNumbers {

    public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
        Set<Integer> result = new LinkedHashSet<>();
        Set<Integer> existedNumbers = new HashSet<>();

        for (var number : numbers) {
            boolean additionResult = result.add(number);
            if (existedNumbers.contains(number) || !additionResult) {
                result.remove(number);
                existedNumbers.add(number);
            }
        }
        return result;
    }
}
