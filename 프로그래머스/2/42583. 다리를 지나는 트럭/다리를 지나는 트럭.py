from collections import deque
def solution(bridge_length, weight, truck_weights):
    
    trucks = deque(truck_weights)
    
    bridge = deque([0]*bridge_length)
    time = 0
    current_weight = 0
    while trucks:
        time +=1
        current_weight -= bridge.popleft() #트럭 탈출
        
        if current_weight + trucks[0] <= weight:
            current_weight += trucks[0] #진입트럭
            bridge.append(trucks.popleft())
        else:
            bridge.append(0)
    #마지막트럭 건너기
    time += bridge_length
        
    return time