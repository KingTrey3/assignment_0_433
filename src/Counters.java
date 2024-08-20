public class Counters {
    public static void main(String[] args) {

        int input = 0;
        if (args.length > 0) {
            try {
                // Parse the first command-line argument as an integer
                input = Integer.parseInt(args[0]);

                // Print the value to confirm it has been initialized correctly
                System.out.println("The input value is: " + input);

                // You can now use 'input' as a variable in your program
                // For example, you might want to loop that many times or perform some calculation
            } catch (NumberFormatException e) {
                System.out.println("Error: The provided argument is not a valid integer.");
            }
        } else {
            System.out.println("Error: Please provide a number as a command-line argument.");
        }

        if (input > 0) {
            for (int i = 1; i <= input; i++) {
                Window window = new Window(i, 300, 300);
            }
        }
    }
}