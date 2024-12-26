package lab6Packages.EnglishDictionary;

import java.util.Map;
import java.util.TreeMap;

public class EnglishDictionary {
    Map<Character, TreeMap<String, String>> dictionaryData = new TreeMap<>();

    public EnglishDictionary() {
        this.LoadData();
    }

    public void printAllWordsOfALetter(char key) {
        char lowerKey = Character.toLowerCase(key);
        
        // First check if it's a valid letter (a-z)
        if (lowerKey < 'a' || lowerKey > 'z') {
            System.out.println("Invalid letter: " + key + ". Please enter a letter from A to Z.");
            return;
        }
        
        // Check if there are any words for this letter
        if (dictionaryData.get(lowerKey).isEmpty()) {
            System.out.println("No words found for letter: " + key);
            return;
        }
    
        System.out.println("\n════════ Words Starting With '" + Character.toUpperCase(key) + "' ════════");
        dictionaryData.get(lowerKey).entrySet().forEach(word -> {
            System.out.printf(" %-15s : %-50s %n", word.getKey(), word.getValue());
        });
        System.out.println("═══════════════════════════════════════════════════════════════════════");
    }

    public void PrintAll() {
        System.out.println("\n═══════════════════ ENGLISH DICTIONARY ═══════════════════");
        dictionaryData.entrySet().forEach(letter -> {
            if (!letter.getValue().isEmpty()) {
                System.out.println("\n                     --- " + 
                    Character.toUpperCase(letter.getKey()) + " ---                     ");
                letter.getValue().entrySet().forEach(word -> {
                    System.out.printf(" %-15s : %-50s %n", 
                        word.getKey(), word.getValue());
                });
            }
        });
        System.out.println("═══════════════════════════════════════════════════════════");
    }

    private void LoadData() {
        // Initialize all letters
        for (char letter = 'a'; letter <= 'z'; letter++) {
            dictionaryData.put(letter, new TreeMap<>());
        }

        // A
        dictionaryData.get('a').put("apple", "A fruit that is sweet and crisp.");
        dictionaryData.get('a').put("ant", "A small insect that lives in colonies.");
        dictionaryData.get('a').put("aurora", "A natural light display in the Earth's sky.");
        dictionaryData.get('a').put("atlas", "A book of maps or charts.");
        dictionaryData.get('a').put("astronomy", "The study of celestial objects and phenomena.");

        // B
        dictionaryData.get('b').put("binary", "A number system with base 2.");
        dictionaryData.get('b').put("ballet", "A classical dance form.");
        dictionaryData.get('b').put("bamboo", "A fast-growing woody grass.");
        dictionaryData.get('b').put("beacon", "A light or signal for guidance.");
        dictionaryData.get('b').put("bizarre", "Strange or unusual.");

        // C
        dictionaryData.get('c').put("cascade", "A waterfall or series of waterfalls.");
        dictionaryData.get('c').put("cipher", "A secret or encoded message.");
        dictionaryData.get('c').put("cosmos", "The universe seen as an ordered system.");
        dictionaryData.get('c').put("crystal", "A solid with a regular atomic structure.");
        dictionaryData.get('c').put("cyclone", "A system of rotating winds.");

        // D
        dictionaryData.get('d').put("dawn", "The first appearance of light in the morning.");
        dictionaryData.get('d').put("debris", "Scattered fragments or remains.");
        dictionaryData.get('d').put("dynasty", "A succession of rulers from the same family.");
        dictionaryData.get('d').put("dazzle", "To blind temporarily with light.");
        dictionaryData.get('d').put("decimal", "Based on the number ten.");

        // E
        dictionaryData.get('e').put("eclipse", "An astronomical event where one body covers another.");
        dictionaryData.get('e').put("enigma", "Something hard to understand or explain.");
        dictionaryData.get('e').put("entropy", "A measure of disorder in a system.");
        dictionaryData.get('e').put("essence", "The fundamental nature of something.");
        dictionaryData.get('e').put("eternal", "Lasting or existing forever.");

        // F
        dictionaryData.get('f').put("facade", "The front of a building.");
        dictionaryData.get('f').put("fable", "A short story with a moral lesson.");
        dictionaryData.get('f').put("fusion", "The process of joining or blending.");
        dictionaryData.get('f').put("fossil", "Preserved remains of ancient life.");
        dictionaryData.get('f').put("fractal", "A never-ending pattern.");

        // G to Z (continuing with more sophisticated words)
        dictionaryData.get('g').put("galaxy", "A system of millions or billions of stars.");
        dictionaryData.get('g').put("genome", "The complete set of genes in an organism.");
        dictionaryData.get('g').put("gravity", "The force that attracts objects toward each other.");

        dictionaryData.get('h').put("harmony", "A pleasing arrangement of parts.");
        dictionaryData.get('h').put("horizon", "The line where the earth meets the sky.");
        dictionaryData.get('h').put("hologram", "A three-dimensional image formed by light.");

        dictionaryData.get('i').put("infinity", "The concept of something without any limit.");
        dictionaryData.get('i').put("isotope", "Atoms with the same atomic number but different mass.");
        dictionaryData.get('i').put("impulse", "A sudden force or urge.");

        // Continue with similar sophisticated entries for J through Z
        // Adding just a few more examples:
        
        dictionaryData.get('j').put("jasmine", "A climbing plant with fragrant flowers.");
        dictionaryData.get('j').put("jubilee", "A special anniversary celebration.");
        dictionaryData.get('j').put("junction", "A point where two or more things join.");

        dictionaryData.get('k').put("kinetic", "Relating to motion and its causes.");
        dictionaryData.get('k').put("kindle", "To start a fire or inspire something.");
        dictionaryData.get('k').put("kaleidoscope", "A toy showing changing colored patterns.");

        dictionaryData.get('l').put("labyrinth", "A complex maze or network of paths.");
        dictionaryData.get('l').put("luminous", "Giving off light; bright or shining.");
        dictionaryData.get('l').put("legacy", "Something handed down from the past.");
    }
}