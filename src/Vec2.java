package lab2;

public class Vec2 {
    private int x;

    @Override
    public boolean equals(Object obj) {
        Vec2 comp = (Vec2)obj;
        if((this.x == comp.x) && (this.y == comp.y)) {
            return true;
        }
        return false;
    }
    
    

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    private int y;

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    public Vec2() {

    }

    public Vec2(int x, int y) {
        this.x = x;
        this.y =y ;

    }
}
