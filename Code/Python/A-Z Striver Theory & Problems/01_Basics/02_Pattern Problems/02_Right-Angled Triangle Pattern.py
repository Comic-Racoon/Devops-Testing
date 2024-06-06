'''
Input Format: N = 3
Result: 
* 
* * 
* * *

Input Format: N = 6
Result:
* 
* * 
* * *
* * * *
* * * * *
* * * * * *
'''

#Solution :
N = int(input("Enter the N value ? "))

for i in range(0, N+1):
    for j in range (i):
        print ("*" , end= " ")
    print()

