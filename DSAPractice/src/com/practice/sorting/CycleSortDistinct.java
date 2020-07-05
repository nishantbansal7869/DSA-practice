package com.practice.sorting;

import java.util.Arrays;

public class CycleSortDistinct {
    public static void main(String[] args) {
        int arr[] = new int[]{2,2,3,5,4,3};
        cycleSort(arr,arr.length);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void cycleSort(int arr[], int n){
        for(int cs = 0; cs < n-1; cs++){
            int item = arr[cs];
            int pos = cs;
            for(int i = cs+1; i < n; i++){
                if(arr[i] < item)
                    pos++;
            }
            if(pos == cs)
                continue;
            while (item == arr[pos]){
                pos += 1;
            }
            if(pos != cs) {
                int temp = arr[pos];
                arr[pos] = item;
                item = temp;
            }
            while (pos != cs){
                pos = cs;
                for(int i = cs+1; i < n; i++){
                    if(arr[i] < item)
                        pos++;
                }
                while (item == arr[pos]){
                    pos += 1;
                }
                if(item != arr[pos]) {
                    int temp = arr[pos];
                    arr[pos] = item;
                    item = temp;
                }
            }
        }
    }
   /* public static void cycleSort(int arr[], int n)
    {
        // count number of memory writes
        int writes = 0;

        // traverse array elements and put it to on
        // the right place
        for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
            // initialize item as starting point
            int item = arr[cycle_start];

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int pos = cycle_start;
            for (int i = cycle_start + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;

            // If item is already in correct position
            if (pos == cycle_start)
                continue;

            // ignore all duplicate elements
            while (item == arr[pos])
                pos += 1;

            // put the item to it's right position
            if (pos != cycle_start) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }

            // Rotate rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // Find position where we put the element
                for (int i = cycle_start + 1; i < n; i++)
                    if (arr[i] < item)
                        pos += 1;

                // ignore all duplicate elements
                while (item == arr[pos])
                    pos += 1;

                // put the item to it's right position
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
    }*/

}
