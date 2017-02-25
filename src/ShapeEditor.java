import processing.core.PApplet;
import processing.event.MouseEvent;


import java.util.ArrayList;
import java.util.Stack;

public class ShapeEditor extends PApplet {

    private ArrayList<Shape> shapeList;
    private boolean ctrlPressed;
    private boolean dPressed;
    private boolean zPressed;
    private boolean yPressed;
    private int offsetX;
    private int offsetY;
    private int preX;
    private int preY;
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public ShapeEditor() {
        shapeList = new ArrayList<>();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static void main(String[] args) {
        ShapeEditor p = new ShapeEditor();
        p.runSketch();
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        background(0);
    }

    @Override
    public void draw() {
        background(0);
        for (Shape s : shapeList) {
            s.draw(this);
        }
    }


    @Override
    public void mouseClicked() {
        if (!keyPressed)
            return;
        Shape shape = findShape(mouseX, mouseY);
        if (shape != null) {
            shape.shapeSelected();
        }

        Command command = null;
        if (key == '1') {
            command = new AddCircleCommand(shapeList, mouseX, mouseY);
        } else if (key == '2') {
            command = new AddRectCommand(shapeList, mouseX, mouseY);
        }

        if (command != null) {
            command.execute();
            undoStack.push(command);
        }
    }

    @Override
    public void mouseDragged() {
        Shape shape = findFrontShape(mouseX, mouseY);
        if (shape == null) {
            return;
        }

        Command command = null;
        MovePosition movePosition = new MovePosition(offsetX, offsetY, 0, 0);
        command = new MoveShapeCommand(shape, mouseX, mouseY, movePosition);

        if (command != null) {
            command.execute();
        }
    }

    @Override
    public void mousePressed() {
        Shape shape = findFrontShape(mouseX, mouseY);
        if (shape == null) {
            return;
        }
        preX = shape.getPosition().getX();
        preY = shape.getPosition().getY();
        offsetX = shape.getPosition().getX() - mouseX;
        offsetY = shape.getPosition().getY() - mouseY;
    }

    @Override
    public void mouseReleased() {
        Shape shape = findFrontShape(mouseX, mouseY);
        if (shape == null) {
            return;
        }
        Command command = null;
        MovePosition movePosition = new MovePosition(offsetX, offsetY, preX, preY);
        command = new MoveShapeCommand(shape, mouseX, mouseY, movePosition);

        if (command != null) {
            command.execute();
            undoStack.push(command);
        }
    }

    @Override
    public void mouseWheel(MouseEvent event) {
        float wheelCount = event.getCount();
        Shape shape = findShape(mouseX, mouseY);
        if (!keyPressed || shape == null) {
            return;
        }

        key = Character.toUpperCase(key);

        switch (key) {
            case 'S':
                shape.changeStroke(wheelCount);
                break;
            case 'C':
                shape.getColor().changeGray(wheelCount);
                break;
            case 'R':
                shape.getColor().changeRed(wheelCount);
                break;
            case 'G':
                shape.getColor().changeGreen(wheelCount);
                break;
            case 'B':
                shape.getColor().changeBlue(wheelCount);
                break;
        }
    }

    @Override
    public void keyPressed() {
        Shape s = findShape(mouseX, mouseY);
        Command command = null;

        if (keyCode == CONTROL)
            ctrlPressed = true;
        else if (keyCode == 68)
            dPressed = true;
        else if (keyCode == 89)
            yPressed = true;
        else if (keyCode == 90)
            zPressed = true;
        else if (keyCode == DELETE)
            command = new DeleteShapeCommand(shapeList);

        if (ctrlPressed && zPressed && !undoStack.empty()) {
            command = undoStack.pop();
            redoStack.push(command);
            command.undo();
            return;
        }
        if (ctrlPressed && yPressed && !redoStack.empty()) {
            command = redoStack.pop();
        }

        if (ctrlPressed && dPressed && s != null) {
            command = new CopyShapeCommand(shapeList, s);
        }
        if (command != null) {
            command.execute();
            undoStack.push(command);
        }
    }

    @Override
    public void keyReleased() {
        switch (keyCode) {
            case CONTROL:
                ctrlPressed = false;
                break;
            case 68:
                dPressed = false;
                break;
            case 89:
                zPressed = false;
                break;
            case 90:
                zPressed = false;
                break;
        }
    }

    private Shape findShape(int x, int y) {
        for (Shape s : shapeList) {
            if (s.containShape(x, y)) {
                return s;
            }
        }
        return null;
    }

    private Shape findFrontShape(int x, int y) {
        for (int i = shapeList.size() - 1; i >= 0; i--) {
            Shape s = shapeList.get(i);
            if (s.containShape(x, y)) {
                return s;
            }
        }
        return null;
    }
}

