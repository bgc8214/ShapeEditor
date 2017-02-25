import processing.core.PApplet;


public abstract class Shape implements Cloneable {
    private Position position;
    private int stroke;
    private Color color;
    private boolean isSelected;

    @Override
    public Shape clone() {
        try {
            Shape shape = (Shape) super.clone();
            shape.position = this.position.clone();
            shape.color = this.color.clone();
            return shape;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Shape(Position position, int stroke, Color color, boolean isSelected) {
        this.position = position;
        this.stroke = stroke;
        this.color = color;
        this.isSelected = isSelected;
    }

    public abstract boolean containShape(int mouseX, int mouseY);

    public void draw(PApplet p) {
        if (isSelected) {
            p.stroke(0, 255, 255);
        } else {
            p.stroke(255, 0, 0);
        }
        p.strokeWeight(stroke);
        p.fill(color.getRed(), color.getGreen(), color.getBlue());
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void changeStroke(float level) {
        stroke += level;
        stroke = (stroke < 0) ? 0 : stroke;
    }

    public void shapeSelected() {
        this.isSelected = !isSelected;
    }

    public Color getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }

}
