/*
 * 當前設定為：學生的申請表
 * */
public class applicationForm {
    public String[] choosedSchoolName = new String[4];// 學生填報的學校列表
    private int numOfApp;

    public applicationForm(String[] choosedSchoolName) {
        for (int i = 0; i < choosedSchoolName.length; i++) {
            this.choosedSchoolName[i] = choosedSchoolName[i];
        }
        numOfApp = choosedSchoolName.length;
    }

    public int getNumOfApp() {
        return numOfApp;
    }

//    public String[] getChoosedSchoolName() {
//        return choosedSchoolName;
//    }

}
