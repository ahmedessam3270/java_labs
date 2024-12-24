package lab4Packages1;

import java.util.ArrayList;

public class GenericTests {
    public static void chooseAShape(ArrayList<Shape> list){
        for (int i = 0; i < list.size(); i++){
            list.get(i).draw();
        }
    }
}
