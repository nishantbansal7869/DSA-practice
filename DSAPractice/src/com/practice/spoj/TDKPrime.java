package com.practice.spoj;

import java.io.*;

public class TDKPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());
        boolean[] primes = new boolean[(int)1e8+1];
        int[] list = computePrime(primes, 86028121);
        while (q > 0){
            int k = Integer.parseInt(br.readLine());
            bw.write(list[k-1] + " ");
            bw.newLine();
            q--;
        }
        bw.flush();
    }

    private static int[] computePrime(boolean[] primes, int n) {
        int[] arr = new int[(int)6e6];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (!primes[i]){
                for (int j = i * i; j <= n; j+=i)
                    primes[j] = true;
            }
        }
        int idx = 0;
        arr[idx++] = 2;
        for (int i = 3; i <= n; i+=2) {
            if (!primes[i])
                arr[idx++] = i;
        }
        return arr;
    }
}
