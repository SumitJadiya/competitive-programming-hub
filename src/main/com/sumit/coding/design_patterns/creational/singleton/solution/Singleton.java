package main.com.sumit.coding.design_patterns.creational.singleton.solution;

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
