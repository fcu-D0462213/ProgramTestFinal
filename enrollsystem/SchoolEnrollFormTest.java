package enrollsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class SchoolEnrollFormTest {

  @Before
  public void setup() {
    Student student1 = new Student("STU20160001", "張三", 100);
    Student student2 = new Student("STU20160002", "赖恬甜", 100);
    Student student3 = new Student("STU20160003", "王喆", 99);
    Student student4 = new Student("STU20160004", "贾泽", 99);
    Student student5 = new Student("STU20160005", "李四", 97);
    Student student6 = new Student("STU20160006", "小明", 96);
    Student student7 = new Student("STU20160007", "李紅", 96);
    Student student8 = new Student("STU20160008", "張飛", 94);
    Student student9 = new Student("STU20160009", "王恐怕", 93);
    Student student10 = new Student("STU20160010", "张天文", 92);
    Student student11 = new Student("STU20160011", "李丹丹", 91);
    Student student12 = new Student("STU20160012", "王某某", 90);
    Student student13 = new Student("STU20160013", "宋晓锋", 89);
    Student student14 = new Student("STU20160014", "赵传家", 88);
    Student student15 = new Student("STU20160015", "李世石", 87);
    Student student16 = new Student("STU20160016", "王宝平", 86);
    Student student17 = new Student("STU20160017", "丁页如", 85);
    Student student18 = new Student("STU20160018", "萧枸", 83);

    School school1 = new School("台灣大學", 1, 1, 96);
    School school2 = new School("清華大學", 2, 1, 95);
    School school3 = new School("交通大學", 2, 1, 94);
    School school4 = new School("成功大學", 3, 1, 93);
    School school5 = new School("政治大學", 3, 1, 92);
    School school6 = new School("中山大學", 4, 1, 91);
    School school7 = new School("逢甲大學", 5, 3, 90);
    School school8 = new School("中原大學", 5, 3, 88);
    School school9 = new School("中央大學", 5, 3, 86);
    School school10 = new School("中興大學", 6, 3, 84);
    School school11 = new School("科技大學", 6, 3, 82);

    Student[] students = new Student[] { student1, student2, student3, student4, student5, student6, student7, student8,
        student9, student10, student11, student12, student13, student14, student15, student16, student17, student18 };// 學生名單

    StudentEnrollForm studentEnrollForm = new StudentEnrollForm();

    // 創建學校錄取名單物件
    SchoolEnrollForm schoolEnrollForm = new SchoolEnrollForm();

    // 設立所有學校名單
    schoolEnrollForm.schools.add(school1);
    schoolEnrollForm.schools.add(school2);
    schoolEnrollForm.schools.add(school3);
    schoolEnrollForm.schools.add(school4);
    schoolEnrollForm.schools.add(school5);
    schoolEnrollForm.schools.add(school6);
    schoolEnrollForm.schools.add(school7);
    schoolEnrollForm.schools.add(school8);
    schoolEnrollForm.schools.add(school9);
    schoolEnrollForm.schools.add(school10);
    schoolEnrollForm.schools.add(school11);

    ApplicationForm app1 = new ApplicationForm(new String[] { "台灣大學", "清華大學" });
    ApplicationForm app2 = new ApplicationForm(new String[] { "台灣大學", "清華大學" });
    ApplicationForm app3 = new ApplicationForm(new String[] { "台灣大學", "清華大學", "交通大學", "成功大學" });
    ApplicationForm app4 = new ApplicationForm(new String[] { "台灣大學", "清華大學", "交通大學", "成功大學" });
    ApplicationForm app5 = new ApplicationForm(new String[] { "台灣大學", "清華大學", "交通大學", "成功大學" });
    ApplicationForm app6 = new ApplicationForm(new String[] { "台灣大學", "交通大學", "成功大學", "政治大學" });
    ApplicationForm app7 = new ApplicationForm(new String[] { "台灣大學", "清華大學", "成功大學", "政治大學" });
    ApplicationForm app8 = new ApplicationForm(new String[] { "清華大學", "成功大學", "政治大學", "中山大學" });
    ApplicationForm app9 = new ApplicationForm(new String[] { "交通大學", "政治大學", "中山大學", "逢甲大學" });
    ApplicationForm app10 = new ApplicationForm(new String[] { "成功大學", "政治大學", "中山大學", "逢甲大學" });
    ApplicationForm app11 = new ApplicationForm(new String[] { "台灣大學", "中山大學", "逢甲大學", "中原大學" });
    ApplicationForm app12 = new ApplicationForm(new String[] { "清華大學", "中原大學", "逢甲大學", "中山大學" });
    ApplicationForm app13 = new ApplicationForm(new String[] { "中央大學", "中原大學", "逢甲大學", "中興大學" });
    ApplicationForm app14 = new ApplicationForm(new String[] { "成功大學", "逢甲大學", "中興大學", "科技大學" });
    ApplicationForm app15 = new ApplicationForm(new String[] { "中原大學", "中興大學", "科技大學" });
    ApplicationForm app16 = new ApplicationForm(new String[] { "中原大學", "中央大學", "中興大學", "科技大學" });
    ApplicationForm app17 = new ApplicationForm(new String[] { "交通大學", "中原大學", "中央大學", "中興大學" });
    ApplicationForm app18 = new ApplicationForm(new String[] { "逢甲大學", "中原大學", "中興大學", "科技大學" });
    ApplicationForm[] apps = new ApplicationForm[] { app1, app2, app3, app4, app5, app6, app7, app8, app9, app10, app11,
        app12, app13, app14, app15, app16, app17, app18 };

    schoolEnrollForm.schoolEnrollRule(students, apps);// 學校的錄取名單
    Logger log = Logger.getLogger("lavasoft");
    log.setLevel(Level.INFO);

    log.info(studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm));

    log.info(schoolEnrollForm.schoolEnrollFormOutput2());// 印出學校榜單
  }

  @Test // 學校錄取名單測試
  public void schoolEnrollFormTest1() {
  }

}
