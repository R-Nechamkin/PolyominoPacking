
import java.awt.*;
import java.util.*;

public class Packer {

    Queue<TetShape> shapeQueue = new ArrayDeque<>();
    Grid grid;


    public Packer(int length, int width){
        grid = new Grid(length, width);
    }

    public void addShapeToPack(TetShape shape){
        shapeQueue.add(shape);
    }

    public void pack(){
        long startTime = System.currentTimeMillis();
        int totalShapes = shapeQueue.size();
        int counter = 0;
        Random rand = new Random();
        TetShape shape = shapeQueue.remove();
        while (shape != null){
            boolean placed = grid.placeShape(shape);
            counter ++;
            if(!placed){
                shapeQueue.add(shape);
            }
            if(!shapeQueue.isEmpty())
                shape = shapeQueue.remove();
            else
                shape = null;

            if(counter / 5 == 1){
                counter = 0;
                grid.switchPreferedIncrementer();
            }

            if(!shapeQueue.isEmpty() && System.currentTimeMillis() - startTime > 10 * 1000){
                System.out.println("Why can't you do the packing?! :( ");
                ClientCode.main(null);
                break;
            }
        }
        System.out.println("Goodbye!");
    }


}
