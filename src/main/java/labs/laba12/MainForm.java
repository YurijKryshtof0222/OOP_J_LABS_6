package labs.laba12;

import javax.swing.*;

public class MainForm {
    private JPanel mainPanel;
    private JButton calcBtn;
    private JTextField radiusTextField;
    private JTextField angleTextField;
    private JTextField areaTextField;
    private JButton exitBtn;

    public MainForm() {
        calcBtn.addActionListener(actionEvent -> {
            try {
                double radius = Double.parseDouble(radiusTextField.getText());
                double angle = Double.parseDouble(angleTextField.getText());
                validateFields(radius, angle);

                double sectorArea = (Math.PI * Math.pow(radius, 2) * angle) / 360;
                areaTextField.setText(String.format("%.2f" ,sectorArea));
            }
            catch (NumberFormatException exc) {
                JOptionPane.showMessageDialog(mainPanel, "Помилка: Перевірте чи у полях були задані невід'ємні числові значення");
            }
        });

        exitBtn.addActionListener(actionEvent -> System.exit(0));

    }

    private static void validateFields(double... args) {
        for (double a: args) {
            if (a < 0) throw new NumberFormatException();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Обрахування площі сектора кола");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(800, 400);
        frame.add(new MainForm().mainPanel);
        frame.pack();
    }

}
