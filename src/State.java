import java.util.ArrayList;

public class State {

    public class DS extends ArrayList<ArrayList<Boolean>> {};

    int maxRows;
    int maxCols;            
    DS ds1;
    DS ds2;
    DS current;

    public State(int maxRows, int maxCols) {
        this.maxRows = maxRows;
        this.maxCols = maxCols;
        ds1 = createDS(maxRows, maxCols);
        ds2 = createDS(maxRows, maxCols);
        current = ds1;
    }

    interface SetCoordinate {
        boolean setCoordinate(boolean val);
    }

    public void each(SetCoordinate operation) {
        for(int r = 0; r < maxRows; r++) {
            for (int c = 0; c < maxCols; c++) {
                current.get(r).set(c, operation.setCoordinate(get(r, c)));
            }
        }
    }

    public void clear() {
        each(val -> false);
    }

    public void flip(int row, int col) {
        if (isOutOfBounds(row, col)) {
            return;
        }
        Boolean val = get(row, col);
        current.get(row).set(col, !val);
    }

    public boolean get(int row, int col) {
        if (isOutOfBounds(row, col)) {
            // Draw no values if out of bounds. :/
            return false;
        }
        return current.get(row).get(col);
    }

    private boolean isOutOfBounds(int row, int col) {
        if (row >= maxRows) {
            return true;
        }
        if (col >= maxCols) {
            return true;
        }
        return false;
    }

    private DS createDS(int maxRows, int maxCols) {
        DS ds = new DS();
        for (int i = 0; i < maxRows; i++) {
            ArrayList<Boolean> cols = new ArrayList<Boolean>();
            for (int j = 0; j < maxCols; j++) {
               cols.add(Boolean.FALSE);
            }
            ds.add(cols);
        }
        return ds;
    }
}
