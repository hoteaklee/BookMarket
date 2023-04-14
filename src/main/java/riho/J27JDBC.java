package riho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class J27JDBC {
    // 2. 데이터베이스 서버에 접속하기
    private static String DRV = "org.mariadb.jdbc.Driver";
   private static String URL = "jdbc:mariadb://fullstacks.chpty04rh0pr.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private static String USR = "admin";
    private static String PWD = "fullstack_2023";

    private static String insertBookSQL = "insert into newbooks (title,writer,price) values(?,?,?)";
    public static void main(String[] args) {
        // newbooks 테이블에 도서정보 저장
        Scanner sc = new Scanner(System.in);
        System.out.print("도서명은??");
        String bkname = sc.next();
        System.out.print("저자는?");
        String author = sc.next();
        System.out.print("가격?");
        int price = sc.nextInt();

        // 1. JDBC 드라이버를 메모리에 적재
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException e) {
            System.out.println("mriadb 용 JDBC 드라이버가 없어요!");
        }

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //데이터베이스 등록
            conn = DriverManager.getConnection(URL,USR,PWD);    //데이터서버 연결
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(insertBookSQL);
            // 실행할 SQL문의 placeholder에 값 전달 (?,?,?)
            pstmt.setString(1,bkname);
            pstmt.setString(2,author);
            pstmt.setInt(3,price);

            // SQL문 실행후 결과 확인
            int cnt = pstmt.executeUpdate();    // DML실행시 사용
            System.out.println("데이터 입력확인 :" + cnt);

        } catch (SQLException e) {
            System.out.println("디비 접속주소나 아이디/비번, SQL문을 확인하세요!!");
        } finally {
            if(pstmt != null) try{pstmt.close();} catch (Exception ex){}
            if(conn != null) try{conn.close();} catch (Exception ex){}
        }

    }
}
