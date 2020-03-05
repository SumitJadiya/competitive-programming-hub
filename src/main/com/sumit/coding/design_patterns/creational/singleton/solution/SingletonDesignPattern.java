package main.com.sumit.coding.design_patterns.creational.singleton.solution;

/**
 * Public class that uses singleton class
 */
public class SingletonDesignPattern {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        System.out.println(singleton);
    }
}
