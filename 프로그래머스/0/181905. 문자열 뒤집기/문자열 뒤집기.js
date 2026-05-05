function solution(my_string, s, e) {
    var answer = '';
    var left = my_string.slice(0, s);
    var middle = my_string.slice(s, e + 1);
    var right = my_string.slice(e+1);
    answer = left + [...middle].reverse().join('') + right;
    
    return answer;
}