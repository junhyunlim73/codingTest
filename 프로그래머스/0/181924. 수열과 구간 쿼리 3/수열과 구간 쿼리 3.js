function solution(arr, queries) {
    var answer = arr;
    
    for(let i = 0; i < queries.length; i++){
        idx1 = queries[i][0];
        idx2 = queries[i][1];
        tmp = answer[idx1];
        answer[idx1] = answer[idx2];
        answer[idx2] = tmp;
    }
    
    return answer;
}