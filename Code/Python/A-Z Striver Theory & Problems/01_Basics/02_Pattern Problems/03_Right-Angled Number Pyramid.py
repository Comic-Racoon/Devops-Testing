'''
Input Format: N = 3
Result: 
1
1 2 
1 2 3

Input Format: N = 6
Result:
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
'''

#Solution :

N = int(input(" Enter the No ?"))

for i in range(1,N+1):
    for j in range(1, i+1):
        print(j , end=" ")
    print()
