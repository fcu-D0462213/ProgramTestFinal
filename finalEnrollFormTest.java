import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class finalEnrollFormTest {

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

    schoolEnrollForm.schoolEnrollRule(school1, students);// 逢甲的錄取名單
    schoolEnrollForm.schoolEnrollRule(school2, students);// 台大的錄取名單
    schoolEnrollForm.schoolEnrollRule(school3, students);// 中原的錄取名單
    schoolEnrollForm.schoolEnrollRule(school4, students);// 清華的錄取名單
    schoolEnrollForm.schoolEnrollRule(school5, students);// 成功的錄取名單

    applicationForm = new applicationForm(new String[] { "台灣大學", "逢甲大學", "中原大學", "清華大學", "成功大學" });// 創立志願

    assertEquals(expected, finalEnrollForm.studentEnrollFormRule(student3, applicationForm, schoolEnrollForm));
  }

}
