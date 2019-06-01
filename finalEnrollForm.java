import java.util.Iterator;

/*
 * 目前設定為：學生所得到的表單
 * */
public class finalEnrollForm {
    //Student student;
    //applicationForm applicationForm;
    //SchoolEnrollForm schoolEnrollForm;
    String stuFinalForm = "";
    public String studentEnrollFormRule(Student student, applicationForm applicationForm, SchoolEnrollForm schoolEnrollForm) {
        int tempSize = 1;
        applicationForm.setStudent(student);
        //找尋學校名單中的學生姓名
        for (int i = 0; i < applicationForm.getChoosedSchoolName().length; i++) {
            for (int j = 0; j < schoolEnrollForm.schools.size(); j++) {
                if (applicationForm.choosedSchoolName[i].equals(schoolEnrollForm.schools.get(j))) {
                    Iterator<Student> iterator = schoolEnrollForm.studentsList.iterator();
                    while (iterator.hasNext()) {
                        Student studentInList = iterator.next();
                        //判斷學生姓名
                        if (studentInList.getStuName().equals(applicationForm.getStudent().getStuName()) &&
                                tempSize <= schoolEnrollForm.schools.get(j).getTotalEnrollNumber()) {
                            if (tempSize <= schoolEnrollForm.schools.get(j).getEnrollNum()) {
                                stuFinalForm = stuFinalForm + schoolEnrollForm.schools.get(j).getSchoolName() + "正取" + tempSize + " ";
                            } else {
                                stuFinalForm = stuFinalForm + schoolEnrollForm.schools.get(j).getSchoolName() + "備取" +
                                        (tempSize - schoolEnrollForm.schools.get(j).getEnrollNum()) + " ";
                            }
                        } else if (tempSize < schoolEnrollForm.schools.get(j).getTotalEnrollNumber()) {
                            tempSize++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return stuFinalForm;
    }
}
