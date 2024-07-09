package objectPool;

import java.awt.geom.Point2D;

public interface Image extends Poolable{

    void draw();

    void setLocation(Point2D point2D);

    Point2D getLocation();
}
