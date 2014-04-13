import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Board {
    private JPanel contentPanel;
    private JButton startBtn;
    private JButton stopBtn;
    private JButton clearBtn;
    private JButton stepBtn;
    private JPanel btnPanel;
    private JPanel boardPanel;
    public JLabel statusLabel;
    private Display display;

    public void showBoard() {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(contentPanel);
        frame.setMinimumSize(new Dimension(750, 500));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        statusLabel = new JLabel();
        statusLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        boardPanel = new Display(statusLabel);
    }
}
