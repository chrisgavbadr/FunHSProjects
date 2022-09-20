public class Vowels {
    public static void main(String[] args) {
        System.out.println(isNonVowel("a"));
        System.out.println(isNonVowel("E"));
        System.out.println(isVowel("i"));
        System.out.println(isVowel("O"));
        System.out.println(isVowel("u"));
    }

    public static boolean isVowel(String character) {
        character = character.toLowerCase();
        return (character.equalsIgnoreCase("a") || character.equalsIgnoreCase("e") ||
                character.equalsIgnoreCase("i") || character.equalsIgnoreCase("o") ||
                character.equalsIgnoreCase("u"));
    }

    public static boolean isNonVowel(String character) {
        return !isVowel(character);
    }
}