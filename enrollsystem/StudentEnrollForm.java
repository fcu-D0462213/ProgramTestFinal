package enrollsystem;

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
                for (School school : schoolEnrollForm.schools) {
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

    public String schoolEnrollFormOutput() {

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
}
