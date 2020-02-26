package main.com.sumit.coding.design_patterns;

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

/**
 * Class that implements Singleton design Pattern
 */
class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    /**
     * @return object using lazy initialization
     */
    static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
