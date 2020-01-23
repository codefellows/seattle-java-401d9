import java.util.HashMap;
import java.util.LinkedList;

public class Brackets {
  public static void main(String[] args) {
    for(String arg : args) {
      System.out.println(validate(arg));
    }
  }

  // Maps opening brackets to closing brackets. Static initialization will run once when the class is created.
  private static HashMap<Character, Character> mapper;
  static {
    mapper = new HashMap<>();
    mapper.put('(', ')');
    mapper.put('[', ']');
    mapper.put('{', '}');
    mapper.put('<', '>');
  }

  public static boolean validate(String brackets) {
    LinkedList<Character> stack = new LinkedList<>();
    for(int i = 0; i < brackets.length(); i++) {
      char curr = brackets.charAt(i);
      // if the current character isn't either a key or a value in mapper, we don't care about it. So our conditionals
      // will only care about characters that are in the mapper.
      if(mapper.containsKey(curr)) {
        // If it's a key, then it's an opening bracket. Add to the stack, hoping to find a matching closing bracket later.
        stack.push(curr);
      } else if (mapper.containsValue(curr)) {
        // If it's a value, then it's a closing bracket. Check that it matches the top of the stack.
        // so if the stack is empty, there was no matching opening bracket.
        if(stack.isEmpty()) {
          return false;
        }
        // Grab the top of the stack, and check that it's the opening bracket that matches the current closing bracket.
        char opener = stack.pop();
        if (curr != mapper.get(opener).charValue()) {
          // if they don't match, then we have mismatched brackets.
          return false;
        }
      }
    }
    // We made it all the way through the string! Only thing left to check is to make sure there are no leftover unclosed brackets.
    return stack.isEmpty();
  }
}




/*
mapper <- { [:], (:), {:} }
match_brackets (String s):
  stack <- new Stack
  for (c in s):
    if c is a key in mapper:
      stack.push(c)
    else if c is a value in mapper:
      if stack is empty or if stack.pop() != mapper.get(c):
        return false
  return stack.isEmpty

*/
