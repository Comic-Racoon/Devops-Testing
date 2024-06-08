'''
Input Format: N = 3
Result: 
A
B B
C C C

Input Format: N = 6
Result:   
A 
B B
C C C
D D D D
E E E E E
F F F F F F
'''

#Solution :
N=6
for i in range(0,N):
    for j in range(0, i+1):
        print(chr(65+i), end="")
    print()
