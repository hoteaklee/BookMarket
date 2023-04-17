package riho;

import java.sql.*;

public class J34JDBCUtil {
    // 2. 오라클 데이터베이스 서버에 접속하기
    private static String DRV = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@13.125.85.72 :1521:XE";
    private static String USR = "hr";
    private static String PWD = "hr";

    // 데이터 베이스 접속 객체 생성 메서드
    public static Connection makeConn(){
        Connection conn = null;
        // 1. JDBC 드라이버를 메모리에 적재
        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL,USR,PWD);
        } catch (ClassNotFoundException e) {
            System.out.println("mriadb 용 JDBC 드라이버가 없어요!");
        } catch (SQLException e) {
                System.out.println("디비 접속주소나 아이디/비번을 확인하세요!!");
        }
        return conn;
    }

    // 데이터베이스 접속 해제
    public static void closeConn(ResultSet rs, PreparedStatement pstmt, Connection conn){
        if(rs != null) try{rs.close();} catch (Exception ex){}
        if(pstmt != null) try{pstmt.close();} catch (Exception ex){}
        if(conn != null) try{conn.close();} catch (Exception ex){}
    }

}
