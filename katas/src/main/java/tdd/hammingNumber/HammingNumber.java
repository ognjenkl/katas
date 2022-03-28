package tdd.hammingNumber;

import java.util.ArrayList;
import java.util.List;

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


    public int hamming(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(8);

        for (int i = 9; list.size() < n; i++) {
            if (isHummingNumber(i))
                list.add(i);
        }

        System.out.println(list);
        System.out.println(n + ": " + list.get(n - 1));
        return list.get(n - 1);
    }

    private boolean isHummingNumber(int n) {
        if (n == 1)
            return true;
        if (n % 2 == 0)
            return isHummingNumber(n / 2);

        if (n % 3 == 0)
            return isHummingNumber(n / 3);

        if (n % 5 == 0)
            return isHummingNumber(n / 5);

        return false;
    }
}
