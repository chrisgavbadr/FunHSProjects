public class ASCIITable {
    public static void main(String[] args) {
        printASCII();
    }

    public static void printASCII() {
        int count = 1;

        for (char i = ' '; i <= 255; i++) {
            System.out.printf("%2c", i);
            if (count % 16 == 0) {
                System.out.println();
            }
            count++;
        }
    }
}