import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockCalculator {

    private Calculator calculator = new Calculator();

    @Test
    public void testCalculatorAdd(){
        int result = calculator.add_first_and_second();
        System.out.println("testCalculatorAdd: " + result);
        assertEquals(11, result);
    }

    @Test
    public void testCalculatorFirstMock(){
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.first_value()).thenReturn(2);
        int result = mockCalculator.first_value();
        System.out.println("testCalculatorFirstMock: " + result);
        assertEquals(2, result);
    }

    @Test
    public void testCalculatorAddMock(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
        int result = spyCalculator.add_first_and_second();
        System.out.println("testCalculatorAddMock: " + result);
        assertEquals(9, result);
    }

    @Test
    public void testDoSumsAddMock(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
        DoMySums mySums = new DoMySums();
        mySums.setCalculator(spyCalculator);
        int result = mySums.calculatorAdd();
        System.out.println("testDoSumsAddMock: " + result);
        assertEquals(9, result);
    }
}
