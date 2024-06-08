'''
Input Format: N = 3
Result: 
  *  
 *** 
*****   
Input Format: N = 6
Result:
     *     
    ***    
   *****   
  *******  
 ********* 
***********
'''

#Solution 

N = 6

# solution 1 (my)
for i in range(0,N):

    for j in range(i, N-1):
        print(" ", end="")

    for j in range(0, (2*i)+1 ):
        print("*", end="")

    print()  

print("-------------------------------------") 

# solution 2 (gfg) 
for i in range(1, N + 1):
    # Print leading spaces
    for j in range(N - i):
        print(" ", end="")
        
    # Print asterisks for the current row
    for k in range(1, 2*i):
        print("*", end="")

    print()



