import lab6Packages.EnglishDictionary.EnglishDictionary;

public class Main {
    public static void main(String[] args) {
        EnglishDictionary ediDictionary =  new EnglishDictionary();

        ediDictionary.PrintAll();
        ediDictionary.printAllWordsOfALetter('a');
        ediDictionary.printAllWordsOfALetter('4');
        ediDictionary.printAllWordsOfALetter('z');
        
    }
}
