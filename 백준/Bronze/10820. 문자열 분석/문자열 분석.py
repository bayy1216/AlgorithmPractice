
while True:
    try:
        line = list(input())
        if not line:
            break
        소문자,대문자,숫자,공백 = 0, 0, 0, 0
        for x in line:
            if x == ' ':
                공백 +=1
            elif x.islower():
                소문자 +=1
            elif x.isupper():
                대문자 += 1
            elif x.isdigit():
                숫자 +=1

        print(f"{소문자} {대문자} {숫자} {공백}")
    except EOFError:
        break
