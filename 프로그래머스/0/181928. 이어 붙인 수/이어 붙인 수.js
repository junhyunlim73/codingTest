function solution(num_list) {
    let str1 = 0
    let str2 = 0;
    
    for(let i of num_list){
        if(i % 2 === 0){
            str1 = str1 * 10 + i
        }else{
            str2 = str2 * 10 + i
        }
    }
    
    return str1 + str2;
}