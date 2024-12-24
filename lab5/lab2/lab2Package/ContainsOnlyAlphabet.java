package lab2Package;

public class ContainsOnlyAlphabet {
    public static boolean containsOnlyAlphabet(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
