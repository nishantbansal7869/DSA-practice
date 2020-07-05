package com.practice.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> arr = new ArrayList<>();
        arr.add(new Interval(1,3));
        arr.add(new Interval(5,8));
        arr.add(new Interval(9,11));
        arr.add(new Interval(12,13));
        margeOverlapping(arr,arr.size());
        arr.stream().forEach(s->System.out.println(s.start + " " + s.end));
    }

    public static void margeOverlapping(ArrayList<Interval> arr, int n){
        Collections.sort(arr);
        int i = 1;
        while (i < arr.size()){
            if(arr.get(i).start >= arr.get(i-1).start && arr.get(i).start <= arr.get(i-1).end){
                int start = Math.min(arr.get(i).start, arr.get(i-1).start);
                int end = Math.max(arr.get(i).end, arr.get(i-1).end);
                Interval obj = new Interval(start, end);
                arr.set(i-1,obj);
                arr.remove(i);
            }
            else {
                i++;
            }
        }
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return this.start - o.start;
    }
}
