package TestAssignment;

import Parser.ParserOnLexemes;

import java.util.List;
import java.util.Optional;

import static Parser.ParserOnLexemes.expr;
import static Parser.ParserOnLexemes.lexAnalyze;

public class CalculatorMatrix {

    private Matrices matrices;

    private Matrix resultMatrix;

    private String expressionMatrixText = "";

    public CalculatorMatrix(Matrices matrices, String baseExpression) {
        this.matrices = matrices;
        this.setExpressionText(baseExpression);
        this.resultMatrix = getMinRowColMatrixWithValues(this.matrices, expressionMatrixText.replaceAll("[^a-zA-Z]","").charAt(0));
    }

    public void setExpressionText(String expressionMatrixText) {
        this.expressionMatrixText = expressionMatrixText;
    }

    public Matrix calculateExpression(){
        List<ParserOnLexemes.Lexeme> lexemes;
        ParserOnLexemes.LexemeBuffer lexemeBuffer;

        for (int i = 0; i < this.resultMatrix.getRows(); i++) {
            for (int j = 0; j < this.resultMatrix.getColumns(); j++) {
                lexemes = lexAnalyze(getExpression(i,j));
                lexemeBuffer = new ParserOnLexemes.LexemeBuffer(lexemes);
                this.resultMatrix.setElement(i, j, expr(lexemeBuffer));
            }
        }
        return resultMatrix;
    }

    private String getExpression(int row, int column){
        StringBuilder stringBuilder = new StringBuilder();
        int pos = 0;
        while (pos < expressionMatrixText.length()) {
            char c = expressionMatrixText.charAt(pos);
            if (c >= 'A' && c <= 'Z') {
                Optional<Matrix> matrixOptional = matrices.getMatrix(c);
                stringBuilder.append(matrixOptional.get().getElement(row,column));
                if (matrixOptional.isEmpty()) {
                    System.err.println("Matrix name '" + c + "' absent");
                }
            } else {
                stringBuilder.append(c);
            }
            pos++;
        }
        return stringBuilder.toString();
    }

    private Matrix getMinRowColMatrixWithValues(Matrices matrices, char getValueFromMatrixName) {
        /*Matrix minRowsMatrix = Arrays.asList(matrices).stream().min(Comparator.comparingInt(Matrix::getRows)).get();
        Matrix minColsMatrix = Arrays.asList(matrices).stream().min(Comparator.comparingInt(Matrix::getColumns)).get();*/

        this.resultMatrix = new Matrix(this.matrices.getMinRows(), this.matrices.getMinColumns());

        //let values from x matrix
        Optional<Matrix> optionalMatrix = matrices.getMatrix(getValueFromMatrixName);
        //Matrix getValuesFromMatrix = optionalMatrix.orElseGet(() -> matrices.next().getValue());
        if (optionalMatrix.isPresent()) {
            for (int i = 0; i < this.resultMatrix.getRows(); i++) {
                for (int j = 0; j < this.resultMatrix.getColumns(); j++) {
                    this.resultMatrix.setElement(i, j, optionalMatrix.get().getElement(i, j));
                }
            }
        }
        return this.resultMatrix;
    }

}
