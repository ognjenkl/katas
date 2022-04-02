package tdd.stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private List<Integer> valueList;

    public Stack() {
        valueList = new ArrayList<>();
    }

    public Boolean isEmpty() {
        return valueList.size() == 0;
    }

    public Integer push(Integer num) {
        valueList.add(num);
        return num;
    }

    public Integer pop() throws UnderflowException {
        int size = valueList.size();
        if (size == 0)
            throw new UnderflowException("Stack is empty, there is nothing to pop");
        return valueList.remove(size - 1);
    }






    public class UnderflowException extends RuntimeException {
        public UnderflowException(String message) {
            super(message);
        }
    }
}
