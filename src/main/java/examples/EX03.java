package examples;

import java.util.Date;
import java.util.Scanner;

public class EX03 {
    public static void main(String[] args) {
        //문7
        // 우선순위: *,/
        System.out.println(3 + 4.5 * 2 + 27 / 8 );
        //우선순위: !,&&,||
        System.out.println(true || false && 3 < 4 || !(5 == 7) ); //true
        //우선순위: (),&&,||
        System.out.println(true || (3 < 5 && 6 >= 2) ); //true
        //System.out.println(!true > 'A'); //알파벳이라서 안됨 (실행불가)

        //단일문자일경우 숫자형으로 변경됨 아스키코드값(ascii)
        // Z: 90, D:68 ,M:77
       // System.out.println("Z =>" +(0 + 'Z') ); //90
        System.out.println( 7 % 4 + 3 - 2 / 6 * 'Z');
        System.out.println( 'D' + 1 + 'M' % 2 / 3 );
        System.out.println(  5.0 / 3 + 3 / 3 );
        System.out.println( 53 % 21 < 45 / 18); //false
        System.out.println( 53 % 21 < 45 / 18); //false
        System.out.println( (4 < 6) || true && false || false && (2 > 3));  //true
        System.out.println(  7 - (3 + 8 * 6 + 3) - (2 + 5 * 2));

        //문8
        System.out.println("문제8번");
        // print : 괄호안의 문자열 출력
        // println: 괄호안의 문자열 출력후 줄바꿈 처리
        System.out.print( " May 13, 1988 fell on day number ");
        System.out.println( ( (13 + (13 * 3 - 1) / 5 + 1988 % 100 + 1988 % 100 / 4 + 1988 / 400
                - 2 * (1988 / 100) ) % 7 + 7) % 7 );

        System.out.print( " Check out this line  ");
        System.out.println( " //hello there " + '9' + 7 );

        //단일문자가 수식에 사용되면 ascii 코드값으로 자동 형변환
        // H:72, I:73, T:84
        System.out.println( 'H' + 'I' + " is " + 1 + "more example" );
        System.out.println( 'H' + 6.5 + 'I' + " is " + 1 + "more example" );
        //System.out.print( "Print both of us", "Me too" );
        System.out.println( "Print both of us" + "Me too" );

        // 'I' + 'T'  먼저 계산이 되면  숫자로 바뀌지만  "Reverse " + 'I' 먼저 해서 문자문자가됨
        // 문자가 문자열과 + 연산시 문자결합 발생!!
        System.out.println( "Reverse " + 'I' + 'T' );
        System.out.println( "No! Here is" + 1 + "more example\n" );

        //System.out.println( "Here is " + 10 * 10 ) // that’s 100 ;    //주석뒤에 ; 이라서 출력X
       // 10 * 10를 먼저  연산 후 문자열로 변환해서 문자결합
        System.out.println( "Here is " + 10 * 10 ); // that’s 100
        System.out.println( "Reverse " + 'I' * 'T' );  //Reverse 6132
        System.out.println( "Not x is " + true ); // that’s true.
        //System.out.print(  );
        //System.out.println;
        //System.out.print( "How about this one" ++ '?' + 'Huh?' );
        System.out.print( "How about this one" +'?' + "Huh?" );

        //요일 계산
        System.out.print( "\n Dec 25, 2023 fell on day number ");
        System.out.println( ( (25 + (25 * 3 - 1) / 12 + 2023 % 100 + 2023 % 100 / 4 + 2023 / 400
                - 2 * (2023 / 100) ) % 7 + 7) % 7 );

        //문9
        System.out.println("문제9번");
        // 우선순위: !, &&, ||
        //단축식 평가 1 : and 연산시 한쪽이 False면 더 볼꺼없이 전체식의 결과는 False
        //단축식 평가 2 : or 연산시 한쪽이 True면 더 볼꺼 없이 전체식의 결과는 True
        System.out.println( true && false && true || true  );
        System.out.println( true || true && true && false  );
        System.out.println( (true && false) || (true && ! false) || (false && !false)   );
        System.out.println(  (2 < 3) || (5 > 2) && !(4 == 4) || 9 != 4  );
        System.out.println(   6 == 9 || 5 < 6 && 8 < 4 || 4 > 3  );






    }
}
