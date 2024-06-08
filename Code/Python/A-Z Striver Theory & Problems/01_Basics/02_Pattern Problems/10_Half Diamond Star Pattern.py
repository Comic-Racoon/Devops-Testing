'''
Input Format: N = 3
Result: 
  *  
  **
  ***  
  **
  *   
Input Format: N = 6
Result:   
     *
     **
     *** 
     ****
     *****
     ******  
     *****
     ****
     ***    
     **
     *
'''

#solution

N = 3

for i in range(1,(N*2)):
    
    if i <= N :
      for j in range(1,i+1):
         print("*", end="")
    
    else:
      for j in range(1, (2 * N) - i + 1):
        print("*", end="")

    print()
    

'''
Explanation:

    Loop Control: The loop runs from 1 to 2N - 1. This creates the first half (increasing stars) and the second half (decreasing stars) of the pattern.
    Increasing Stars: When i is less than or equal to N, it prints stars from 1 to i.
    Decreasing Stars: When i is greater than N, it prints stars from 1 to (2 * N) - i.

'''