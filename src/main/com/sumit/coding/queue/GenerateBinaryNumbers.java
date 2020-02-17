package main.com.sumit.coding.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {
        int n = 4;
        Queue<String> queue = new LinkedList<>();
        GenerateBinaryNumbers generateBinaryNumbers = new GenerateBinaryNumbers();

        queue.add("1");

        generateBinaryNumbers.generate(queue, n);
    }

    private void generate(Queue<String> queue, int n) {
        int count = 0;
        while (count != n && !queue.isEmpty()) {
            String result = queue.peek();
            queue.remove();
            System.out.print(result + " ");
            queue.add(result + "" + 0);
            queue.add(result + "" + 1);
            count++;
        }
    }
}
