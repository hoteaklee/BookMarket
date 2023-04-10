package riho;

import java.util.Scanner;

public class SungjukV1Service {
    private Scanner sc = null;
    private SungjukVO[] sjs = null; //성적 저장
    public SungjukV1Service(){
        sc= new Scanner(System.in);
        sjs = new SungjukVO[10];
    }

    //성적 프로그램 메뉴
    public String displayMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------\n")
        .append(" 성적 처리 프로그램 v1\n")
        .append("-------------------------------\n")
        .append("1. 성적데이터 추가\n")
        .append("2. 성적데이터 조회(이름,국어,영어,수학)\n")
        .append("3. 성적데이터 상세조회(모두)\n")
        .append("4. 성적데이터 수정\n")
        .append("5. 성적데이터 삭제\n")
        .append("0. 프로그램 종료\n")
        .append("-------------------------------\n")
        .append("작업을 선택하세요 : \n");
        System.out.println(sb);
        String menu = sc.next();

        return menu;
    }

    // 리스트 분기 처리
    public void processList(String menu){
        switch (menu){
            case "1":System.out.println("\n성적데이터 입력"); break;
            case "2":System.out.println("성적데이터 조회\n"); break;
            case "3":System.out.println("성적데이터 전체 조회\n");
                      break;
            case "4":System.out.println("성적데이터 수정\n"); break;
            case "5":System.out.println("성적데이터 삭제\n"); break;
            case "0":System.out.println("프로그램 종료합니다.");
                System.exit(0); break;
            default:
                System.out.println("\n---잘못 입력하셨습니다.---\n");
        }
    }

    //성적 등록
    public void registerSungjuk(){
        System.out.print("이름은? ");
        String name = sc.next();
        System.out.print("국어 점수는? ");
        int kor = sc.nextInt();
        System.out.print("영어 점수는? ");
        int eng = sc.nextInt();
        System.out.print("수학 점수는? ");
        int mat = sc.nextInt();

       // sjs = new SungjukVO();
    }

   //성적처리
    public static void computesSungjuk(SungjukVO sj){
        sj.setTot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setAvg( (double)sj.getTot()/ 3);

        switch ((int)sj.getAvg()/10){
            case 10:
            case 9: sj.setGrd("수");break;
            case 8: sj.setGrd("우");break;
            case 7: sj.setGrd("미");break;
            case 6: sj.setGrd("양");break;
            default :sj.setGrd("가");break;
        }
    }
    public static void printSungJuk(SungjukVO sj){
        System.out.println(sj);
    }


}
