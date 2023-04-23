package labs.laba11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    {
        setSize(300, 120);
        setLocation(200, 300);
        setVisible(true);
        setResizable(false);
        addMouseListener(this);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        this.add(panel);
        panel.revalidate();
    }

    public MyFrame() throws HeadlessException {
        super("Demo");
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        label.setText("");
        panel.revalidate();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        int x = e.getX();
        int width = getWidth();

        if (x >= width) {
            label.setText("Вихід курсора за праву межу вікна");
            panel.revalidate();
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }

}
