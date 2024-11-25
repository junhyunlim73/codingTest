def solution(today, terms, privacies):
    answer = []
    d2 = today.split(".")

    for i in range(len(privacies)):
        s = privacies[i].split(" ")
        d1 = s[0].split(".")
        for j in range(len(terms)):
            t = terms[j].split(" ")
            if s[1] == t[0]:
                d1[1] = int(d1[1]) + int(t[1]) % 12
                d1[2] = int(d1[2]) - 1
                if int(t[1]) >= 12:
                    d1[0] = int(d1[0]) + (int(t[1])//12)
                if d1[1] > 12:
                    d1[0] = int(d1[0]) + (d1[1]//12)
                    d1[1] = d1[1] - ((d1[1]//12) * 12)
                if d1[2] == 0:
                    d1[1] -= 1
                    d1[2] = 28
                    if d1[1] == 0:
                        d1[0] -= 1
                        d1[1] = 12
                break
        if int(d2[0]) == int(d1[0]):
            if int(d2[1]) > int(d1[1]):
                answer.append(i + 1)
            elif int(d2[1]) == int(d1[1]):
                if int(d2[2]) <= int(d1[2]):
                    continue
                else:
                    answer.append(i + 1)
            else:
                continue
        elif int(d2[0]) > int(d1[0]):
            answer.append(i + 1)
        else:
            continue
    return answer