package examples;

import java.util.Date;
import java.util.Scanner;

public class EX04 {
    public static void main(String[] args) {
        //문 11
        System.out.println("문제11번");
        Scanner sc = new Scanner(System.in);
        System.out.print("이름은?");
        String name = sc.next();

        System.out.print("몸무게는?");
        double weight = sc.nextDouble();

        System.out.print("나이는?");
        int age1 = sc.nextInt();

        String fmt = "이름 : %s, 몸무게: %.1f Kg, 나이:%d";
        System.out.printf(fmt,name,weight,age1 );

        //문12 -MyAge
        System.out.println("\n문제12번");
        System.out.print("탄생년도를 입력하세요?");
        int byear = sc.nextInt();

        System.out.print("탄생월?");
        int bmonth = sc.nextInt();

        System.out.print("탄생일?");
        int bday = sc.nextInt();

        int cyear = 2023, cmonth = 4, cday= 3;
        //1) 현재년도에서 생년을 뻄
        int age = cyear - byear;

        //2) 생일이 지났으면 나이 +1 해줌
        age = (bmonth > cmonth && bday > cday) ? age += 1 : age;
        fmt = "입력한 생일:%d-%02d-%02d\n";
        fmt += "현재 날짜:%d-%02d-%02d\n";
        fmt += "나이 :%d세\n";
        System.out.printf(fmt, byear,bmonth,bday,cyear,cmonth,cday,age);


        //문제13
        System.out.println("문제 13번");
        int dan = 7;
//        System.out.printf("구구단 %d단\n",dan);
//        System.out.printf("%d * 1 = %d\n",dan,dan*1);
//        System.out.printf("%d * 2 = %d\n",dan,dan*2);
//        System.out.printf("%d * 3 = %d\n",dan,dan*3);
//        System.out.printf("%d * 4 = %d\n",dan,dan*4);
//        System.out.printf("%d * 5 = %d\n",dan,dan*5);
//        System.out.printf("%d * 6 = %d\n",dan,dan*6);
//        System.out.printf("%d * 7 = %d\n",dan,dan*7);
//        System.out.printf("%d * 8 = %d\n",dan,dan*8);
//        System.out.printf("%d * 9 = %d\n",dan,dan*9);

        for( int i = 1; i<10; i++){
            System.out.printf("%d * %d = %d\n",dan,i,dan*i);
        };

        String dan7 = "7 * 1 = " + ( 7 * 1 );
                dan7 += "\n7 * 2 = " + ( 7 * 2 );
                dan7 += "\n7 * 3 = " + ( 7 * 3 );
                dan7 += "\n7 * 4 = " + ( 7 * 4 );
                dan7 += "\n7 * 5 = " + ( 7 * 5 );
                dan7 += "\n7 * 6 = " + ( 7 * 6 );
                dan7 += "\n7 * 7 = " + ( 7 * 7 );
                dan7 += "\n7 * 8 = " + ( 7 * 8 );
                dan7 += "\n7 * 9 = " + ( 7 * 9 );
        System.out.println(dan7);

        //문제14
        System.out.println("문제14번");
        int daysec = 86400;
        int data1 = 1234567890;
        System.out.printf("하루는 %,d초 , %,d초는 약 %,d일\n",daysec,data1,data1/daysec);

        int hour = 3600;
        int data2 = 98765;
        fmt = "하루는 %,d초 , %,d초는 약 %,d 시간 이다\n";
        System.out.printf(fmt,hour,data2, data2/hour);

        int min = 60;
        int data3 = 12345;
        fmt = "1분은  %,d초 , %,d초는 약 %,d 분 이다\n";
        System.out.printf(fmt,min,data3, data3/min);



        sc.close();
    }
}
