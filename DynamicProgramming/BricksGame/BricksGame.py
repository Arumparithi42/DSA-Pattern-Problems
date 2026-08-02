def bricksGame(arr):
    dp = [0]*len(arr)
    tot = 0
    temp = 0
    for i in range(len(arr)-1, -1, -1):
        tot += arr[i]
        if (temp < 3):
            dp[i] = tot
            temp += 1
        else:
            dp[i] = tot - min(dp[i+1], dp[i+2], dp[i+3])
        
    return dp[0]