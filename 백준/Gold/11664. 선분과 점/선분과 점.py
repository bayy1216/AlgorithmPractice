import math
aX,aY,aZ,bX,bY,bZ,cX,cY,cZ = map(int,input().split())

def calc_mid(start,end):
    return ((start[0]+end[0])/2, (start[1]+end[1])/2,(start[2]+end[2])/2)

def calc_distance(a,b):
    return math.sqrt((a[0]-b[0])**2 + (a[1]-b[1])**2 +(a[2]-b[2])**2)



start = (aX ,aY,aZ)

end =  (bX ,bY,bZ)


prev = float('inf')

target = (cX,cY,cZ)


while True:
    mid = calc_mid(start,end)
    s_distance = calc_distance(start,target)
    e_distance = calc_distance(end,target)

    distance = calc_distance(mid, target)

    if abs(prev-distance) <= 0.00000001:
        print(distance)
        break
    if distance < prev:
        prev = distance

    if s_distance > e_distance:
        start = mid
    else:
        end = mid
