package enrollsystem;

import java.util.Iterator;

/*
 * 學生所得到的表單
 * */
public class StudentEnrollForm {
  public String studentEnrollFormRule(Student[] stu, ApplicationForm[] app, SchoolEnrollForm schoolEnrollForm) {
    StringBuilder stuFinalForm = new StringBuilder();
    for (int k = 0; k < stu.length; k++) {
      Student student = stu[k];
      ApplicationForm applicationForm = app[k];
      stuFinalForm.append(student.getStuId() + " " + student.getStuName() + "\n");
      // 記錄是否正取
      int flag = 0;
      // 找尋學校名單中的學生姓名
      for (int i = 0; i < applicationForm.getNumOfApp(); i++) {
        for (int j = 0; j < schoolEnrollForm.schools.size(); j++) {
          int tempSize = 1;
          /* 學校List */
          if (applicationForm.getChoosedSchoolName(i).equals(schoolEnrollForm.schools.get(j).getSchoolName())) {
            // 成績小於錄取線：未錄取
            if (student.getStuStore() < schoolEnrollForm.schools.get(j).getMinEnrollScore()) {
              stuFinalForm.append(schoolEnrollForm.schools.get(j).getSchoolName() + " 未錄取" + "\n");
            }
            // 使用iterator遍歷該學校的報名名單
            Iterator<Student> iterator = schoolEnrollForm.schools.get(j).studentsList.iterator();
            while (iterator.hasNext()) {
              Student studentInList = iterator.next();
              // 判斷學生id
              if (studentInList.getStuId().equals(student.getStuId())) {
                if (flag == 0) {
                  if (tempSize <= schoolEnrollForm.schools.get(j).getEnrollNum()) {
                    stuFinalForm.append(schoolEnrollForm.schools.get(j).getSchoolName() + " 正取" + tempSize + "\n");
                    flag = 1;
                  } else if (tempSize > schoolEnrollForm.schools.get(j).getEnrollNum()
                      && tempSize <= schoolEnrollForm.schools.get(j).getTotalEnrollNumber()) {
                    stuFinalForm.append(schoolEnrollForm.schools.get(j).getSchoolName() + " 備取"
                        + (tempSize - schoolEnrollForm.schools.get(j).getEnrollNum()) + "\n");
                  } else {
                    stuFinalForm.append(schoolEnrollForm.schools.get(j).getSchoolName() + " 未錄取" + "\n");
                  }
                } else {
                  stuFinalForm.append(schoolEnrollForm.schools.get(j).getSchoolName() + " ----" + "\n");
                }
              } else if (tempSize <= schoolEnrollForm.schools.get(j).getTotalEnrollNumber()) {
                tempSize++;
              } else {
                break;
              }
            }
          }
        }
      }
      stuFinalForm.append("\n");
    }
    return stuFinalForm.toString();
  }
}
