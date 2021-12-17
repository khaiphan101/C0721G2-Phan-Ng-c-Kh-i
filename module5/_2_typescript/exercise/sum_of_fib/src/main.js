let count = 20;
let sum = 0;
for(let i = 0 ; i<count; i++){
    sum += fib(i);
}
function  fib(num) {
    if (num<=1){
        return num;
    }
    else{
        return fib(num - 1) + fib(num - 2);
    }
}
alert("Tổng 20 số fibonacci đầu tiên: " + "\n" + sum);