import java.util.PriorityQueue;
import java.util.Scanner;

public class asd {
    public static void main(String[] args) {
        PriorityQueue<Integer[]> que = new PriorityQueue<>((o1, o2) ->
            o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
        );

// 큐에 원소 추가
        que.offer(new Integer[]{7, 13, 127});
        que.offer(new Integer[]{6, 12, 127});

// poll 연산 수행
        Integer[] poll = que.poll();
        for (int i: poll) {
            System.out.print(i+" ");
        }
    }
}

