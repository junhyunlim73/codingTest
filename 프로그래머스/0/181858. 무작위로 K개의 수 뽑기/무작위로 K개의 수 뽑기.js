function solution(arr, k) {
    var answer = [];
    
    for(let i of arr){
        if(answer.indexOf(i) === -1)
            answer.push(i)
        
        if(answer.length == k)
            return answer;
    }
    
    if(answer.length < k){
        l = k - answer.length;
        
        for(let i = 0; i < l; i++)
            answer.push(-1)
    }
    
    return answer;
}