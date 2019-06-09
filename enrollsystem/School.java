package enrollsystem;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * 學校class
 * 包含學校名稱，學校錄取人數，備取人數，最低分數線
 *
 * */
public class School {
  private String schoolName;// 學校名字
  private int enrollNum;// 錄取人數
  private int standbyEnrollNum;// 備取人數
  private double minEnrollScore;// 最低錄取分數線
  private int totalStuNum = 0;// 报名人数
  TreeSet<Student> studentsList = new TreeSet<>();// 每個學校的報考學生列表
  TreeSet<Student> enrollList = new TreeSet<>();// 每個學校的录取學生列表
  TreeSet<Student> standbyEnrollList = new TreeSet<>();// 每個學校的备取學生列表
  TreeSet<Student> outEnrollList = new TreeSet<>();// 每個學校的未录取學生列表

  public School(String schoolName, int enrollNum, int standbyEnrollNum, double minEnrollScore) {
    this.schoolName = schoolName;
    this.enrollNum = enrollNum;
    this.standbyEnrollNum = standbyEnrollNum;
    this.minEnrollScore = minEnrollScore;
  }

  public void setSchoolStuList() {
    Iterator<Student> stuIte = studentsList.iterator();
    Student stu;
    double enrollMinScore = 0;
    double standbyMinScore = 0;
    for (int i = 0; i < enrollNum; i++) {
      if (stuIte.hasNext()) {
        stu = stuIte.next();
        if (stu.getStuScore() >= this.minEnrollScore)
          enrollList.add(stu);
        else
          outEnrollList.add(stu);
        enrollMinScore = stu.getStuScore();
      }
    }

    for (int i = 0; i < standbyEnrollNum; i++) {
      if (stuIte.hasNext()) {
        stu = stuIte.next();
        // 檢測正取同分
        while (stu.getStuScore() == enrollMinScore) {
          enrollList.add(stu);
          enrollNum++;
          stu = stuIte.next();
        }
        if (stu.getStuScore() >= this.minEnrollScore)
          standbyEnrollList.add(stu);
        else
          outEnrollList.add(stu);
        standbyMinScore = stu.getStuScore();
      }
    }
    for (int i = 0; i < totalStuNum - enrollNum - standbyEnrollNum; i++) {
      if (stuIte.hasNext()) {
        stu = stuIte.next();
        // 檢測正取同分
        while (stu.getStuScore() == enrollMinScore) {
          enrollList.add(stu);
          enrollNum++;
          stu = stuIte.next();
        }
        // 檢測備取同分
        while (stu.getStuScore() == standbyMinScore) {
          standbyEnrollList.add(stu);
          standbyEnrollNum++;
          stu = stuIte.next();
        }
        outEnrollList.add(stu);
      }
    }
  }

  public String getSchoolName() {
    return schoolName;
  }

  public int getEnrollNum() {
    return enrollNum;
  }

  public int getStandbyEnrollNum() {
    return standbyEnrollNum;
  }

  public int getTotalStuNum() {
    return totalStuNum;
  }

  public void addStuNum() {
    this.totalStuNum++;
  }

}