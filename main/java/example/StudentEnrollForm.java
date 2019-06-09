package main.java.example;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 學生所得到的表單
 * */
public class StudentEnrollForm {
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<ApplicationForm> applicationList = new ArrayList<>();

    public int setStudentStateEnroll(Iterator<Student> enrollIter, ApplicationForm app, Student stu, int i) {
        int flag = 0;
        int tempSize = 1;
        while (enrollIter.hasNext()) {
            Student student = enrollIter.next();
            if (Integer.valueOf(student.getStuId()).equals(Integer.valueOf(stu.getStuId()))) {
                app.setSchoolState(i, "正取" + tempSize);
                flag = 1;
                break;
            }
            tempSize++;
        }
        return flag;
    }

    public void setStudentStateStandby(Iterator<Student> standbyIter, ApplicationForm app, Student stu, int i) {
        int tempSize = 1;
        while (standbyIter.hasNext()) {
            Student student = standbyIter.next();
            if (Integer.valueOf(student.getStuId()).equals(Integer.valueOf(stu.getStuId()))) {
                app.setSchoolState(i, "備取" + tempSize);
            }
            tempSize++;
        }
    }

    public void setStudentStateOutEnroll(Iterator<Student> outIter, ApplicationForm app, Student stu, int i) {
        while (outIter.hasNext()) {
            Student student = outIter.next();
            if (Integer.valueOf(student.getStuId()).equals(Integer.valueOf(stu.getStuId()))) {
                app.setSchoolState(i, "未錄取");
            }
        }
    }


    public void studentEnrollFormRule(Student[] stu, ApplicationForm[] app, SchoolEnrollForm schoolEnrollForm) {
        //第k個學生
        for (int k = 0; k < stu.length; k++) {
            studentList.add(stu[k]);
            applicationList.add(app[k]);
            int flag = 0;

            //历遍第k個學生的志願里的每个学校i
            for (int i = 0; i < app[k].getNumOfApp(); i++) {
                for (School school : schoolEnrollForm.getSchool()) {
                    if (school.getSchoolName().equals(app[k].getChoosedSchoolName(i))) {
                        Iterator<Student> enrollIter = school.enrollList.iterator();
                        Iterator<Student> standbyIter = school.standbyEnrollList.iterator();
                        Iterator<Student> outIter = school.outEnrollList.iterator();

                        if (flag == 1) {//已经正取 则之后的学校状态都为----
                            app[k].setSchoolState(i, "----");
                            break;
                        }
                        flag = setStudentStateEnroll(enrollIter, app[k], stu[k], i);
                        setStudentStateStandby(standbyIter, app[k], stu[k], i);
                        setStudentStateOutEnroll(outIter, app[k], stu[k], i);
                    }
                }
            }
        }
    }

    public String studentEnrollFormOutput() {
        StringBuilder stuFinalForm = new StringBuilder();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            ApplicationForm application = applicationList.get(i);
            stuFinalForm.append(student.getStuId()).append(" ").append(student.getStuName()).append("\n");
            for (int j = 0; j < application.getNumOfApp(); j++) {
                stuFinalForm.append(application.getChoosedSchoolName(j)).append(" ").
                        append(application.getSchoolState(j)).append("\n");
            }
            stuFinalForm.append("\n");
        }
        return stuFinalForm.toString();
    }
    /*public static void main(String[] args) {
        Student student1 = new Student("160001", "張三", 100);
        Student student2 = new Student("160002", "赖恬甜", 100);
        Student student3 = new Student("160003", "王喆", 99);
        Student student4 = new Student("160004", "贾泽", 99);
        Student student5 = new Student("160005", "李四", 97);
        Student student6 = new Student("160006", "小明", 96);
        Student student7 = new Student("160007", "李紅", 96);
        Student student8 = new Student("160008", "張飛", 94);
        Student student9 = new Student("160009", "王恐怕", 93);
        Student student10 = new Student("160010", "张天文", 92);
        Student student11 = new Student("160011", "李丹丹", 91);
        Student student12 = new Student("160012", "王某某", 90);
        Student student13 = new Student("160013", "宋晓锋", 89);
        Student student14 = new Student("160014", "赵传家", 88);
        Student student15 = new Student("160015", "李世石", 87);
        Student student16 = new Student("160016", "王宝平", 86);
        Student student17 = new Student("160017", "丁页如", 85);
        Student student18 = new Student("160018", "萧枸", 83);

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
        schoolEnrollForm.setSchool(school1);
        schoolEnrollForm.setSchool(school2);
        schoolEnrollForm.setSchool(school3);
        schoolEnrollForm.setSchool(school4);
        schoolEnrollForm.setSchool(school5);
        schoolEnrollForm.setSchool(school6);
        schoolEnrollForm.setSchool(school7);
        schoolEnrollForm.setSchool(school8);
        schoolEnrollForm.setSchool(school9);
        schoolEnrollForm.setSchool(school10);
        schoolEnrollForm.setSchool(school11);

        ApplicationForm app1 = new ApplicationForm(new String[] { "台灣大學", "清華大學"});
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
        studentEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm);//學生錄取信息
        Logger log = Logger.getLogger("lavasoft");
        log.setLevel(Level.INFO);

        log.info(studentEnrollForm.studentEnrollFormOutput());//印出學生的榜單
        log.info(schoolEnrollForm.schoolEnrollFormOutput());// 印出學校榜單
    }*/
}
