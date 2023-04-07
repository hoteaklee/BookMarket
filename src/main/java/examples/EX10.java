package examples;

import riho.SungjukVO;

import java.util.Scanner;

public class EX10 {
    public static void main(String[] args) {
        // ex) 성적 처리프로그램 v5
        // 클래스 기반 성적프로그램
//        String[] names = new String[3];
//        int[] kors = new int[3];
//        int[] engs = new int[3];
//        int[] mats = new int[3];
//
//        int[] tots = new int[3];
//        double[] avgs = new double[3];
//        String[] grds = new String[3];
        SungjukVO sj = new SungjukVO();

//        readSungJuk(names,kors,engs,mats);
//        computesSungjuk(kors,engs,mats,tots,avgs,grds);
//        printSungJuk(names,kors,engs,mats,tots,avgs,grds);

        readSungJuk(sj);
        computesSungjuk(sj);
        printSungJuk(sj);

    }
    public static void readSungJuk(SungjukVO sj){

        Scanner sc = new Scanner(System.in);
            System.out.print("번 학생이름은??");
            sj.setName( sc.next() );
            System.out.print("국어 점수?");
            sj.setKor(sc.nextInt() );
            System.out.print( "영어 점수?");
            sj.setEng(sc.nextInt() );
            System.out.print("수학 점수?");
            sj.setMat(sc.nextInt() );
           //성적 데이터 입력
    }

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
            }//성적 처리
    }

    public static void printSungJuk(SungjukVO sj){
        System.out.println(sj);
    }
}
