import java.util.*;

public class StudentsMap {
    public static void main(String[] args) {
        // Create a Map for MCA students
        Map<String, String> mcaStudents = new HashMap<>();
        mcaStudents.put("mca_user1", "password1");
        mcaStudents.put("mca_user2", "password2");
        mcaStudents.put("mca_user3", "password3");
        mcaStudents.put("mca_user4", "password4");
        mcaStudents.put("mca_user5", "password5");

        // Create a Map for MSC students
        Map<String, String> mscStudents = new HashMap<>();
        mscStudents.put("msc_user1", "password6");
        mscStudents.put("msc_user2", "password7");
        mscStudents.put("msc_user3", "password8");
        mscStudents.put("msc_user4", "password9");
        mscStudents.put("msc_user5", "password10");

        // Merge both maps into a single map
        Map<String, String> allStudents = new HashMap<>(mcaStudents);
        allStudents.putAll(mscStudents);

        // Display the merged map
        System.out.println("Merged Student Map:");
        for (Map.Entry<String, String> entry : allStudents.entrySet()) {
            System.out.println("Username: " + entry.getKey() + ", Password: " + entry.getValue());
        }
    }
}
