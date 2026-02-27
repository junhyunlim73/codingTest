function solution(a, b) {
    var num1 = parseInt(a + "" + b)
    var num2 = 2 * a * b
    
    if (num1 >= num2){
        return num1
    }
    else{
        return num2
    }
    
}