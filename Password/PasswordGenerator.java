package Password;

import java.util.*;

public class PasswordGenerator {

    private int lengthOfPassword;
    private String password;

    public PasswordGenerator(int lengthOfPassword) {
        this.lengthOfPassword = lengthOfPassword;
    }

    public int getLengthOfPassword() {
        return lengthOfPassword;
    }

    public String getPassword() {
        return password;
    }

    private String getRandomItem(ArrayList<String> l) {
        return l.get((int)(Math.random()*l.size()));
    }

    public void generateRandomPassword() {

        ArrayList<String> pwd = new ArrayList<>();
        RangeArray ra = new RangeArray();

        pwd.add(getRandomItem(ra.getCapitalAlphabets()));
        pwd.add(getRandomItem(ra.getDecimals()));
        pwd.add(getRandomItem(ra.getSpecialCharacters()));

        for(int i=0;i<this.lengthOfPassword-3;i++){
            Collections.shuffle(ra.getCombineCharacters());
            pwd.add(getRandomItem(ra.getCombineCharacters()));
        }

        Collections.shuffle(pwd);
        this.password = String.join("", pwd);
    }
}


