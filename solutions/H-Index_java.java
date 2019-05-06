class Solution {
    public int hIndex(int[] citations) {
      // 3 0 6 1 5
      int numOfCitations = citations.length;
      int[] buckets = new int[numOfCitations + 1];

      for (int c : citations) {
         if (c >= numOfCitations) {
            buckets[numOfCitations]++;
         } else {
            buckets[c]++;
         }
      }

      // h-index is equal to 0 if and only if the number of citations is 0
      for (int i = numOfCitations - 1; i >= 0; i--) {
         buckets[i] += buckets[i + 1];
      }

      int hIndex = 0;
      for (int i = numOfCitations; i >= 0; i--) {
         if (buckets[i] >= i) {
            hIndex = i;
            break;
         }
      }
      return hIndex;
   }
}
// 0 1 3 5 6