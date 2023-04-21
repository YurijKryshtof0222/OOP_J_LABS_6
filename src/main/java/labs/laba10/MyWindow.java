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

        System.out.println("window size: " + myWindow.getLocation());
        System.out.println("window title: " + myWindow.getTitle());
        System.out.println("window visible state: " + myWindow.isVisible());
    }
}
