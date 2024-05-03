from collections import deque
import heapq

def solution(priorities, location):
    
    
    queue = deque([])
    heap = []
    
    for i in range(len(priorities)):
        queue.append((priorities[i], i))
        # maxheap으로 -1곱
        heapq.heappush(heap,priorities[i] * -1)
    answer = 0
    
    while queue:
        current = queue.popleft()
        lvl = heap[0] * -1 #heap에서 미리보기
        
        if current[0] == lvl: # 우선순위 맞으면 꺼내기
            heapq.heappop(heap)
            answer+=1
            
            if current[1] == location: #꺼냈을때, 원하는 것이면 종료
                break
        else:
            queue.append(current)
        
            
    
    return answer