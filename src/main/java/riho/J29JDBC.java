package riho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J29JDBC {
    // 2. 데이터베이스 서버에 접속하기

    //private static String selectBookSQL = "select * from newbooks order by bookno desc";
    private static String selectBookSQL = "select * from newbooks where title like ? order by bookno desc";

    private static String insertBookSQL = "insert into newbooks (title,writer,price) values(?,?,?)";
    public static void main(String[] args) {
        // newbooks 테이블의 도서명에 'IT CookBook'이 포한된 레코드 조회
        List<Book> bookdata = new ArrayList<>();

        // 검색할 도서명을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 도서명은? ");
        String findbook = sc.nextLine();

        // 1. JDBC 드라이버를 메모리에 적재


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; // 넘어오는 결과 확인

        try {
            //데이터베이스 등록
            conn = J32JDBCUtil.makeConn();
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(selectBookSQL);
            pstmt.setString(1,"%"+ findbook+"%");

            // SQL문 실행후 결과집합 받음 resultSet
            rs = pstmt.executeQuery();    // DML실행시 사용
            while (rs.next()){
                Book book = new Book(rs.getInt(1),
                        rs.getString(2),rs.getString(3),
                        rs.getInt(4),rs.getString(5));
                bookdata.add(book);
            }

        } catch (SQLException e) {
            System.out.println("디비 접속주소나 아이디/비번, SQL문을 확인하세요!!");
        } finally {
            // static으로 선언된 메서드는 객체 생성 없이 바로 호출가능
            //단, 클래스명.메서드명으로 호출하야 함
            J32JDBCUtil.closeConn(rs,pstmt,conn);
        }

        // 도서 정보 출력
        for ( Book b :bookdata){
            System.out.println(b);
        }

    }
}

