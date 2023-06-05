package Command;


import TestAssignment.CalculatorMatrix;

public class SubtractionCommand implements Command {
    private CalculatorMatrix calculateMatrix;
    private TestAssignment.Matrix[] matrices;

    public SubtractionCommand(CalculatorMatrix calculateMatrix, TestAssignment.Matrix[] matrices) {
        this.calculateMatrix = calculateMatrix;
        this.matrices = matrices;
    }

    @Override
    public TestAssignment.Matrix execute() {
        calculateMatrix.subtraction(matrices);
        return null;
    }
}
