class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
      Map<String, Integer> domainCount = new HashMap<>();
      for (String cpdomain : cpdomains) {
         String[] domainInfo = cpdomain.split("\\s");

         int visitCount = Integer.parseInt(domainInfo[0]);
         String domain = domainInfo[1];

         int curDotPos = -1;
         while (true) {
            if (!domainCount.containsKey(domain)) {
               domainCount.put(domain, visitCount);
            } else {
               domainCount.put(domain, domainCount.get(domain) + visitCount);
            }
            curDotPos = domain.indexOf('.');
            if (curDotPos == -1) {
               break;
            }
            domain = domain.substring(curDotPos + 1);
         }
      }

      List<String> ans = new ArrayList<>();
      for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
         ans.add(entry.getValue() + " " + entry.getKey());
      }
      return ans;
   }
}