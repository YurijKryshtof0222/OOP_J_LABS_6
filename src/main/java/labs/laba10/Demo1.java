package labs.laba10;

import javax.swing.*;
import java.awt.*;

public class Demo1 {
    public static void main(String[] args) {
        JFrame myWindow = new JFrame("Приховане вікно");
        myWindow.setSize(400, 300);
        myWindow.setLocation(50, 60);
        myWindow.setVisible(false);

        Point location = myWindow.getLocation();
        System.out.printf("window location: [x = %d, y = %d]", location.x, location.y);
        System.out.println("window title: " + myWindow.getTitle());
        System.out.println("window is visible state: " + myWindow.isVisible());
    }
}
