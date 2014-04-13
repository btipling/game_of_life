import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Display extends JPanel {

    private final int boxSize = 10;
    private final JLabel statusLabel;
    private Point over;
    private Point clicked;

    private Point eventToPoint(MouseEvent e) {
        int x = (e.getX()/boxSize) * boxSize;
        int y = (e.getY()/boxSize) * boxSize;
        return new Point(x, y);
    }

    public Display(JLabel statusLabel) {
        super();
        this.statusLabel = statusLabel;
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                over = eventToPoint(e);
                statusLabel.setText(String.format("p moved is %s", over.toString()));
            }
        });
        addMouseListener(new MouseListener () {

            @Override
            public void mouseClicked(MouseEvent e) {
                statusLabel.setText(String.format("E clicked is %s", e.toString()));

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

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
        g2d.setColor(new Color(128, 128, 128));
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
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
