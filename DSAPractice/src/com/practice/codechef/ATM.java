/*
* Pooja would like to withdraw X $US from an ATM. The cash machine will only accept the transaction if X is a
* multiple of 5, and Pooja's account balance has enough cash to perform the withdrawal transaction
* (including bank charges). For each successful withdrawal the bank charges 0.50 $US. Calculate Pooja's
* account balance after an attempted transaction.

Input
Positive integer 0 < X <= 2000 - the amount of cash which Pooja wishes to withdraw.

Nonnegative number 0<= Y <= 2000 with two digits of precision - Pooja's initial account balance.

Output
Output the account balance after the attempted transaction, given as a number with two digits of precision.
* If there is not enough money in the account to complete the transaction, output the current bank balance.

Example - Successful Transaction
Input:
30 120.00

Output:
89.50
Example - Incorrect Withdrawal Amount (not multiple of 5)
Input:
42 120.00

Output:
120.00
Example - Insufficient Funds
Input:
300 120.00

Output:
120.00
* */

package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int withdrawAmount = 0;
        double balance = 0.0;
        if(s == null || s.isEmpty()){
            withdrawAmount = 0;
            balance = 0.00;
        }
        else {
            String[] s1 = s.split(" ");
            withdrawAmount = Integer.parseInt(s1[0]);
            balance = Double.parseDouble(s1[1]);
        }
        double remainingBalance = atm(withdrawAmount, balance);
        System.out.println(String.format("%.2f", remainingBalance));
    }

    private static double atm(int withdrawAmount, double balance) {
        if(withdrawAmount % 5 == 0 && (withdrawAmount + 0.50) < balance){
            return balance - withdrawAmount - 0.50;
        }
        return balance;
    }

}
