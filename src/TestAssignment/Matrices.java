package TestAssignment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Matrices {
    private Map<Character, Matrix> matrices = new LinkedHashMap<Character, Matrix>();

    public Matrices(char[] names, String[] matrices) {
        if (!(names.length == matrices.length)){
            System.err.println("Matrices class constructor, init arrays length Not equal");
        }
        for (int i = 0; i < names.length; i++) {
            this.matrices.put((Character)names[i], new Matrix(matrices[i]));
        }
    }

    public Map.Entry<Character, Matrix> next() {
        Map.Entry<Character, Matrix> entry = this.matrices.entrySet().iterator().next();
        return entry;
    }

    public char[] getKeys(){
        char[] res = new char[]{};
        int i = 0;
        for (Character key : matrices.keySet()) {
            res[i] = (char)key;
            i++;
        }
        return res;
    }

    public String[] getItems(){
        String[] res = new String[]{};
        int i = 0;
        for (Map.Entry<Character, Matrix> entry : this.matrices.entrySet()) {
            res[i] = entry.getValue().toString();
            i++;
        }
        return res;
    }

    public int getMinRows() {
        int minRows = 1000;
        for (Map.Entry<Character, Matrix> entry : this.matrices.entrySet()) {
            if (minRows >= entry.getValue().getRows()){
                minRows = entry.getValue().getRows();
            };
        }
        return minRows;
    }

    public int getMinColumns() {
        int minColumns = 1000;
        for (Map.Entry<Character, Matrix> entry : this.matrices.entrySet()) {
            if (minColumns >= entry.getValue().getColumns()){
                minColumns = entry.getValue().getColumns();
            };
        }
        return minColumns;
    }

    public boolean containsMatrix(char c) {
        return getMatrix((Character)c).isPresent();
    }

    public Optional<Matrix> getMatrix(char c) {
        return Optional.ofNullable(matrices.get((Character)c));
    }

    public int size() {
        return matrices.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Matrix> matrix : this.matrices.entrySet()) {
            stringBuilder.append(matrix.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
