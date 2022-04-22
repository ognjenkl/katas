package tdd.hammingNumber;

import java.util.HashMap;
import java.util.Map;

/*
A Hamming number is a positive integer of the form 2i3j5k,
for some non-negative integers i, j, and k.

Write a function that computes the nth smallest Hamming number.

Specifically:

The first smallest Hamming number is 1 = 203050
The second smallest Hamming number is 2 = 213050
The third smallest Hamming number is 3 = 203150
The fourth smallest Hamming number is 4 = 223050
The fifth smallest Hamming number is 5 = 203051
The 20 smallest Hamming numbers are given in example test fixture.

Your code should be able to compute all of the smallest 5,000 (Clojure: 2000, NASM: 13282)
Hamming numbers without timing out.
 */
public class HammingNumber {


    public long hamming(long n) {
        long two = 2L;
        long three = 3L;
        long five = 5L;
        long i = 0L;
        long j = 0L;
        long k = 0L;
        long next = 1L;
        long nextOfTwo = two;
        long nextOfThree = three;
        long nextOfFive = five;
        Map<Long, Long> hammingMap = new HashMap<>();
        hammingMap.put(0L, 1L);


        for (long ii = 1L; ii < n; ii++) {
            next = Math.min(nextOfTwo, Math.min(nextOfThree, nextOfFive));
            hammingMap.put(ii, next);

            if (next == nextOfTwo)
                nextOfTwo = two * hammingMap.get(++i);
            if (next == nextOfThree)
                nextOfThree = three * hammingMap.get(++j);
            if (next == nextOfFive)
                nextOfFive = five * hammingMap.get(++k);
        }
        return next;
    }
}
