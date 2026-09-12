import java.util.*;

class Solution {

    class Pair {
        int start;
        int end;
        int weight;
        int index;

        Pair(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by ending time
        Arrays.sort(arr, (a, b) -> a.end - b.end);

        // prev[i] = first index after the last non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {

            int low = 0;
            int high = i - 1;
            int ans = 0;

            while (low <= high) {

                int mid = (low + high) / 2;

                if (arr[mid].end < arr[i].start) {
                    ans = mid + 1;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            prev[i] = ans;
        }

        // dp[i][k] = best result using first i intervals
        // and choosing at most k intervals
        long[][] dp = new long[n + 1][5];

        // Store selected indices
        List<Integer>[][] list = new ArrayList[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                list[i][k] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {

            for (int k = 1; k <= 4; k++) {

                // Don't take this interval
                dp[i][k] = dp[i - 1][k];
                list[i][k] = new ArrayList<>(list[i - 1][k]);

                // Take this interval
                long take = dp[prev[i - 1]][k - 1] + arr[i - 1].weight;

                if (take > dp[i][k]) {

                    dp[i][k] = take;

                    list[i][k] =
                        new ArrayList<>(list[prev[i - 1]][k - 1]);

                    list[i][k].add(arr[i - 1].index);

                    Collections.sort(list[i][k]);

                } else if (take == dp[i][k]) {

                    ArrayList<Integer> temp =
                        new ArrayList<>(list[prev[i - 1]][k - 1]);

                    temp.add(arr[i - 1].index);

                    Collections.sort(temp);

                    if (isSmaller(temp, list[i][k])) {
                        list[i][k] = temp;
                    }
                }
            }
        }

        int[] answer = new int[list[n][4].size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list[n][4].get(i);
        }

        return answer;
    }

    public boolean isSmaller(List<Integer> a, List<Integer> b) {

        for (int i = 0; i < a.size(); i++) {

            if (a.get(i) < b.get(i)) {
                return true;
            }

            if (a.get(i) > b.get(i)) {
                return false;
            }
        }

        return false;
    }
}