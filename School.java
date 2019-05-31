public class School {
    private String schoolName;
    private int enrollNum;
    private int standbyEnrollNum;
    private double minEnrollScore;
    private int totalEnrollNumber;

    public School(String schoolName, int enrollNum, int standbyEnrollNum, double minEnrollScore) {
        this.schoolName = schoolName;
        this.enrollNum = enrollNum;
        this.standbyEnrollNum = standbyEnrollNum;
        this.minEnrollScore = minEnrollScore;
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
