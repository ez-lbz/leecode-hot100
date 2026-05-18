package hot100.Solution71;

import java.util.*;

public class Solution {
    public String decodeString(String s) {
        Deque<String> numStack = new ArrayDeque<>();
        Deque<Character> strStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                String tempString = "" + c;
                while (i + 1 < s.length() && s.charAt(i + 1) <= '9' && s.charAt(i + 1) >= '0') {
                    tempString += s.charAt(++i);
                }
                numStack.push(tempString);
            } else if (c == ']') {
                Deque<Character> tempStack = new ArrayDeque<>();
                String tempString = "";
                while (strStack.size() > 0 && strStack.peek() != '[') {
                    tempStack.push(strStack.pop());
                }
                strStack.pop();
                while (!tempStack.isEmpty()) {
                    tempString += tempStack.pop();
                }
                int num = Integer.parseInt(numStack.pop().toString());
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < tempString.length(); k++) {
                        strStack.push(tempString.charAt(k));
                    }
                }
            } else {
                strStack.push(c);
            }
        }

        String res = "";
        while (!strStack.isEmpty()) {
            res += strStack.pollLast();
        }
        return res;
    }
}