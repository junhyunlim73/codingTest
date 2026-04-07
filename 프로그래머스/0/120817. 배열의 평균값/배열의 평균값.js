function solution(numbers) {
    let num = numbers.reduce((p, d) => p + d, 0);
    
    return num / numbers.length;
}