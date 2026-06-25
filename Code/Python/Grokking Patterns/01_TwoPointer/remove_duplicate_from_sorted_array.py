# Remove Duplicate from Sorted Array

# Problem Statement:
# Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

# Example 1:
# Input: nums = [1,1,2]
# Output: 2, nums = [1,2]
# Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the returned length.

# Example 2:
# Input: nums = [0,0,1,1,1,2,2,3,3,4]
# Output: 5, nums = [0,1,2,3,4]

# Solution:

def removeDuplicates(nums):

    if len(nums) == 0 :
        return []

    result = [nums[0]]

    for left in range(1, len(nums)):
        if nums[left] != nums[left - 1]:
            result.append(nums[left])

    return result



print(removeDuplicates([1,1,2]))
