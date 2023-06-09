package riho;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.Scanner;

public class J33JDBC {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        //사원등록
       /* System.out.println("사원등록을 진행합니다.");
        System.out.print("사원 번호??");
        int empno = sc.nextInt();
        System.out.print("이름은?");
        String fname = sc.next();
        System.out.print("성은??");
        String lname = sc.next();
        System.out.print("이메일은??");
        String email = sc.next();
        System.out.print("전화번호??");
        String phone = sc.next();
        System.out.print("입사일??");
        String hdate = sc.next();
        System.out.print("직무 아이디??");
        String jobid = sc.next();
        System.out.print("연봉은???");
        int sal = sc.nextInt();
        System.out.print("커미션은??");
        double comm = sc.nextDouble();
        System.out.print("상사번호???");
        int mgrid = sc.nextInt();
        System.out.print("부서번호???");
        int deptno = sc.nextInt();

        EMPVO emp = new EMPVO(empno,fname,lname,email,phone,hdate,jobid,sal,comm,mgrid,deptno);
        int cnt = EMPDAOImpl.insertEmp(emp);
        if (cnt > 0) System.out.println("사원정보 입력 성공!!");*/

        //사원 조회
        List<EMPVO> empdata = EMPDAOImpl.selectEmp();

        String fmt = "%d %s %s %s %d\n";
        for (EMPVO emp :empdata){
            System.out.printf(fmt,emp.getEmpno(),emp.getFname(),emp.getEmail(),
                    emp.getJobid(),emp.getDeptno() );
        }

        //사원 상세조회
        /*System.out.println("조회할 사원번호는?");
        int empno = sc.nextInt();

        EMPVO emp = EMPDAOImpl.insertOneEmp(empno);
        if (emp!= null) System.out.println(emp);
        else System.out.println("일치하는 번호가 없습니다.");*/

        //사워 수정

        //사원 삭제
        System.out.print("삭제할 사원 번호는? ");
        int empno =sc.nextInt();

        int cnt = EMPDAOImpl.deleteEmp(empno);
        if (cnt > 0) System.out.println("사원정보 삭제 성공!!");

    }
}

class EMPVO{
    private int empno;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String hdate;
    private String jobid;
    private int sal;
    private double comm;
    private int mgrid;
    private int deptno;

    public EMPVO() {
    }

    public EMPVO(int empno, String fname, String lname, String email, String phone, String hdate, String jobid, int sal, double comm, int mgrid, int deptno) {
        this.empno = empno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.hdate = hdate;
        this.jobid = jobid;
        this.sal = sal;
        this.comm = comm;
        this.mgrid = mgrid;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public int getMgrid() {
        return mgrid;
    }

    public void setMgrid(int mgrid) {
        this.mgrid = mgrid;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        String fmt = "%d %s %s %s %s %s %s %d %.2f %d %d";
        return String.format(fmt,empno,fname,lname,email, phone, hdate, jobid,sal, comm,mgrid,deptno);
    }
}

interface EMPDAO{
    int insetEmp(EMPVO emp);
    List<EMPVO> selectEmp();
    EMPVO selectOneEmp(int empno);
    int updateEmp(EMPVO emp);
    int deleteEmp(int empno);
}
class EMPDAOImpl{  //공유객체사용 (static사용)
    private static  String insetEmpSQL = "insert into employees values(?,?,?,?,? ,?,?,?,?,? ,?)";
    private static  String selectEmpSQL =
            " select employee_id, first_name, email, job_id,department_id from employees order by employee_id ";
    private static  String selectOneEmpSQL =
            " select * from employees where employee_id =? ";
    private static  String deleteEmpSQL =
            " delete from employees where employee_id =? ";

    public static int insertEmp(EMPVO emp){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;

        try {
           conn = J34JDBCUtil.makeConn();
           pstmt = conn.prepareStatement(insetEmpSQL);
           pstmt.setInt(1,emp.getDeptno());
           pstmt.setString(2,emp.getFname());
           pstmt.setString(3,emp.getLname());
           pstmt.setString(4,emp.getEmail());
           pstmt.setString(5,emp.getPhone());
           pstmt.setString(6,emp.getHdate());
           pstmt.setString(7,emp.getJobid());
           pstmt.setInt(8,emp.getSal());
           pstmt.setDouble(9,emp.getComm());
            pstmt.setInt(10,emp.getMgrid());
            pstmt.setInt(11,emp.getDeptno());

            cnt = pstmt.executeUpdate();
        } catch (Exception ex){
            System.out.println("insetEmpSQL 오류 발생!!");
            System.out.println(ex.getMessage());
        } finally {
            // static으로 선언된 메서드는 객체 생성 없이 바로 호출가능
            //단, 클래스명.메서드명으로 호출하야 함
            J34JDBCUtil.closeConn(null,pstmt,conn);
        }
        return cnt;}

    public static List<EMPVO> selectEmp(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; //넘어오는 결과 확인
        List<EMPVO> empdata = new ArrayList<>();
        try {
            conn = J34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(selectEmpSQL);//실행할 SQL문 생성
            rs = pstmt.executeQuery();

            while (rs.next()){
                EMPVO emp = new EMPVO(rs.getInt(1),rs.getString(2),"",
                        rs.getString(3),"","",rs.getString(4),0,
                        0.0,0,rs.getInt(5) );
                empdata.add(emp);
            }
        } catch (Exception ex){
            System.out.println("selectEmp에서 오류 발생!!");
            System.out.println(ex.getMessage());
        } finally {
            J34JDBCUtil.closeConn(rs,pstmt,conn);
        }
        return empdata;}


    public static EMPVO insertOneEmp(int empno){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EMPVO emp = null;

        try {
            conn = J34JDBCUtil.makeConn();
            pstmt = conn.prepareStatement(selectOneEmpSQL);
            pstmt.setInt(1,empno);

            rs = pstmt.executeQuery();

            if (rs.next()){
                emp = new EMPVO(rs.getInt(1),rs.getString(2),rs.getString(3)
                        ,rs.getString(4),rs.getString(5),rs.getString(6)
                        ,rs.getString(7),rs.getInt(8),rs.getDouble(9)
                        ,rs.getInt(10),rs.getInt(11));

            }
        } catch (Exception ex){
            System.out.println("insertOneEmpdp에서 오류 발생!!");
            System.out.println(ex.getMessage());
        } finally {
            J34JDBCUtil.closeConn(rs,pstmt,conn);
        }
        return emp;}


    public static int updateOneEmp(EMPVO emp){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {

        } catch (Exception ex){
            System.out.println("updateOneEmp 오류 발생!!");
            System.out.println(ex.getMessage());
        } finally {

        }
        return 0;}
    public static int deleteEmp(int empno){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int cnt = 0;

        try {
           conn = J34JDBCUtil.makeConn();
           pstmt = conn.prepareStatement(deleteEmpSQL);
           pstmt.setInt(1,empno);

           cnt = pstmt.executeUpdate();

        } catch (Exception ex){
            System.out.println("deleteOneEmp 오류 발생!!");
            System.out.println(ex.getMessage());
        } finally {
            J34JDBCUtil.closeConn(null,pstmt,conn);
        }
        return cnt;}
}