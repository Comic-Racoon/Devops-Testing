'''
Input Format: N = 3
Result: 
*****  
 ***
  *   
Input Format: N = 6
Result:     
***********
 *********
  *******
   ***** 
    ***    
     *
'''

#solution :

N = 6

for i in range(N):

    for j in range(i , 0, -1):
        print(" ", end="")
    
    for j in range( (N-i)*2-1 ,0 , -1):
        print("*", end="")
    print()
    # for k in range(N)
