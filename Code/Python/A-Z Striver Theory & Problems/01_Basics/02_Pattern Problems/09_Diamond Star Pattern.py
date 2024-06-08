'''
Input Format: N = 3
Result: 
  *  
 ***
***** 
*****  
 ***
  *   
Input Format: N = 6
Result:   
     *
    ***
   ***** 
  *******
 *********
***********  
***********
 *********
  *******
   ***** 
    ***    
     *
'''

# Solution 

N = 3

for i in range(0,N):
    for j in range(i, N-1):
        print(" ", end="")
    for j in range(0, (2*i)+1 ):
        print("*", end="")
    print()  

for i in range(N):
    for j in range(i , 0, -1):
        print(" ", end="")
    for j in range( (N-i)*2-1 ,0 , -1):
        print("*", end="")
    print()