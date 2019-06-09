package main.java.example;
/*
 * 學校的錄取規則
 * */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SchoolEnrollForm {
    private List<School> schools = new ArrayList<>();// 所有學校的名單

    public void setSchool(School school) {
        this.schools.add(school);
    }

    public List<School> getSchool() {
        return schools;
    }

    // 每個學校加入所有并排序
    public void schoolEnrollRule(Student[] student, ApplicationForm[] appForm) {
        for (School school : schools) {
            for (int i = 0; i < student.length; i++) {
                for (int j = 0; j < appForm[i].getNumOfApp(); j++) {
                    if (appForm[i].getChoosedSchoolName(j).equals(school.getSchoolName())) {
                        school.addStuNum();
                        school.studentsList.add(student[i]);
                    }
                }
            }
            school.setSchoolStuList();
        }
    }

    // 使用String輸出
    public String schoolEnrollFormOutput() {
        int tempSize;
        int order;
        StringBuilder finalForm2 = new StringBuilder();
        for (School school : schools) {
            Iterator<Student> enrollIter = school.enrollList.iterator();
            Iterator<Student> standbyIter = school.standbyEnrollList.iterator();
            Iterator<Student> outIter = school.outEnrollList.iterator();
            finalForm2.append(school.getSchoolName()).
                    append(" (正取名額:").
                    append(school.getEnrollNum()).
                    append(" 備取名額:").
                    append(school.getStandbyEnrollNum()).
                    append(" 報名人數:").
                    append(school.getTotalStuNum()).
                    append(")").
                    append(" 錄取名單：\n");

            tempSize = 0;
            while (enrollIter.hasNext()) {
                Student student = enrollIter.next();
                order = tempSize + 1;
                finalForm2.append("正取學生").append(order).append(":").append(student.getStuName()).append("\n");
                tempSize++;
            }

            tempSize = 0;
            while (standbyIter.hasNext()) {
                Student student = standbyIter.next();
                order = tempSize + 1;
                finalForm2.append("備取學生").append(order).append(":").append(student.getStuName()).append("\n");
                tempSize++;
            }

            while (outIter.hasNext()) {
                Student student = outIter.next();
                finalForm2.append("未錄取學生").append(":").append(student.getStuName()).append("\n");
            }
            finalForm2.append("錄取率:").append(school.getEnrollRate()).append(" 缺額率：").append(school.getGapRate()).append("\n\n");
        }
        return finalForm2.toString();
    }

}
