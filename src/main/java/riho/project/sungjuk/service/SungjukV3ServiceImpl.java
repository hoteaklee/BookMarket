package riho.project.sungjuk.service;

import riho.project.sungjuk.dao.SungjukV3DAO;
import riho.project.sungjuk.dao.SungjukV3DAOImpl;
import riho.project.sungjuk.model.SungjukVO;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SungjukV3ServiceImpl implements SungjukV1cSerive {
    private Scanner sc = null;
    private List<SungjukVO> sjs = null; //성적 저장
    private SungjukV3DAO sjdao = null;


    public SungjukV3ServiceImpl(){
        sc= new Scanner(System.in);
        // 파일에 저장된 데이터를 모두 읽어서 arrayList 객체에 저장
        sjs = sjdao.loadSungjuk();
        sjdao = new SungjukV3DAOImpl();
    }

    //성적 프로그램 메뉴
    public int displayMenu(){
        int menu = -1;

        StringBuffer sb = new StringBuffer();
        sb.append("-------------------------------\n")
        .append(" 성적 처리 프로그램 v3\n")
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

        try {
             menu = sc.nextInt();   // a 를 입력하면 a\n 입력되는거라서 \n를 소진해야 한다.sc.nextLine();을 입력해줌
        } catch (InputMismatchException ex) {
            sc.nextLine();  // nextInt 시 문자를 입력했을때 입력 버퍼에 남은 문자찌꺼기 제거
            // 숫자가 아닌 그 이외 문자 입력시 menu에 -1 대입
            menu = -1;
        }
        return menu;
    }

    // 리스트 분기 처리
    public void processMenu(int menu){
        switch (menu){
            case 1:newSungjuk(); break;
            case 2:readSungjuk(); break;
            case 3:readOneSungjuk();break;
            case 4:modifySungjuk(); break;
            case 5:removeSungjuk(); break;
            case 0: System.exit(0); break;
            default:
                System.out.println("\n---잘못 입력하셨습니다.---\n");
        }
    }

    // 성적데이터 추가
    public void newSungjuk() {
        String name = "";
        int kor = 0, eng = 0, mat = 0;

        try {
            System.out.print("이름은? ");
            name = sc.next();
            System.out.print("국어 점수는? ");
            kor = sc.nextInt();
            System.out.print("영어 점수는? ");
            eng = sc.nextInt();
            System.out.print("수학 점수는? ");
            mat = sc.nextInt();
        } catch (InputMismatchException ex){
            System.out.println("잘못 입력하셨습니다.... 다시 시도 하세요!!");
            sc.nextLine();
            return;
        }


        SungjukVO sj = new SungjukVO(name,kor,eng,mat);
        computeSungjuk(sj);    // 성적처리 (총점, 평균,학점)

        // 성적데이처에 파일에 저장
        if (sjdao.saveSungjuk(sj) )
            System.out.println("파일 저장성공\n");


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
        String fmt = "\n%s %d %d %d\n";

        // 파일에 저장된 데이터를 모두 읽어서 arrayList 객체에 저장
        sjs = sjdao.loadSungjuk();

        try {
            for (SungjukVO sj : sjs) {
                System.out.printf(fmt, sj.getName(), sj.getKor(), sj.getEng(), sj.getMat());
            }   // sjs 배열에 저장된 모든 성적데이터 출력
        } catch (NullPointerException ex){}
    }

    public void readOneSungjuk() {
        // 이름입력 -> 대상 검색 -> 대상출력
        System.out.println(" 조회할 학생이름은?? ");
        String name = sc.next();    //이름입력

        SungjukVO one = null;   //대상검색



        try {
            for (SungjukVO sj : sjs) {
                if (sj.getName().equals(name)) {
                    one = sj;
                    break;
                }
            }
        } catch (NullPointerException ex){}
        if (one != null){
            System.out.printf("\n%s\n",one);
        } else {
            System.out.println("\n찾는 데이터가 없습니다.!\n");
        }
    }

    public void modifySungjuk() {
        // 이름입력 -> 대상검색 -> 새로운데이터입력 -> 성적처리
        System.out.print(" 수정할 학생이름은?? ");
        String name = sc.next();    //이름입력

        for (int i = 0; i < sjs.size() ; i++) {
            try {
                if (sjs.get(i).getName().equals(name)){
                    System.out.print("국어 점수는? ");
                    int kor = sc.nextInt();
                    System.out.print("영어 점수는? ");
                    int eng = sc.nextInt();
                    System.out.print("수학 점수는? ");
                    int mat = sc.nextInt();

                    SungjukVO newOne = new SungjukVO(name,kor, eng, mat);
                    computeSungjuk(newOne); //총점,평균,학점 다시 계산
                    sjs.set(i,newOne);    // 기존 성적데이터 위치에 새롭게 생성한 객체 대입
                    System.out.println("\n수정 완료!!\n");
                    break;
                }
            }catch (InputMismatchException ex){
                System.out.println("\n 잘못 입력하셨습니다. .. 다시 시도해주세요!\n");
                sc.nextLine();
                return;
            }

        }
    }

    public void removeSungjuk() {
        // 이름입력 -> 대상 검색 -> 대상제거
        System.out.print(" 삭제할 학생이름은?? ");
        String name = sc.next();    //이름입력

            for ( SungjukVO sj:sjs) {
                if (sj.getName().equals(name)){
                   sjs.remove(sj);      // 대상을 list에서 삭제
                    System.out.println("\n삭제되었습니다.\n");
                    break;
                }
            }


    }


}
