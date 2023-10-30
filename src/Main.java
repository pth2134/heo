import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Queue<Integer[]>> bus_list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            bus_list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());
            bus_list.get(from).add(new Integer[]{to, fee});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        //o1[0] 현재위치 o1[1] 현재까지의 요금
        int[] visited = new int[n + 1];

        Queue<Integer[]> que = bus_list.get(start);
        int size = que.size();
        for (int i = 0; i < size; i++) {
            Integer[] poll = que.poll();
            int to = poll[0];
            int fee = poll[1]+1;
            if (visited[to] == 0 || visited[to] > fee) {
                pq.add(new Integer[]{to, fee});
                visited[to] = fee;
            }
        }
        while (!pq.isEmpty()) {
            Integer[] poll = pq.poll();
            int now = poll[0];
            int fee_now = poll[1];
            if (visited[now] < fee_now) continue;
            que = bus_list.get(now);
            size = que.size();
            for (int i = 0; i < size; i++) {
                poll = que.poll();
                int to = poll[0];
                int fee = fee_now + poll[1];
                if (visited[to] == 0 || visited[to] > fee) {
                    pq.add(new Integer[]{to, fee});
                    visited[to] = fee;
                }
            }
        }

        System.out.println(visited[dest]-1);
    }
}
