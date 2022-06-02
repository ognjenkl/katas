package tdd.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tdd.stringcalculator.StringCalculator2Impl.NegativeNumberException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class StringCalculator2Test {

    private StringCalculator2 stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = makeStringCalculator2();
    }

    @Test
    void add_shouldReturnDefaultValue_noParameters() {
        assertEquals(StringCalculator2.DEFAULT_VALUE, stringCalculator.add(""));
    }

    @Test
    void add_shouldReturnDefaultValue_emptyParameters() {
        assertEquals(StringCalculator2.DEFAULT_VALUE, stringCalculator.add("    "));
    }

    @Test
    void add_shouldReturnOne_oneParameter() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void add_shouldReturnTwo_oneParameter() {
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    void add_shouldCalculate3_forOneAndTwoAsParameters() {
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
    void add_oneTwoAndThreeParameters_returnSix() {
        assertEquals(6, stringCalculator.add("1,2,3"));
    }

    @Test
    void add_numberOfParametersFour_returnTen() {
        assertEquals(10, stringCalculator.add("1,2,3,4"));
    }

    @Test
    void add_numberOfParamsThreeWithNewLines_returnSix() {
        assertEquals(6, stringCalculator.add("1,2\n3"));
    }

    @Test
    void add_numberOfParamsFourWithNewLineAsDelimiter_returnEleven() {
        assertEquals(11, stringCalculator.add("1,2\n3,5"));
    }

    @Test
    void add_delimiterDefinedInString_return3() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    void add_delimiterDefinedInString_return6() {
        assertEquals(6, stringCalculator.add("//;\n1;2;3"));
    }

    @Test
    void add_ifThereIsNegativNumber_throwExceptionWithThatNumberInMessage() {
        NegativeNumberException negativeNumberException = assertThrows(
                NegativeNumberException.class, () -> stringCalculator.add(("-1")));
        assertTrue(negativeNumberException.getMessage().startsWith("negatives not allowed"));
        System.out.println(negativeNumberException.getMessage());
        assertEquals("negatives not allowed: [-1]", negativeNumberException.getMessage());
    }

    @Test
    void add_ifThereIsTwoNegativNumbers_throwExceptionWithThatNumbersInMessage() {
        NegativeNumberException negativeNumberException = assertThrows(
                NegativeNumberException.class, () -> stringCalculator.add(("-1,3,-2")));
        assertTrue(negativeNumberException.getMessage().startsWith("negatives not allowed"));
        assertEquals("negatives not allowed: [-1, -2]", negativeNumberException.getMessage());
    }

    @Test
    void add_ifThereIsTwoNegativNumbers_throwExceptionWithThatNumbersInMessage2() {
        NegativeNumberException negativeNumberException = assertThrows(
                NegativeNumberException.class, () -> stringCalculator.add(("-1\n3,-2")));
        assertTrue(negativeNumberException.getMessage().startsWith("negatives not allowed"));
        assertEquals("negatives not allowed: [-1, -2]", negativeNumberException.getMessage());
    }

    @Test
    void add_ifThereIsTwoNegativNumbers_throwExceptionWithThatNumbersInMessage3() {
        NegativeNumberException negativeNumberException = assertThrows(
                NegativeNumberException.class, () -> stringCalculator.add(("//;\n-1;3;-2")));
        assertTrue(negativeNumberException.getMessage().startsWith("negatives not allowed"));
        assertEquals("negatives not allowed: [-1, -2]", negativeNumberException.getMessage());
    }

    @Test
    void getCalledCount_calculatesHowManyTimesAddWasCalled_return1() {
        stringCalculator.add("1,2");
        Integer count = stringCalculator.getCalledCount();
        assertEquals(1, count);
    }

    @Test
    void getCalledCount_callAdd2_return2() {
        stringCalculator.add("1,2");
        stringCalculator.add("//;\n1;3;2");
        Integer count = stringCalculator.getCalledCount();
        assertEquals(2, count);
    }

    @Test
    void add_ignoreNumbersGT1000_return2() {
        Integer sum = stringCalculator.add("2,1001");
        assertEquals(2, sum);
    }

    @Test
    void add_ignoreNumbersGT1000_return1001() {
        Integer sum = stringCalculator.add("2,1001\n999");
        assertEquals(1001, sum);
    }

    @Test
    void add_delimitersOfAnyLength_return6() {
        Integer sum = stringCalculator.add("//[***]\n1***2***3");
        assertEquals(6, sum);
    }

    @Test
    void add_multipleDelimitersPredefined_return6() {
        Integer sum = stringCalculator.add("//[*][%]\n1*2%3");
        assertEquals(6, sum);
    }

    @Test
    void add_multipleDelimitersOfAnyLength_return6() {
        Integer sum = stringCalculator.add("//[**][%%]\n1**2%%3");
        assertEquals(6, sum);
    }
}
