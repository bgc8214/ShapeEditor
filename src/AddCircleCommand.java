import java.util.ArrayList;

/**
 * Created by bgc82 on 2016-10-29.
 */
public class AddCircleCommand extends AddCommand {

    public AddCircleCommand(ArrayList<Shape> list, int posX, int posY) {
        super(list, posX, posY);
    }

    @Override
    protected Shape createShape(int posX, int posY) {
        return new Circle(new Position(posX, posY, 100, 100), 1, new Color(0, 100, 55, 1), false);
    }
}
