import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {
    private final int MAX_ROWS = 1000;
    private final int MAX_COLS = 1000;
    private State state;
    private JPanel contentPanel;
    private JButton startBtn;
    private JButton stopBtn;
    private JButton clearBtn;
    private JButton stepBtn;
    private JPanel btnPanel;
    private JPanel boardPanel;
    public JLabel statusLabel;
    private Display display;

    public Board() {
        clearBtn.addActionListener(e -> {
            state.clear();
            boardPanel.repaint();
        });
    }



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
        state = new State(MAX_ROWS, MAX_COLS);
        statusLabel = new JLabel();
        statusLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
        boardPanel = new Display(statusLabel, state, MAX_ROWS, MAX_COLS);
    }
}
