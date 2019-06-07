
/*
* 當前設定為：學生的申請表
* */
public class applicationForm {
  private Student student;// 學生物件
  public String[] choosedSchoolName = new String[3];// 學生填報的學校列表

  public applicationForm(String[] choosedSchoolName) {
    for (int i = 0; i < 3; i++) {
      this.choosedSchoolName[i] = choosedSchoolName[i];
    }
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public String[] getChoosedSchoolName() {

    return choosedSchoolName;
  }

}
