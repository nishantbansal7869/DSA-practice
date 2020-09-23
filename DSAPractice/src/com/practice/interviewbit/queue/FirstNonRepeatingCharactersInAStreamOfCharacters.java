package com.practice.interviewbit.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingCharactersInAStreamOfCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String ans = createString(a);
        System.out.println(ans);
    }

    private static String createString(String a) {
        StringBuilder b = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();
        Queue<Character> queue1 = new ArrayDeque<>();
        b.append(a.charAt(0));
        queue.add(a.charAt(0));
        queue1.add(a.charAt(0));
        for (int i = 1; i < a.length(); i++){
            if (!queue.isEmpty() && !queue.contains(a.charAt(i))){
                queue.add(a.charAt(i));
                queue1.add(a.charAt(i));
            }
            else if (!queue.isEmpty() && queue.contains(a.charAt(i)))
                queue1.remove(a.charAt(i));
            b.append(queue1.isEmpty() ? '#' : queue1.peek());
        }
        return b.toString();
    }
}
