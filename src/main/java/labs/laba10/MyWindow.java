package labs.laba10;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    {
        setTitle("Приховане вікно");
        setSize(400, 300);
        setLocation(50, 60);
        setVisible(false);
    }

    public MyWindow() throws HeadlessException {
        super();
    }

    public static void main(String[] args) {
        MyWindow myWindow = new MyWindow();

        Point location = myWindow.getLocation();
        System.out.printf("window location: [x = %d, y = %d]\n", location.x, location.y);
        System.out.println("window title: " + myWindow.getTitle());
        System.out.println("window is visible state: " + myWindow.isVisible());
    }
}
