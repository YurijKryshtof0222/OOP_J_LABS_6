package labs.laba13;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    {
        setUpWindow();
        setUpMenuBar();
        revalidate();
    }

    public MainFrame() {}

    private void setUpWindow() {
        setSize(600, 400);
        setLocation(800, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Window with menu");
    }

    private void setUpMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        setUpFileMenuItem(menuBar);
        setUpEditMenuItem(menuBar);
        setUpViewMenuItem(menuBar);
        setUpHelpMenuItem(menuBar);

        setJMenuBar(menuBar);
    }

    private void setUpFileMenuItem(JMenuBar menuBar) {
        JMenu viewMenu = new JMenu("Файл");

        JMenuItem saveMenuItem = new JCheckBoxMenuItem("Зберегти");
        JMenuItem openMenuItem = new JMenuItem("Відкрити");

        JMenu sendMenu = new JMenu("Надіслати");
        JMenuItem sendMessageSubMenuItem = new JMenuItem("Повідомлення");
        JMenuItem sendFaxSubMenuItem = new JMenuItem("Факс");

        sendMenu.add(sendMessageSubMenuItem);
        sendMenu.add(sendFaxSubMenuItem);

        viewMenu.add(saveMenuItem);
        viewMenu.add(openMenuItem);
        viewMenu.add(sendMenu);

        menuBar.add(viewMenu);
    }

    private void setUpEditMenuItem(JMenuBar menuBar) {
        JMenu service = new JMenu("Редагування");

        menuBar.add(service);
    }

    private void setUpViewMenuItem(JMenuBar menuBar) {
        JMenu viewMenu = new JMenu("Вигляд");

        menuBar.add(viewMenu);
    }

    private void setUpHelpMenuItem(JMenuBar menuBar) {
        JMenu viewMenu = new JMenu("Допомога");

        menuBar.add(viewMenu);
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
