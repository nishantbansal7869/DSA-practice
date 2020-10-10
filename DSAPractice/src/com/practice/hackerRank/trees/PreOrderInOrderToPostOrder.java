package com.practice.hackerRank.trees;

import java.io.*;

public class PreOrderInOrderToPostOrder {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] preOrder = new int[n];
            int[] inOrder = new int[n];
            String[] pre = br.readLine().split(" ");
            String[] in = br.readLine().split(" ");
            for (int i = 0; i < n; i++){
                preOrder[i] = Integer.parseInt(pre[i]);
                inOrder[i] = Integer.parseInt(in[i]);
            }
            postOrder(preOrder, inOrder, 0, n-1);
            test--;
            bw.newLine();
            pos = 0;
        }
        bw.flush();
    }
static int pos = 0;
    private static void postOrder(int[] preOrder, int[] inOrder, int low, int high)throws IOException {
        if (low > high)
            return;
        int idx = search(preOrder[pos], inOrder, low, high);
        pos++;
        postOrder(preOrder, inOrder, low, idx-1);
        postOrder(preOrder, inOrder, idx+1, high);
        bw.write(inOrder[idx]+" ");
    }

    private static int search(int x, int[] inOrder, int low, int high) {
        for (int i = low; i <= high; i++){
            if (inOrder[i] == x)
                return i;
        }
        return -1;
    }
}
