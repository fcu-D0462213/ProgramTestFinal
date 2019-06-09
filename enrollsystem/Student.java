package enrollsystem;

/*
 * 學生class
 * 包含學生姓名和成績
 * 重寫TreeSet比較
 * */
public class Student implements Comparable {
  private String stuName;// 學生姓名
  private double stuScore;// 學生成績
  private String stuId;// student ID

  public Student(String stuId, String stuName, double stuScore) {
    this.stuId = stuId;
    this.stuName = stuName;
    this.stuScore = stuScore;

  }

  public String getStuId() {
    return stuId;
  }

  public String getStuName() {
    return stuName;
  }

  public double getStuScore() {
    return stuScore;
  }

  // 重寫比較 升序排列
  @Override
  public int compareTo(Object o) {
    Student student = (Student) o;
    if (this.getStuScore() > student.getStuScore()) {
      return -1;
      // 同分按照id排序 小到大
    } else if (this.getStuScore() == student.getStuScore() && this.getStuId().compareTo(student.getStuId()) < 0) {
      return -1;
    } else {
      return 1;
    }
  }

  // @Override
  // public boolean equals(Object o) {
  // if (o == null)
  // return false;
  //
  // if (o == this)
  // return true;
  //
  // if (this.getClass() != o.getClass())
  // return false;
  //
  // if (o instanceof Student) {
  // Student student = (Student) o;
  // return student.stuId == this.stuId
  // && Double.doubleToLongBits(student.stuScore) ==
  // Double.doubleToLongBits(this.stuScore)
  // && student.stuName == this.stuName;
  // }
  // return false;
  //
  // }
  //
  // @Override
  // public int hashCode() {
  // int hash = 17;
  // hash = hash * 31 + stuName.hashCode();
  // return hash;
  // }

}
