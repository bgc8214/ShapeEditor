import java.util.ArrayList;

/**
 * Created by bgc82 on 2016-10-29.
 */
public class CopyShapeCommand implements Command {
    private ArrayList<Shape> shapeList;
    private Shape shape;

    public CopyShapeCommand(ArrayList<Shape> shapeList, Shape shape) {
        this.shapeList = shapeList;
        this.shape = shape;
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    @Override
    public void execute() {
        Shape clone = shape.clone();
        shapeList.add(clone);
    }

    @Override
    public void undo() {
        shapeList.remove(shapeList.size() - 1);
    }
}
