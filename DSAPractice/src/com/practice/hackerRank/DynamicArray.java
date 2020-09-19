package com.practice.hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int q = Integer.parseInt(arr[1]);
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < q; i++){
            List<Integer> query = new ArrayList<>();
            String[] que = br.readLine().split(" ");
            for (int j = 0; j < que.length; j++)
                query.add(Integer.parseInt(que[j]));
            queries.add(query);
        }
        List<Integer> ans = dynamicArray(n, queries);
        System.out.println(ans);
    }

    private static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<List<Integer>> array = new ArrayList<>();
        for (int i = 0; i < n; i++)
            array.add(new ArrayList<>());
        List<Integer> ans = new ArrayList<>();
        for (List<Integer> query : queries){
            int type = query.get(0);
            int x = query.get(1);
            int y = query.get(2);
            if (type == 1){
                int seq = (x^lastAnswer)%n;
                array.get(seq).add(y);
            }
            else {
                int seq = (x^lastAnswer)%n;
                int idx = y % array.get(seq).size();
                lastAnswer = array.get(seq).get(idx);
                ans.add(lastAnswer);
            }
        }
        return ans;
    }
}
