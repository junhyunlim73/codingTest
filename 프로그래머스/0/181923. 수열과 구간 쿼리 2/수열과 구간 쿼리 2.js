function solution(arr, queries) {
    var answer = [];
    
    for(let i = 0; i < queries.length; i++){
        newArr = arr.slice(queries[i][0], queries[i][1] + 1);
        m = Number.MAX_VALUE;
        
        for(let n of newArr){
            if(queries[i][2] < n)
                m = Math.min(m, n);
        }
        
        if(m === Number.MAX_VALUE)
            m = -1;
        
        answer.push(m);
    }
    
    return answer;
}