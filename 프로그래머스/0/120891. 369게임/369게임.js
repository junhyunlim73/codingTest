function solution(order) {
    var answer = 0;
    String(order).split("").map((x) => {
        if(x === '3' || x === '6' || x === '9')
            answer += 1
    })
    return answer;
}