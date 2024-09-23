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

   public void showDetails(){
        System.out.println("Student's name is: "+name);
        System.out.println("Student's course is: "+course);
        System.out.println("Student's CGPA is: "+cgpa+"\n");
    }

    public static int getInstanceCount(){
        return instanceCount;
    }
}
