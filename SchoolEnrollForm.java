/*
* 學校的錄取規則
* */
import java.util.Iterator;
import java.util.TreeSet;

public class SchoolEnrollForm {
    School school;
    TreeSet<Student> studentsList = new TreeSet<Student>();

    public SchoolEnrollForm(School school) {
        this.school = school;
    }

    //加入學生
    public void schoolEnrollRule(Student[] student){
        for (int i = 0; i < student.length ; i++) {
            if (student[i].getStuStore() >= school.getMinEnrollScore()){
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
}

