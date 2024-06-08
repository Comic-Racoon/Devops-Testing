'''
Input Format: N = 3
Result: 
1
2 3
4 5 6

Input Format: N = 6
Result:   
1
2  3
4  5  6
7  8  9  10
11  12  13  14  15
16  17  18  19  20  21

'''

#Solution :

N = 6
count = 1
for i in range(1,N+1):

    for j in range(1, i+1):
        print(count, end="")
        count+=1
    
    print()