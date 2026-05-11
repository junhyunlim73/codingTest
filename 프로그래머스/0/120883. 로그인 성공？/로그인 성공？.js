function solution(id_pw, db) {
    
    for(let pwd of db) {
        if((id_pw[0] === pwd[0]) && (id_pw[1] === pwd[1])){
            return 'login'
        }else if(id_pw[0] === pwd[0]){
            return 'wrong pw'
        }
    }
    
    return 'fail';
}