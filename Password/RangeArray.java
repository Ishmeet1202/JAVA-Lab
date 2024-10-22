package Password;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeArray {

    private ArrayList<String> smallAlphabets;
    private ArrayList<String> capitalAlphabets;
    private ArrayList<String> decimals;
    private ArrayList<String> specialCharacters;
    private ArrayList<String> combineCharacters;

    public RangeArray() {
        this.generateSmallAlphabets();
        this.generateCapitalAlphabets();
        this.generateDecimalNumbers();
        this.generateSpecialCharacters();
        this.generateCombineList();
    }

    public ArrayList<String> getSmallAlphabets() {
        return smallAlphabets;
    }

    public ArrayList<String> getCapitalAlphabets() {
        return capitalAlphabets;
    }

    public ArrayList<String> getDecimals() {
        return decimals;
    }

    public ArrayList<String> getSpecialCharacters() {
        return specialCharacters;
    }

    public ArrayList<String> getCombineCharacters() {
        return combineCharacters;
    }

    private void generateSmallAlphabets() {
        this.smallAlphabets = new ArrayList<String>();
        for(char x = 'a'; x<='z'; x++){
            this.smallAlphabets.add(Character.toString(x));
        }
    }

    private void generateCapitalAlphabets() {
        this.capitalAlphabets = new ArrayList<String>();
        for (char x = 'A'; x <= 'Z'; x++) {
            this.capitalAlphabets.add(Character.toString(x));
        }
    }

    private void generateDecimalNumbers() {
        this.decimals = new ArrayList<String>();
        for(int x = 0; x<=9; x++){
            this.decimals.add(Integer.toString(x));
        }
    }

    private void generateSpecialCharacters() {
        String[] special = {"$", "@", "#"};
        this.specialCharacters = new ArrayList<String>(Arrays.asList(special));
    }

    private void generateCombineList(){
        this.combineCharacters = new ArrayList<>();
        this.combineCharacters.addAll(getSmallAlphabets());
        this.combineCharacters.addAll(getCapitalAlphabets());
        this.combineCharacters.addAll(getSpecialCharacters());
        this.combineCharacters.addAll(getDecimals());
    }
}
