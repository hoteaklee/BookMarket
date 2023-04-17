package riho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J30JDBC {
    // 2. 데이터베이스 서버에 접속하기
    /*private static String DRV = "org.mariadb.jdbc.Driver";
    private static String URL = "jdbc:mariadb://fullstacks.chpty04rh0pr.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private static String USR = "admin";
    private static String PWD = "fullstack_2023";*/

    private static String deleteBookSQL = "delete from newbooks where bookno = ?";

    public static void main(String[] args) {
        // newbooks 테이블의 입력받은 도서번호를 이용해서 래코드 삭제

        // 삭제할 도서번호를 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할  도서번호는?  ");
        int bookno = sc.nextInt();

        // 1. JDBC 드라이버를 메모리에 적재
        /*try {
            Class.forName(DRV);
        } catch (ClassNotFoundException e) {
            System.out.println("mariadb 용 JDBC 드라이버가 없어요!");
        }*/

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //데이터베이스 등록
            /*conn = DriverManager.getConnection(URL,USR,PWD);*/
            conn = J32JDBCUtil.makeConn();
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(deleteBookSQL);
            pstmt.setInt(1, bookno);

            //SQL문 실행 후 결과 확인
            int cnt =  pstmt.executeUpdate();
            System.out.println("데이터 삭제 확인 : " + cnt);


        } catch (SQLException e) {
            System.out.println("디비 접속주소나 아이디/비번, SQL문을 확인하세요!!");
        } finally {
            // static으로 선언된 메서드는 객체 생성 없이 바로 호출가능
            //단, 클래스명.메서드명으로 호출하야 함
            J32JDBCUtil.closeConn(null,pstmt,conn);
        }



    }
}

