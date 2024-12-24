import java.util.ArrayList;

import lab4Packages1.Circle;
import lab4Packages1.GenericTests;
import lab4Packages1.Rectangle;
import lab4Packages1.Shape;

public class Main {
    public static void main (String args []){
        ArrayList<Shape> myShapes = new ArrayList<Shape>();

    
            myShapes.add(new Circle());
    

            myShapes.add(new Rectangle());
        

        GenericTests.chooseAShape(myShapes);
    }
}
