package exampleMVCgol;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LifeFrame extends JFrame {

    public LifeFrame() {
        setTitle("Game of Life");

        // Taking user input for speed and number of generations
        String speedStr = JOptionPane.showInputDialog(this, "Enter the speed of the game (in milliseconds):", "100");
        String generationsStr = JOptionPane.showInputDialog(this, "Enter the number of generations you would like:", "1000");

        int speed = Integer.parseInt(speedStr);
        int generations = Integer.parseInt(generationsStr);


        LifeModel model = new LifeModel(700, 700); // grid size
        LifeView view = new LifeView(model, 20); // cell size
        new LifeController(model, view, speed, generations, generations);

        add(view);
        // Set the size of the frame
        setSize(800, 800); // Adjust the values as needed

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                new LifeFrame();
            }
        });
    }
}
