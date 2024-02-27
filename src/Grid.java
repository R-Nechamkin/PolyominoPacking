import java.util.Queue;
public class Grid {
    private boolean[][] board;
    int xCounter;
    int yCounter;
    boolean preferIncrementingX;

    public Grid(int length, int width) {
        board = new boolean[length][width];
        xCounter = 0;
        yCounter = 0;
    }


    public boolean placeShape(TetShape shape) {
        Position pos = new Position(yCounter, xCounter);
        if(attemptToPlace(shape, pos)){
            putShape(shape,pos);
            return true;
        }
        else {
            shape = TetShape.rotateCW(shape);
            if(attemptToPlace(shape, pos)){
                putShape(shape,pos);
                return true;
            }
            else {
                shape = TetShape.rotateCW(shape);
                if(attemptToPlace(shape, pos)){
                    putShape(shape,pos);
                    return true;
                }
                else {
                    shape = TetShape.rotateCW(shape);
                    if (attemptToPlace(shape, pos)) {
                        putShape(shape, pos);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean attemptToPlace(TetShape shape, Position pos){
        int xCoord = pos.getCol();
        int yCoord = pos.getRow();

        while (!canPut(shape, xCoord, yCoord)) {
            if(preferIncrementingX){
                if (xCoord < board[0].length){
                    xCoord++;
                }
                else if (yCoord < board.length) {
                    yCoord++;
                    xCoord = 0;
                } else {
                    return false;
                }
            }
            else {
                if (yCoord < board.length) {
                    yCoord++;
                    xCoord = 0;
                }
                else if (xCoord < board[0].length){
                    xCoord++;
                } else {
                    return false;
                }
            }

        }
        pos.setCol(xCoord);
        pos.setRow(yCoord);
        return true;
    }
    /*
        public boolean canPut(TetShape shape, int x, int y){
                 boolean[][] array = shape.getArray();
                 for (int i = 0; i < (array.length); i++){
                     for (int j = 0; j < ( array[0].length); j++) {
                         if(array[i][j] && board[y+i][x+j]) //if our shape has this box and there is already something there return false
                             return false;
                     }
                 }
                 return true;
             }
             */
/*
    public boolean canPut(TetShape shape, int x, int y) {
        boolean[][] array = shape.getArray();
        int shapeWidth = array[0].length;
        int shapeHeight = array.length;

        // Check if the shape exceeds the grid boundaries
        if (x < 0 || y < 0 || x + shapeWidth > board[0].length || y + shapeHeight > board.length) {
            return false;
        }

        // Check if the shape overlaps with any other shape on the grid
        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                if (array[i][j] && board[y + i][x + j]) {
                    return false;
                }
            }
        }

        return true;
    }

 */
    public boolean canPut(TetShape shape, int x, int y) {
        boolean[][] array = shape.getArray();
        int shapeWidth = array[0].length;
        int shapeHeight = array.length;

        // Check if the shape exceeds the grid boundaries
        if (x < 0 || y < 0 || x + shapeWidth > board[0].length || y + shapeHeight > board.length) {
            return false;
        }

        // Check if the shape overlaps with any other shape on the grid
        for (int i = 0; i < shapeHeight; i++) {
            for (int j = 0; j < shapeWidth; j++) {
                if (array[i][j] && board[y + i][x + j]) {
                    return false;
                }
            }
        }

        return true;
    }



    public void putShape(TetShape shape, Position pos) {
        int x = pos.getCol();
        int y = pos.getRow();
        shape.setCoordinates(x, y);
        boolean[][] array = shape.getArray();
        for (int i = 0; i < (array.length); i++) {

            for (int j = 0; j < (array[0].length); j++) {
                if(array[i][j]) {
                    board[y + i][x + j] = true;
                }
            }
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : board) {
            for (boolean b : row) {
                sb.append(b ? "1" : "0").append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void switchPreferedIncrementer(){
        preferIncrementingX = !preferIncrementingX;
    }

}
