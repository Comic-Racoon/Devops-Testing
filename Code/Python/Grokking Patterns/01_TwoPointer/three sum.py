# Problem: Given an array of integers, find all unique triplets that sum to zero.
# Example:
# Input: [-1, 0, 1, 2, -1, -4]
# Output: [[-1, -1, 2], [-1, 0, 1]]
# Explanation: The triplets [-1, -1, 2] and [-1, 0, 1] sum to zero.
# Constraints:
# 1 <= nums.length <= 3000
# -10^5 <= nums[i] <= 10^5
# Solution:
# We can use two pointers to solve this problem.
# We can sort the array first, then use two pointers to find the triplets.
# We can use two pointers to find the triplets.
# We can use two pointers to find the triplets. 

def threeSum(nums):
    res = []
    nums.sort()

    for i , a in enumerate(nums):
        # as we dont want to use same value twice 
        if i > 0 and a == nums[i-1]:
            continue
        
        left, right = i + 1, len(nums) - 1 

        while left < right:
            threeSum = a + nums[left] + nums[right]

            if threeSum > 0:
                right -= 1
            elif threeSum < 0:
                left += 1 
            else:
                res.append([a, nums[left], nums[right]])
                left += 1

                while nums[left] == nums[left - 1] and left < right:
                    left += 1  
                
                right -= 1
                while left < right and nums[right] == nums[right + 1]:
                    right -= 1

    return res


print(threeSum([-3,-1,0,1,2,3,-2,4]))