public class Color implements Cloneable {
    private int gray;
    private int red;
    private int green;
    private int blue;

    public Color(int gray, int red, int green, int blue) {
        this.gray = gray;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public Color clone() {
        try {
            return (Color) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void changeRed(float level) {
        red += level * 5;
        red = (red < 0) ? 0 : (red > 255) ? 255 : red;
    }

    public void changeGreen(float level) {
        green += level * 5;
        green = (green < 0) ? 0 : (green > 255) ? 255 : green;
    }

    public void changeBlue(float level) {
        blue += level * 5;
        blue = (blue < 0) ? 0 : (blue > 255) ? 255 : blue;
    }

    public void changeGray(float level) {
        changeBlue(level);
        changeGreen(level);
        changeRed(level);
    }


}
