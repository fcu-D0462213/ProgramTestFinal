import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class systemTest {
    SchoolEnrollForm schoolEnrollForm;
    Student[] students;
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    @Before
    public void createTestData(){
        student1 = new Student("張三",80.5);
        student2 = new Student("李四",90);
        student3 = new Student("小明",99);
        student4 = new Student("王五",100);
        student5 = new Student("小紅",88);
    }
    @Test
    public void Test1(){
        StringBuffer expected =null;
        String expected2 = "";
        School school = new School("台灣大學",3,2,75);
        schoolEnrollForm = new SchoolEnrollForm(school);
        students = new Student[]{student1, student2, student3, student5, student4};
        schoolEnrollForm.schoolEnrollRule(students);
        assertEquals(expected,schoolEnrollForm.schoolEnrollFormOutput());
        //assertEquals(expected2,schoolEnrollForm.schoolEnrollFormOutput2());
    }


}
