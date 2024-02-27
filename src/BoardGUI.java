import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


class BoardGUI extends JPanel {
    private int width;
    private int height;
    private int cellSize;
    private int numShapes;

    BoardGUI(int width, int height, int cellSize, int numShapes) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        this.numShapes = numShapes;
        setPreferredSize(new Dimension(width * cellSize, height * cellSize));
    }

    void drawShape(Graphics g, TetShape shape, Color color) {
        g.setColor(color);

        int x = shape.getxCoord() * cellSize;
        int y = shape.getyCoord() * cellSize;

        for (boolean[] row : shape.getArray()) {
            for (boolean cell : row) {
                if (cell) {
                    g.fillRect(x, y, cellSize, cellSize);
                }
                x += cellSize; // Move to the next column
            }
            x = shape.getxCoord() * cellSize; // Reset x-coordinate to the starting column
            y += cellSize; // Move to the next row
        }
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        List<TetShape> shapeList = new ArrayList<>();
        for (int i = 0; i < numShapes; i++) {
            shapeList.add(new TetShape("" + i));
        }


        Packer packer = new Packer(height,width);

        for (int i = 0; i < numShapes; i++) {
            packer.addShapeToPack(shapeList.get(i));
        }

        Random rand = new Random();

        packer.pack();

        // Draw polyominoes
        for (int i = 0; i < numShapes; i++) {
            drawShape(g, shapeList.get(i), Color.getHSBColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));

        }


    }


}


