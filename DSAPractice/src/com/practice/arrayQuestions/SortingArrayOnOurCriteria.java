package com.practice.arrayQuestions;

import java.util.Arrays;
import java.util.Comparator;
//Arrays.sort() uses dual pivot quit sort
//Collections.sort() uses tim sort that is hybrid of insertion sort and merge sort.
public class SortingArrayOnOurCriteria {
    public static void main(String[] args) {
        Points arr[] = {
                new Points(3,4),
                new Points(1,4),
                new Points(9,4),
                new Points(0,3),
        };
        Arrays.sort(arr, new Mysort());
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].x + " " + arr[i].y);
        }
    }
}

class Points{
    int x;
    int y;
    Points(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Mysort implements Comparator<Points>{

    @Override
    public int compare(Points a, Points b) {
        return a.x - b.x;
    }
}
