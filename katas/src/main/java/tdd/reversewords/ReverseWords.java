package tdd.reversewords;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.*;

public class ReverseWords {
    public String reverseWords(String str) {
        List<String> strList = Arrays.asList(str.split(" "));
        Collections.reverse(strList);
        return String.join(" " ,strList);

//        return StringUtils.reverseDelimited(str, ' ');

//        return Arrays.stream(str.split(" "))
//                .reduce((x, y) -> y + " " + x).get();
    }
}
