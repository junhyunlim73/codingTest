import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

q = deque()
ans = []

for i in range(n):
    cmd = list(input().split())

    if cmd[0] == 'push_front':
        q.appendleft(cmd[1])
    elif cmd[0] == 'push_back':
        q.append(cmd[1])
    elif cmd[0] == 'pop_front':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q.popleft())
    elif cmd[0] == 'pop_back':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q.pop())
    elif cmd[0] == 'size':
        ans.append(len(q))
    elif cmd[0] == 'empty':
        if len(q) == 0:
            ans.append(1)
        else:
            ans.append(0)
    elif cmd[0] == 'front':
        if len(q) == 0:
            ans.append(-1)
        else:
            n = q.popleft()
            ans.append(n)
            q.appendleft(n)
    elif cmd[0] == 'back':
        if len(q) == 0:
            ans.append(-1)
        else:
            n = q.pop()
            ans.append(n)
            q.append(n)
    
print('\n'.join(map(str, ans)))