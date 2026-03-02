const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    result = '';
    for(let ch of str){
        if (ch === ch.toUpperCase()){
            result += ch.toLowerCase();
        }else{
            result += ch.toUpperCase();
        }
    }
    
    console.log(result);
    
});