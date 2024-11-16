package Triplet_Collection;

import java.util.HashMap;

public class TripletCollection <T,U,V> {
    private HashMap<T,Doublet<U,V>> triplemap;

    public TripletCollection() {
        this.triplemap = new HashMap<>();
    }

    public void add(T first,U second,V third){
        if(!triplemap.containsKey(first))
        {
            triplemap.put(first,new Doublet<>(second,third));
        }
        else{
            System.out.println("Key " + first + " already exist !");
        }
    }

    public void remove(T key){
        try{
            triplemap.remove(key);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public int size(){
        return triplemap.size();
    }

    public boolean contains(T key){
        return triplemap.containsKey(key);
    }

    @Override
    public String toString(){
        return triplemap.toString();
    }

    public String getValue(T key) {
        try {
            Doublet<U, V> t = triplemap.get(key);
            return t.toString();
        }
        catch(NullPointerException e1){
            System.out.println(e1.getMessage());
        }
        return null;
    }
}
