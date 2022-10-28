// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;

int main() {
    cout<<"* \n";
    
    int t=1;
    int j=1;
    
    while(t<=5)
    {
        int i=1;
        cout<<"*";
        while(i<=j)
        {
            cout<<i;
            i++;
        }
        i--;
        while(i>=1)
        {
            i--;
            if(i==0)
            {break;}
            cout<<i;
            
        }
        t++;
        j++;
        cout<<"*\n";
    }
    
    j=j-2;
    t=1;
    while(t<=4)
    {
       int i = 1;
        cout<<"*";
        while(i<=j)
        {
            cout<<i;
            i++;
        }
        i--;
        while(i>1)
        {
            i--;
            if(i==0)
            {break;}
            cout<<i;
        }
        
        j--;
        t++;
        cout<<"*\n" ;   
    }
    
    
    
    
   cout<<"*";
    return 0;
}





/*

*
*1*
*121*
*12321*
*1234321*
*123454321*
*1234321*
*12321*
*121*
*1*
*

*/
