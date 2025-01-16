import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTransformerTest {

    private final StringTransformer transformer = new StringTransformer();

    @Test
    public void testTransformWithSingleCharacter() {
        assertEquals("1", transformer.transform("a"));
        assertEquals("b", transformer.transform("b"));
    }

    @Test
    public void testTransformWithTwoCharacters() {
        assertEquals("B1", transformer.transform("aB"));
        assertEquals("1", transformer.transform("A"));
    }

    @Test
    public void testTransformWithMultipleCharacters() {
        assertEquals("dlr15w", transformer.transform("world"));
        assertEquals("dlr15W", transformer.transform("World"));
        assertEquals("521rt", transformer.transform("true"));
        assertEquals("521rT", transformer.transform("True"));
    }

    @Test
    public void testTransformWithNoVowels() {
        assertEquals("cbdfg", transformer.transform("gfdbc"));
    }

    @Test
    public void testTransformWithAllVowels() {
        assertEquals("121159", transformer.transform("ioua"));
    }
}
