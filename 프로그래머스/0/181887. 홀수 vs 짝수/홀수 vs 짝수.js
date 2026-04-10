function solution(num_list) {
    let a = 0;
    let b = 0;
    
    num_list.map((x, i) => {
        if(i % 2 === 0)
            a += x;
        else
            b += x;
    });
    
    return Math.max(a, b);
}