package com.practice.hackerRank;

public class CountNoOfValley {
    public static void main(String[] args) {
        //String s = "DUDUUUUUUUUDUDDUUDUUDDDUUDDDDDUUDUUUUDDDUUUUUUUDDUDUDUUUDDDDUUDDDUDDDDUUDDUDDUUUDUUUDUUDUDUDDDDDDDDD";
        String s = "DDDUUUDUUD";
        System.out.println(noOfValley(s,s.length()));
    }
    public static int noOfValley(String s, int n){
        int count = 0;
        int seaLevel = 0;
        for(int i = 0; i < n;i++){
            if(s.charAt(i) == 'U')
                seaLevel+=1;
            if(s.charAt(i) == 'D')
                seaLevel -= 1;
            if(seaLevel < 0){
                count++;
                i++;
                while (seaLevel != 0 && i < n){
                    if(s.charAt(i) == 'U')
                        seaLevel+=1;
                    if(s.charAt(i) == 'D')
                        seaLevel -= 1;
                    i++;
                }
                i--;
            }
        }
        return count;
    }
}
