import java.util.Scanner;

public class CounterTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I hear you like to count by threes\n");
        System.out.println("Jimmy: It depends.");
        System.out.println("Oh, ok...");

       // See detailed instructions on Learn the Part.
        System.out.print("Pick a number to count by: ");
        int number = scan.nextInt();
        System.out.print("Pick a number to start counting from: ");
        int from = scan.nextInt();
        System.out.print("Pick a number to count to: ");
        int to = scan.nextInt();

        for (int i = from; i <= to; i += number) {
            System.out.print(i + " ");
        }

        scan.close();
    }
}
