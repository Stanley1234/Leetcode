class Solution {
    private HashMap<Integer, Set<Integer>> graphs = new HashMap<>();

    private void link(int i, int j) {
        if (!graphs.containsKey(i)) {
            graphs.put(i, new HashSet<>());
        }
        graphs.get(i).add(j);
        if (!graphs.containsKey(j)) {
            graphs.put(j, new HashSet<>());
        }
        graphs.get(j).add(i);
    }

    // assume same length
    // assume lowercase only
    private boolean canFormBySwap(String s1, String s2) {

        int d1 = -1, d2 = -1;
        for (int i = 0;i < s1.length();i ++) {
            if (s1.charAt(i) == s2.charAt(i)) { continue; }
            if (d1 == -1) {
                d1 = i;
            } else if (d2 == -1) {
                d2 = i;
            } else { // too many differences
                return false;
            }
        }
        if (d1 == -1 && d2 == -1) {
            return true; // no difference, will not happen
        }
        if ((d1 != -1 && d2 == -1)) {
            return false; // one difference
        }
        return s1.charAt(d1) == s2.charAt(d2) && s1.charAt(d2) == s2.charAt(d1); // can swap ?
    }

    private void constructGraph(String[] s) {
        for (int i = 0;i < s.length;i ++) {
            link(i, i);
            for (int j = i + 1;j < s.length;j ++) {
                if (canFormBySwap(s[i], s[j])) {
                    link(i, j);
                }
            }
        }
    }

    private String[] filterDupe(String[] A) {
        Arrays.sort(A);
        List<String> list = new ArrayList<>();
        for (int i = 0;i < A.length;i ++) {
            if (list.size() != 0 && list.get(list.size() - 1).equals(A[i])) { continue; }
            list.add(A[i]);
        }
        String[] B = new String[list.size()];
        for (int i = 0;i < list.size();i ++) {
            B[i] = list.get(i);
        }
        return B;
    }

    private int findComponents() {
        HashSet<Integer> visited = new HashSet<>();
        int cnt = 0;

        for (int start : graphs.keySet()) {
            if (visited.contains(start)) { continue; }
            cnt ++;

            LinkedList<Integer> queue = new LinkedList();
            queue.offer(start);
            while (queue.size()  > 0) {
                int curIndex = queue.poll();
                visited.add(curIndex);
                for (int nextIndex : graphs.get(curIndex)) {
                    if (visited.contains(nextIndex)) { continue; }
                    visited.add(nextIndex);
                    queue.offer(nextIndex);
                }
            }
        }
        return cnt;
    }

    public int numSimilarGroups(String[] A) {
        String[] B = filterDupe(A);
        constructGraph(B);

        /*for (int start : graphs.keySet()) {
            System.out.print(start + ": ");
            for (int next : graphs.get(start)) {
                System.out.print(next + " ");
            }
            System.out.println();
        }*/

        return findComponents();
    }
}