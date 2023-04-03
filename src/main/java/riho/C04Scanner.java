package riho;

import java.util.Scanner;

public class C04Scanner {                       //1
    public static void main(String[] args) {
        // 데이터 입력 : Scanner
        //Scan 탭~~~
    Scanner sc = new Scanner(System.in);        //2

        // 이름을 입력받음
//        System.out.println("이름은?");
//        String name = sc.next();                 //3
//        System.out.printf("이름은 %s",name);

        // ex)성적 처리프로그램 v2
        // 이름, 국어, 영어, 수학을  키보드로 입력받아
        // 총접, 평균, 학점을 계산한 뒤 결과 출력
        System.out.print("이름은?");
        String name = sc.next();

        System.out.print("국어 점수?");
        int kor = sc.nextInt();

        System.out.print("영어 점수?");
        int eng = sc.nextInt();

        System.out.print("수학 점수?");
        int mat = sc.nextInt();

        int tot = kor + eng + mat;
        double avg = (double) tot/3;
        String grade = avg >= 90 ? "수" :
                        avg >= 80 ? "우" :
                        avg >= 70 ? "미" :
                        avg >= 60 ? "양" : "가";

        System.out.printf(" 이름:%s , 국어: %d, 영어:%d, 수학:%d, \n" +
                "총점 : %d , 평균: %.1f , 학점: %s",name,kor,eng,mat, tot,avg,grade);



        //종료시 sc 객체 제거
        sc.close();                               //4


    }
}
