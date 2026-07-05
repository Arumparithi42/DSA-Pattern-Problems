def validPalindrome(self, s: str) -> bool:
    i = 0; j = len(s) -1
    while(i<j):
        if(s[i] != s[j]):
            si = s[i+1:j+1]
            sj = s[i:j]
            return si == si[::-1] or sj == sj[::-1]
        i += 1
        j -= 1
    return True