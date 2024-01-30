import Stack from "./ds/stack/E_Stack_01.js";
import Queue from "./ds/queue/E_Queue_01.js";
// import Stack from "./ds/stack/O_Stack_05.js";

// const stack  = new Stack();
// stack.push(3);
// console.log(stack.peek());

// const checkParenthesis = function (str) {
//   const stack = new Stack();
//   let parString = str;
//   const chars = parString.split("");
//   for (const c of parString) {
//     if (c == "(") {
//       const open = "open: (";
//       stack.push(open);
//       console.log(open);
//     }
//     if (c == ")") {
//       let polled = stack.poll();
//       console.log(polled);
//     }
//   }

//   if (stack.isEmpty()) {
//     console.log("String of parentheses is valid.");
//   } else {
//     console.log("String of parentheses is NOT valid.");
//   }
// };

// checkParenthesis("((()()())");
// checkParenthesis("((()()()))");

const queue = new Queue();
queue.add(5);
queue.add(4);
queue.add(3);
queue.remove();

console.log(queue.peek());
