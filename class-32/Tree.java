public class Tree {
  int value;
  Tree left;
  Tree right;

  public Tree(int value) {
    this.value = value;
  }

  public Tree(int value, Tree left, Tree right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public static void main(String[] args) {
    Tree tree1 = new Tree(4, new Tree(2), new Tree(1));
    Tree tree2 = new Tree(4, new Tree(1), new Tree(2));
    System.out.println(areSame(tree1, tree2));
    Tree tree3 = new Tree(4, new Tree(2), new Tree(1));
    System.out.println(areSame(tree1, tree3));
    Tree tree4 = new Tree(4, new Tree(2, new Tree(7), null), new Tree(1));
    System.out.println(areSame(tree1, tree4));
  }

  public static boolean areSame(Tree t1, Tree t2) {
    if(t1 == null && t2 == null) {
      return true;
    } else if (t1 == null || t2 == null) {
      return false;
    } else {
      return t1.value == t2.value &&
        areSame(t1.left, t2.left) &&
        areSame(t1.right, t2.right);
    }
  }
}
