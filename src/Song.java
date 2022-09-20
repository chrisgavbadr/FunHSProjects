/* Song.java
 *
 * Christian Baduria, Java 2017
 * Ch 1 Project (Song), 9/12/17
 *
 * This program prints the lyrics of "Bought me a Cat"
 */

public class Song {
    // Prints out the first two lines of verse 1
    public static void cat() {
        System.out.println("Bought me a cat and the cat pleased me,");
        System.out.println("I fed my cat under yonder tree.");
        catGoes();
    }

    // Prints out the first two lines of verse 2
    public static void hen() {
        System.out.println("Bought me a hen and the hen pleased me,");
        System.out.println("I fed my hen under yonder tree.");
        henGoes();
    }

    // Prints out the first two lines of verse 3
    public static void duck() {
        System.out.println("Bought me a duck and the duck pleased me,");
        System.out.println("I fed my duck under yonder tree.");
        duckGoes();
    }

    // Prints out the first two lines of verse 4
    public static void goose() {
        System.out.println("Bought me a goose and the goose pleased me,");
        System.out.println("I fed my goose under yonder tree.");
        gooseGoes();
    }

    // Prints out the first two lines of verse 5
    public static void sheep() {
        System.out.println("Bought me a sheep and the sheep pleased me,");
        System.out.println("I fed my sheep under yonder tree.");
        sheepGoes();
    }

    // Prints out the first two lines of verse 6
    public static void pig() {
        System.out.println("Bought me a pig and the pig pleased me,");
        System.out.println("I fed my pig under yonder tree.");
        pigGoes();
    }

    // Prints out the final line of the verse
    public static void catGoes() {
        System.out.println("Cat goes fiddle-i-fee.");
        System.out.println();
    }

    // Prints out the hen line and calls catGoes()
    public static void henGoes() {
        System.out.println("Hen goes chimmy-chuck, chimmy-chuck,");
        catGoes();
    }

    // Prints out the duck line and calls henGoes()
    public static void duckGoes() {
        System.out.println("Duck goes quack, quack,");
        henGoes();
    }

    // Prints out the goose line and calls duckGoes()
    public static void gooseGoes() {
        System.out.println("Goose goes hissy, hissy,");
        duckGoes();
    }

    // Prints out the sheep line and calls gooseGoes()
    public static void sheepGoes() {
        System.out.println("Sheep goes baa, baa,");
        gooseGoes();
    }

    // Prints out the pig line and calls sheepGoes()
    public static void pigGoes() {
        System.out.println("Pig goes oink, oink,");
        sheepGoes();
    }

    // Prints out the entire song lyrics
    public static void main(String[] args) {
        cat();
        hen();
        duck();
        goose();
        sheep();
        pig();
    }
}
