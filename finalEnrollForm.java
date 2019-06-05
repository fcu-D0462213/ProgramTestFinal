import java.util.Iterator;

/*
 * 學生所得到的表單
 * 可以考慮增加使用StringBuffer輸出
 * */
public class finalEnrollForm {
    public String studentEnrollFormRule(Student student, applicationForm applicationForm, SchoolEnrollForm schoolEnrollForm) {
        applicationForm.setStudent(student);
        String stuFinalForm = student.getStuName()+"同學："+"\n";
        //找尋學校名單中的學生姓名
        for (int i = 0; i < applicationForm.getChoosedSchoolName().length; i++) {
            for (int j = 0; j < schoolEnrollForm.schools.size(); j++) {
                int tempSize = 1;
                                                                /*              學校List                       */
                if (applicationForm.choosedSchoolName[i].equals(schoolEnrollForm.schools.get(j).getSchoolName())) {
                    //成績小於錄取線：未錄取
                    if (student.getStuStore() < schoolEnrollForm.schools.get(j).getMinEnrollScore()){
                        stuFinalForm = stuFinalForm + schoolEnrollForm.schools.get(j).getSchoolName() + "未錄取" + "\n";
                    }
                    //使用iterator遍歷
                    Iterator<Student> iterator = schoolEnrollForm.schools.get(j).studentsList.iterator();
                    while (iterator.hasNext()) {
                        Student studentInList = iterator.next();
                        //判斷學生姓名
                        if (studentInList.getStuName().equals(applicationForm.getStudent().getStuName())) {
                            if (tempSize <= schoolEnrollForm.schools.get(j).getEnrollNum()) {
                                stuFinalForm = stuFinalForm + schoolEnrollForm.schools.get(j).getSchoolName() + "正取" + tempSize + "\n";
                            } else if (tempSize > schoolEnrollForm.schools.get(j).getEnrollNum()&&
                                    tempSize <= schoolEnrollForm.schools.get(j).getTotalEnrollNumber()){
                                stuFinalForm = stuFinalForm + schoolEnrollForm.schools.get(j).getSchoolName() + "備取" +
                                        (tempSize - schoolEnrollForm.schools.get(j).getEnrollNum()) + "\n";
                            }else {
                                stuFinalForm = stuFinalForm + schoolEnrollForm.schools.get(j).getSchoolName() + "未錄取" + "\n";
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
        return stuFinalForm;
    }

    /*public static void main(String[] args) {
        Student student1 = new Student("張三",100);
        Student student2 = new Student("李四",90);
        Student student3 = new Student("小明",99);
        Student student4 = new Student("王五",99);
        Student student5 = new Student("小紅",88);
        School school1 = new School("逢甲大學",5,3,90);
        School school2 = new School("台灣大學",4,4,95);
        School school3 = new School("中原大學",2,3,82);
        School school4 = new School("清華大學",4,2,93);
        School school5 = new School("成功大學",3,3,94);
        finalEnrollForm finalEnrollForm = new finalEnrollForm();
        Student[] students = new Student[]{student1, student2, student3, student5, student4};//學生名單

        //創建學校錄取名單物件
        SchoolEnrollForm schoolEnrollForm1 = new SchoolEnrollForm();

        //設立所有學校名單
        schoolEnrollForm1.schools.add(school1);
        schoolEnrollForm1.schools.add(school2);
        schoolEnrollForm1.schools.add(school3);
        schoolEnrollForm1.schools.add(school4);
        schoolEnrollForm1.schools.add(school5);

        schoolEnrollForm1.setSchool(school1);

        school1.setSchoolEnrollForm(schoolEnrollForm1);
        school1.schoolEnrollForm.schoolEnrollRule(students);//調用school中的學校錄取方法

        applicationForm applicationForm = new applicationForm(student1, new String[]{"台灣大學","逢甲大學"});
        System.out.println(finalEnrollForm.studentEnrollFormRule(student1,applicationForm,schoolEnrollForm1));
    }*/
}
