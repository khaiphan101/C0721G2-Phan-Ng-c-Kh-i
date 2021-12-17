let count = 20;
let sum = 0;
for (let i = 0; i < count; i++) {
    sum += fib(i);
}
function fib(num) {
    let sum = 0;
    if (num <= 1) {
        return num;
    }
    else {
        return fib(num - 1) + fib(num - 2);
    }
}
console.log("Tổng 20 số fibonacci đầu tiên: " + "\n" + sum);
//# sourceMappingURL=main.js.map