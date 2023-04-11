package riho;

import java.util.Scanner;

public class SungjukV1bServiceImpl implements SungjukV1bSerive {
    private Scanner sc = null;
    private  int idx = 0;
    private SungjukVO[] sjs = null; //성적 저장
    public SungjukV1bServiceImpl(){
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
        .append("작업을 선택하세요 : ");
        System.out.println(sb);
        String menu = sc.next();

        return menu;
    }

    // 리스트 분기 처리
    public void processMenu(String menu){
        switch (menu){
            case "1":newSungjuk(); break;
            case "2":readSungjuk(); break;
            case "3":readOneSungjuk();break;
            case "4":modifySungjuk(); break;
            case "5":removeSungjuk(); break;
            case "0": System.exit(0); break;
            default:
                System.out.println("\n---잘못 입력하셨습니다.---\n");
        }
    }

    // 성적데이터 추가
    public void newSungjuk() {
        System.out.print("이름은? ");
        String name = sc.next();
        System.out.print("국어 점수는? ");
        int kor = sc.nextInt();
        System.out.print("영어 점수는? ");
        int eng = sc.nextInt();
        System.out.print("수학 점수는? ");
        int mat = sc.nextInt();

        SungjukVO sj = new SungjukVO(name,kor,eng,mat);
        computeSungjuk(sj);    // 성적처리 (총점, 평균,학점)
        sjs[idx++] = sj;    //처리된 성적데이터 저장(배열에 순서대로 담기)
    }
    //성적처리
    public void computeSungjuk(SungjukVO sj){
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

    // 성적 리스트 조회 (이름,국어,영어,수학)
    public void readSungjuk() {
        String fmt = "%s %d %d %d\n";
        for ( SungjukVO sj : sjs ){
            if (sj != null) //배열에 성적데이터가 존재한다면 출력
            System.out.printf(fmt,sj.getName(),sj.getKor(),sj.getEng(),sj.getMat());
        }   // sjs 배열에 저장된 모든 성적데이터 출력
    }

    public void readOneSungjuk() {
        // 이름입력 -> 대상 검색 -> 대상출력
        System.out.println(" 조회할 학생이름은?? ");
        String name = sc.next();    //이름입력

        SungjukVO one = null;   //대상검색
        for (SungjukVO sj : sjs){
            if (sj != null && sj.getName().equals(name)){
                one = sj; break;
            }
        }
        if (one != null){
            System.out.println(one);
        } else {
            System.out.println("\n찾는 데이터가 없습니다.!\n");
        }
    }

    public void modifySungjuk() {
    }

    public void removeSungjuk() {

    }







}