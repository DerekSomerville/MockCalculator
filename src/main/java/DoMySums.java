public class DoMySums {
    private Calculator calculator = new Calculator();

    public void setCalculator(Calculator calculator){
        this.calculator = calculator;
    }

    public int calculatorAdd(){
        return calculator.add_first_and_second();
    }
}
