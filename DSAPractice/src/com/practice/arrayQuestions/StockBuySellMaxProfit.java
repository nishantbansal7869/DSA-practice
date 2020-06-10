package com.practice.arrayQuestions;
/*
* The cost of stock on each day is given in an array A[] of size N. Find all the days on which you buy
*  and sell the stock so that in between those days your profit is maximum.

Input:
First line contains number of test cases T. First line of each test case contains an integer value N
* denoting the number of days, followed by an array of stock prices of N days.

Output:
For each testcase, output all the days with profit in a single line. And if there is no profit then print "No Profit".

User Task:
The task is to complete the function stockBuySell() which finds the days of buying and selling stock and print them.
* The newline is automatically added by the driver code.

Expected Time Complexity : O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
2 <= N <= 103
0 <= Ai <= 104

Example
Input:
5
7
100 180 260 310 40 535 695
10
23 13 25 29 33 19 34 45 65 67
5
4 2 2 2 4
5
5 5 5 5 5
9
57 69 12 59 5 9 29 29 99

Output:
(0 3) (4 6)
(1 4) (5 9)
(3 4)
No Profit
(0 1) (2 3) (4 8)

Explanation:
Testcase 1: We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.
* Now, we buy stock on day 4 and sell it on day 6.
Testcase 2: We can buy stock on day 1, and sell it on 4th day, which will give us maximum profit.
* Now, we buy stock on day 5 and sell it on day 9.
Testcase 3: We can buy stock on day 3, and sell it on 4th day, which will give us maximum profit.
Testcase 4: We cannot sell any stock that will give us profit as the price remains same.
Testcase 5: Buy on day 0 and sell on day 1. Then buy on day 2 and sell on day 3. Next, buy on day 4 and sell on day 8.

Note: Output format is as follows - (buy_day sell_day) (buy_day sell_day)
For each input, output should be in a single line.
* */

public class StockBuySellMaxProfit {
    public static void main(String[] args) {
        int price[] = new int[]{57,69,12,59,5,9,29,29,99};
        stockBuyAndSell(price,price.length);
    }
    public static void stockBuyAndSell(int price[], int n){
        int index[] = new int[n];
        int j = 0;
        for(int i = 1;i < n; i++){
            if(price[i]>price[i-1]){
                index[j] = i-1;
                j++;
                i++;
                while (i<n && price[i]>=price[i-1]){
                    i++;
                }
                index[j] = i-1;
                j++;
            }
        }
        if(j == 0){
            System.out.print("No Profit");
        }
        else {
            for (int i = 0; i < j - 1; i += 2) {
                System.out.print("("+index[i] + " " + index[i + 1] + ")" +" " );
            }
        }
    }
}
