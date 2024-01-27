const Node = function(value){
    this.value = value;
    this.next = null;
}

const Stack = function (){
    this.top = null
    const isEmpty = function(){
        return this.top == null;
    }
    const push = function(value){
        let newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
    }
    const poll = function(){
        let output = this.peek();
        this.top = this.top.next;
        return output;
    }
    const peek = function(){
        if(this.isEmpty){
        throw new Error("stack is empty");
        }
        return this.top.value;
    }
}

let stack = new Stack();
stack.push("3");
console.log(stack.peek());