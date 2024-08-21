import java.awt.*;

public class Counters {
    public static void main(String[] args) {

        int input = 0;
        int x = 50;
        int y = 50;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;

        if (args.length > 0) {
            try {
                input = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Error: The provided argument is not a valid integer.");
            }
        } else {
            System.out.println("Error: Please provide a number as a command-line argument.");
        }

        if (input > 0) {
            for (int i = 1; i <= input; i++) {
                if (x > screenSize.width) {
                    x = 50;
                    y += 315;
                }

                Window window = new Window(i, 300, 300, x, y);
                x += 350;
            }
        }
    }
}