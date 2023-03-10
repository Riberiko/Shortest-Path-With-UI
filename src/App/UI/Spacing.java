package App.UI;

public class Spacing {

    private int top;
    private int bottom;
    private int left;
    private int right;

    public Spacing(){
        this(0,0);
    }

    public Spacing(int vertical, int horizantle){
        this(vertical, horizantle, vertical, horizantle);
    }

    public Spacing(int top,int right, int bottom, int left){
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }


    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}
