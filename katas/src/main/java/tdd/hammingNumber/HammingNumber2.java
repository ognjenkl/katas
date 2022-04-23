package tdd.hammingNumber;

import java.util.HashMap;
import java.util.Map;

public class HammingNumber2 {

    public Long hamming(Long n) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        long ii = 0L;
        long next = map.get(ii++);

        long multipleOf2 = 2L;
        long multipleOf3 = 3L;
        long multipleOf5 = 5L;

        for (long i = 0L, j = 0L, k = 0L; ii < n; ii++) {
            next = Math.min(multipleOf2, Math.min(multipleOf3, multipleOf5));
            map.put(ii, next);
            if (multipleOf2 == next)
                multipleOf2 = 2L * map.get(++i);
            if (multipleOf3 == next)
                multipleOf3 = 3L * map.get(++j);
            if (multipleOf5 == next)
                multipleOf5 = 5L * map.get(++k);

        }
        return next;
    }
}
