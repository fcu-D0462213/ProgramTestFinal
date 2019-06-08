import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SchoolEnrollFormTest {

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
  School school6;
  School school7;

  @Before
  public void setup() {

    school1 = new School("逢甲大學", 4, 4, 85);
    school2 = new School("台灣大學", 1, 2, 95);
    school3 = new School("中原大學", 2, 3, 86);
    school4 = new School("清華大學", 2, 2, 93);
    school5 = new School("成功大學", 3, 3, 94);
    school6 = new School("交通大學", 2, 3, 92);
    school7 = new School("中山大學", 2, 2, 93);
  }

  @Test // 學校錄取名單測試
  public void SchoolEnrollFormTest1() {
    StringBuffer expected = null;
    String expected2 = "";
    student1 = new Student("STU0002016001", "張三", 100);
    student2 = new Student("STU0002016002", "李四", 99);
    student3 = new Student("STU0002016003", "小明", 93);
    student4 = new Student("STU0002016004", "王五", 97);
    student5 = new Student("STU0002016005", "小紅", 91);
    students = new Student[] { student1, student2, student3, student5, student4 };// 假設這些同學投了逢甲

    schoolEnrollForm = new SchoolEnrollForm();
    schoolEnrollForm.schoolEnrollRule(school1, students);
    schoolEnrollForm.schoolEnrollRule(school2, students);
    // assertEquals(expected,schoolEnrollForm.schoolEnrollFormOutput(school));
    // assertEquals(expected2,schoolEnrollForm.schoolEnrollFormOutput2(school));
    assertEquals(expected, schoolEnrollForm.schoolEnrollFormOutput2(school2));
  }

}
