package tdd.stringcalculator;

public class StringCalculator2Impl implements StringCalculator2 {

    @Override
    public Integer add(String numbers) {
        Integer retVal = DEFAULT_VALUE;

        if (numbers == null)
            return retVal;
        if (numbers.isBlank())
            return retVal;

        if(numbers.contains(",")){
            String[] numbersArray = numbers.split(",");
            retVal = Integer.valueOf(numbersArray[0]) + Integer.valueOf(numbersArray[1]);
        } else
            retVal = Integer.valueOf(numbers);

        return  retVal;
    }
}
