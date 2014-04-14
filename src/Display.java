import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Display extends JPanel {

    private final int boxSize = 8;
    private final JLabel statusLabel;
    private int max_rows;
    private int max_cols;
    private State state;
    private Point over;

    private Point eventToPoint(MouseEvent e) {
        int x = (e.getX()/boxSize) * boxSize;
        int y = (e.getY()/boxSize) * boxSize;
        return new Point(x, y);
    }

    public Display(JLabel statusLabel, State state, int max_rows, int max_cols) {
        super();
        this.state = state;
        this.max_rows = max_rows;
        this.max_cols = max_cols;
        this.statusLabel = statusLabel;
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                over = eventToPoint(e);
                repaint();
            }
        });
        addMouseListener(new MouseListener () {

            @Override
            public void mouseClicked(MouseEvent e) {
                Point clicked = eventToPoint(e);
                int row = clicked.y / boxSize;
                int col = clicked.x / boxSize;
                statusLabel.setText(String.format("Clicked coords are x: %d y: %d", col, row));
                state.flip(row, col);
                repaint();
            }

            @Override public void mousePressed(MouseEvent e) {}

            @Override public void mouseReleased(MouseEvent e) {}

            @Override public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {
                over = null;
                repaint();
            }
        });
    }

    private void doDrawing(Graphics g) {
        Graphics g2d = g;
        Dimension size = getSize();
        int width = new Double(size.getWidth()).intValue();
        int columns = width/boxSize;
        int height = new Double(size.getHeight()).intValue();
        int rows = height/boxSize;
        if (rows > max_rows) {
            rows = max_rows;
        }
        if (columns > max_cols) {
            columns = max_cols;
        }
        g2d.setColor(new Color(148, 148, 148));
        for (int w = 0; w < columns; w++) {
            int step = w * boxSize;
            g2d.drawLine(step, 0, step, boxSize * rows);
        }
        for (int h = 0; h < rows; h++) {
            int step = h * boxSize;
            g2d.drawLine(0, step, boxSize * columns, step);
        }
        int step = boxSize * rows;
        g2d.drawLine(0, step, boxSize * columns, step);
        step = boxSize * columns;
        g2d.drawLine(step, 0, step, boxSize * rows);
        if (over != null) {
            g2d.setColor(new Color(193, 193, 193));
            g2d.fillRect(over.x, over.y, boxSize, boxSize);
        }
        g2d.setColor(new Color(45, 45, 45));
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (state.get(r, c)) {
                   g2d.fillRect(c * boxSize, r * boxSize, boxSize, boxSize);
                }
            }
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
