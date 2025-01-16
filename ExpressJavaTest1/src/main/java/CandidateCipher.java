import java.util.HashSet;
import java.util.Set;

public class CandidateCipher {

    public String calculateCipher(String fullName, int day, int month, int year) {
        Set<Character> uniqueCharacters = new HashSet<>();
        for (char c : fullName.toCharArray()) {
            uniqueCharacters.add(c);
        }
        int uniqueCount = uniqueCharacters.size();

        int sumOfDigits = sumOfDigits(day) + sumOfDigits(month);

        char firstLetter = fullName.charAt(0);
        int alphabetPosition = Character.toLowerCase(firstLetter) - 'a' + 1;

        int cipherValue = uniqueCount + (sumOfDigits * 64) + (alphabetPosition * 256);

        String hexValue = Integer.toHexString(cipherValue).toUpperCase();
        String result = hexValue.length() > 3 ? hexValue.substring(hexValue.length() - 3) : String.format("%03s", hexValue).replace(' ', '0');

        return result;
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        CandidateCipher cipher = new CandidateCipher();

        String candidate1 = "Volozh,Arcady,Yurievich";
        System.out.println(cipher.calculateCipher(candidate1, 11, 2, 1964)); // Вывод: 710

        String candidate2 = "Segalovich,Ilya,Valentinovich";
        System.out.println(cipher.calculateCipher(candidate2, 13, 9, 1964)); // Вывод: 64F
    }
}