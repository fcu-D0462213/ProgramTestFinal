package test.java.example;

import java.lang.System;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.example.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SchoolEnrollFormTest {

    School school = new School("成功大學", 5, 4, 90);

    Student student1 = new Student("160001", "張三", 0);
    Student student2 = new Student("160002", "赖恬甜", 0);
    Student student3 = new Student("160003", "王喆", 0);
    Student student4 = new Student("160004", "贾泽", 0);
    Student student5 = new Student("160005", "李四", 0);
    Student student6 = new Student("160006", "小明", 0);
    Student student7 = new Student("160007", "李紅", 0);
    Student student8 = new Student("160008", "張飛", 0);
    Student student9 = new Student("160009", "王恐怕", 0);
    ApplicationForm app = new ApplicationForm(new String[]{"成功大學"});
    ApplicationForm[] apps = new ApplicationForm[]{app, app, app,
                                                   app, app, app,
                                                   app, app, app,};

    SchoolEnrollForm schoolEnrollForm;

    StudentEnrollForm studentEnrollForm = new StudentEnrollForm();
    @Before
    public void setup() {
        schoolEnrollForm = new SchoolEnrollForm();
        schoolEnrollForm.setSchool(school);
    }

    @Test // 學校錄取名單測試
    public void schoolEnrollFormTest1() {
        Student[] students = new Student[]{student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9};
        student1.setStuScore(80.4);
        student2.setStuScore(70.2);
        student3.setStuScore(60.6);
        student4.setStuScore(50.8);
        student5.setStuScore(89.2);
        student6.setStuScore(89.9);
        student7.setStuScore(88.1);
        student8.setStuScore(55.1);
        student9.setStuScore(16.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);
        System.out.println(schoolEnrollForm.schoolEnrollFormOutput());

        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息
        System.out.println(studentEnrollForm.schoolEnrollFormOutput());
        assertEquals("成功大學 (正取名額:5 備取名額:4 報名人數:9) 錄取名單：\n" +
                "未錄取學生:小明\n" +
                "未錄取學生:李四\n" +
                "未錄取學生:李紅\n" +
                "未錄取學生:張三\n" +
                "未錄取學生:赖恬甜\n" +
                "未錄取學生:王喆\n" +
                "未錄取學生:張飛\n" +
                "未錄取學生:贾泽\n" +
                "未錄取學生:王恐怕\n" +
                "錄取率:0.00% 缺額率：100.00%\n",schoolEnrollForm.schoolEnrollFormOutput());

    }

}
