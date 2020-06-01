package main.com.sumit.coding.design_patterns.creational.singleton.problem;

class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    /**
     * @return object using lazy initialization
     */
    static Singleton getInstance() {

        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
