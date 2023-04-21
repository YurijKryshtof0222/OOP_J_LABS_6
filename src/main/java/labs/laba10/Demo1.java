package labs.laba10;

import javax.swing.*;

public class Demo1 {
    public static void main(String[] args) {
        JFrame window = new JFrame("Приховане вікно");
        window.setSize(400, 300);
        window.setLocation(50, 60);
        window.setVisible(false);

        System.out.println("window size: " + window.getLocation());
        System.out.println("window title: " + window.getTitle());
        System.out.println("window visible state: " + window.isVisible());
    }
}
