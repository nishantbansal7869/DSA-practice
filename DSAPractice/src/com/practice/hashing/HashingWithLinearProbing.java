package com.practice.hashing;

import java.util.ArrayList;

public class HashingWithLinearProbing {
    public static void main(String[] args) {
        HashLinear obj = new HashLinear(19);
       obj.insert(944101);
       obj.insert(432332);
       obj.insert(4730);
       obj.insert(779357);
       obj.insert(767178);
       obj.insert(118088);
       obj.insert(453314);
       obj.insert(459419);
       obj.insert(396271);
       obj.insert(213804);
       obj.insert(219101);
       obj.insert(515641);
       obj.insert(633968);
       obj.insert(252800);
       obj.insert(562126);
       obj.insert(935684);
       obj.insert(662662);
       obj.insert(770828);
       obj.insert(801862);
       obj.insert(630757);
       obj.insert(17307);
       obj.insert(796521);
       obj.insert(933071);
       obj.print();
    }
}

class HashLinear{
    ArrayList<Integer> list;
    int size;
    HashLinear(int size){
        this.size = size;
        list = new ArrayList<>(this.size);
        for(int i = 0; i < this.size; i++){
            list.add(i,-1);
        }
    }
    int hash(int key){
        return key % this.size;
    }

    boolean insert(int key){
        int probe = hash(key);
        int start = probe;
        int flag = 0;
        int offset = 1;
        while (list.get(probe) != -1 && list.get(probe) != -2 && list.get(probe)!= key){
            probe = (probe + offset)%this.size;
            if(probe == start || list.get(probe) == key) {
                return false;
            }
        }
            list.set(probe, key);
            return true;
    }

    boolean delete(int key){
        int probe = hash(key);
        int offset = 1;
        int start = probe;
        while (list.get(probe) != -1){
            if(list.get(probe) == key){
                list.set(probe,-2);
                return true;
            }
            else {
                probe = (probe+offset)%this.size;
                if(probe == start)
                    return false;
            }
        }
        return false;
    }

    boolean search(int key){
        int probe = hash(key);
        int start = probe;
        int offset = 1;
        do{
            if(list.get(probe) == key)
                return true;
            else {
                probe = (probe + offset) % this.size;
            }
        }while (list.get(probe)!= -1 && probe != start);
        return false;
    }

    void print(){
        System.out.println(list);
    }

}