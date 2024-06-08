'''
Input Format: N = 3
Result: 
* * *
* * 
*

Input Format: N = 6
Result:
* * * * * *
* * * * * 
* * * * 
* * * 
* * 
* 
'''

#solution

N = 3

for i in range(0,N):
    for j in range(i,N):
        print("*", end=" ")
    print()