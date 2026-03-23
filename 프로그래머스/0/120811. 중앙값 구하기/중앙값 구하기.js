function solution(array) {
    array.sort((a, b) => a > b ? 1 : -1);
    return array[Math.trunc(array.length / 2)];
}