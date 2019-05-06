class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int mx1 = rec1[0], my1 = rec1[1], mx2 = rec1[2], my2 = rec1[3];
        int nx1 = rec2[0], ny1 = rec2[1], nx2 = rec2[2], ny2 = rec2[3];
        
        return !(mx1 >= nx2 || 
                (nx1 <= mx1 && mx1 <= nx2 && (my1 >= ny2 || my2 <= ny1)) ||
                (mx2 <= nx1 || my1 >= ny2 || my2 <= ny1)) ;
    }
}