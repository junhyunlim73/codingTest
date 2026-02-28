function solution(a, b) {
    var answer = 0;
    var num1 = +(a + "" + b + "")
    var num2 = +(b + "" + a + "")
    return Math.max(num1, num2);
}