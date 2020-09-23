package com.practice.hackerRank.stack;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
public class GameOfTwoStacks {
        /*
         * Complete the twoStacks function below.
         */
        static int twoStacks(int x, int[] a, int[] b) {
            int sum = 0;
            int count = 0;
            int i = 0;
            int j = 0;
            while(i < a.length && j < b.length){
                if(a[i] < b[j]){
                    sum += a[i];
                    i++;
                }
                else{
                    sum += b[j];
                    j++;
                }
                if(sum <= x)
                    count++;
                else
                    break;
            }
            return count;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            int g = Integer.parseInt(scanner.nextLine().trim());

            for (int gItr = 0; gItr < g; gItr++) {
                String[] nmx = scanner.nextLine().split(" ");

                int n = Integer.parseInt(nmx[0].trim());

                int m = Integer.parseInt(nmx[1].trim());

                int x = Integer.parseInt(nmx[2].trim());

                int[] a = new int[n];

                String[] aItems = scanner.nextLine().split(" ");

                for (int aItr = 0; aItr < n; aItr++) {
                    int aItem = Integer.parseInt(aItems[aItr].trim());
                    a[aItr] = aItem;
                }

                int[] b = new int[m];

                String[] bItems = scanner.nextLine().split(" ");

                for (int bItr = 0; bItr < m; bItr++) {
                    int bItem = Integer.parseInt(bItems[bItr].trim());
                    b[bItr] = bItem;
                }

                int result = twoStacks(x, a, b);

                bufferedWriter.write(result + "");
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
        }
    }
