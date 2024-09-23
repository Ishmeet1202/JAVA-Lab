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

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
    }
}
