package riho;

import java.sql.*;
import java.util.Scanner;

public class J28JDBC {
    // 2. 데이터베이스 서버에 접속하기
    private static String DRV = "org.mariadb.jdbc.Driver";
   private static String URL = "jdbc:mariadb://fullstacks.chpty04rh0pr.ap-northeast-2.rds.amazonaws.com:3306/fullstacks";
    private static String USR = "admin";
    private static String PWD = "fullstack_2023";

    private static String selectBookSQL = "select * from newbooks order by bookno desc";

    private static String insertBookSQL = "insert into newbooks (title,writer,price) values(?,?,?)";
    public static void main(String[] args) {
        // newbooks 테이블의 모든 레코드 조회


        // 1. JDBC 드라이버를 메모리에 적재
        try {
            Class.forName(DRV);
        } catch (ClassNotFoundException e) {
            System.out.println("mariadb 용 JDBC 드라이버가 없어요!");
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; // 넘어오는 결과 확인

        try {
            //데이터베이스 등록
            conn = DriverManager.getConnection(URL,USR,PWD);
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(selectBookSQL);

            // SQL문 실행후 결과집합 받음 resultSet
            rs = pstmt.executeQuery();    // DML실행시 사용
            while (rs.next()){
                System.out.print(rs.getInt("bookno") + " ");
                System.out.print(rs.getString("title") + " ");
                System.out.print(rs.getString("writer") + "\n");
            }

        } catch (SQLException e) {
            System.out.println("디비 접속주소나 아이디/비번을 확인하세요!!");
        } finally {
            if(rs != null) try{rs.close();} catch (Exception ex){}
            if(pstmt != null) try{pstmt.close();} catch (Exception ex){}
            if(conn != null) try{conn.close();} catch (Exception ex){}
        }

    }
}

class Book {
    private int bookno;
    private String title;
    private String writer;
    private int price;
    private String regdate;

    public Book() { }

    public Book(int bookno, String title, String writer, int price, String regdate) {
        this.bookno = bookno;
        this.title = title;
        this.writer = writer;
        this.price = price;
        this.regdate = regdate;
    }

    public int getBookno() {
        return bookno;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }


}