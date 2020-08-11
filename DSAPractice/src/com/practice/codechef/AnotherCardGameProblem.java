package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnotherCardGameProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = 0;
        if (t != null && !t.isEmpty())
            test = Integer.parseInt(t);
        for (int i = 0; i < test; i++){
            String val  = br.readLine();
            if (val != null && !val.isEmpty()){
                String[] arr = val.split(" ");
                int chef = Integer.parseInt(arr[0]);
                int rick = Integer.parseInt(arr[1]);
                int result[] = findWinner(chef, rick);
                System.out.println(result[0] + " " + result[1]);
            }
        }
    }

    private static int[] findWinner(int chef, int rick) {
        int[] result = new int[2];
        int countChef = 0;
        int countRick = 0;
            int[] arr = {1,2,3,4,5,6,7,8,9};
            int i = arr.length-1;
            while (chef > 0){
                if (chef >= arr[i]) {
                   int div = chef/arr[i];
                   chef = chef - (arr[i] * div);
                   countChef = countChef + div;
                }
                else
                    i--;
            }
             i = arr.length-1;
            while (rick > 0){
                if (rick >= arr[i]){
                   int div = rick/arr[i];
                   rick = rick - (arr[i] * div);
                   countRick += div;
                }
                else
                    i--;
            }

        if (countChef < countRick){
            result[0] = 0;
            result[1] = countChef;
        }
        else {
            result[0] = 1;
            result[1] = countRick;
        }
        return result;
    }
}
