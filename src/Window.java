import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JButton numberButton;
    private int windowNumber;
    private int buttonValue = 0;

    public Window(int windowNumber, int width, int height, int x, int y) {

        super("Window #" + windowNumber);
        this.windowNumber = windowNumber;

        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation(x, y);

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
                    buttonValue++;
                    numberButton.setText(String.valueOf(buttonValue));

                    Thread.sleep(windowNumber * 1000);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
