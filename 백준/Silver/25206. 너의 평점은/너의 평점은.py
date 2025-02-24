subject = [input().split(" ") for _ in range(20)]
sum = 0.0
total = 0.0

grade = {'A+' : 4.5,
         'A0' :	4.0,
'B+' :	3.5,
'B0' :	3.0,
'C+' :	2.5,
'C0' :	2.0,
'D+' : 1.5,
'D0' :	1.0,
'F' :	0.0}

for i in range(20):
    if(subject[i][2] == 'P'):
        continue
    
    score = grade[subject[i][2]]
    sum += float(subject[i][1]) * score
    total += float(subject[i][1])

print(round(sum / total, 6))