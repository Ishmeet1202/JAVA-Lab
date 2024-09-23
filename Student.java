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

    public static void main(String[] args) {
        Student obj1 = new Student("Harry Potter","MCA",8.63);
        Student obj2 = new Student("Ron Weasley","BTech CS",8.42);
        Student obj3 = new Student("Dean Thomas","MSc Physics",8.23);

        obj1.showDetails();
        obj2.showDetails();
        obj3.showDetails();

        System.out.println("The number of instances of the Student class is: "+Student.getInstanceCount());
    }
}
