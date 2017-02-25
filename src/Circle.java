import processing.core.PApplet;

public class Circle extends Shape implements Cloneable {


    public Circle(Position position, int stroke, Color color, boolean isSelected) {
        super(position, stroke, color, isSelected);
    }

    @Override
    public void draw(PApplet p) {
        super.draw(p);
        p.ellipse(getPosition().getX(), getPosition().getY(), getPosition().getWidth(), getPosition().getHeight());
    }

    @Override
    public boolean containShape(int mouseX, int mouseY) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        int height = getPosition().getHeight();
        return (Math.pow(mouseX - x, 2) + Math.pow(mouseY - y, 2) < Math.pow(height / 2, 2));
    }
}
