package labs.laba10;

import javax.swing.*;
import java.awt.*;

public class Demo1 {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Приховане вікно");
        myFrame.setSize(400, 300);
        myFrame.setLocation(50, 60);
        myFrame.setVisible(false);

        Point location = myFrame.getLocation();
        System.out.printf("window location: [x = %d, y = %d]", location.x, location.y);
        System.out.println("window title: " + myFrame.getTitle());
        System.out.println("window is visible state: " + myFrame.isVisible());
    }
}
