package riho;

public class C03TypeComversion {
    //psvm 탭
    public static void main(String[] args) {
        // 자료형 변환
        // 묵시적 형변환(자동 auto)
        // 명시적 형변환(캐스팅 casting)

        //자동형변환
        byte z = 10; // byte는 1byte 크그의 자료형
        int a = z;  // int는 4byte 크기 자료형 (승격 promotion)
        //int a = (int)z;  // 변수 승격시 명시적 형변환 사용시 불필요!! z= (int)z

        System.out.printf("%d, %d\n", z,a);

        // 캐스팅 형변환 : casting연산자 사용!
        // 자료형 변수명A = (변환할자료형) 변수명B;
        z = (byte) a;
        System.out.printf("%d, %d\n", z,a);

        a = 512;
        z = (byte) a;
        System.out.printf("%d, %d\n", z,a);

        double b = 3.14;
        long c = (long) b;
        System.out.printf("%f, %d\n", b,c);

        // 의도적이 형변환
        // 정수끼리 산술연산 결과 : 정수
        // 정수끼리 산술연산 결과를 실수로 출력 - 형변환필요!
        int x = 98;
        int y = 99;

        System.out.printf("98 / 99 = %d\n", x /y );
        // 정수끼리 연산시 결과도 정수: 소수부 출력 불가!
        System.out.printf("98 / 99 = %f\n", (double)x /y ); //실수 바이트가 커서 실수로 승격
        // 자동형변환에 의해 연산 결과는 실수로 바뀌어 출력





    }
}
