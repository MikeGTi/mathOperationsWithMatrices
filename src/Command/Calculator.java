package Command;

public class Calculator {
    Command addition;
    Command subtraction;
    Command multiplication;

    public Calculator(Command addition, Command subtraction, Command multiplication) {
        this.addition = addition;
        this.subtraction = subtraction;
        this.multiplication = multiplication;
    }

    public TestAssignment.Matrix sum(){
        return addition.execute();
    }

    public TestAssignment.Matrix subtract(){
        return subtraction.execute();
    }

    public TestAssignment.Matrix multiply(){
        return multiplication.execute();
    }

}
