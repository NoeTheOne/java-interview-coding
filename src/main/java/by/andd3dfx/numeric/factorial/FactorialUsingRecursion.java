package by.andd3dfx.numeric.factorial;

/**
 * Top-down approach
 *
 * @see <a href="https://youtu.be/HZrTppQjXVs">Video solution</a>
 */
public class FactorialUsingRecursion implements IFactorial {

    @Override
    public long calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be greater than 0");
        }

        if (n == 0) {
            return 1;
        }

        return n * calc(n - 1);
    }
}
