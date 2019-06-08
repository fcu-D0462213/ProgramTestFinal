/*
 * 當前設定為：錄取的操作系統
 *
 * */

public class enrollSystem {
    public void systemRule() {

    }

    public static void main(String[] args) {

        Student student1 = new Student("STU20160001", "張三", 100);
        Student student2 = new Student("STU20160002", "赖恬甜", 100);
        Student student3 = new Student("STU20160003", "王喆", 99);
        Student student4 = new Student("STU20160004", "贾泽", 99);
        Student student5 = new Student("STU20160005", "李四", 97);
        Student student6 = new Student("STU20160006", "小明", 95);
        Student student7 = new Student("STU20160007", "李紅", 94);
        Student student8 = new Student("STU20160008", "張飛", 91);
        Student student9 = new Student("STU20160009", "王恐怕", 89);
        Student student10 = new Student("STU20160010", "张天文", 88);
        Student student11 = new Student("STU20160011", "李丹丹", 87);
        Student student12 = new Student("STU20160012", "王某某", 86);
        Student student13 = new Student("STU20160013", "宋晓锋", 84);
        Student student14 = new Student("STU20160014", "赵传家", 83);
        Student student15 = new Student("STU20160015", "李世石", 81);
        Student student16 = new Student("STU20160016", "王宝平", 81);
        Student student17 = new Student("STU20160017", "丁页如", 80);
        Student student18 = new Student("STU20160018", "萧枸", 80);

        School school1 = new School("台灣大學", 1, 1, 96);
        School school2 = new School("清華大學", 2, 1, 95);
        School school3 = new School("交通大學", 2, 1, 95);
        School school4 = new School("成功大學", 3, 1, 95);
        School school5 = new School("政治大學", 3, 1, 94);
        School school6 = new School("中山大學", 4, 1, 93);
        School school7 = new School("逢甲大學", 5, 3, 90);
        School school8 = new School("中原大學", 5, 3, 92);
        School school9 = new School("中央大學", 5, 3, 92);
        School school10 = new School("中興大學", 6, 3, 92);
        School school11 = new School("科技大學", 6, 3, 91);
        School school12 = new School("嘉義大學", 6, 3, 90);
        School school13 = new School("淡江大學", 6, 3, 88);
        School school14 = new School("東海大學", 6, 3, 86);
        School school15 = new School("長庚大學", 6, 3, 84);
        School school16 = new School("輔仁大學", 7, 3, 82);
        School school17 = new School("靜宜大學", 7, 3, 80);

        Student[] students = new Student[]{student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10,
                student11, student12, student13, student14, student15,
                student16, student17, student18};// 學生名單

        finalEnrollForm finalEnrollForm = new finalEnrollForm();
        // 創建學校錄取名單物件
        SchoolEnrollForm schoolEnrollForm = new SchoolEnrollForm();

        // 設立所有學校名單
        schoolEnrollForm.schools.add(school1);
        schoolEnrollForm.schools.add(school2);
        schoolEnrollForm.schools.add(school3);
        schoolEnrollForm.schools.add(school4);
        schoolEnrollForm.schools.add(school5);
        schoolEnrollForm.schools.add(school6);
        schoolEnrollForm.schools.add(school7);
        schoolEnrollForm.schools.add(school8);
        schoolEnrollForm.schools.add(school9);
        schoolEnrollForm.schools.add(school10);
        schoolEnrollForm.schools.add(school11);
        schoolEnrollForm.schools.add(school12);
        schoolEnrollForm.schools.add(school13);
        schoolEnrollForm.schools.add(school14);
        schoolEnrollForm.schools.add(school15);
        schoolEnrollForm.schools.add(school16);
        schoolEnrollForm.schools.add(school17);

        applicationForm app1 = new applicationForm(new String[]{"台灣大學", "清華大學", "中原大學"});// 創立stu1志願
        applicationForm app2 = new applicationForm(new String[]{"台灣大學", "中山大學", "中原大學"});
        applicationForm app3 = new applicationForm(new String[]{"清華大學", "中山大學", "逢甲大學"});
        applicationForm app4 = new applicationForm(new String[]{"交通大學", "清華大學", "中興大學"});
        applicationForm app5 = new applicationForm(new String[]{"交通大學", "清華大學", "成功大學"});
        applicationForm app6 = new applicationForm(new String[]{"東海大學", "中興大學", "逢甲大學"});
        applicationForm app7 = new applicationForm(new String[]{"交通大學", "清華大學", "東海大學"});
        applicationForm app8 = new applicationForm(new String[]{"靜宜大學", "科技大學", "成功大學"});
        applicationForm app9 = new applicationForm(new String[]{"科技大學", "中山大學", "輔仁大學"});
        applicationForm app10 = new applicationForm(new String[]{"交通大學", "清華大學", "靜宜大學"});
        applicationForm app11 = new applicationForm(new String[]{"科技大學", "輔仁大學", "成功大學"});
        applicationForm app12 = new applicationForm(new String[]{"東海大學", "淡江大學", "長庚大學"});
        applicationForm app13 = new applicationForm(new String[]{"交通大學", "靜宜大學", "淡江大學"});
        applicationForm app14 = new applicationForm(new String[]{"靜宜大學", "嘉義大學", "長庚大學"});
        applicationForm app15 = new applicationForm(new String[]{"輔仁大學", "中山大學", "逢甲大學"});
        applicationForm app16 = new applicationForm(new String[]{"淡江大學", "清華大學", "嘉義大學"});
        applicationForm app17 = new applicationForm(new String[]{"長庚大學", "清華大學", "成功大學"});
        applicationForm app18 = new applicationForm(new String[]{"長庚大學", "靜宜大學", "嘉義大學"});
        applicationForm[] apps = new applicationForm[]{app1, app2, app3, app4, app5,
                app6, app7, app8, app9, app10,
                app11, app12, app13, app14, app15,
                app16, app17, app18};

        schoolEnrollForm.schoolEnrollRule(students, apps);//學校的錄取名單

        System.out.println(finalEnrollForm.studentEnrollFormRule(students, apps, schoolEnrollForm));

        System.out.println(schoolEnrollForm.schoolEnrollFormOutput2());//印出學校榜單
    }

}
