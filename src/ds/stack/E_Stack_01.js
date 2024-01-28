const Node = function(value){
    this.value = value;
    this.next = null;
}

const Stack = function (){
    this.top = null;
    this.isEmpty = function(){
        return this.top == null;
    }
    this.push = function(value){
        let newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
    }
    this.poll = function(){
        let output = this.peek();
        this.top = this.top.next;
        return output;
    }
    this.peek = function(){
        if(this.isEmpty()){
            throw new Error("stack is empty");
        }
        return this.top.value;
    }
}