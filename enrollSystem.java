/*
* 當前設定為：錄取的操作系統
*
* */

public class enrollSystem {
  public void systemRule() {

  }

  public static void main(String[] args) {

    Student student1 = new Student("STU20160001", "張三", 100);
    Student student2 = new Student("STU20160002", "李四", 90);
    Student student3 = new Student("STU20160003", "小明", 99);
    Student student4 = new Student("STU20160004", "王五", 99);
    Student student5 = new Student("STU20160005", "小紅", 88);
    School school1 = new School("逢甲大學", 5, 3, 90);
    School school2 = new School("台灣大學", 1, 3, 95);
    School school3 = new School("中原大學", 2, 3, 82);
    School school4 = new School("清華大學", 4, 2, 93);
    School school5 = new School("成功大學", 3, 3, 94);
    School school6 = new School("交通大學", 2, 3, 94);
    School school7 = new School("中山大學", 2, 3, 94);
    finalEnrollForm finalEnrollForm = new finalEnrollForm();
    Student[] students = new Student[] { student1, student2, student3, student5, student4 };// 學生名單

    // 創建學校錄取名單物件
    SchoolEnrollForm schoolEnrollForm1 = new SchoolEnrollForm();
    SchoolEnrollForm schoolEnrollForm2 = new SchoolEnrollForm();
    SchoolEnrollForm schoolEnrollForm3 = new SchoolEnrollForm();
    SchoolEnrollForm schoolEnrollForm4 = new SchoolEnrollForm();
    SchoolEnrollForm schoolEnrollForm5 = new SchoolEnrollForm();

    // 設立所有學校名單
    schoolEnrollForm1.schools.add(school1);
    schoolEnrollForm1.schools.add(school2);
    schoolEnrollForm1.schools.add(school3);
    schoolEnrollForm1.schools.add(school4);
    schoolEnrollForm1.schools.add(school5);
    schoolEnrollForm1.schools.add(school6);
    schoolEnrollForm1.schools.add(school7);

    applicationForm app1 = new applicationForm(new String[] { "台灣大學", "清華大學", "中原大學" });// 創立stu1志願
    applicationForm app2 = new applicationForm(new String[] { "台灣大學", "中山大學", "中原大學" });
    applicationForm app3 = new applicationForm(new String[] { "清華大學", "中山大學", "逢甲大學" });
    applicationForm app4 = new applicationForm(new String[] { "交通大學", "清華大學", "中山大學" });
    applicationForm app5 = new applicationForm(new String[] { "交通大學", "清華大學", "成功大學" });
    applicationForm[] app = new applicationForm[] { app1, app2, app3, app4, app5 };

    schoolEnrollForm1.schoolEnrollRule(school1, students, app);// 逢甲的錄取名單
    schoolEnrollForm1.schoolEnrollRule(school2, students, app);// 台大的錄取名單
    schoolEnrollForm1.schoolEnrollRule(school3, students, app);// 中原的錄取名單
    schoolEnrollForm1.schoolEnrollRule(school4, students, app);// 清華的錄取名單
    schoolEnrollForm1.schoolEnrollRule(school5, students, app);// 成功的錄取名單
    schoolEnrollForm1.schoolEnrollRule(school6, students, app);
    schoolEnrollForm1.schoolEnrollRule(school7, students, app);

    System.out.println(finalEnrollForm.studentEnrollFormRule(student1, app1, schoolEnrollForm1));
    System.out.println(finalEnrollForm.studentEnrollFormRule(student2, app2, schoolEnrollForm2));
    System.out.println(finalEnrollForm.studentEnrollFormRule(student3, app3, schoolEnrollForm3));
    System.out.println(finalEnrollForm.studentEnrollFormRule(student4, app4, schoolEnrollForm4));
    System.out.println(finalEnrollForm.studentEnrollFormRule(student5, app5, schoolEnrollForm5));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school1));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school2));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school3));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school4));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school5));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school6));
    System.out.println(schoolEnrollForm1.schoolEnrollFormOutput2(school7));
  }

}
