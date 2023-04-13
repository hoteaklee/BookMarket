package riho.project.sungjuk;

import riho.project.sungjuk.service.SungjukV1cSerive;
import riho.project.sungjuk.service.SungjukV1cServiceImpl;
import riho.project.sungjuk.service.SungjukV2ServiceImpl;

public class SungjukV2Main {
    // 성적 처리프로그램 v2
    // 배열과 클래스, 인터페이스, 예외처리, 컬렉션을 이용해서
    // 성적을 입력하면  총점,평균,학점을 계산함
    // 입력가능한 학생 성적 데이터는 최대 10명까지
    // SungjukV2Main , SungjukVO, SungjukV1cService, SungjukV2ServiceImpl
    //1. 성적데이터 입력
    //2. 성적데이터 조회 (이름,국어,영어,수학)
    //3. 성적데이터 조히 (모두 다 출력)
    //4. 성적데이터 수정
    //5. 성적데이터 삭제
    //0. 프로그램 종료
    public static void main(String[] args) {
        SungjukV1cSerive sjsrv = new SungjukV2ServiceImpl();

        while (true) {
            //성적 프로그램 메뉴 작성
            int menu = sjsrv.displayMenu();

            // 입력한 리스트에 따라 작업 분기
            sjsrv.processMenu(menu);

        }
    }
}
