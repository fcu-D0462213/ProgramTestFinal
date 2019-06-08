package enrollsystem;

/*
 * 學生class
 * 包含學生姓名和成績
 * 重寫TreeSet比較
 * */
public class Student implements Comparable {
  private String stuName;// 學生姓名
  private double stuStore;// 學生成績
  private String stuId;// student ID

  public Student(String stuId, String stuName, double stuStore) {
    this.stuId = stuId;
    this.stuName = stuName;
    this.stuStore = stuStore;

  }

  public String getStuId() {
    return stuId;
  }

  public String getStuName() {
    return stuName;
  }

  public double getStuStore() {
    return stuStore;
  }

  // 重寫比較 升序排列
  @Override
  public int compareTo(Object o) {
    Student student = (Student) o;
    if (this.getStuStore() >= student.getStuStore()) {
      return -1;
    } else {
      return 1;
    }
  }

  @Override
  public boolean equals(Object o) {
    Student student = (Student) o;
    return this.getStuStore() >= student.getStuStore();

  }

}
