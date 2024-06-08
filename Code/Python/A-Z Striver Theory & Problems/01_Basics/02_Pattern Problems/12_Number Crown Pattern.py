'''
Input Format: N = 3
Result: 
1    1
12  21
123321

Input Format: N = 6
Result:   
1          1
12        21
12       321
1234    4321
12345  54321
123456654321
'''

#solution : 

N = 6 

#solution :

spaces = 2*(N-1)

for i in range(1,N+1):

    for j in range(1,i+1):
        print(j, end="")
    
    for j in range(1, spaces + 1 ):
        print("", end=" ")
    
    for j in range(i, 0, -1):
        print(j, end="")

    spaces -= 2

    print()