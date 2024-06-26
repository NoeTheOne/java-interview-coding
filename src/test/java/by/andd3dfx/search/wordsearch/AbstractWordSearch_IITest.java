package by.andd3dfx.search.wordsearch;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractWordSearch_IITest {

    private IWordSearch_II wordSearch2;

    @Before
    public void setUp() throws Exception {
        wordSearch2 = initiate();
    }

    protected abstract IWordSearch_II initiate();

    @Test
    public void exist_forEmptyWordsList() {
        var board = new char[][]{
                {'A', 'B'},
                {'C', 'D'},
        };
        var words = new String[]{};
        var expectedWords = new String[]{};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_1x2() {
        var board = new char[][]{
                {'A', 'B'},
        };
        var words = new String[]{"AB", "ABC", "BA", "AA", "B"};
        var expectedWords = new String[]{"AB", "BA", "B"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_2x2() {
        var board = new char[][]{
                {'A', 'B'},
                {'C', 'D'},
        };
        var words = new String[]{"ABD", "ADC", "BDC", "DCAB", "DBA", "BCD", "D", "BC", "CA"};
        var expectedWords = new String[]{"ABD", "BDC", "DCAB", "DBA", "D", "CA"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_3x3() {
        var board = new char[][]{
                {'A', 'B', 'C'},
                {'C', 'D', 'A'},
                {'A', '2', 'B'},
        };
        var words = new String[]{"2DA", "AB2", "A2DAC", "CAC", "BDB"};
        var expectedWords = new String[]{"2DA", "AB2", "A2DAC"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    @Test
    public void exist_3x4() {
        var board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        var words = new String[]{"ABCCED", "SFCCE", "SCEEE", "FC", "SCEDFB", "SECCEE", "FDA", "FDEES", "CSEEE"};
        var expectedWords = new String[]{"ABCCED", "SFCCE", "FC", "SCEDFB", "SECCEE", "FDA", "FDEES"};

        findWordAndCheckAsserts(board, words, expectedWords);
    }

    private void findWordAndCheckAsserts(char[][] board, String[] words, String[] expectedWords) {
        var result = wordSearch2.findWords(board, words);

        assertThat(result).hasSize(expectedWords.length);
        assertThat(result).containsExactlyInAnyOrder(expectedWords);
    }
}
