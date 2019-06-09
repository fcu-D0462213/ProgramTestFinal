package test.java.example;

import main.java.example.*;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StudentEnrollFormTest {

    Student student1 = new Student("160014", "赵传家", 96);
    Student student2 = new Student("160015", "李世石", 94);
    Student student3 = new Student("160016", "王宝平", 92);
    Student student4 = new Student("160017", "丁页如", 90);
    Student student5 = new Student("160018", "萧枸", 89);
    School school1 = new School("台灣大學", 2, 2, 94);
    School school2 = new School("交通大學", 1, 1, 90);
    School school3 = new School("逢甲大學", 2, 1, 84);
    School school4 = new School("中央大學", 2, 3, 88);
    School school5 = new School("政治大學", 3, 1, 92);

    Student[] students = new Student[]{student1, student2, student3, student4, student5};

    SchoolEnrollForm schoolEnrollForm = new SchoolEnrollForm();
    StudentEnrollForm studentEnrollForm = new StudentEnrollForm();

    @Before
    public void setup() {
        schoolEnrollForm.setSchool(school1);
        schoolEnrollForm.setSchool(school2);
        schoolEnrollForm.setSchool(school3);
        schoolEnrollForm.setSchool(school4);
        schoolEnrollForm.setSchool(school5);
    }

    // 學生錄取測試
    @Test
    public void studentFinalEnrollFormTest1() {
        ApplicationForm app1 = new ApplicationForm(new String[]{"台灣大學", "逢甲大學", "政治大學", "中央大學"});
        ApplicationForm app2 = new ApplicationForm(new String[]{"中央大學", "台灣大學", "逢甲大學", "政治大學"});
        ApplicationForm app3 = new ApplicationForm(new String[]{"交通大學", "台灣大學", "逢甲大學", "中央大學"});
        ApplicationForm app4 = new ApplicationForm(new String[]{"逢甲大學", "交通大學", "台灣大學", "政治大學"});
        ApplicationForm app5 = new ApplicationForm(new String[]{"政治大學", "交通大學", "逢甲大學", "台灣大學"});
        ApplicationForm[] apps = new ApplicationForm[]{app1, app2, app3, app4, app5};

        schoolEnrollForm.schoolEnrollRule(students, apps);// 學校的錄取名單
        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息

        assertEquals("[正取1, ----, ----, ----]", Arrays.toString(apps[2].getSchoolState()));
    }

    @Test // 學生錄取測試
    public void studentFinalEnrollFormTest2() {
        ApplicationForm app1 = new ApplicationForm(new String[]{"中央大學", "", "政治大學", "台灣大學"});
        ApplicationForm app2 = new ApplicationForm(new String[]{"交通大學", "中央大學", "政治大學", "台灣大學"});
        ApplicationForm app3 = new ApplicationForm(new String[]{"交通大學", "逢甲大學", "中央大學", "政治大學"});
        ApplicationForm app4 = new ApplicationForm(new String[]{"逢甲大學", "政治大學", "中央大學", "台灣大學"});
        ApplicationForm app5 = new ApplicationForm(new String[]{"逢甲大學", "中央大學", "政治大學", "交通大學"});
        ApplicationForm[] apps = new ApplicationForm[]{app1, app2, app3, app4, app5};

        schoolEnrollForm.schoolEnrollRule(students, apps);// 學校的錄取名單
        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息

        assertEquals("[備取1, 正取1, ----, ----]", Arrays.toString(apps[2].getSchoolState()));
    }

    @Test // 學生錄取測試
    public void studentFinalEnrollFormTest3() {
        ApplicationForm app1 = new ApplicationForm(new String[]{"中央大學", "逢甲大學", "台灣大學", "政治大學"});
        ApplicationForm app2 = new ApplicationForm(new String[]{"交通大學", "中央大學", "政治大學", "逢甲大學"});
        ApplicationForm app3 = new ApplicationForm(new String[]{"台灣大學", "交通大學", "政治大學", "中央大學"});
        ApplicationForm app4 = new ApplicationForm(new String[]{"台灣大學", "政治大學", "逢甲大學", "中央大學"});
        ApplicationForm app5 = new ApplicationForm(new String[]{"中央大學", "政治大學", "交通大學", "逢甲大學"});
        ApplicationForm[] apps = new ApplicationForm[]{app1, app2, app3, app4, app5};

        schoolEnrollForm.schoolEnrollRule(students, apps);// 學校的錄取名單
        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息

        assertEquals("[未錄取, 備取1, 正取3, ----]", Arrays.toString(apps[2].getSchoolState()));
    }

    @Test // 學生錄取測試 3 3 2 1
    public void studentFinalEnrollFormTest4() {
        ApplicationForm app1 = new ApplicationForm(new String[]{"交通大學", "政治大學", "中央大學", "台灣大學"});
        ApplicationForm app2 = new ApplicationForm(new String[]{"中央大學", "交通大學", "政治大學", "台灣大學"});
        ApplicationForm app3 = new ApplicationForm(new String[]{"中央大學", "政治大學", "台灣大學", "交通大學"});
        ApplicationForm app4 = new ApplicationForm(new String[]{"台灣大學", "中央大學", "逢甲大學", "政治大學"});
        ApplicationForm app5 = new ApplicationForm(new String[]{"交通大學", "政治大學", "中央大學", "逢甲大學"});
        ApplicationForm[] apps = new ApplicationForm[]{app1, app2, app3, app4, app5};

        schoolEnrollForm.schoolEnrollRule(students, apps);// 學校的錄取名單
        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息

        assertEquals("[未錄取, 未錄取, 備取3, 正取2]", Arrays.toString(apps[4].getSchoolState()));
    }

    @Test // 學生錄取測試 2 3 2 2
    public void studentFinalEnrollFormTest5() {
        ApplicationForm app1 = new ApplicationForm(new String[]{"中央大學", "交通大學", "逢甲大學", "中央大學"});
        ApplicationForm app2 = new ApplicationForm(new String[]{"中央大學", "逢甲大學", "中央大學", "政治大學"});
        ApplicationForm app3 = new ApplicationForm(new String[]{"交通大學", "台灣大學", "逢甲大學", "中央大學"});
        ApplicationForm app4 = new ApplicationForm(new String[]{"逢甲大學", "中央大學", "政治大學", "交通大學"});
        ApplicationForm app5 = new ApplicationForm(new String[]{"台灣大學", "中央大學", "交通大學", "逢甲大學"});
        ApplicationForm[] apps = new ApplicationForm[]{app1, app2, app3, app4, app5};

        schoolEnrollForm.schoolEnrollRule(students, apps);// 學校的錄取名單
        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息

        assertEquals("[備取1, 未錄取, 備取1, 備取3]", Arrays.toString(apps[2].getSchoolState()));
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.INFO);

        log.info(studentEnrollForm.studentEnrollFormOutput());//印出學生的榜單
        log.info(schoolEnrollForm.schoolEnrollFormOutput());// 印出學校榜單
    }
}
