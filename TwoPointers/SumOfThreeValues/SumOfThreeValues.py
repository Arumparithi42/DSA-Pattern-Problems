def three_sum(nums):
    
    # Replace this placeholder return statement with your code
    answer = []
    nums.sort()
    for k in range(0,len(nums)-2):
        if (k > 0 and nums[k] == nums[k-1]):
            continue
        i = k+1
        j = len(nums)-1
        target = -nums[k]
        while(i < j):
            tot = nums[i] + nums[j]
            if (target < tot):
                j -= 1
            elif (target > tot):
                i += 1
            else:
                answer.append([nums[i],nums[j],nums[k]])
                i += 1
                j -= 1
                while (i < j and nums[i] == nums[i-1]):
                    i += 1
                while(i < j and nums[j] == nums[j+1]):
                    j -= 1
    return answer