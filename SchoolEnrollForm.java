import java.util.Iterator;
import java.util.TreeSet;

public class SchoolEnrollForm {
    School school;
    TreeSet<Student> studentsList = new TreeSet<Student>();
    Iterator<Student> iterator = studentsList.iterator();
    public void schoolEnrollRule(Student[] student){
        for (int i = 0; i < student.length ; i++) {
            if (student[i].getStuStore() >= school.getMinEnrollScore()){
                studentsList.add(student[i]);
            }
        }
    }
    public void schoolEnrollFormOutput(){
        while (iterator.hasNext()){
            int tempSize = 1;
            Student student = iterator.next();
            if (tempSize <= school.getEnrollNum()){
                System.out.println("爭取學生"+tempSize+":"+student.getStuName());
                tempSize++;
            }else if (tempSize>school.getEnrollNum()&&tempSize<=school.getTotalEnrollNumber()){
                System.out.println("備取學生"+tempSize+":"+student.getStuName());
                tempSize++;
            }else {
                break;
            }
        }
    }
}

