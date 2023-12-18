package exampleMVCgol;

// backend model for functioning of the game
public class LifeModel {
    private int[][] life;
    private int[][] nextLife;
    private int xWidth, yHeight;

    public LifeModel(int xWidth, int yHeight) {
        this.xWidth = xWidth;
        this.yHeight = yHeight;
        life = new int[xWidth][yHeight]; // current array
        nextLife = new int[xWidth][yHeight]; // next array
        initializeGrid();
    }

    private void initializeGrid() {
        // initializing the grid with random values
        for (int x = 0; x < xWidth; x++) {
            for (int y = 0; y < yHeight; y++) {
                if (Math.random() < 0.20) { // less than 20% alive cells
                    life[x][y] = 1; // current generation array
                }
            }
        }
    }

    public void updateLife() {
        for (int x = 0; x < xWidth; x++) {
            for (int y = 0; y < yHeight; y++) {
                int aliveNeighbours = countAliveNeighbours(x, y);

                // applying game rules
                if (life[x][y] == 1) { // alive cell
                    if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                        nextLife[x][y] = 0; // cell dies
                    } else {
                        nextLife[x][y] = 1; // cell stays alive
                    }
                } else { // dead cell
                    if (aliveNeighbours == 3) {
                        nextLife[x][y] = 1; // cell becomes alive
                    } else {
                        nextLife[x][y] = 0; // cell stays dead
                    }
                }
            }
        }
        copyNextLifeToLife();
    }


    private int countAliveNeighbours(int x, int y) {

        int alive = 0;

        // top left
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth) % xWidth][(y + yHeight - 1) % yHeight];

        // top right
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight - 1) % yHeight];
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight) % yHeight];

        // bottom right
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight) % yHeight];
        alive += life[(x + xWidth - 1) % xWidth][(y + yHeight + 1) % yHeight];

        // bottom left
        alive += life[(x + xWidth) % xWidth][(y + yHeight + 1) % yHeight];
        alive += life[(x + xWidth + 1) % xWidth][(y + yHeight + 1) % yHeight];

        return alive;

    }

    private void copyNextLifeToLife() {
        for (int x = 0; x < xWidth; x++) {
            for (int y = 0; y < (yHeight); y++){

                life[x][y] = nextLife[x][y];

            }
        }
    }

    public int[][] getLife() {
        return life;
    }



    // recognising patterns
    public int matchesPattern(int[][] pattern) {
        int[][] currentGrid = getLife();
        int rows = currentGrid.length;
        int cols = (rows > 0) ? currentGrid[0].length : 0;
        int count = 0;


        for (int x = 0; x < rows - pattern.length + 1; x++) {
            for (int y = 0; y < cols - pattern[0].length + 1; y++) {
                boolean match = true;

                for (int i = 0; i < pattern.length && match; i++) {
                    for (int j = 0; j < pattern[i].length; j++) {
                        if (pattern[i][j] != currentGrid[x + i][y + j]) {
                            match = false;
                            break;
                        }
                    }
                }

                if (match) {
                    count++;
                }
            }
        }

        return count;
    }





}
