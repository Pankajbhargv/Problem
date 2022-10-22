# Problem

1. Leetcode problem 1636 : https://leetcode.com/problems/sort-array-by-increasing-frequency/
2. gfg problem: https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1

// C/C++ program to find maximum number of 
// games played by winner
#include <bits/stdc++.h>

using namespace std;
 
// method returns maximum games a winner needs
// to play in N-player tournament

int maxGameByWinner(int N)
{

    int dp[N];

    //return 0 if there is only 1 player

    if (N == 1){

      return 0;

    }

     

    // for 0 games, 1 player is needed

    // for 1 game, 2 players are required

    dp[0] = 1;    

    dp[1] = 2;

     

    // loop until i-th Fibonacci number is  

    // less than or equal to N

    int i = 1;

    while (dp[i++] < N){

      dp[i] = dp[i - 1] + dp[i - 2];

    }

    if (dp[i-1] == N){

      return (i - 1);

    }
 

    // result is (i - 2) because i will be 

    // incremented one extra in while loop

    // and we want the last value which is 

    // smaller than N, so one more decrement

    return (i - 2);
}
 
// Driver code to test above methods

int main()
{

    int N = 10;

    cout << maxGameByWinner(N) << endl;

    return 0;
}
