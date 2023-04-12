package riho;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class J19Package {
    public static void main(String[] args) {
        // Math 클래스
        int a = 4, b= 10, c = 1;
        double d = 4.51, e = 5.41;
        System.out.println(Math.max(a,b) + "/" + Math.max(b,c));    //최대값
        System.out.println(Math.min(b,c) + "/" + Math.min(a,b));    //최소값

        System.out.println(Math.round(d) + "/" + Math.round(e));    //반올림
        System.out.println(Math.ceil(d) + "/" + Math.floor(d));     //올림  내림
        System.out.println(Math.ceil(e) + "/" + Math.floor(e));

        double r = Math.random();
        System.out.println(r);
        System.out.println( (int)(r*5) );    // 0~4 난수
        System.out.println( (int)(r*10) );   // 0 ~ 9 난수

        System.out.println( ((int)(r*5))+1 );    // 0~5 난수
        System.out.println( ((int)(r*10)) +1 );   // 1 ~ 10 난수

        // 1 ~ 45 사이 임의의 난수 6개 생성
        System.out.print( "1 ~ 45 사이의 난수 6개 : ");
        for (int i = 1; i <= 6 ; i++) {
            r = Math.random();
            System.out.print( ((int)(r*45)) +1 + " " );
        }
        System.out.println("");


        // String 클래스
        // ex)  파일명이 abc123.png라 할때 파일명과 확장자를 분리해서 출력
        //String filename = "abc123.png";
        String filename = "abc123xyz.jpeg";

        //String fname= filename.substring(0,6);
        String fname= filename.substring(0,filename.indexOf('.')); // 점의 위치
        //String ext = filename.substring(7); //또는 (7,10);
        String ext = filename.substring(filename.indexOf('.')+1);

        System.out.println(fname + " / " + ext);

        // split로 파일명/확장자 분리
        String[] names = filename.split("[.]"); //split 는 배열
        System.out.println(names[0] + " / " + names[1]);

        // 문자열 합치기  : + , concat(비추) , StringBuilder, StringBuffer
        // + : 내부적으로 StringBuilder를 이용해서 처리
        // StringBuilder ( 동기화 x ) > StringBuffer (동기화 o )
        // 하지만 , 실무 에서는 StringBuffer를 주로 사용

        // Date 클래스
        Date today = new Date();
        System.out.println(today);

        //Calrendar 클래스
        Calendar cal = Calendar.getInstance();

        System.out.println(cal.getTime() );

        System.out.println(cal.toString() );
//        System.out.println(cal.get(Calendar.YEAR) + "-" +
//                        ( cal.get(Calendar.MONTH) +1 ) + "-"+
//                        (cal.get(Calendar.D)));

        // SimpleDateFormat 클래스
        // 날짜나 시간 표시를 좀 더 편하게 다루기 위해 사용
        String dfmt = "yyyy-MM-dd";    // 년월일
        String tfmt = "HH:mm:ss E";    // 시분초 요일

        SimpleDateFormat sdf = new SimpleDateFormat(dfmt);
        System.out.println(sdf.format(today));

        sdf = new SimpleDateFormat(tfmt);
        System.out.println(sdf.format(today));

        // 래퍼클래스 (포장)
        // 기본자료형 데이터를 클래스형 데이터로 취급할때 사용하는 클래스
        int f = 1;
        System.out.println(f);

        Integer g = new Integer(f); //박싱 : 기본형을 클래스형 바꿈
        System.out.println(g.toString());

        int h = g.intValue();   //언박싱 : 클래스형을 기본형으로 바꿈
        System.out.println(h);

        // 문자열값을 기본자료형/클래스형으로 변환  : parseXxx...
        int i = Integer.parseInt("12345");
        Integer j = Integer.parseInt("12345");



    }
}
