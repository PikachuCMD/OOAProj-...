import java.util.Scanner;

public class inputKey {
    private Scanner input;

    public inputKey() {
        input = new Scanner(System.in);
    }

    public int getInput() {
        return input.nextInt();
    }
}
