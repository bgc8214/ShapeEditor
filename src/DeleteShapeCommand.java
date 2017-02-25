import java.util.ArrayList;

/**
 * Created by bgc82 on 2016-10-29.
 */
public class DeleteShapeCommand implements Command {
    private ArrayList<Shape> shapeList;

    public DeleteShapeCommand(ArrayList<Shape> shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void execute() {
        for (int i = 0; i < shapeList.size(); i++) {
            Shape s = shapeList.get(i);
            if (s.getIsSelected()) {
                shapeList.remove(i);
                i--;
            }
        }
    }
}
