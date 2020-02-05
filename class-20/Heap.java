import java.util.Arrays;

public class Heap {

  // instance variables
  private int[] values;
  // count gives the index of the last value in the heap
  private int count;

  // constructor
  public Heap() {
    this.values = new int[5];
    this.values[0] = 404;
    this.count = 0;
  }

  public int removeMax() {
    // hold onto the max for posterity
    int answer = this.values[1];
    this.values[1] = this.values[count];
    this.values[count] = 404;
    count--;
    // heapify: we just moved a leaf to be the root, probably that's wrong, let's fix it
    int idx = 1;
    while(idx < (this.count + 1) / 2) {
      if( 2 * idx + 1 <= this.count && (this.values[2 * idx + 1] > this.values[idx] && this.values[2 * idx + 1] > this.values[2 * idx])) {
        // if the right child (exists and) is the biggest, swap right with parent
        int temp = this.values[idx];
        this.values[idx] = this.values[2 * idx + 1];
        this.values[2 * idx + 1] = temp;
        idx = 2 * idx + 1;
      } else if (this.values[2 * idx] > this.values[idx]) {
        // if the left child is the biggeest, swap left with parent
        int temp = this.values[idx];
        this.values[idx] = this.values[2 * idx];
        this.values[2 * idx] = temp;
        idx = 2 * idx;
      } else {
        break;
      }
    }
    return answer;
  }

  // instance methods
  public void add(int value) {
    this.count++;
    // if we're out of space in our array, make a new array!
    if (count >= values.length) {
      int[] newValues = new int[this.values.length * 2];
      for (int i = 0; i < this.values.length; i++) {
        newValues[i] = this.values[i];
      }
      this.values = newValues;
    }
    // set the thing at that index to be our shiny new value
    this.values[count] = value;
    // actually make sure it stays a heap
    int idx = count;
    // as long as current value is bigger than parent
    while(idx > 1 && (this.values[idx] > this.values[idx/2])) {
      // swap current value with parent
      int temp = this.values[idx/2];
      this.values[idx/2] = this.values[idx];
      this.values[idx] = temp;
      // reset idx to parent
      idx = idx / 2;
    }
  }

  public int getMax() {
    return this.values[1];
  }

  public String toString() {
    return String.format("Heap with %d things: %s", this.count, Arrays.toString(this.values));
  }

  // main method for testing/running
  public static void main(String[] args) {
    Heap h = new Heap();
    h.add(8);
    h.add(-2);
    h.add(-6);
    h.add(1);
    h.add(5);
    System.out.println(h);
    System.out.println(h.getMax());
    h.add(12);
    h.add(-3);
    h.add(17);
    h.add(4);
    System.out.println(h);
    System.out.println(h.removeMax());System.out.println(h);
    System.out.println(h.removeMax());System.out.println(h);
    System.out.println(h.removeMax());System.out.println(h);
    System.out.println(h.removeMax());System.out.println(h);
    System.out.println(h.removeMax());System.out.println(h);
    System.out.println(h.removeMax());System.out.println(h);
    System.out.println(h.removeMax());
  }
}
