import java.util.*;

public class Tree<T> {

  static class Node<E> {
    E value;
    Node<E> right;
    Node<E> left;

    public Node() {}
    public Node(E value) {
      this(value, null, null);
    }

    public Node(E value, Node<E> left, Node<E> right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }

    public String toString() {
      return "( " + 
        (this.left == null ? "." : this.left.toString()) +
        " " + this.value + " " +
        (this.right == null ? "." : this.right.toString()) +
        " )";
    }
  }
  private Node<T> root;

  public Tree() {
    this.root = null;
  }

  public Tree(Node<T> root) {
    this.root = root;
  }

  public List<T> inOrder() {
    return inOrder(this.root);
  }

  private List<T> inOrder(Node<T> root) {
    LinkedList<T> ans = new LinkedList<>();
    if (root != null) {
      ans.addAll(inOrder(root.left));
      ans.add(root.value);
      ans.addAll(inOrder(root.right));
    }
    return ans;
  }

  public String toString() {
    return this.root == null ? "." : this.root.toString();
  }

  // main method for testing
  public static void main(String[] args) {
    //     root
    //     /  \
    //    l    r
    //   /
    //  leaf
    Tree<String> t = new Tree<>(new Node<>("root",
      new Node<>("l", new Node<>("leaf"), null),
      new Node<>("r")
    ));

    Tree<Integer> start = new Tree<>(new Node<>(4,
      new Node<>(3, new Node<>(1), new Node<>(10)),
      new Node<>(15, null, new Node<>(7))
    ));


    List<Integer> bf = start.breadthFirst();
    System.out.println(bf);
    System.out.println(t.breadthFirst());
    // System.out.println(start);

    // Tree<String> result = fizzBuzz(start);
    // System.out.println(result);
  }

  public List<T> breadthFirst() {
    LinkedList<Node<T>> queueOfNodesToProcess = new LinkedList<>();
    if (this.root != null) {
      queueOfNodesToProcess.addLast(this.root);
    }
    LinkedList<T> answer = new LinkedList<>();
    // actually loop through
    // while there are still nodes to process in the queue:
    //  take current node from front of queue
    //  add its value to answer
    //  add its children to queue
    while(!queueOfNodesToProcess.isEmpty()) {
      Node<T> current = queueOfNodesToProcess.removeFirst();
      answer.add(current.value);
      if(current.left != null) {
        queueOfNodesToProcess.addLast(current.left);
      }
      if(current.right != null) {
        queueOfNodesToProcess.addLast(current.right);
      }
    }
    return answer;
  }


  public static Tree<String> fizzBuzz(Tree<Integer> input) {
    Tree<String> answer = new Tree<>();
    answer.root = fizzBuzzHelper(input.root);
    return answer;
  }

  private static Node<String> fizzBuzzHelper(Node<Integer> node) {
    if(node == null) {
      return null;
    } else {
      Node<String> answer = new Node<String>();
      // fizzy buzzy ness
      if (node.value % 15 == 0) {
        answer.value = "fizzbuzz";
      } else if (node.value % 5 == 0) {
        answer.value = "buzz";
      } else if (node.value % 3 == 0) {
        answer.value = "fizz";
      } else {
        answer.value = node.value.toString();
      }
      // actual recursive work
      answer.left = fizzBuzzHelper(node.left);
      answer.right = fizzBuzzHelper(node.right);
      return answer;
    }
  }

}
