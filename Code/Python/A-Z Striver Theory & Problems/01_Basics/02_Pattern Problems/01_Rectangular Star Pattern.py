'''
Example 1:
Input: N = 3
Output: 
* * *
* * *
* * *


Example 2:
Input: N = 6
Output:
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
'''

# solution : 
N = int(input("Enter the value of N"))

for i in range(N):
    for j in range(N):
        print('*', end=' ')
    print()

'''
Explanation:
    The outer loop runs N times.
    The inner loop also runs N times.
    print('*', end=' ') prints a star followed by a space without moving to a new line.
    print() at the end of the outer loop iteration moves to a new line.
'''