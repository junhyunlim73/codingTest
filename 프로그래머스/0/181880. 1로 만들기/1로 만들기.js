function solution(num_list) {
    var answer = 0;
    
    for(let num of num_list){
        while(num !== 1) {
            num = num % 2 === 0 ? Math.floor(num / 2) : Math.floor((num - 1) / 2);
            answer++;
        }
    }
    
    return answer;
}