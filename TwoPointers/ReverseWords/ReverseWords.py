def reverseWords(self, s: str) -> str:
    #return " ".join(s.split()[::-1])
    l = s.split()
    l.reverse()
    return " ".join(l)

