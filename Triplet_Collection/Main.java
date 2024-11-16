package Triplet_Collection;

public class Main {
    public static void main(String[] args) {
        TripletCollection<Integer,String,Integer> tc = new TripletCollection<>();

        tc.add(1,"Ishmeet",21);
        tc.add(2,"Sarthak",22);
        tc.add(3,"Swarnim",21);

        System.out.print("\nTripletCollection after adding is: "+tc+"\n");

        System.out.print("\nValues corresponding to the key is: "+tc.getValue(2)+" \n");

        tc.remove(2);
        System.out.print("\nTripletCollection after removing a triplet is: "+tc+"\n");

        System.out.print("\nSize of the TripletCollection: "+tc.size()+"\n");

        if(tc.contains(3)){
            System.out.println("\nContain in TripletCollection.\n");
        }
        else {
            System.out.println("\nNot contain in TripletCollection.\n");
        }
    }
}
