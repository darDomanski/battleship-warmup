import java.util.Scanner;

public class Common {
    public static int getInt() {
        String intString = "";
        boolean isNotInteger = true;
        int number = 0;
        while (isNotInteger) {

            intString = getInput();

            try {
                number = Integer.parseInt(intString);
                isNotInteger = false;
            } catch (NumberFormatException e) {
                System.out.println("Error! Type a number...");
                isNotInteger = true;
            }
        }
        return number;
    }

    public static String getInput() {
        Scanner stringInput = new Scanner(System.in);
        String text = stringInput.nextLine();
        return text;
    }

    public static char getChar()
    {
        Scanner charInput = new Scanner(System.in);
        char text = charInput.next().charAt(0);
        return text;
    }
}