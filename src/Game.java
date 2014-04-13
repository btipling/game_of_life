import javax.swing.*;

public class Game {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> run());
    }

    private static void run() {
        Board board = new Board();
        board.showBoard();
    }
}
