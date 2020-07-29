package com.practice.codeforces;

import java.util.Scanner;

public class DominoPiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count  = countOfDominos(m ,n);
        System.out.println(count);
    }

    private static int countOfDominos(int m, int n) {
        if (m == 1 && n == 1)
            return 0;
        if (m == 1)
            return n / 2;
        if (n == 1)
            return m / 2;
        if (n % 2 == 0){
            int count = n / 2;
            return count * m;
        }
        else {
            int countCol = n / 2;
            int countRow = countCol * m;
            int lastCol = m / 2;
            return countRow + lastCol;
        }
    }
}
