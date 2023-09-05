package by.andd3dfx.string;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * </pre>
 */
public class LongestWordWithoutRepeatingChars {

    public static int determine(String s) {
        if (StringUtils.isBlank(s)) {
            return 0;
        }

        var left = 0;
        var right = 0;
        var max = 1;

        var chars = s.toCharArray();
        Set set = new HashSet();
        set.add(chars[left]);

        while (right < chars.length - 1) {
            right++;
            if (set.contains(chars[right])) {
                max = Math.max(right - left, max);

                left = right;
                set.clear();
            }
            set.add(chars[right]);
        }

        return Math.max(max, set.size());
    }
}
