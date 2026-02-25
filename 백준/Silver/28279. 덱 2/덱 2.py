import sys
from collections import deque
input = sys.stdin.readline

n = int(input())

q = deque()
ans = []

for i in range(n):
    cmd = list(input().split())

    if cmd[0] == '1':
        q.appendleft(cmd[1])
    elif cmd[0] == '2':
        q.append(cmd[1])
    elif cmd[0] == '3':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q.popleft())
    elif cmd[0] == '4':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q.pop())
    elif cmd[0] == '5':
        ans.append(len(q))
    elif cmd[0] == '6':
        if len(q) == 0:
            ans.append(1)
        else:
            ans.append(0)
    elif cmd[0] == '7':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q[0])
    elif cmd[0] == '8':
        if len(q) == 0:
            ans.append(-1)
        else:
            ans.append(q[-1])

print('\n'.join(map(str, ans)))