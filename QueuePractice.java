import java.util.LinkedList;
import java.util.Queue;

class QueuePractice{

    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(12);
        queue.add(15);
        queue.add(24);
        queue.add(9);
        queue.add(56);
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
        System.out.println(queue.remove());
        queue.remove();
		queue.remove();
        for (Integer i : queue) {
            System.out.print(i + " ");
        }
    }
}

