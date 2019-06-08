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
  TreeSet<Student> studentsList = new TreeSet<Student>();// 每個學校的報考學生列表

  public School(String schoolName, int enrollNum, int standbyEnrollNum, double minEnrollScore) {
    this.schoolName = schoolName;
    this.enrollNum = enrollNum;
    this.standbyEnrollNum = standbyEnrollNum;
    this.minEnrollScore = minEnrollScore;
  }

  public TreeSet<Student> getStudentsList() {
    return studentsList;
  }

  public void setStudentsList(TreeSet<Student> studentsList) {
    this.studentsList = studentsList;
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

  public double getMinEnrollScore() {
    return minEnrollScore;
  }

  public int getTotalEnrollNumber() {
    return this.getStandbyEnrollNum() + this.getEnrollNum();
  }

  public int getTotalStuNum() {
    return totalStuNum;
  }

  public void setTotalStuNum(int totalStuNum) {
    this.totalStuNum = totalStuNum;
  }

  public void addStuNum() {
    this.totalStuNum++;
  }

}
