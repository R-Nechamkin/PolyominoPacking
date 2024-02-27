import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {


    @Test
    void CoordinatesWork(){
        Packer packer = new Packer(10,10);
        TetShape shape = new TetShape("jump");
        packer.addShapeToPack(shape);
        packer.pack();
        int x = shape.getxCoord();
        int y = shape.getyCoord();

        for (boolean[] row: shape.getArray()) {
            for(boolean cell: row){
                if(cell){
                    System.out.println(x + " , " + y);
                }
                x++;
            }
            y++;
        }

    }


}