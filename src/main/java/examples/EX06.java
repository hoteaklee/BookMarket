package examples;

import java.util.Random;
import java.util.Scanner;

public class EX06 {
    public static void main(String[] args) {

//        25. 다음 조건을 만족하는 복권 발행 프로그램을 작성하세요. (Lotto)
//        가. 사용자로부터 복권 숫자 3자리를 입력 받으세요 (yourkey)
//        나. 변수에 임의의 복권 숫자 3자리를 초기화합니다 (lottokey)
//        다. 사용자가 입력한 복권 숫자가 모두 일치 : 상금 1백만 지급
//        라. 일치하지 않는 경우 : “아쉽지만, 다음 기회를!” 라고 출력
//        int[] yourkey = new int[3];
//        int[] lottokey = {1,2,3};
//        String result = "";
//        for (int i = 0; i < yourkey.length; i++) {
//        Scanner sc = new Scanner(System.in);
//            System.out.print((i+1) + "번째 번호?");
//        yourkey[i] = sc.nextInt();
//
//            for (int j = 0; j < lottokey.length; j++) {
//                if (yourkey[i] == lottokey[j]) result = "상금 1백만 지급";
//                else result = "아쉽지만, 다음 기회를!";
//            }
//        }
//        System.out.println(result);

/*        //25 - 복권 발행 프로그램 : Lotto
        // 위치에 상관 없이 숫자만 맞으면 일치하는 것으로 인정!
        Scanner sc = new Scanner(System.in);
        String lottokey = "123";
        System.out.print("복권숫자는?");
        String yourkey = sc.next();

        int match = 0;  //일치여부
        char key = yourkey.charAt(0);   //첫번째 숫자 비교
        if (key == lottokey.charAt(0) || key == lottokey.charAt(1)
                || key == lottokey.charAt(2)) ++match;

        key = yourkey.charAt(1);   //두번째 숫자 비교
        if (key == lottokey.charAt(0) || key == lottokey.charAt(1)
                || key == lottokey.charAt(2)) ++match;

        key = yourkey.charAt(2);   //세번째 숫자 비교
        if (key == lottokey.charAt(0) || key == lottokey.charAt(1)
                || key == lottokey.charAt(2)) ++match;

        String result = "아쉽지만, 다음기회를!";
        if (match == 3) result = "당첨! 상금 100만원 지급!!";

        System.out.printf("복권번호 : %s, 입력한 번호 : %s\n",lottokey,yourkey);
        System.out.printf("당첨여부 : %d개 일치, 결과여부 : %s\n",match,result);*/

        //25 - 복권 발행 프로그램 : Lotto v2
        // 위치에 상관 없이 숫자만 맞으면 일치하는 것으로 인정!
        Scanner sc = new Scanner(System.in);

        Random rnd = new Random(); // 난수생성을 위한 객체 정의
        String lottokey = "";

        // nextInt(경계값) : 0 ~ 경계값 -1 사이의 정수 난수 출력
        // 1 ~ 9 사이의 임의의 정수 3개를 난수로 생성
        for (int i = 0; i < 3; i++) {
            lottokey +=  rnd.nextInt(9) + 1;   // 0 ~ 8 + 1
        }

        System.out.print("복권숫자는(3자리)?");
        String yourkey = sc.next();

        int match = 0;  //일치여부
        char key = yourkey.charAt(0);   //첫번째 숫자 비교
        if (key == lottokey.charAt(0) || key == lottokey.charAt(1)
                || key == lottokey.charAt(2)) ++match;

        key = yourkey.charAt(1);   //두번째 숫자 비교
        if (key == lottokey.charAt(0) || key == lottokey.charAt(1)
                || key == lottokey.charAt(2)) ++match;

        key = yourkey.charAt(2);   //세번째 숫자 비교
        if (key == lottokey.charAt(0) || key == lottokey.charAt(1)
                || key == lottokey.charAt(2)) ++match;

        String result = "아쉽지만, 다음기회를!";
        if (match == 3) result = "당첨! 상금 100만원 지급!!";

        System.out.printf("복권번호 : %s, 입력한 번호 : %s\n",lottokey,yourkey);
        System.out.printf("당첨여부 : %d개 일치, 결과여부 : %s\n",match,result);






//        30. 다음 조건에 따라 숫자 맞추기 프로그램을 작성해보세요. (CatchNumber)
//                가. 사용자로부터 1 - 100사이의 숫자를 입력 받으세요 (num1)
//                나. 변수에 임의의 숫자 3자리를 초기화합니다 (num2)
//                다. num1이 num2보다 크면 “추측한 숫자가 큽니다”라고 출력하세요
//                라. num1이 num2보다 작으면 “추측한 숫자가 작습니다”라고 출력하세요력하고 종료
//            int[] num1 = new int[1];
//            int[] num2 = {1};
//        int num2 = 10;
//        result = "";
//        System.out.print("1 ~100 사이의 숫자 입력: ");
//        Scanner sc = new Scanner(System.in);
//         int num1 = sc.nextInt();
//         if (num1 > num2) result = "추측한 숫자가 큽니다";
//         else result = "추측한 숫자가 작습니다";
//        System.out.println(result);


//        32. 키보드로 정수를 하나 입력받아 다음 조건에 따라 결과를 출력하는 프로그램을 작성하시오. (CheckNumber)
//         가. 입력한 값이 10000 보다 작으면 “10000미만” 이라 출력
//        나. 입력한 값이 10000 이상 20000미만 이면 “10000~20000” 이라 출력
//        다. 입력한 값이 20000 이상 30000미만 이면 “20000~30000” 이라 출력
//        라. 입력한 값이 그 이외 값이면 “범위 밖 값” 이라 출력
//            result = "";
//            System.out.print("1~40000 사이 입력: ");
//             int num = sc.nextInt();
//             if (num < 10000) result = "10000미만";
//             else if (num < 20000) result ="10000~20000";
//             else if (num < 30000) result ="20000~30000";
//             else result = "범위 밖 값";
//        System.out.println(result);

       //48. 지금 현재 수지의 통장잔액이 25,000원이다.
        // 은행이자가 연 6%라 가정할 때,
        // 몇 년이 지나야 통장잔액이 지금의 2배를 넘는지
        // 알아보는 프로그램을 아래 그림을 참고하여 작성하여라. (ComputeInvestment)
        // 1년 * 0.06 =
//        int money = 25000;
//        //int inter = year * 0.06;
//        for (int i = 0;  ; i++) {
//
//        }














    }
}
