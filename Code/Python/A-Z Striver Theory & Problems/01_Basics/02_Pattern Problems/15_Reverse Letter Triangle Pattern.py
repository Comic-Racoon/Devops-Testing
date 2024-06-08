'''
Input Format: N = 3
Result: 
A B C
A B
A

Input Format: N = 6
Result:   
A B C D E F
A B C D E 
A B C D
A B C
A B
A
'''

#Solution :
N=3 
for i in range(0,N):
    for j in range(0,N-i):
        print(chr(65+j), end="")
    print()