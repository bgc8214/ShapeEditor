/**
 * Created by bgc82 on 2016-10-30.
 */
public class MovePosition {
    private int offsetX;
    private int offsetY;
    private int preX;
    private int preY;

    public MovePosition(int offsetX, int offsetY, int preX, int preY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.preX = preX;
        this.preY = preY;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public int getPreX() {
        return this.preX;
    }

    public int getPreY() {
        return this.preY;
    }
}
