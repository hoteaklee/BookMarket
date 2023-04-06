package examples;

import java.util.Scanner;

public class EX07 {
    public static void main(String[] args) {
        //Q51 - 구구단 BigGugudan
        System.out.println("\t\t\t\tMultipication Table");
        System.out.print("\t\t\t");
        for (int i = 1; i <= 9 ; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("\n--------------------------------------------------");
        for (int i = 1; i <= 9 ; i++) {
            System.out.print(i + "\t|\t\t");    // 앞 2부분
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%2d\t",j*i); //나머지 뒷 9부분
            }

            System.out.println("");
        }



        //Q53 - 1월 달력 CalrendarV1
        // 1월 1일 요일 계산
        //((년도 - 1)*365 + (년도 - 1)/4 - (년도 - 1)/100 + (년도 - 1)/400 + 1) % 7
        //0 : 일, 1 : 월, 2 : 화, … … , 6 : 토
        int year = 2005;
        int stnum =((year - 1)*365 + (year - 1)/4 - (year - 1)/100 + (year - 1)/400 + 1) % 7 ;
        //System.out.println(stnum);  //시작 숫자 = 6
        System.out.printf("\t\tJanuary %d\n",year);
        System.out.println("-----------------------------");
        System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
        for (int i = 1; i <= stnum; i++) {
            System.out.print(" \t");
        }
            for (int j = 1; j <= 31; j++) {
                System.out.printf("%2d",j);
                stnum++;
                if (stnum%7==0) System.out.println();
                else System.out.print("\t");
            }

        System.out.println("");


            //Q55 주민번호 유호성검사
        Scanner sc = new Scanner(System.in);
//        int[] jumin = {1,2,3,4,5,6,   //불일치
//                          1,2,3,4,5,6,7};
        int[] jumin = {1,2,3,4,5,6,     //일치
                            1,2,2,2,3,3,1};
        int sum = 0;

        // 1) 2,3,4,5,6,7,8,9,2,3,4,5 가중치 곱합
        sum += jumin[0] *2;
        sum += jumin[1] *3;
        sum += jumin[2] *4;
        sum += jumin[3] *5;
        sum += jumin[4] *6;
        sum += jumin[5] *7;
        sum += jumin[6] *8;
        sum += jumin[7] *9;
        sum += jumin[8] *2;
        sum += jumin[9] *3;
        sum += jumin[10] *4;
        sum += jumin[11] *5;

        //2) 누적합을 11로 나눈 나머지 구함
        int mod = sum % 11;

        // 3) 나머지에서 11을 뺀 값을 비교
        mod = 11 - mod;

        // 4) 주민번호 끝자리와 비교
        if (jumin[12] == (mod%10)) System.out.println("주민번호 일치!"); // mod%10 모드가 두자리수가 나올수 있어서 10을 나눠줌
        else System.out.println("주민번호 불일치");

        System.out.println("나머지: " + mod);

        //v2 주민번호 코드 개선~~
        int[] weight = {2,3,4,5,6,7,8,9,2,3,4,5}; //가중치
        sum = 0;

        // 누적합 구함
        for (int i = 0; i < weight.length; i++) {
            sum += jumin[i] * weight[i];
        }

        // 나머지 구함
         mod = (11 -sum %11) % 10;

        //결과 확인
        String result = "주민번호 불일치";
        if (jumin[12] == (mod)) result = "주민번호 일치!";

        System.out.println(result + "/" + mod);


    }
}
