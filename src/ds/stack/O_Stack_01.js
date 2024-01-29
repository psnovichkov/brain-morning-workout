const Node = function (value) {
  this.value = value;
  this.next = null;
};

const Stack = function () {
  this.top = null;

  this.isEmpty = function () {
    return this.top == null;
  };
  this.push = function (value) {
    let newNode = new Node(value);
    newNode.next = this.top;
    this.top = newNode;
  };
  this.poll = function () {
    let value = this.peek();
    this.top = this.top.next;
    return value;
  };
  this.peek = function () {
    if (this.isEmpty()) {
      throw new Error("Stack is empty.");
    }
    return this.top.value;
  };

  this.print = function () {
    let newTop = this.top;
    while (newTop != null) {
      console.log(newTop.value);
      newTop = newTop.next;
    }
  };
  this.last = function () {
    if (this.isEmpty()) {
      throw new Error("Stack is empty.");
    }
    let newTop = this.top;
    while (newTop.next != null) {
      newTop = newTop.next;
    }
    console.log(newTop.value);
  };
};

const stack = new Stack();
// stack.push(2);
// stack.push(4);
// stack.push(5);
stack.print();
console.log("______");
stack.last();
