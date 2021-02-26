public class Calculator {
    public  int first_value(){
        return 4;
    }
    public int second_value(){
        return 7;
    }
    public int add_first_and_second(){
        int result;
        try {
            result = this.first_value() + this.second_value();
        } catch (NullPointerException exp) {
            result = 0;
        }
        return result;
    }
}
