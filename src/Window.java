import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JButton numberButton;
    private int windowNumber;
    private int buttonValue = 0;

    public Window(int windowNumber, int width, int height) {

        super("Window #" + windowNumber);
        this.windowNumber = windowNumber;

        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        numberButton = new JButton(String.valueOf(buttonValue));
        add(numberButton, BorderLayout.CENTER);

        numberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startIncrementThread();
            }
        });



        setVisible(true);
    }

    private void startIncrementThread() {
        new Thread(() -> {
            try {
                while (true) {
                    // Increment the button's value
                    buttonValue++;
                    numberButton.setText(String.valueOf(buttonValue));

                    // Sleep for `windowNumber` seconds
                    Thread.sleep(windowNumber * 1000);
                }
            } catch (InterruptedException ex) {
                // Handle interruption
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
