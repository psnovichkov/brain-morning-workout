import Node from "../node/Node.js";

const Queue = function(){
    this.top = null;
    this.bottom = null;

    this.isEmpty = function(){
        return this.top == null;
    }

    this.peek = function(){
        if(this.isEmpty()){
            throw new Error("Queue is empty");
        }
        return this.top.data;
    }

    this.remove = function(){
        let output = this.peek();
        if(this.top == this.bottom){
            this.top = null;
            this.bottom = null;
        } else {
            this.top = this.top.next;
        }
        return output;
    }

    this.add = function(value){
        let newNode =  new Node(value);
        if(this.isEmpty()){
            this.top = newNode;
            this.bottom = newNode;
        } else {
            this.bottom.next = newNode;
            this.bottom = newNode;
        }
    }
}

export default Queue;