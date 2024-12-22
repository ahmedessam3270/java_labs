import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class RepeatedWord {
    public static void main(String[] args) {
        String sentenceToSearchIn = "ITI develops people and ITI house of developers and ITI for people";
        String wordToFind = "ITI";

        // using split 
        int countUsingSplit = RepeatedWordSplit.countOccurrences(sentenceToSearchIn, wordToFind);
        System.out.println("Using String.split(): There are " + countUsingSplit + " occurrences of '" + wordToFind + "' in the sentence.");

        // Using StringTokenizer
        int countUsingTokenizer = RepeatedWordTokenizer.countOccurrences(sentenceToSearchIn, wordToFind);
        System.out.println("Using StringTokenizer: There are " + countUsingTokenizer + " occurrences of '" + wordToFind + "' in the sentence.");

        // Using Regular Expressions
        int countUsingRegex = RepeatedWordRegex.countOccurrences(sentenceToSearchIn, wordToFind);
        System.out.println("Using Regular Expressions: There are " + countUsingRegex + " occurrences of '" + wordToFind + "' in the sentence.");
    }
}


class RepeatedWordSplit {
    public static int countOccurrences(String text, String word) {
       
        String[] separatedBySpaces = text.split("\\s+");

        int count = 0;
        for (String w : separatedBySpaces) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }
}

class RepeatedWordTokenizer {
    public static int countOccurrences(String text, String word) {
        StringTokenizer tokenizer = new StringTokenizer(text);

        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(word)) {
                count++;
            }
        }
        return count;
    }
}

class RepeatedWordRegex {
    public static int countOccurrences(String text, String word) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(word) + "\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            count++;
        }
        return count;
    }
}