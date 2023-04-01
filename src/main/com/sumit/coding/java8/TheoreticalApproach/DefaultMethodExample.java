package main.com.sumit.coding.java8.TheoreticalApproach;

interface TestInterface {
    // abstract method
    public void square(int a);

    // default method
    default void show() {
        System.out.println("Default Method Executed");
    }
}

class DefaultMethodExample implements TestInterface {
    // implementation of square abstract method
    public void square(int a) {
        System.out.println(a * a);
    }

    public static void main(String args[]) {
        DefaultMethodExample d = new DefaultMethodExample();
        d.square(4);

        // default method executed
        d.show();
    }
}