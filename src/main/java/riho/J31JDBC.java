package riho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class J31JDBC {
    // 2. 데이터베이스 서버에 접속하기

    private static String updateBookSQL = "update newbooks set title=?, writer=?,price=? where bookno = ?";

    public static void main(String[] args) {
        // newbooks 테이블의 입력받은 도서정보(도서번호,도서명,저자,가격)를 이용해서 래코드 수정

        // 수정할 도서번호를 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("수정할  도서번호는?  ");
        int bookno = sc.nextInt();
        System.out.print("수정할 도서명은??");
        String bkname = sc.next();
        System.out.print("수정할 저자는?");
        String author = sc.next();
        System.out.print("수정할 가격?");
        int price = sc.nextInt();

        // 1. JDBC 드라이버를 메모리에 적재


        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //데이터베이스 등록
            conn = J32JDBCUtil.makeConn();
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(updateBookSQL);
            pstmt.setString(1, bkname);
            pstmt.setString(2, author);
            pstmt.setInt(3, price);
            pstmt.setInt(4, bookno);

            //SQL문 실행 후 결과 확인
            int cnt =  pstmt.executeUpdate();
            System.out.println("데이터 수정 확인 : " + cnt);


        } catch (SQLException e) {
            System.out.println("디비 접속주소나 아이디/비번, SQL문을 확인하세요!!");
        } finally {
            // static으로 선언된 메서드는 객체 생성 없이 바로 호출가능
            //단, 클래스명.메서드명으로 호출하야 함
            J32JDBCUtil.closeConn(null,pstmt,conn);
        }



    }
}

