import java.util.Random;

public class Position implements Cloneable {
    private int x;
    private int y;
    private int width;
    private int height;

    public Position(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public Position clone() {
        try {
            Random random = new Random();
            Position position = (Position) super.clone();
            position.x = random.nextInt(800);
            position.y = random.nextInt(600);
            return position;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
