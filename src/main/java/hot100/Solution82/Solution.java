package hot100.Solution82;

import java.util.*;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1) return l;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            for (int j = 0; j < l.get(l.size() - 1).size() - 1; j++) {
                l1.add(l.get(l.size() - 1).get(j) + l.get(l.size() - 1).get(j + 1));
            }
            l1.add(1);
            l.add(l1);
        }
        return l;

    }
}