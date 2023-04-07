package examples;

import riho.SungjukVO;

public class EX09 {
    public static void main(String[] args) {
        //board 테이블에 대응하는 클래스 작성
        Board b = new Board(1,"테스트","abc123","2023-04-07",
                0,"테스트입니다.");
        System.out.println(b);

        // employees, departments 테이블에 대응하는 클래스 작성
        EmployeeVO em = new EmployeeVO(100,"Steven","King","SKING",
                "515.123.4567","2003-06-17","ad_pres",24000,0,0,90);
        System.out.println(em);
        DepartmentsVO de = new DepartmentsVO(10,"administration",200,1700);
        System.out.println(de);

        SungjukVO su = new SungjukVO("이호",80,80,80);
        System.out.println(su);

    }
}

class Board {
    private int bno;
    private String title;
    private String userid;
    private String regdate;
    private int views;
    private String contents;

    public Board() {
    }

    public Board(int bno, String title, String userid, String regdate, int views, String contents) {
        this.bno = bno;
        this.title = title;
        this.userid = userid;
        this.regdate = regdate;
        this.views = views;
        this.contents = contents;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        String fmt = "%d %s %s %s %d %s\n";
        return String.format(fmt,bno,title,userid,regdate,views,contents);
    }

}

class EmployeeVO{
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String hire_date;
    private String job_id;
    private int salary;
    private double commission_pct;
    private int manager_to;
    private int department_id;

    public EmployeeVO() { }

    public EmployeeVO(int employee_id, String first_name, String last_name, String email, String phone_number, String hire_date, String job_id, int salary, double commission_pct, int manager_to, int department_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.job_id = job_id;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_to = manager_to;
        this.department_id = department_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getCommission_pct() {
        return commission_pct;
    }

    public void setCommission_pct(double commission_pct) {
        this.commission_pct = commission_pct;
    }

    public int getManager_to() {
        return manager_to;
    }

    public void setManager_to(int manager_to) {
        this.manager_to = manager_to;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public String toString() {
        String fmt = " %s %s %s %s %s %d %.2f %d %d \n";
        return String.format(fmt,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_to,department_id);
    }
}

class DepartmentsVO{
    private int department_id;
    private String department_name;
    private int manager_id;
    private int location_id;

    public DepartmentsVO(int department_id, String department_name, int manager_id, int location_id) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.manager_id = manager_id;
        this.location_id = location_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        String fmt = "%d %s %d %d\n";
        return String.format(fmt,department_id,department_name,manager_id,location_id);
    }
}