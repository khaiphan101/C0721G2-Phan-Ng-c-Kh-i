let count:number = 20;
let sum:number = 0;
for(let i:number = 0 ; i<count; i++){
    sum += fib(i);
}
function fib(num:number):number {
    let sum:number = 0;
    if (num<=1){
        return num;
    }
    else{
        return fib(num - 1) + fib(num - 2);
    }
}
console.log("Tổng 20 số fibonacci đầu tiên: " + "\n" + sum);