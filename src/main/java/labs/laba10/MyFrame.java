package labs.laba10;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    {
        setSize(400, 300);
        setLocation(50, 60);
        setVisible(false);
    }

    public MyFrame() throws HeadlessException {
        super("Приховане вікно");
    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();

        Point location = myFrame.getLocation();

        System.out.printf("window location: [x = %d, y = %d]\n", location.x, location.y);
        System.out.println("window title: " + myFrame.getTitle());
        System.out.println("window is visible state: " + myFrame.isVisible());
    }
}
