import processing.core.PApplet;

public class Rectangle extends Shape implements Cloneable {


    public Rectangle(Position position, int stroke, Color color, boolean isSelected) {
        super(position, stroke, color, isSelected);
    }

    @Override
    public void draw(PApplet p) {
        super.draw(p);
        p.rect(getPosition().getX() - (getPosition().getWidth() / 2), getPosition().getY() - (getPosition().getHeight() / 2),
                getPosition().getWidth(), getPosition().getHeight());
    }

    @Override
    public boolean containShape(int mouseX, int mouseY) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        int width = getPosition().getWidth();
        int height = getPosition().getHeight();
        return (mouseX > (x - width / 2) && mouseX < (x + width / 2) && mouseY > (y - height / 2) && mouseY < (y + height / 2));
    }

}
