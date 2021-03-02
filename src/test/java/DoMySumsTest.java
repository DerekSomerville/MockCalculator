import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoMySumsTest {

    private DoMySums mySums = new DoMySums();
    private Calculator calculator = new Calculator();

    @Test
    public void testDoSumsAdd(){
        assertEquals(11, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMock(){
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.first_value()).thenReturn(2);
        assertEquals(11, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockSetZero(){
        Calculator mockCalculator = mock(Calculator.class);
        when(mockCalculator.first_value()).thenReturn(2);
        mySums.setCalculator(mockCalculator);
        assertEquals(0, mySums.calculatorAdd());
    }


    @Test
    public void testDoSumsAddMockSpy(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
        mySums.setCalculator(spyCalculator);
        assertEquals(9, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockMutlipleReturns(){

        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value())
                .thenReturn(2)
                .thenReturn(3);
        mySums.setCalculator(spyCalculator);
        mySums.calculatorAdd();
        assertEquals(10, mySums.calculatorAdd());
    }

    @Test
    public void testDoSumsAddMockMutlipleCalls(){
        Calculator spyCalculator = spy(calculator);
        when(spyCalculator.first_value()).thenReturn(2);
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
        mySums.setCalculator(spyCalculator);
        assertEquals(0, mySums.calculatorAdd());
    }
}