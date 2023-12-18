package exampleMVCgol;

import javax.swing.JPanel;
import java.awt.*;

public class LifeView extends JPanel {
    private LifeModel model;
    private int cellSize;


    public LifeView(LifeModel model, int cellSize) {
        this.model = model;
        this.cellSize = cellSize;

        setBackground(new Color(255, 105, 180));
        // background color
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawCells(g);
    }

    private void drawGrid(Graphics g) {
        int[][] grid = model.getLife();
        int rows = grid.length;
        int cols = (rows > 0) ? grid[0].length: 0;

        g.setColor(Color.BLACK);

        for (int i = 0; i < grid.length; i++){

            g.drawLine(0, i * cellSize, cols * cellSize, i * cellSize); // row
            g.drawLine(i * cellSize, 0, i * cellSize, rows * cellSize); // column

        }
    }

    private void drawCells(Graphics g) {
        int[][] grid = model.getLife();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == 1) {
                    g.setColor(Color.BLACK); // color for alive cells
                    g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
    }
}
