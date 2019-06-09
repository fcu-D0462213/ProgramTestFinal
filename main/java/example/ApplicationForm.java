package main.java.example;

/*
 * 當前設定為：學生的申請表
 * */
public class ApplicationForm {
    private String[] choosedSchoolName = new String[4];// 學生填報的學校列表
    private String[] schoolState = new String[4];
    private int numOfApp;

    public ApplicationForm(String[] choosedSchoolName) {
        for (int i = 0; i < choosedSchoolName.length; i++) {
            this.choosedSchoolName[i] = choosedSchoolName[i];
        }
        numOfApp = choosedSchoolName.length;
    }

    public int getNumOfApp() {
        return numOfApp;
    }

    public String getChoosedSchoolName(int i) {
        return choosedSchoolName[i];
    }

    public void setSchoolState(int i, String schoolState) {
        this.schoolState[i] = schoolState;
    }

    public String getSchoolState(int i) {
        return schoolState[i];
    }
}
