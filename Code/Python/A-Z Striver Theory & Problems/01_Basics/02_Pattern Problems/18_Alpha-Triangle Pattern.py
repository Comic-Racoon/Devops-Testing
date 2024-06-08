'''
Input Format: N = 3
Result: 
C
B C
A B C

65
64 65
63 64 65

Input Format: N = 6
Result:   
F
E F
D E F
C D E F
B C D E F
A B C D E F
'''

#solutio
N = 3
for i in range(0,N):

    for j in range(i+1):

        print(chr(65+N-i-1+j), end="")
    
    
    print()