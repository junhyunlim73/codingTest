function solution(num_list) {
    let answer = [...num_list];
    let idx = answer.length - 1;
    
    if(answer[idx] > answer[idx - 1]){
        answer.push(answer[idx] - answer[idx - 1]);
    }else{
        answer.push(answer[idx] * 2);
    }
    
    return answer;
}