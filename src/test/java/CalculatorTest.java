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


}