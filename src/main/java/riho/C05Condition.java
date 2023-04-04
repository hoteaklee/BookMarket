package riho;

import java.util.Scanner;

public class C05Condition {
    public static void main(String[] args) {
        //제어문
        // 프로그램의 실행 순서를 제어할 수 있는 문장
        // 조건문, 반복문, 분기문

        // 조건문
        //조건에 대한 만족여부에 따라 실행할 코드를 결정하는 명령문
        // ex) 짝수, 홀수 여부 출력
        int num = 5;

        if (num%2 == 0){
            System.out.println("짝수 입니다.");
        }
        if(num%2 != 0){
            System.out.println("홀수 입니다.");
        }

        //ex) 오전, 오후 구분
        String time = "09:47:15";

        //문자추출 : chatAt(위치)
        //System.out.println(time.charAt(0) +""+ time.charAt(1));
        // 문자열 숫자로 변환 : Integer.parseInt(대상)
        int hour = Integer.parseInt(time.charAt(0) +""+ time.charAt(1));
        System.out.println(hour);

        if (hour >= 12) {
            System.out.println("오후 입니다.");
        }
        if (hour < 12){
            System.out.println("오전 입니다.");
        }

        // ex) 투표가 가능한 나이 구분하기
        //int age = 18 ;

        System.out.print("나이는?");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if(age >= 18){
            System.out.println("투표가능한 나이입니다.");
        }
        if (age < 18){
            System.out.println("투표가 불가능한 나이 입니다.");
        }

        // if ~ else 문
        // 평균 점수가 60점 이상이면 "시험 합격!!"을 출력
        // 평균 점수가 60전 미만이면 "시험 불랍격!!"을 출력
        System.out.print("점수는");
        int jumsu = sc.nextInt();

        if (jumsu >= 60){
            System.out.println("시험 합격!!");
        } else {
            System.out.println("시험 불합격!!");
        }

        // 짝수 , 홀수 여부 판별 v2
        num = 15;

        if (num % 2 == 0){
            System.out.println(num + " 짝수 입니다.");
        } else {
            System.out.println(num + " 홀수 입니다.");
        }

        // ex) 아이디와 비밀번호를 이용해서
        // 로그인 기능 구현하기
        String userid = "abc123";
        String passwd = "987xyz";

        System.out.print("아이디는?");
        String uid = sc.next();

        System.out.println("비밀번호는?");
        String pwd = sc.next();

        // String형 변수 비교시 == 연산자는 대상의 주소값을 확인
        //정수, 실수와는 달리 String은 참조자료형이기 때문임
        // 따라서, 문자열 자체를 비교하려면 equals()를 사용
        //if (userid == uid && passwd == pwd){
        if (userid.equals(uid) && passwd.equals(pwd)){
            System.out.println("로그인 가능!!");
        } else {
            System.out.println("로그인 불가능!!");
        }

        // 중첩 조건문 - 가독성 저하로 비추 !!
        // if문 안에 또 다른 if문 작성

        // 특정년도의 윤년여부를 출력 v2
        // 조건1 : 4로 나눠 떨어지고 윤년
        // 조건2 : 4로 나눠 떨어지고, 100으로도 나눠 떨어지면 평년
        // 조건3 : 400으로 나눠 떨어지면 윤년

        int year = 2020;
        if (year%4 ==0){                        //조건 1
            if(year%100 == 0){                  //조건 2
                System.out.println("평년!!");
            }else {                             //조건 2b
                System.out.println("윤년!!");
            }
        }else {
            if (year%400 == 0){                   //조건 3
                System.out.println("윤년!!");
            } else {
                System.out.println("평년!!");
            }
        }

        //다중 조건문
        //둘 이상의 조건을 처리하는 조건문
        // if ~ else 뒤에 if ~ else를 더 추가함

        // 평균점수에 따라 수우무양가 성적결과 출력
        double avg = 76.4;
        String grd = "";    //성적결과 담는 변수

        if (avg >= 90) grd = "수";
        else if (avg >= 80) grd = "우";
        else if (avg >= 70) grd = "미";
        else if (avg >= 60) grd = "양";
        else grd = "가";

        System.out.printf("평균 : %.1f, 성적: %S\n", avg,grd);


        // 버스 기본요금 부과하기 - 나이를 입력받음
        // 미취학 아동 (~7세) : 0원
        // 어린이 (8~13) : 450원
        // 청소년 (14~19) : 720원
        // 일반 (20~) : 1200원
        // 노인 (70~) : 0원

        System.out.print("버스요금 나이는");
        int ageB = sc.nextInt();
        int price = 0 ;

        if (ageB >= 70) price = 0;
        else if (ageB >= 20) price = 1200;
        else if (ageB >= 14) price = 720;
        else if (ageB >= 8) price = 450;
        else price = 0;

        System.out.printf("나이는 %d, 요금은 %d원 입니다. \n",ageB,price);

        // switch
        // 다중 조건문을 가독성 있게 작성한 조건문
        // swich의 표현식을 평가하여 그 값의 일치여부에 따라
        // case문 아래의 코드 블록을 실행하는 구조

        //짝수, 홀수 여부 출력 v3
        num = 74;
        String result = "";

        switch (num%2){
            case 0: result = "짝수"; break;
            case 1: result = "홀수"; break;
        }

        System.out.println(result);

        //짝수, 홀수 여부 출력 v4  //자바에서는 안됨~!!!
//        switch (num%2 == 0){
//            case true: result = "짝수"; break;
//            case false: result = "홀수"; break;
//        }


        // 평균점수에 따라 수우무양가 성적결과 출력 v2
        double avgV2 = 89.4;
        String grdV2 = "";    //성적결과

        switch ((int) (avgV2/10)){
            case 10 :
            case 9 : grdV2 = "수"; break;
            case 8 : grdV2 = "우"; break;
            case 7 : grdV2 = "미"; break;
            case 6 : grdV2 = "양"; break;
            default: grdV2 = "가"; break;
        }
        System.out.printf("평균 : %.1f, 성적: %S\n", avgV2,grdV2);


        // ex) 월, 윤년여부(Y/N)를 입력한 해당 월의 마지막 날을 출력
        // 1,3,5,7,8,10,12 - 31일
        //4,6,9,11 - 30일
        // 2 - 윤년여부에 따라 28(N)일 or 29(Y)일
        System.out.print("월은?");
        int month = sc.nextInt();
        System.out.print("윤년여부는?(y/n)");
        String isLeapYear = sc.next();

        int lastDay = 0;

        switch (month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                lastDay = 31; break;
            case 4: case 6: case 9: case 11:
                lastDay = 30; break;
                //equalsIgnoreCase 대소문자 상관없이 가능
            case 2: if (isLeapYear.equalsIgnoreCase("Y")) lastDay= 29;
                    else lastDay = 28; break;
        }
        String fmt = "%d월은 %d일 (윤년:%s)까지 입니다. \n";
        System.out.printf(fmt,month,lastDay,isLeapYear);


    }
}
