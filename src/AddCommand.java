import java.util.ArrayList;

/**
 * Created by bgc82 on 2016-10-29.
 */
abstract class AddCommand implements Command {

    private ArrayList<Shape> shapeList;
    private int posX;
    private int posY;

    public AddCommand(ArrayList<Shape> shapeList, int posX, int posY) {
        this.shapeList = shapeList;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public void execute() {
        shapeList.add(createShape(posX, posY));
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    @Override
    public void undo() {
        shapeList.remove(shapeList.size() - 1);
        }

    protected abstract Shape createShape(int posX, int posY);


}
