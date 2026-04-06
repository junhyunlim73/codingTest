function solution(n) {
    var answer = [];
    
    let dc = [1 ,0 , -1, 0];
    let dr = [0, 1, 0, -1];
    let cnt = 1
    let r = 0;
    let c = 0;
    let idx = 0;
    
    for(let i = 0; i < n; i++){
        let arr = [];
        for(let j = 0; j < n; j++)
            arr.push(0);
        answer.push(arr);
    }
    

    
    while(cnt <= n * n){
        answer[r][c] = cnt++;
        
        let nr = r + dr[idx];
        let nc = c + dc[idx];
        
        if(nr < 0 || nc < 0 || nr >=n || nc >= n || answer[nr][nc] !== 0){
            idx = (idx + 1) % 4;
            nr = r + dr[idx]
            nc = c + dc[idx]
        }
            
        r = nr;
        c = nc;
    }
    
    
    
    console.log(answer)
    
    
    
    return answer;
}