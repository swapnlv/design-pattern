package objectPool;

import java.awt.geom.Point2D;

public class BitMap implements Image{

    private Point2D location;

    public BitMap(String name) {
        this.name = name;
    }

    private String name;
    @Override
    public void draw() {
        System.out.println("drawing "+ name +"@ "+ location);
    }

    @Override
    public void setLocation(Point2D point2D) {
        this.location=point2D;

    }

    @Override
    public Point2D getLocation() {
        return location;
    }

    @Override
    public void reset() {
        location=null;
        System.out.println("BitMap is reset");
    }
}
