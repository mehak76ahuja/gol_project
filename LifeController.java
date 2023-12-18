package exampleMVCgol;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// connection between model and view
public class LifeController implements ActionListener {
    private LifeModel model;
    private LifeView view;
    private Timer timer;
    private int numGenerations;
    private int generations;

    public LifeController(LifeModel model, LifeView view, int delay, int numGenerations, int generations) {
        this.model = model;
        this.view = view;
        this.numGenerations = numGenerations;
        this.generations = generations;
        timer = new Timer(delay, this);
        timer.start();
    }



    public void actionPerformed(ActionEvent e){

        // print the current generation number before decrementing
        System.out.println("Generation number: " + (generations - numGenerations + 1));

        // Stop the timer after the specified number of generations
        if (numGenerations <= 1) {
            ((Timer) e.getSource()).stop();
        } else {
            model.updateLife();
            view.repaint();
            numGenerations--;

            try {
                // sleep thread
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }


        }


        int[][] gliderPattern = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        };

        // count the gliders in current generation
        int gliderCount = model.matchesPattern(gliderPattern);
        System.out.println("The number of gliders in the current generation are: " + gliderCount);




        int[][] tumblerPattern = {
                {0, 1, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 1}
        };

        // count the tumblers in current generation
        int tumblerCount = model.matchesPattern(tumblerPattern);
        System.out.println("The number of tumblers in the current generation are: " + tumblerCount);

        int[][] spaceshipPattern = {
                {0, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0}
        };

        // count the spaceships in current generation
        int spaceshipCount = model.matchesPattern(spaceshipPattern);
        System.out.println("The number of spaceships in the current generation are: " + spaceshipCount);

        int[][] tenCellRowPattern = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // count the 10 cell rows in current generation
        int tenCellRowCount = model.matchesPattern(tenCellRowPattern);
        System.out.println("The number of 10 cell rows in the current generation are: " + tenCellRowCount);


    }


}

