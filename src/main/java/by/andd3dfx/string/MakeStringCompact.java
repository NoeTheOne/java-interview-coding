package by.andd3dfx.string;

/**
 * <pre>
 * Write a function that transforms string into a new string.
 * New string does not contain repeating letters but contains a number after every letter
 * that means how many times the letter was repeated in the original string.
 * a.	“” -> “”
 * b.	“a” -> “a”
 * c.	“aaa” -> “a3”
 * d.	“aaabbcbbb” -> “a3b2cb3”
 * </pre>
 *
 * @see <a href="https://youtu.be/s3sGF7C6cV8">Video solution</a>
 */
public class MakeStringCompact {

    public static String transform(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        var sb = new StringBuilder();
        var chars = str.toCharArray();

        var last = chars[0];
        var counter = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != last) {
                appendWithCounter(sb, last, counter);

                last = chars[i];
                counter = 1;
            } else {
                counter++;
            }
        }

        appendWithCounter(sb, last, counter);

        return sb.toString();
    }

    private static void appendWithCounter(StringBuilder sb, char ch, int counter) {
        sb.append(ch);
        if (counter > 1) {
            sb.append(counter);
        }
    }
}
