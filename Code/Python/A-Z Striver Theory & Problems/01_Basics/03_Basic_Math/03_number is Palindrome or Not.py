'''
Example 1:
Input:N = 4554
Output:Palindrome Number
Explanation: The reverse of 4554 is 4554 and therefore it is palindrome number
Example 2:
Input:N = 7789
Output: Not Palindrome
Explanation: The reverse of number 7789 is 9877 and therefore it is not palindrome
'''

# Solution 

N = 123
reverse_no = 0
dup = N
while N > 0:
    
    temp_no = N%10
    
    reverse_no = (reverse_no*10) + temp_no

    N = N//10

if reverse_no == dup:
    print(f"Number {dup} is palindrome")
else :
    print(f"Number {dup} is Not palindrome")