function solution(numer1, denom1, numer2, denom2) {
    let answer = [];
    
    let num1 = numer1 * denom2 + numer2 * denom1;
    let num2 = denom1 * denom2;
    let n = gcd(num1, num2);
    
    answer.push(Math.trunc(num1 / n));
    answer.push(Math.trunc(num2 / n));
    return answer;
}

function gcd(num1, num2){
    let tmp = 1;
    
    while(num2 > 0){
        tmp = num1 % num2;
        num1 = num2;
        num2 = tmp;
    }
    
    return num1;
}