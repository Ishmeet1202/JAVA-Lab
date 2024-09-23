package SingletonClass;

public class Singleton {

    private Singleton() {
        String s = "Hello I am a singleton class.";
        System.out.println(s);
    }

    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
