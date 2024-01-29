const Node = function(value){
    this.value = value;
    this.next = null;
};

const Stack = function(){
    this.top = null;

    this.push() = function(value){
        let newNode = new Node(value);
        newNode.next = this.top;
        this.top = newNode;
    };
    this.peek() = function(){
        if(this.isEmpty()){
            throw new Error("Stack is empty.");
        }
        return this.top.value;
    };
    this.poll() = function(){
        let output = this.peek();
        this.top = this.top.next;
        return output;
    };
    this.isEmpty() = function(){
        return this.top == null;
    };
};

//time: 6:08