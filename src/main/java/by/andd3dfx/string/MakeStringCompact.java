package by.andd3dfx.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <pre>
 * Write a function that transforms string into a new string.
 * New string does not contain repeating letters but contains a number after every letter
 * that means how many times the letter was repeated in the original string.
 * a.	“” -> “”
 * b.	“a” -> “a1”
 * c.	“aaa” -> “a3”
 * d.	“aaabbc” -> “a3b2c1”
 * </pre>
 */
public class MakeStringCompact {

    public static String transform(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (var ch: s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        var result = "";
        for (var key : map.keySet()) {
            result += String.format("%s%d", key, map.get(key));
        }
        return result;
    }
}
