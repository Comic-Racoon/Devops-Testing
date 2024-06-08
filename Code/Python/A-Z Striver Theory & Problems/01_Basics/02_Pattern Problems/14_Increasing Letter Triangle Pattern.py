'''
Input Format: N = 3
Result: 
A
A B
A B C

Input Format: N = 6
Result:   
A
A B
A B C
A B C D
A B C D E
A B C D E F
'''

#Solution :

N = 6

for i in range(0,N):
    for j in range(0, i+1):
        print(chr(65 + j), end="")
    
    print()