public class Student implements Comparable{
    private String stuName;
    private double stuStore;

    public Student(String stuName, double stuStore) {
        this.stuName = stuName;
        this.stuStore = stuStore;
    }

    public String getStuName() {
        return stuName;
    }

    public double getStuStore() {
        return stuStore;
    }

    //重寫比較 升序排列
    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        if (this.getStuStore() > student.getStuStore()){
            return 1;
        }else if (this.getStuStore() == student.getStuStore()){
            return 0;
        }else {
            return -1;
        }
    }
}
