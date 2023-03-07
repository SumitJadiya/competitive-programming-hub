package main.com.sumit.coding.java8.TheoreticalApproach;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsHashcodeExample {
    public static void main(String[] args) {
        Map<DataKey, Integer> hm = getAllData();

        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println(dk.hashCode());

        Integer value = hm.get(dk);

        System.out.println(value);

    }

    private static Map<DataKey, Integer> getAllData() {
        Map<DataKey, Integer> hm = new HashMap<>();

        DataKey dk = new DataKey();
        dk.setId(1);
        dk.setName("Pankaj");
        System.out.println(dk.hashCode());

        hm.put(dk, 10);

        return hm;
    }
}

class DataKey {

    private String name;
    private int id;

    // getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataKey dataKey)) return false;
        return getId() == dataKey.getId() && getName().equals(dataKey.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }

    @Override
    public String toString() {
        return "DataKey [name=" + name + ", id=" + id + "]";
    }

}