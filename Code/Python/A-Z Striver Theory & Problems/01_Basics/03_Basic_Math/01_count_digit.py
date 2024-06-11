'''
Example 1:
Input:N = 12345
Output:5
Explanation:  The number 12345 has 5 digits.
Example 2:
Input:N = 7789
Output: 4
Explanation: The number 7789 has 4 digits.
'''

N = 12345

count = 0 

while N > 0:
    count+=1
    N=N//10

print(count)