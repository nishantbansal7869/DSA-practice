/*
* Given a read only array of n + 1 integers between 1 and n, find one number that repeats
* in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
* */
package com.practice.arrayQuestions;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicte {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(1);
        arr.add(4);
        arr.add(1);
        System.out.println(findDuplicate(arr));
    }
    public static int findDuplicate(List<Integer> arr){
        Set<Integer> num = new HashSet<>();
        for(int a : arr){
            if(num.contains(a)){
                return a;
            }
            else {
                num.add(a);
            }
        }

        return -1;
    }
}
