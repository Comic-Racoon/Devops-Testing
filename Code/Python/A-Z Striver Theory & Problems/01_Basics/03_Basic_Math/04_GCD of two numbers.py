'''
Example 1:
Input:N1 = 9, N2 = 12
                
Output:3
Explanation:Factors of 9: 1, 3 and 9
Factors of 12: 1, 2, 3, 4, 6, 12
Common Factors: 1, 3 out of which 3 is the greatest hence it is the GCD.
Example 2:
Input:N1 = 20, N2 = 15
                
Output: 5
Explanation:Factors of 20: 1, 2, 4, 5
Factors of 15: 1, 3, 5
Common Factors: 1, 5 out of which 5 is the greatest hence it is the GCD.
'''

N1 = 9
N2 = 12

# solution 

gcd = 1

for i in range(1, min(N1,N2) + 1):
    if N1%i == 0 and N2%i == 0:
        gcd = i 

print(f"GCD of {N1} and {N2} is {gcd}")