package tdd.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class StringCalculator2Test {

    private StringCalculator2 stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = makeStringCalculator2();
    }

    @Test
    void add_shouldReturnDefaultValue_NoParameters() {
        assertEquals(StringCalculator2.DEFAULT_VALUE, stringCalculator.add(""));
    }

    @Test
    void add_shouldReturnDefaultValue_EmptyParameters() {
        assertEquals(StringCalculator2.DEFAULT_VALUE, stringCalculator.add("    "));
    }

    @Test
    void add_shouldReturnOne_OneParameter() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void add_shouldReturnTwo_OneParameter() {
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    void add_shouldCalculate3_ForOneAndTwoAsParameters() {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    private StringCalculator2 makeStringCalculator2() {
        return new StringCalculator2Impl();
    }

    @Test
    void add_shouldReturn4_forOneAndThreeAsParameters() {
        assertEquals(4, stringCalculator.add("1,3"));
    }

    @Test
    void add_OneTwoAndThreeParameters_ReturnSix() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    void add_numberOfParametersFour_ReturnTen() {
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }

    @Test
    void add_numberOfParamsThreeWithNewLines_ReturnSix() {
        assertEquals(6, stringCalculator.add("1,2\n3"));
    }

    @Test
    void add_numberOfParamsFourWithNewLineAsDelimiter_ReturnEleven() {
        assertEquals(11, stringCalculator.add("1,2\n3,5"));
    }

    @Test
    void add_delimiterDefinedInString_Return3() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }
}
