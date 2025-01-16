import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandidateCipherTest {

    private final CandidateCipher cipher = new CandidateCipher();

    @Test
    public void testCalculateCipherFirstCandidate() {
        String result = cipher.calculateCipher("Volozh,Arcady,Yurievich", 11, 2, 1964);
        assertEquals("710", result);
    }

    @Test
    public void testCalculateCipherSecondCandidate() {
        String result = cipher.calculateCipher("Segalovich,Ilya,Valentinovich", 13, 9, 1964);
        assertEquals("64F", result);
    }

    @Test
    public void testCalculateCipherWithLowerCase() {
        String result = cipher.calculateCipher("volozh,arcady,yurievich", 11, 2, 1964);

        assertEquals("710", result);
    }

    @Test
    public void testCalculateCipherWithDigits() {
        String result = cipher.calculateCipher("12345,67890,ABCDEF", 25, 5, 2000);
        assertEquals("7E", result);
    }

    @Test
    public void testCalculateCipherWithMixedCharacters() {
        String result = cipher.calculateCipher("Volozh,Arcady,Yurievich12", 11, 2, 1964);
        assertEquals("710", result);
    }

    @Test
    public void testCalculateCipherSameInitial() {
        String result = cipher.calculateCipher("Aaa,A,A", 1, 1, 2000);
        assertEquals("101", result);
    }
}
