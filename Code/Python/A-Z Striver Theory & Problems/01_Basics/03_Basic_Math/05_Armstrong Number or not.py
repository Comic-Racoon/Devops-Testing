'''
Example 1:
Input:N = 153
Output:True
Explanation: 13+53+33 = 1 + 125 + 27 = 153
Example 2:
Input:N = 371
Output: True
Explanation: 33+53+13 = 27 + 343 + 1 = 371
'''

#solution 

N = 153 
duplicate = N
armStrongNo = 0

while N > 0:
    temp_no = N%10
    
    armStrongNo = armStrongNo + pow(temp_no, 3)

    N = N//10

if (duplicate == armStrongNo):
    print(f"{duplicate} number is armstrong number")

else:
    print(f"{duplicate} number is not armstrong number")