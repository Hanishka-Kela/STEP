import java.util.*;

class WindowStats {
    int W;
    Queue<long[]> q = new LinkedList<>();
    Map<String, Integer> userCount = new HashMap<>();
    int total = 0;

    WindowStats(int WSeconds) {
        W = WSeconds * 1000;
    }

    String ingest(long tMs, String userId) {
        q.add(new long[]{tMs, userId.hashCode()});
        userCount.put(userId, userCount.getOrDefault(userId, 0) + 1);
        total++;

        while (!q.isEmpty() && tMs - q.peek()[0] >= W) {
            long[] e = q.poll();
            String u = String.valueOf(e[1]);
            userCount.put(u, userCount.get(u) - 1);
            if (userCount.get(u) == 0) userCount.remove(u);
            total--;
        }

        int unique = userCount.size();
        int qps = (int) Math.floor((double) total / (W / 1000.0));
        return unique + " " + qps;
    }

    public static void main(String[] args) {
        WindowStats ws = new WindowStats(5);
        System.out.println(ws.ingest(1000, "A"));
        System.out.println(ws.ingest(2000, "A"));
        System.out.println(ws.ingest(2500, "B"));
        System.out.println(ws.ingest(7000, "B"));
    }
}
