N, K = map(int, input().split())

people = [i for i in range(1, N+1)]
current = 0
size = N


print("<",end="")
while size > 0:
    current = (current + K)%size -1
    if current == -1:
        current = size-1
    num = people[current]
    people.remove(num)
    size -= 1
    if size == 0:
        print(num,">",sep="",end="")
        break
    print(num, end=", ")
