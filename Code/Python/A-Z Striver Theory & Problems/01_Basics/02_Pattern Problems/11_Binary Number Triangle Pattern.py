'''
Input Format: N = 3
Result: 
1
01
101

Input Format: N = 6
Result:   
1
01
101
0101
10101
010101

'''

#Solution : 

N=6

for i in range(1, N+1):

    start=1

    if i%2 == 0:
        
        start = 0

    
    for j in range(start, i+start):
        
        print(j%2, end="")

    print()