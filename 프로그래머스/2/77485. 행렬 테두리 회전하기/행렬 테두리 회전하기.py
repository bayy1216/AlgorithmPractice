from collections import deque
def solution(rows, columns, queries):
    nums = [[0] * (columns + 1) for _ in range(rows + 1)]
    a = 1
    for x in range(1,rows+1):
        for y in range(1,columns+1):
            nums[x][y] = a
            a += 1
    answer = []

    for query in queries:
        x1, y1, x2, y2 = query[0], query[1], query[2], query[3]
        answer.append(turn(x1, y1, x2, y2, nums))

    return answer


def turn(x1, y1, x2, y2, nums):
    num_queue = deque([])

    for i in range(y1, y2 + 1):
        num_queue.append(nums[x1][i])
    for i in range(x1 + 1, x2):
        num_queue.append(nums[i][y2])
    for i in range(y2, y1-1, -1):
        num_queue.append(nums[x2][i])
    for i in range(x2-1, x1, -1):
        num_queue.append(nums[i][y1])
    res = min(num_queue)
    num_queue.appendleft(num_queue.pop())

    for i in range(y1, y2 + 1):
        nums[x1][i] = num_queue.popleft()
    for i in range(x1 + 1, x2):
        nums[i][y2] = num_queue.popleft()
    for i in range(y2, y1-1, -1):
        nums[x2][i] = num_queue.popleft()
    for i in range(x2-1, x1, -1):
        nums[i][y1] = num_queue.popleft()
    return res
