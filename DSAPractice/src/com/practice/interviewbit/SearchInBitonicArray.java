package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchInBitonicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        int idx = searchBitonic(list, b);
        System.out.println(idx);
    }

    private static int searchBitonic(ArrayList<Integer> list, int b) {
        int idx = -1;
        int bitonicIdx = searchBitonicIndex(list);
        if (b == list.get(bitonicIdx))
            return bitonicIdx;
        int leftIdx = binarySearch(list, b, bitonicIdx - 1);
        if (leftIdx != -1)
            return leftIdx;
        int rightIdx = binarySeacrhRight(list, b, bitonicIdx+1);
        if (rightIdx != -1)
            return rightIdx;
        return idx;
    }

    private static int binarySeacrhRight(ArrayList<Integer> list, int b, int low) {
        int high = list.size()-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (list.get(mid) == b)
                return mid;
            if (list.get(mid) > b)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    private static int binarySearch(ArrayList<Integer> list, int b, int high) {
        int low = 0;
        while (low <= high){
            int mid = (low+high)/2;
            if (list.get(mid) == b)
                return mid;
            else if (list.get(mid) > b)
                high = mid-1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private static int searchBitonicIndex(ArrayList<Integer> list) {
        int min1 = list.get(0);
        int min2 = list.get(list.size()-1);
        int low = 0;
        int high = list.size() - 1;
        while (low <= high){
            int mid = (low+high)/2;
            if (list.get(mid) == min1)
                low = mid+1;
            else if (list.get(mid) == min2)
                high = mid-1;
            else if (list.get(mid) > list.get(mid+1) && list.get(mid) > list.get(mid-1))
                return mid;
            else if (list.get(mid) < list.get(mid+1))
                low = mid + 1;
            else
                high= mid-1;
        }
        return -1;
    }
}
