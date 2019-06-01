/*
* 學校class
* 包含學校名稱，學校錄取人數，備取人數，最低分數線
*
* */
public class School {
    private String schoolName;
    private int enrollNum;
    private int standbyEnrollNum;
    private double minEnrollScore;
    private int totalEnrollNumber;
    SchoolEnrollForm schoolEnrollForm;

    public School(String schoolName, int enrollNum, int standbyEnrollNum, double minEnrollScore) {
        this.schoolName = schoolName;
        this.enrollNum = enrollNum;
        this.standbyEnrollNum = standbyEnrollNum;
        this.minEnrollScore = minEnrollScore;
    }

    public void setSchoolEnrollForm(SchoolEnrollForm schoolEnrollForm) {
        this.schoolEnrollForm = schoolEnrollForm;
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
        return this.getStandbyEnrollNum()+this.getEnrollNum();
    }
}
