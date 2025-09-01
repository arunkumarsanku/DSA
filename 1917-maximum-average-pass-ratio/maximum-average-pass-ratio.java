import java.util.*;

class Solution {
    static class Info {
        double inc; // gain if adding one student
        int p, q;   // current pass and total

        Info(double inc, int p, int q) {
            this.inc = inc;
            this.p = p;
            this.q = q;
        }
    }

    public double maxAverageRatio(int[][] classes, int k) {
        int n = classes.length;
        double sum = 0.0;

        // Max-heap based on increment
        PriorityQueue<Info> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(b.inc, a.inc)
        );

        for (int[] c : classes) {
            int p = c[0], q = c[1];
            sum += (double) p / q;
            double inc = (double) (q - p) / (q * (q + 1.0));
            pq.offer(new Info(inc, p, q));
        }

        for (int i = 0; i < k; i++) {
            Info cur = pq.poll();
            if (cur == null || cur.inc == 0) break; // early stop

            // apply increment
            sum += cur.inc;
            cur.p += 1;
            cur.q += 1;
            cur.inc = (double)(cur.q - cur.p) / (cur.q * (cur.q + 1.0));

            pq.offer(cur);
        }

        return sum / n;
    }
}
