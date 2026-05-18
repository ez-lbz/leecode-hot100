package hot100.Solution53;

import java.net.Inet4Address;
import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> p = new HashMap<>();
        Map<Integer, Set<Integer>> l = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int[] pr : prerequisites) {
            if (!l.containsKey(pr[1])) l.put(pr[1], new HashSet<>(Arrays.asList(pr[0])));
            else l.get(pr[1]).add(pr[0]);
            if (!p.containsKey(pr[0])) p.put(pr[0], new HashSet<>(Arrays.asList(pr[1])));
            else p.get(pr[0]).add(pr[1]);

        }

        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++)
            if (!p.containsKey(i)) {
                q.offer(i);
                visited[i] = true;
            }

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (l.get(cur) == null) continue;
            for (int num : l.get(cur)) {
                if (!visited[num] && p.get(num).contains(cur)) p.get(num).remove(cur);
                if (p.get(num).size() == 0) {
                    q.offer(num);
                    visited[num] = true;
                }
            }
        }

        for (boolean b : visited)
            if (!b) return false;

        return true;



    }
}