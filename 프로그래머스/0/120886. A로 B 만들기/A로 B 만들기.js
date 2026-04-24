function solution(before, after) {
    let arr = before.split('').sort();
    let arr2 = after.split('').sort();
    
    for(let i = 0; i < arr.length; i++){
        if(arr[i] !== arr2[i])
            return 0;
    }
    
    return 1;
}