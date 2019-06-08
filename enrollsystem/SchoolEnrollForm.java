package enrollsystem;
/*
 * 學校的錄取規則
 * */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class SchoolEnrollForm {
  ArrayList<School> schools = new ArrayList<>();// 所有學校的名單

  // 每個學校加入超過最低分數線的學生,并排序
  public void schoolEnrollRule(Student[] student, ApplicationForm[] appForm) {
    Iterator<School> iteSchool = schools.iterator();
    while (iteSchool.hasNext()) {
      School school = iteSchool.next();
      for (int i = 0; i < student.length; i++) {
        for (int j = 0; j < appForm[i].getNumOfApp(); j++) {
          if (appForm[i].getChoosedSchoolName(j).equals(school.getSchoolName())) {
            school.addStuNum();
            if (student[i].getStuScore() >= school.getMinEnrollScore()) {
              school.studentsList.add(student[i]);
            }
          }
        }
      }
    }
  }

  // 使用String輸出
  public String schoolEnrollFormOutput2() {
    StringBuilder finalForm2 = new StringBuilder();
    Iterator<School> iteSchool = schools.iterator();
    int trulyEnrollNumber = 0;
    while (iteSchool.hasNext()) {
      School school = iteSchool.next();
      Iterator<Student> iterator = school.studentsList.iterator();
      finalForm2.append(school.getSchoolName());
      finalForm2.append(" 錄取名單：\n");
      int tempSize = 1;

      if (school.studentsList.size() >= school.getEnrollNum()) {
        trulyEnrollNumber = school.getEnrollNum();
      } else {
        trulyEnrollNumber = school.studentsList.size();
      }

      while (iterator.hasNext()) {
        Student student = iterator.next();
        if (tempSize <= school.getEnrollNum()) {
          finalForm2.append("正取學生" + tempSize + ":" + student.getStuName() + "\n");
          tempSize++;
        } else if (tempSize > school.getEnrollNum() && tempSize <= school.getTotalEnrollNumber()) {
          finalForm2.append("備取學生" + (tempSize - school.getEnrollNum()) + ":" + student.getStuName() + "\n");
          tempSize++;
        } else {
          break;
        }
      }

      String enrollRateFormat = "0.00";
      DecimalFormat df = new DecimalFormat(enrollRateFormat);
      float enrollRate = (float) (tempSize - 1) * 100 / school.getTotalStuNum();
      float gapRate = (float) (school.getEnrollNum() - trulyEnrollNumber) / (float) school.getEnrollNum() * 100;
      finalForm2.append("錄取率:" + df.format(enrollRate) + "%" + " 缺額率：" + df.format(gapRate) + "%" + "\n\n");
    }

    return finalForm2.toString();
  }

}
