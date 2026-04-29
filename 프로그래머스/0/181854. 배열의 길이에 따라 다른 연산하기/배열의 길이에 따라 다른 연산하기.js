function solution(arr, n) {
    var answer = [...arr];

    
    if(answer.length % 2 == 0){
        answer = answer.map((x, i) => {
            return (i % 2 == 1) ? (x + n) : x;
        })
    }else{
        answer = answer.map((x, i) => {
            return (i % 2 == 0) ? (x + n) : x
        })
    }
    
    return answer;
}