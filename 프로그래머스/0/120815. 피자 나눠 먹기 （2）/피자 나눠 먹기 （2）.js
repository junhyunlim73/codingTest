function solution(n) {
    return Math.floor(n / gcd(n, 6));
}

function gcd(a, b){
    tmp = b
    
    while(b > 0){
        b = a % b;
        a = tmp;
        tmp = b;
    }
    
    
    return a;
}