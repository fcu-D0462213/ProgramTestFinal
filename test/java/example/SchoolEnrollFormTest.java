package test.java.example;

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
    Student student10 = new Student("160010", "王紅飛", 0);
    Student student11 = new Student("160011", "王紅", 0);
    ApplicationForm app = new ApplicationForm(new String[]{"成功大學"});
    ApplicationForm[] apps = new ApplicationForm[]{app, app, app,
            app, app, app,
            app, app, app,};

    Student[] students = new Student[]{student1, student2, student3,
            student4, student5, student6,
            student7, student8, student9};
    SchoolEnrollForm schoolEnrollForm;

    @Before
    public void setup() {
        schoolEnrollForm = new SchoolEnrollForm();
        schoolEnrollForm.setSchool(school);
    }

    @Test //0人正取，0人備取，9人未錄取
    public void schoolEnrollFormTest1() {
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

        assertEquals("[]", school.getEnrollList().toString());
        assertEquals("[]", school.getStandbyEnrollList().toString());
        assertEquals("[小明, 李四, 李紅, 張三, 赖恬甜, 王喆, 張飛, 贾泽, 王恐怕]", school.getOutEnrollList().toString());
        assertEquals("0.00%", school.getEnrollRate());
        assertEquals("100.00%", school.getGapRate());
    }

    @Test //1人正取，0人備取，8人未錄取
    public void schoolEnrollFormTest2() {
        student1.setStuScore(80.4);
        student2.setStuScore(70.2);
        student3.setStuScore(60.6);
        student4.setStuScore(50.8);
        student5.setStuScore(89.2);
        student6.setStuScore(90.1);
        student7.setStuScore(88.1);
        student8.setStuScore(55.1);
        student9.setStuScore(16.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[小明]", school.getEnrollList().toString());
        assertEquals("[]", school.getStandbyEnrollList().toString());
        assertEquals("[李四, 李紅, 張三, 赖恬甜, 王喆, 張飛, 贾泽, 王恐怕]", school.getOutEnrollList().toString());
        assertEquals("11.11%", school.getEnrollRate());
        assertEquals("80.00%", school.getGapRate());
    }

    @Test //5人正取，1人備取，3人未錄取
    public void schoolEnrollFormTest3() {
        student1.setStuScore(90.4);
        student2.setStuScore(70.2);
        student3.setStuScore(90.6);
        student4.setStuScore(90.8);
        student5.setStuScore(89.2);
        student6.setStuScore(90.1);
        student7.setStuScore(98.1);
        student8.setStuScore(95.1);
        student9.setStuScore(16.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[李紅, 張飛, 贾泽, 王喆, 張三]", school.getEnrollList().toString());
        assertEquals("[小明]", school.getStandbyEnrollList().toString());
        assertEquals("[李四, 赖恬甜, 王恐怕]", school.getOutEnrollList().toString());
        assertEquals("55.56%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //4人正取，0人備取，5人未錄取
    public void schoolEnrollFormTest4() {
        student1.setStuScore(80.4);
        student2.setStuScore(70.2);
        student3.setStuScore(80.6);
        student4.setStuScore(90.8);
        student5.setStuScore(89.2);
        student6.setStuScore(90.1);
        student7.setStuScore(98.1);
        student8.setStuScore(95.1);
        student9.setStuScore(16.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[李紅, 張飛, 贾泽, 小明]", school.getEnrollList().toString());
        assertEquals("[]", school.getStandbyEnrollList().toString());
        assertEquals("[李四, 王喆, 張三, 赖恬甜, 王恐怕]", school.getOutEnrollList().toString());
        assertEquals("44.44%", school.getEnrollRate());
        assertEquals("20.00%", school.getGapRate());
    }

    @Test //3人正取，0人備取，6人未錄取
    public void schoolEnrollFormTest5() {
        student1.setStuScore(94.4);
        student2.setStuScore(90.8);
        student3.setStuScore(92.3);
        student4.setStuScore(90.8);
        student5.setStuScore(90.4);
        student6.setStuScore(90.0);
        student7.setStuScore(90.3);
        student8.setStuScore(90.2);
        student9.setStuScore(90.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[張三, 王喆, 赖恬甜, 贾泽, 李四]", school.getEnrollList().toString());
        assertEquals("[李紅, 張飛, 王恐怕, 小明]", school.getStandbyEnrollList().toString());
        assertEquals("[]", school.getOutEnrollList().toString());
        assertEquals("55.56%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //5人正取，4人備取，0人未錄取
    public void schoolEnrollFormTest6() {
        student1.setStuScore(94.4);
        student2.setStuScore(90.8);
        student3.setStuScore(92.3);
        student4.setStuScore(90.8);
        student5.setStuScore(90.4);
        student6.setStuScore(90.0);
        student7.setStuScore(90.3);
        student8.setStuScore(90.2);
        student9.setStuScore(90.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[張三, 王喆, 赖恬甜, 贾泽, 李四]", school.getEnrollList().toString());
        assertEquals("[李紅, 張飛, 王恐怕, 小明]", school.getStandbyEnrollList().toString());
        assertEquals("[]", school.getOutEnrollList().toString());
        assertEquals("55.56%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //5人正取，3人備取，1人未錄取
    public void schoolEnrollFormTest7() {
        student1.setStuScore(94.4);
        student2.setStuScore(90.8);
        student3.setStuScore(92.3);
        student4.setStuScore(93.8);
        student5.setStuScore(95.4);
        student6.setStuScore(97.0);
        student7.setStuScore(93.3);
        student8.setStuScore(90.2);
        student9.setStuScore(88.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[小明, 李四, 張三, 贾泽, 李紅]", school.getEnrollList().toString());
        assertEquals("[王喆, 赖恬甜, 張飛]", school.getStandbyEnrollList().toString());
        assertEquals("[王恐怕]", school.getOutEnrollList().toString());
        assertEquals("55.56%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //5人正取，2人備取，2人未錄取
    public void schoolEnrollFormTest8() {
        student1.setStuScore(88);
        student2.setStuScore(98);
        student3.setStuScore(97);
        student4.setStuScore(96);
        student5.setStuScore(94);
        student6.setStuScore(95);
        student7.setStuScore(91);
        student8.setStuScore(92);
        student9.setStuScore(88);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[赖恬甜, 王喆, 贾泽, 小明, 李四]", school.getEnrollList().toString());
        assertEquals("[張飛, 李紅]", school.getStandbyEnrollList().toString());
        assertEquals("[張三, 王恐怕]", school.getOutEnrollList().toString());
        assertEquals("55.56%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //4人正取，0人備取，5人未錄取
    public void schoolEnrollFormTest9() {
        student1.setStuScore(80.4);
        student2.setStuScore(70.2);
        student3.setStuScore(80.6);
        student4.setStuScore(90.8);
        student5.setStuScore(89.2);
        student6.setStuScore(90.1);
        student7.setStuScore(98.1);
        student8.setStuScore(90.1);
        student9.setStuScore(16.1);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[李紅, 贾泽, 小明, 張飛]", school.getEnrollList().toString());
        assertEquals("[]", school.getStandbyEnrollList().toString());
        assertEquals("[李四, 王喆, 張三, 赖恬甜, 王恐怕]", school.getOutEnrollList().toString());
        assertEquals("44.44%", school.getEnrollRate());
        assertEquals("20.00%", school.getGapRate());
    }

    @Test //6人录取 3人备取
    public void schoolEnrollFormTest10() {
        student1.setStuScore(90.4);
        student2.setStuScore(90.2);
        student3.setStuScore(90.4);
        student4.setStuScore(91.1);
        student5.setStuScore(95.3);
        student6.setStuScore(93.1);
        student7.setStuScore(98.1);
        student8.setStuScore(91.1);
        student9.setStuScore(92.2);
        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[李紅, 李四, 小明, 王恐怕, 贾泽, 張飛]", school.getEnrollList().toString());
        assertEquals("[張三, 王喆, 赖恬甜]", school.getStandbyEnrollList().toString());
        assertEquals("[]", school.getOutEnrollList().toString());
        assertEquals("66.67%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //5人录取 5人备取
    public void schoolEnrollFormTest11() {
        student1.setStuScore(90.2);
        student2.setStuScore(90.2);
        student3.setStuScore(93);
        student4.setStuScore(98);
        student5.setStuScore(96);
        student6.setStuScore(93.1);
        student7.setStuScore(92);
        student8.setStuScore(91.1);
        student9.setStuScore(94);
        student10.setStuScore(92.2);
        student11.setStuScore(90);
        apps = new ApplicationForm[]{app, app, app,
                app, app, app,
                app, app, app,app};

       students = new Student[]{student1, student2, student3,
                student4, student5, student6,
                student7, student8, student9, student10};

        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[贾泽, 李四, 王恐怕, 小明, 王喆]", school.getEnrollList().toString());
        assertEquals("[王紅飛, 李紅, 張飛, 張三, 赖恬甜]", school.getStandbyEnrollList().toString());
        assertEquals("[]", school.getOutEnrollList().toString());
        assertEquals("50.00%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }

    @Test //5人录取 5人备取 1人无
    public void schoolEnrollFormTest12() {
        student1.setStuScore(90.2);
        student2.setStuScore(90.2);
        student3.setStuScore(93);
        student4.setStuScore(98);
        student5.setStuScore(96);
        student6.setStuScore(93.1);
        student7.setStuScore(92);
        student8.setStuScore(91.1);
        student9.setStuScore(94);
        student10.setStuScore(92.2);
        student11.setStuScore(90);
        apps = new ApplicationForm[]{app, app, app,
                app, app, app,app,
                app, app, app,app};

        students = new Student[]{student2, student1, student3,
                student4, student5, student6,
                student7, student8, student9, student10,student11};

        schoolEnrollForm.schoolEnrollRule(students, apps);

        assertEquals("[贾泽, 李四, 王恐怕, 小明, 王喆]", school.getEnrollList().toString());
        assertEquals("[王紅飛, 李紅, 張飛, 張三, 赖恬甜]", school.getStandbyEnrollList().toString());
        assertEquals("[王紅]", school.getOutEnrollList().toString());
        assertEquals("45.45%", school.getEnrollRate());
        assertEquals("0.00%", school.getGapRate());
    }
}
