import java.util.Arrays;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;

public class TetShape {

    String id;
    boolean[][] array;
    int xCoord;  //stores the coordinates of the upper-left corner
    int yCoord;

    static Random rand = new Random();

    public TetShape(String id) {
        int randomIndex = rand.nextInt(21 );
        this.array = shapes[randomIndex];

        this.id = id;
    }


    public TetShape(boolean[][] shape, String id) {
        this.array = shape;
        this.id = id;
        //priority = (size *3) / STANDARD_SIZE;
    }




    public boolean[][] getArray() {
        return this.array;
    }

    public void setArray(boolean[][] array) {
        this.array = array;
    }

    public String getId() {
        return this.id;
    }

    // Shape 1
    static boolean[][] shape1 = {
            {true}
    };

    // Shape 2
    static boolean[][] shape2 = {
            {true},
            {true}
    };

    // Shape 3
    static boolean[][] shape3 = {
            {true, true, true}
    };

    // Shape 4
    static boolean[][] shape4 = {
            {true, true},
            {false, true}
    };

    // Shape 5
    static boolean[][] shape5 = {
            {true, true, true},
            {false, false, true}
    };

    // Shape 6
    static boolean[][] shape6 = {
            {true, true, true, true}
    };

    // Shape 7
    static boolean[][] shape7 = {
            {true, false, false},
            {true, true, true},
            {false, false, true}
    };

    // Shape 8
    static boolean[][] shape8 = {
            {true, true, true, true, true}
    };

    // Shape 9
    static boolean[][] shape9 = {
            {true, true, true},
            {false, false, true},
            {false, false, true}
    };

    // Shape 10
    static boolean[][] shape10 = {
            {true, true, true},
            {true, true, false}
    };

    // Shape 11
    static boolean[][] shape11 = {
            {true, true, false},
            {false, true, true},
            {false, false, true}
    };

    // Shape 12
    static boolean[][] shape12 = {
            {true, true, true},
            {false, true, false},
            {false, true, false}
    };

    // Shape 13
    static boolean[][] shape13 = {
            {false, true, false},
            {true, true, true},
            {false, false, true}
    };

    // Shape 14
    static boolean[][] shape14 = {
            {true, true, false},
            {false, true, true}
    };

    // Shape 15
    static boolean[][] shape15 = {
            {false, true},
            {true, true},
            {true, false}
    };

    // Shape 16
    static boolean[][] shape16 = {
            {false, true, false},
            {true, true, true},
            {false, true, false}
    };

    // Shape 17
    static boolean[][] shape17 = {
            {true, true, true},
            {false, true, false}
    };

    // Shape 18
    static boolean[][] shape18 = {
            {true, true},
            {true, true}
    };

    // Shape 19
    static boolean[][] shape19 = {
            {false, false, false, true},
            {true, true, true, true}
    };

    // Shape 20
    static boolean[][] shape20 = {
            {true, false},
            {true, true},
            {false, true},
            {false, true}
    };

    // Shape 21
    static boolean[][] shape21 = {
            {true, true, true},
            {true, false, true}
    };

    static boolean[][][] shapes = {shape1, shape2, shape3, shape4, shape5, shape6, shape7, shape8, shape9, shape10,
            shape11, shape12, shape13, shape14, shape15, shape16, shape17, shape18, shape19, shape20, shape21,
    };

    public static void addShapesToArray(boolean[][][] shapes) {
        ArrayList<boolean[][]> shapeDoubleArrs = new ArrayList<>();

        for (boolean[][] shape : shapes) {
            shapeDoubleArrs.add(shape);
        }
    }

    public void setCoordinates(int x, int y){
        this.xCoord = x;
        this.yCoord = y;
    }

    public int getxCoord(){
        return  xCoord;
    }

    public int getyCoord(){
        return yCoord;
    }

  /*
    public static final TetShape L_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, true}
    }, "L");

    public static final TetShape Line_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, false}
    }, "Line");

    public static final TetShape up_L_SHAPE = new TetShape(new boolean[][]{
            {true, true},
            {true, false},
            {true, false}
    }, "up-L");

    public static final TetShape sideT_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, true},
            {true, false}
    }, "sideT");

    public static final TetShape sideU_SHAPE = new TetShape(new boolean[][]{
            {true, true},
            {true, false},
            {true, true}
    }, "sideU");

    public static final TetShape FourLine_SHAPE = new TetShape(new boolean[][]{
            {true, false},
            {true, false},
            {true, false},
            {true, false}
    }, "4Line");
*/


    public static TetShape rotateCW(TetShape tetShape) {
        boolean[][] arr = tetShape.getArray();
        final int M = arr.length;
        final int N = arr[0].length;
        boolean[][] rotated = new boolean[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                rotated[c][M-1-r] = arr[r][c];
            }
        }
        tetShape.setArray(rotated);
        return tetShape;
    }
//
//   @Override
//   public String toString(){
//
//   }





    public static void main(String[] args) {
        boolean[][] array = {{false, true, false}, {false, false, true}, {true, false, true}, {true, true, false}};

        System.out.println("\nCreating 3x4 array");
        TetShape tetShape = new TetShape(array, "1234");
        for (boolean[] row : array) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("\nRotating right once");
        TetShape newTetShape = rotateCW(tetShape);
        System.out.println();

        for (boolean[] row : newTetShape.getArray()) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        System.out.println("Adding 21 shapes to list...");
        addShapesToArray(shapes);

        System.out.println("\nTesting creation of random shape...");
        TetShape randShape = new TetShape("random");

        for (boolean[] row : randShape.getArray()) {
            for (boolean val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(boolean[] row: array){
            for(boolean b: row){
                sb.append(b? "1" : "0").append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean hasStraightEdge(){
        boolean straightRightColumn = true;
        for(boolean[] row: array){
            if(!row[row.length -1])
                straightRightColumn = false;
        }

        boolean straightLeftColumn = true;
        for(boolean[] row: array){
            if(!row[0])
                straightLeftColumn = false;
        }

        boolean straightTopEdge = true;
        for (int i = 0; i < array.length; i++) {
            if(!array[0][i])
                straightTopEdge = false;
        }

        boolean straightBottomEdge = true;
        for (int i = 0; i < array.length; i++) {
            if(!array[array.length -1][i])
                straightBottomEdge = false;
        }

        return straightRightColumn || straightLeftColumn || straightBottomEdge || straightTopEdge;
    }



}
