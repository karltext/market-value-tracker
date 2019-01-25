
def stripchars(string):
    return cat(s for s in string if s not in chars)

cat = ''.join
chars = '$£(),'

def test():
    t0 = ['Demantra','1,112','+69','£62,500','-26.47%','9 (0.006%)']
    assert stripchars('£62,500') == '62500'

if __name__ == '__main__':
    test()