/*
* 當前設定為：學生的申請表
* */
public class applicationForm {
    private Student student;
    private String choosedSchoolName;

    public applicationForm(Student student, String choosedSchoolName) {
        this.student = student;
        this.choosedSchoolName = choosedSchoolName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getChoosedSchoolName() {
        return choosedSchoolName;
    }

    public void setChoosedSchoolName(String choosedSchoolName) {
        this.choosedSchoolName = choosedSchoolName;
    }
}
