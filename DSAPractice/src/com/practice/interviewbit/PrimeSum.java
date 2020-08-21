package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        ArrayList<Integer> res = findPair(a);
        System.out.println(res);
    }

    private static ArrayList<Integer> findPair(int a) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> primes = findPrimeTillN(a);
        int p1 = 0;
        int p2 = primes.size()-1;
        while (p1 <= p2){
            int sum = primes.get(p1) + primes.get(p2);
            if (sum == a)
            {
                res.add(primes.get(p1));
                res.add(primes.get(p2));
                break;
            }
            if (sum < a)
                p1++;
            else
                p2--;
        }
        return res;
    }

    private static ArrayList<Integer> findPrimeTillN(int a) {
        boolean[] arr = new boolean[a+1];
        int i = 2;
        while (i < a+1){
            if (arr[i] == false){
                int n = i * i;
                if (n > a)
                    break;
                for (int j = n; j < a+1; j+=i){
                    arr[j] = true;
                }
            }
            i++;
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int j = 2; j < a+1; j++){
            if (arr[j] == false)
                primes.add(j);
        }
        return primes;
    }
}
