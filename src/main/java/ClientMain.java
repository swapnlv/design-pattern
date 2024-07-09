import objectPool.BitMap;
import objectPool.ObjectPool;

import java.awt.geom.Point2D;

public class ClientMain {

    public static final ObjectPool<BitMap> bitpPool=new ObjectPool<>(()->new BitMap("logo.png"),5);

    public static void  main(String[] args){
        BitMap b1=bitpPool.get();
        b1.setLocation(new Point2D.Float(10,10));

        BitMap b2=bitpPool.get();
        b2.setLocation(new Point2D.Float(20,20));

        b1.draw();
        b2.draw();
        System.out.println(b1.getLocation());
        bitpPool.release(b1);
        System.out.println(b1.getLocation());
    }
}
