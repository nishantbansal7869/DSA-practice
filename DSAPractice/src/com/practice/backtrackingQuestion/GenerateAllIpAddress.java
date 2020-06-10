package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateAllIpAddress {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> allIpAddress = new ArrayList<>();
        allIpAddress = findIdAddress(s,allIpAddress);
        allIpAddress.stream().forEach(ip -> System.out.println(ip));
    }
    public static List<String> findIdAddress(String s, List<String > allIpAddress){
        int path[] = new int[4];
         snapshotIp(s,allIpAddress,path,0,0);
        return allIpAddress;
    }

    private static void snapshotIp(String s, List<String> allIpAddress, int[] path, int buildIndex, int segment)
    {
        if(segment == 4 && buildIndex == s.length()){
            allIpAddress.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
            return;
        }
        if(segment == 4 || buildIndex == s.length())
            return;

        for(int len = 1; len <= 3 && buildIndex+len <= s.length(); len++){
            String snap = s.substring(buildIndex,buildIndex+len);
            int value = Integer.parseInt(snap);
            if(value > 255 || len>= 2 && s.charAt(buildIndex) == '0'){
                break;
            }
            path[segment] = value;
            snapshotIp(s,allIpAddress,path,buildIndex+len,segment+1);
            path[segment] = -1;
        }
    }
}
