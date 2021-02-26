import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    public void testCalculatorAdd(){
        assertEquals(11, calculator.add_first_and_second());
    }

    @Test
    public void testCalculatorFirstMock(){
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.first_value()).thenReturn(2);
        assertEquals(2, mockCalculator.first_value());
    }

    @Test
    public void testCalculatorAddMock(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
        assertEquals(9, spyCalculator.add_first_and_second());
    }

    @Test
    public void testDoSumsAddMock(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
        DoMySums mySums = new DoMySums();
        mySums.setCalculator(spyCalculator);
        assertEquals(9, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockMutlipleReturns(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value())
                .thenReturn(2)
                .thenReturn(3);
        DoMySums mySums = new DoMySums();
        mySums.setCalculator(spyCalculator);
        mySums.calculatorAdd();
        assertEquals(10, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockMutlipleCalls(){
        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
        DoMySums mySums = new DoMySums();
        mySums.setCalculator(spyCalculator);
        mySums.calculatorAdd();
        assertEquals(9, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockMutlipleReturnsAndCalls(){
        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value())
                .thenReturn(2)
                .thenReturn(3);
        DoMySums mySums = new DoMySums();
        mySums.setCalculator(spyCalculator);
        mySums.calculatorAdd();
        mySums.calculatorAdd();
        assertEquals(10, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockException(){
        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value())
                .thenThrow(NullPointerException.class);
        DoMySums mySums = new DoMySums();
        mySums.setCalculator(spyCalculator);
        assertEquals(0, mySums.calculatorAdd());
    }
}