package main.com.sumit.coding.arrays;

import java.util.List;
import java.util.stream.Collectors;

public class SquareAndSortNumbersProblem {

    public static void main(String[] args) {
        List<Integer> list = List.of(-6, -3, -1, 2, 4, 5);
        list = (new SquareAndSortNumbersProblem()).squareAndSort(list);

        for (int i : list)
            System.out.println(i);
    }

    public List<Integer> squareAndSort(List<Integer> list) {
        return (new SquareAndSortNumbersProblem()).square(list).parallelStream().sorted().collect(Collectors.toList());
    }

    private List<Integer> square(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            list.set(i, list.get(i) * list.get(i));

        return list;
    }
}
