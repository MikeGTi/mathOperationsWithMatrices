import java.util.Arrays;
import java.util.Objects;

public class Matrix {
    private final int rows;
    private final int columns;
    private final int[][] matrix;

    public void setElement(int _row, int _column, int _value) {

        matrix[_row][_column] = _value;
    }

    public int getElement(int _row, int _column) {
        return matrix[_row][_column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Matrix(int _rows, int _columns) {
        this.rows = _rows;
        this.columns = _columns;
        this.matrix = new int[rows][columns];
    }

    public Matrix(String _dataNumbers) {
        String[] rows = _dataNumbers.split("; ");
        this.matrix = new int[rows.length][rows[0].split("\\s").length];

        this.rows = rows.length;
        this.columns = rows[0].split("\\s").length;

        for (int i = 0; i < rows.length; i++) {
            String[] cols = rows[i].split("\\s");
            for (int j = 0; j < cols.length; j++) {
                cols[j] = cols[j].replaceAll("[\\[\\]]", "");
                this.matrix[i][j] = Integer.parseInt(cols[j]);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix matrix1)) return false;
        return getRows() == matrix1.getRows() && getColumns() == matrix1.getColumns() && Arrays.deepEquals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getRows(), getColumns());
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j != 0) stringBuilder.append(" ");
                stringBuilder.append(this.matrix[i][j]);
            }
            if (i != rows - 1) stringBuilder.append("; ");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public Matrix copy() {
        Matrix res = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                res.setElement(i, j, this.getElement(i, j));
            }
        }
        return res;
    }

    public void print() {
        /*StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                stringBuilder.append(matrix[i][j] + " ");
            }
            stringBuilder.replace(stringBuilder.length()-1,stringBuilder.length(),"; ");
        }
        stringBuilder.replace(stringBuilder.length()-2,stringBuilder.length(),"]");*/
        System.out.println(this);
    }
}
