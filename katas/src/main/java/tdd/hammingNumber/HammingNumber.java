package tdd.hammingNumber;

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
        long countSmallest = 0;
        for (long i = 1; countSmallest < n; i++) {
            if (!isHammingNumberRecursion(i)) {
                continue;
            }
            if (++countSmallest == n) {
                System.out.println(countSmallest + ". " + i);
                return i;
            }
        }
        return 0;
    }

    boolean isHammingNumberRecursion(long n) {
        if (n == 1)
            return true;
        if (n % 2 == 0)
            return isHammingNumberRecursion(n / 2);
        if (n % 3 == 0)
            return isHammingNumberRecursion(n / 3);
        if (n % 5 == 0)
            return isHammingNumberRecursion(n / 5);
        return false;
    }
}
