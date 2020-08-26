package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class HotelBookingsPossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr = sc.nextInt();
        ArrayList<Integer> arrival = new ArrayList<>(arr);
        for (int i = 0; i < arr; i++)
            arrival.add(i, sc.nextInt());
        int dep = sc.nextInt();
        ArrayList<Integer> depart = new ArrayList<>();
        for (int i = 0; i < dep; i++)
            depart.add(i, sc.nextInt());
        int k = sc.nextInt();
        boolean possible = findRooms(arrival, depart, k);
        System.out.println(possible);
    }

    private static boolean findRooms(ArrayList<Integer> arrival, ArrayList<Integer> depart, int k) {
        Collections.sort(arrival);
        Collections.sort(depart);
        int count = 1;
        int i = 1;
        int j = 0;
        while (i < arrival.size() && j < depart.size()){
            if (arrival.get(i) <= depart.get(j)){
                count++;
                i++;
                if (count > k)
                    return false;
            }
            else {
               count--;
                j++;
            }
        }
        return true;
    }
}
