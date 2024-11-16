package Triplet_Collection;

public class Doublet<U,V> {
    private U second;
    private V third;

    public Doublet(U second, V third) {
        this.second = second;
        this.third = third;
    }

    public U getSecond() {
        return second;
    }

    public V getThird() {
        return third;
    }

    @Override
    public String toString() {
        return "( " + second + " , " + third + " )";
    }
}
