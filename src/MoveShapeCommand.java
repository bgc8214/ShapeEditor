/**
 * Created by bgc82 on 2016-10-29.
 */
public class MoveShapeCommand implements Command {
    private Shape shape;
    private int posX;
    private int posY;
    private MovePosition movePosition;

    public MoveShapeCommand(Shape shape, int posX, int posY, MovePosition movePosition) {
        this.shape = shape;
        this.posX = posX;
        this.posY = posY;
        this.movePosition = movePosition;
    }


    @Override
    public void execute() {
        shape.getPosition().setX(posX + movePosition.getOffsetX());
        shape.getPosition().setY(posY + movePosition.getOffsetY());
    }

    @Override
    public boolean canUndo() {
        return true;
    }

    @Override
    public void undo() {
        shape.getPosition().setX(movePosition.getPreX());
        shape.getPosition().setY(movePosition.getPreY());
    }
}
