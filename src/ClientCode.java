import javax.swing.*;

public class ClientCode {
    public static void main(String[] args) {
        final int height = 100;
        final int width = 100;
        final int cellSize = 10;
        final double percentSpaceToUse = .95;
        final double avgPieceSize = Math.pow(2.2, 2);
        final int numShapes = (int) (height * width * percentSpaceToUse/avgPieceSize);

        SwingUtilities.invokeLater(() -> createAndShowGUI(height, width, cellSize, numShapes));

    }


    private static void createAndShowGUI(int height, int width, int cellSize, int numShapes) {
        JFrame frame = new JFrame("Packing Polyominoes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BoardGUI(height, width, cellSize, numShapes));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
