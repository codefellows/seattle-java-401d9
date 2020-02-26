import java.util.*;

public class Graph {
  String value;
  List<Graph> neighbors;

  public Graph(String s) {
    this.value = s;
    this.neighbors = new LinkedList<>();
  }

  public static List<String> bfs(Graph start) {
    List<String> answer = new LinkedList<>();
    Set<Graph> seen = new HashSet<>();
    LinkedList<Graph> nodesToProcess = new LinkedList<>();
    nodesToProcess.addLast(start);
    seen.add(start);
    while(!nodesToProcess.isEmpty()) {
      Graph current = nodesToProcess.removeFirst();
      answer.add(current.value);
      for (Graph neighbor : current.neighbors) {
        if (!seen.contains(neighbor)) {
          seen.add(neighbor);
          nodesToProcess.addLast(neighbor);
        }
      }
    }
    return answer;
  }

    public static List<String> dfs(Graph start) {
    List<String> answer = new LinkedList<>();
    Set<Graph> seen = new HashSet<>();
    LinkedList<Graph> nodesToProcess = new LinkedList<>();
    nodesToProcess.addLast(start);
    while(!nodesToProcess.isEmpty()) {
      Graph current = nodesToProcess.removeFirst();
      if (!seen.contains(current)) {
        seen.add(current);
        answer.add(current.value);
        for (Graph neighbor : current.neighbors) {
          if (!seen.contains(neighbor)) {
            nodesToProcess.addFirst(neighbor);
          }
        }
      }
      
    }
    return answer;
  }
  public static void main(String[] args) {
    Graph ellen = new Graph("Ellen");
    Graph vik = new Graph("Vik");
    Graph chase = new Graph("Chase");
    Graph ran = new Graph("Ran");

    ellen.neighbors.add(vik);
    ellen.neighbors.add(ran);
    ran.neighbors.add(ellen);
    ran.neighbors.add(chase);
    chase.neighbors.add(ran);
    chase.neighbors.add(vik);
    vik.neighbors.add(ellen);
    vik.neighbors.add(chase);

    System.out.println(bfs(ellen));
    System.out.println(dfs(ellen));
  }
}
