/*
* 系統測試class
* */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class systemTest {
    finalEnrollForm finalEnrollForm;
    SchoolEnrollForm schoolEnrollForm;
    applicationForm applicationForm;
    Student[] students;
    Student student1;
    Student student2;
    Student student3;
    Student student4;
    Student student5;
    School school1;
    School school2;
    School school3;
    School school4;
    School school5;
    @Before
    public void createTestData(){
        student1 = new Student("張三",100);
        student2 = new Student("李四",99);
        student3 = new Student("小明",98);
        student4 = new Student("王五",97);
        student5 = new Student("小紅",80);
        school1 = new School("逢甲大學",1,3,90);
        school2 = new School("台灣大學",4,4,95);
        school3 = new School("中原大學",2,3,82);
        school4 = new School("清華大學",4,2,93);
        school5 = new School("成功大學",3,3,94);
    }
    @Test //學校錄取名單測試
    public void SchoolEnrollFormTest1(){
        StringBuffer expected = null;
        String expected2 = "";
        School school = new School("逢甲大學",1,3,90);
        students = new Student[]{student1, student2, student3, student5, student4};//假設這些同學投了台大

        schoolEnrollForm = new SchoolEnrollForm();
        schoolEnrollForm.setSchool(school);

        school.setSchoolEnrollForm(schoolEnrollForm);
        school.schoolEnrollForm.schoolEnrollRule(students);

        //schoolEnrollForm.schoolEnrollRule(students);
        //assertEquals(expected,schoolEnrollForm.schoolEnrollFormOutput());
        assertEquals(expected2,schoolEnrollForm.schoolEnrollFormOutput2());
    }
    @Test //學生錄取測試
    public void StudentFinalEnrollFormTest(){
        String expected = "";
        finalEnrollForm = new finalEnrollForm();
        students = new Student[]{student1, student2, student3, student5, student4};//學生名單

        //創建學校錄取名單物件
        schoolEnrollForm = new SchoolEnrollForm();

        //設立所有學校名單
        schoolEnrollForm.schools.add(school1);//逢甲
        schoolEnrollForm.schools.add(school2);//台大
        schoolEnrollForm.schools.add(school3);//中原
        schoolEnrollForm.schools.add(school4);//清華
        schoolEnrollForm.schools.add(school5);//成功

        schoolEnrollForm.setSchool(school1);

        school1.setSchoolEnrollForm(schoolEnrollForm);
        school1.schoolEnrollForm.schoolEnrollRule(students);//調用school中的學校錄取方法


        //schoolEnrollForm = new SchoolEnrollForm(schools);
        applicationForm = new applicationForm(new String[]{"台灣大學","逢甲大學","中原大學"});
        assertEquals(expected,finalEnrollForm.studentEnrollFormRule(student3,applicationForm,schoolEnrollForm));
    }


}
