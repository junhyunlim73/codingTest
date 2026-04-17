function solution(arr, flag) {
    var answer = [];
    
    for(let i in flag){
        if(flag[i]){
            a = Array(arr[i]*2).fill(arr[i])
            answer.push(...a)
        }else{
            for(let j = 0; j < arr[i]; j++){
                answer.pop()
            }
        }
    }
    
    return answer;
}