package helloworld;

public class EnumTest {

    public static void main(String []args){
        String valueString = "True";
        Double valueDouble = null;
        if (AlarmValue.TRUE.toString().equals(valueString))
            valueDouble = 1D;
        else if (AlarmValue.FALSE.toString().equals(valueString))
            valueDouble = 0D;
        else if (valueString != null)
            valueDouble = Double.valueOf(valueString);
        System.out.println(valueDouble);
    }

    public enum AlarmValue {
        TRUE("True"),
        FALSE("False");

        private final String text;

        AlarmValue(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}