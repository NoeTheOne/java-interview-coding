package by.andd3dfx.common;

/**
 * <pre>
 * You are holding one link of a chain in your hand. Implement method longerSide() to find which side of the
 * chain, relative to the link you are holding, has more links.
 *
 * If the left side has more links return LEFT, if the right side has more links return RIGHT,
 * and if both sides have an equal number of links or if the chain is a closed loop, return NONE.
 *
 * For example, for the code below, the output should be RIGHT:
 *
 *   ChainLink left = new ChainLink();
 *   ChainLink middle = new ChainLink();
 *   ChainLink right = new ChainLink();
 *   left.append(middle);
 *   middle.append(right);
 *   System.out.println(left.longerSide());
 * </pre>
 *
 * @see <a href="https://youtu.be/KAqZwNY7yUc">Video solution</a>
 */
public class ChainLink {

    public enum Side {
        NONE, LEFT, RIGHT
    }

    private ChainLink left;
    private ChainLink right;

    public void append(ChainLink newRightLink) {
        if (this.right != null) {
            throw new IllegalStateException("Link already connected!");
        }
        this.right = newRightLink;
        newRightLink.left = this;
    }

    public Side longerSide() {
        ChainLink left = this.left;
        ChainLink right = this.right;

        while (true) {
            if (left == right) {
                return Side.NONE;
            }
            if (left == null) {
                return Side.RIGHT;
            }
            if (right == null) {
                return Side.LEFT;
            }

            left = left.left;
            right = right.right;
        }
    }
}
