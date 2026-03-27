function solution(num_list) {
    let s = num_list.reduce((p, n) => p + n, 0);
    let m = num_list.reduce((p, n) => p * n, 1);
    
    return m < (s * s) ? 1 : 0;
}