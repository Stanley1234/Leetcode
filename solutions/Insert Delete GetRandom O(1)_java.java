class RandomizedSet {
   private List<Integer> storage = new ArrayList<>();
   
   private Map<Integer, Integer> index = new HashMap<>();
   
   private int size = 0;
   
   /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
   public boolean insert(int val) {
      if (index.containsKey(val)) {
         return false;
      }
      if (size == storage.size()) {
         storage.add(val);
      } else {
         storage.set(size, val);
      }
      index.put(val, size);
      size ++;
      return true;
   }

   /** Removes a value from the set. Returns true if the set contained the specified element. */
   public boolean remove(int val) {
      if (!index.containsKey(val)) {
         return false;
      }
      int removedIndex = index.get(val);
      index.put(storage.get(size - 1), removedIndex);
      index.remove(val);
      storage.set(removedIndex, storage.get(size - 1));
      size --;
      return true;
   }

   /** Get a random element from the set. */
   public int getRandom() {
      return storage.get(new Random().nextInt(size));
   }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */