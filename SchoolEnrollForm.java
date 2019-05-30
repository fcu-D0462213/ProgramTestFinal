import java.util.ArrayList;

public class SchoolEnrollForm {
    School school;
    int totalNum = school.getEnrollNum()+school.getStandbyEnrollNum();
    //ArrayList<Student> students = new ArrayList<Student>();
    Student[] students = new Student[totalNum];


}
