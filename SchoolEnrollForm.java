/*
* 學校的錄取規則
* */
import java.util.ArrayList;
import java.util.Iterator;

public class SchoolEnrollForm {
    ArrayList<School> schools = new ArrayList<>();//所有學校的名單

    //每個學校加入超過最低分數線的學生,并排序
    public void schoolEnrollRule(School school,Student[] student){
        for (int i = 0; i < student.length ; i++) {
            if (student[i].getStuStore() >= school.getMinEnrollScore()){
                school.studentsList.add(student[i]);
            }
        }
    }

    //使用StringBuffer輸出
    public StringBuffer schoolEnrollFormOutput(School school){

        Iterator<Student> iterator = school.studentsList.iterator();
        StringBuffer finalForm =new StringBuffer();
        int tempSize = 1;

        while (iterator.hasNext()){
            Student student = iterator.next();
            if (tempSize <= school.getEnrollNum()){
                finalForm.append("正取學生"+tempSize+":"+student.getStuName()+"\n");
                //System.out.println("正取學生"+tempSize+":"+student.getStuName());
                tempSize++;
            }else if (tempSize>school.getEnrollNum()&&tempSize<=school.getTotalEnrollNumber()){
                finalForm.append("備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName()+"\n");
                //System.out.println("備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName());
                tempSize++;
            }else {
                break;
            }
        }
        return finalForm;
    }

    //使用String輸出
    public String schoolEnrollFormOutput2(School school){

        Iterator<Student> iterator = school.studentsList.iterator();
        String finalForm2= "";
        int tempSize = 1;

        while (iterator.hasNext()){
            Student student = iterator.next();
            if (tempSize <= school.getEnrollNum()){
                finalForm2 = finalForm2 + "正取學生"+tempSize+":"+student.getStuName()+"\n";
                //System.out.println("正取學生"+tempSize+":"+student.getStuName());
                tempSize++;
            }else if (tempSize>school.getEnrollNum()&&tempSize<=school.getTotalEnrollNumber()){
                finalForm2 = finalForm2 + "備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName()+"\n";
                //System.out.println("備取學生"+(tempSize-school.getEnrollNum())+":"+student.getStuName());
                tempSize++;
            }else {
                break;
            }
        }
        return finalForm2;
    }

}

