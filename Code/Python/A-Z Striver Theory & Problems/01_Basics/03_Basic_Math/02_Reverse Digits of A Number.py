'''
Example 1:
Input:N = 12345
Output:54321
Explanation: The reverse of 12345 is 54321.
Example 2:
Input:N = 7789
Output: 9877
Explanation: The reverse of number 7789 is 9877.
'''

N = 12345

Ans = 0

while N > 0:
    ld = N%10
    Ans = (Ans*10) + ld
    N = N//10

print(Ans)

