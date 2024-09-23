package Student;

public class Student {

    private static int instanceCount = 0;
    private String name;
    private String course;
    private double cgpa;

    public Student(String name, String course, double cgpa) {
        this.name = name;
        this.course = course;
        this.cgpa = cgpa;
        instanceCount++;
    }

    public static int getInstanceCount(){
        return instanceCount;
    }
}
