package riho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J28JDBC {
    // 2. 데이터베이스 서버에 접속하기

    private static String selectBookSQL = "select * from newbooks order by bookno desc";


    public static void main(String[] args) {
        // newbooks 테이블의 모든 레코드 조회
        List<Book> bookdata = new ArrayList<>();

        // 1. JDBC 드라이버를 메모리에 적재

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null; // 넘어오는 결과 확인

        try {
            //데이터베이스 등록
            conn = J32JDBCUtil.makeConn();
            // 실행할 SQL문 생성
            pstmt = conn.prepareStatement(selectBookSQL);

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

    @Override
    public String toString() {
       String fmt ="%d %s %s %d %s \n";
        return String.format(fmt,bookno,title,writer,price,regdate);
    }
}