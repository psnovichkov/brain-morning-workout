import Stack from "./ds/stack/E_Stack_01.js";
import Queue from "./ds/queue/E_Queue_01.js";

// const stack  = new Stack();
// stack.push(3);
// console.log(stack.peek());

const queue = new Queue();
queue.add(5);
queue.add(4);
queue.add(3);
queue.remove();

console.log(queue.peek());