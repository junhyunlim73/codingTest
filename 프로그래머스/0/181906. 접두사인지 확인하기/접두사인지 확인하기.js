function solution(my_string, is_prefix) {
    let l = is_prefix.length;
    
    return my_string.slice(0, l) === is_prefix ? 1 : 0;
}