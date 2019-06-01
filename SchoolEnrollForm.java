/*
* 學校的錄取規則
* */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class SchoolEnrollForm {
    School school;
    TreeSet<Student> studentsList = new TreeSet<Student>();
    ArrayList<School> schools = new ArrayList<>();

    public void setSchool(School school) {
        this.school = school;
    }

    //加入超過最低分數線的學生,并排序
    public void schoolEnrollRule(Student[] student){
        for (int i = 0; i < student.length ; i++) {
            if (student[i].getStuStore() >= this.school.getMinEnrollScore()){
                studentsList.add(student[i]);
            }
        }
    }

    //使用StringBuffer輸出
    public StringBuffer schoolEnrollFormOutput(){
        Iterator<Student> iterator = studentsList.iterator();
        StringBuffer finalForm =new StringBuffer();
        int tempSize = 1;
        while (iterator.hasNext()){
            Student student = iterator.next();
            if (tempSize <= school.getEnrollNum()){
                finalForm.append("正取學生"+tempSize+":"+student.getStuName()+" ");
                //System.out.println("正取學生"+tempSize+":"+student.getStuName());
                tempSize++;
            }else if (tempSize>school.getEnrollNum()&&tempSize<=school.getTotalEnrollNumber()){
                finalForm.append("備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName()+" ");
                //System.out.println("備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName());
                tempSize++;
            }else {
                break;
            }
        }
        return finalForm;
    }

    //使用String輸出
    public String schoolEnrollFormOutput2(){
        Iterator<Student> iterator = studentsList.iterator();
        String finalForm2= "";
        int tempSize = 1;
        while (iterator.hasNext()){
            Student student = iterator.next();
            if (tempSize <= school.getEnrollNum()){
                finalForm2 = finalForm2+"正取學生"+tempSize+":"+student.getStuName()+" ";
                //System.out.println("正取學生"+tempSize+":"+student.getStuName());
                tempSize++;
            }else if (tempSize>school.getEnrollNum()&&tempSize<=school.getTotalEnrollNumber()){
                finalForm2 = finalForm2+"備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName()+" ";
                //System.out.println("備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName());
                tempSize++;
            }else {
                break;
            }
        }
        return finalForm2;
    }

    /*public static void main(String[] args) {
        School school1 = new School("逢甲大學",5,3,85);
        School school2 = new School("台灣大學",4,4,95);
        School school3 = new School("中原大學",2,3,82);
        School school4 = new School("清華大學",4,2,93);
        School school5 = new School("成功大學",3,3,94);
        SchoolEnrollForm schoolEnrollForm = new SchoolEnrollForm(school1);
        //SchoolEnrollForm schoolEnrollForm = new SchoolEnrollForm(new School[]{school1,school2});
        System.out.println(schoolEnrollForm.getSchool());
        System.out.println(schoolEnrollForm.getSchools());
    }*/
}

