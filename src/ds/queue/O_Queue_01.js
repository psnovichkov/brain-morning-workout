import Node from "../node/Node.js";

const Queue = function () {
  this.first = null;
  this.last = null;

  this.isEmpty = function () {
    return this.first == null;
  };

  this.peek = function () {
    if (this.isEmpty()) {
      throw new Error("Queue is empty.");
    }
    return this.first.data;
  };

  this.add = function (data) {
    let newNode = new Node(data);
    if (this.isEmpty()) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.next = newNode;
      this.last = newNode;
    }
  };

  this.remove = function () {
    let output = this.peek();
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      this.first = this.first.next;
    }
    return output;
  };
};

export default Queue;
