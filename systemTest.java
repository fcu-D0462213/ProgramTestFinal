
/*
* 系統測試class
* */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
  public void createTestData() {
    student1 = new Student("STU0002016001", "張三", 100);
    student2 = new Student("STU0002016002", "李四", 99);
    student3 = new Student("STU0002016003", "小明", 93);
    student4 = new Student("STU0002016004", "王五", 97);
    student5 = new Student("STU0002016005", "小紅", 91);
    school1 = new School("逢甲大學", 1, 2, 90);
    school2 = new School("台灣大學", 4, 4, 95);
    school3 = new School("中原大學", 2, 3, 82);
    school4 = new School("清華大學", 2, 2, 93);
    school5 = new School("成功大學", 3, 3, 94);
  }

  @Test // 學校錄取名單測試
  public void SchoolEnrollFormTest1() {
    StringBuffer expected = null;
    String expected2 = "";
    School school = new School("逢甲大學", 1, 6, 90);
    School school2 = new School("台灣大學", 4, 4, 95);
    students = new Student[] { student1, student2, student3, student5, student4 };// 假設這些同學投了逢甲

    schoolEnrollForm = new SchoolEnrollForm();
    // schoolEnrollForm.schoolEnrollRule(school, students);
    // schoolEnrollForm.schoolEnrollRule(school2, students);
    // assertEquals(expected,schoolEnrollForm.schoolEnrollFormOutput(school));
    // assertEquals(expected2,schoolEnrollForm.schoolEnrollFormOutput2(school));
//    assertEquals(expected, schoolEnrollForm.schoolEnrollFormOutput2(school2));
  }

  @Test // 學生錄取測試
  public void StudentFinalEnrollFormTest() {
    String expected = "1";
    finalEnrollForm = new finalEnrollForm();
    students = new Student[] { student1, student2, student3, student5, student4 };// 學生名單

    // 創建學校錄取名單物件
    schoolEnrollForm = new SchoolEnrollForm();

    // 設立所有學校名單
    schoolEnrollForm.schools.add(school1);// 逢甲
    schoolEnrollForm.schools.add(school2);// 台大
    schoolEnrollForm.schools.add(school3);// 中原
    schoolEnrollForm.schools.add(school4);// 清華
    schoolEnrollForm.schools.add(school5);// 成功

    // schoolEnrollForm.schoolEnrollRule(school1, students);// 逢甲的錄取名單
    // schoolEnrollForm.schoolEnrollRule(school2, students);// 台大的錄取名單
    // schoolEnrollForm.schoolEnrollRule(school3, students);// 中原的錄取名單
    // schoolEnrollForm.schoolEnrollRule(school4, students);// 清華的錄取名單
    // schoolEnrollForm.schoolEnrollRule(school5, students);// 成功的錄取名單

    applicationForm = new applicationForm(new String[] { "台灣大學", "逢甲大學", "中原大學", "清華大學", "成功大學" });// 創立志願

    assertEquals(expected, finalEnrollForm.studentEnrollFormRule(student3, applicationForm, schoolEnrollForm));
  }
}
