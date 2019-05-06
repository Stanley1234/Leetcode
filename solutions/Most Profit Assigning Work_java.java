class Solution {
    private class Job {
        int difficulty;
        int profit;
        public Job(int diff, int pro) {
            this.difficulty = diff;
            this.profit = pro;
        }
    }
    
    private Job[] init(int[] difficulties, int[] profits) {
        int numOfJobs = difficulties.length;
        Job[] jobs = new Job[numOfJobs];
        for (int i = 0;i < numOfJobs;i ++) {
            jobs[i] = new Job(difficulties[i], profits[i]);
        }
        
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.difficulty - o2.difficulty;
            }
        });
        return jobs;
    }
    
    private int getMaxProfit(int[] workers, Job[] jobs) {
        int difficultyUpperBoundIndex = -1;
        int maxProfitTask = 0;
        int profitSum = 0;
        
        for (int workerAbility : workers) {
            if (difficultyUpperBoundIndex == -1 
                    || workerAbility > jobs[difficultyUpperBoundIndex].difficulty) {
                while (difficultyUpperBoundIndex + 1 < jobs.length
                        && jobs[difficultyUpperBoundIndex + 1].difficulty <= workerAbility) {
                    difficultyUpperBoundIndex ++;
                    maxProfitTask = Math.max(maxProfitTask, jobs[difficultyUpperBoundIndex].profit);
                }
            }
            profitSum += maxProfitTask;
        }
        return profitSum;
    }
    
    public int maxProfitAssignment(int[] difficulties, int[] profits, int[] workers) {
        // initialize
        Job[] jobs = init(difficulties, profits);
        Arrays.sort(workers);
        // search
        return getMaxProfit(workers, jobs);
    }
}