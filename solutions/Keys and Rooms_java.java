class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int visitedNum = 0;
        boolean[] visited = new boolean[rooms.size()];
        LinkedList<Integer> q = new LinkedList<>();
        
        visited[0] = true;
        q.push(0);
        
        while (q.size() > 0) {
            int curRoom = q.poll();
            visitedNum ++;
            for (int key : rooms.get(curRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    q.offer(key);
                }
            }
        }
        return visitedNum == rooms.size();
    }
}