'''
Input Format: N = 3
Result: 
  A  
 ABA 
ABCBA


Input Format: N = 6
Result:   
     A     
    ABA    
   ABCBA   
  ABCDCBA  
 ABCDEDCBA 
ABCDEFEDCBA
'''

#Soluiton :

N=3

for i in range(0,N):

    for j in range(1, N-i):
        print(" ", end="")

    breakpoint = (2*i)/2
    char=65
    for j in range(0,2*i+1):
        print(chr(char), end="")
        if j <= breakpoint:
            char+=1
        else:
            char-=1
            



    print()