'''
Input Format: N = 3
Result: 
1 2 3
1 2
1

Input Format: N = 6
Result:
1 2 3 4 5 6
1 2 3 4 5
1 2 3 4
1 2 3
1 2 
1
'''

N = 6

for i in range(0,N+1):
    for j in range(1, N-i+1 ):
        print(j , end=" ")
    print()