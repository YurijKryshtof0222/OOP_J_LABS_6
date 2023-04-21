package labs.laba9;

import java.util.Enumeration;
import java.util.Vector;

public class SequenceEnumeration implements Enumeration<Vector> {
    @Override
    public boolean hasMoreElements() {
        return false;
    }

    @Override
    public Vector nextElement() {
        return null;
    }
}
