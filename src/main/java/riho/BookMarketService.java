package riho;

import java.util.Scanner;

public class BookMarketService {
    private Scanner sc = null;  // 기능을 수행하기 위한 변수 (값을 넣는것은 아님)
    private MemberShip m = null;    //회원정보 저장용
    public  BookMarketService() {
        sc = new Scanner(System.in);
    }

    public String displayMenu(){   // bookmatket 메뉴 작성
        StringBuilder sb = new StringBuilder(); // 문자열 모아서 출력
        sb.append("-------------------------------------\n")
        .append("Welcome to Shopping Mall\n")
        .append("Welcome to Book Market\n")
        .append("-------------------------------------\n")
        .append("2. 장바구니 상품목록 보기\n")
        .append("3. 장바구니 비우기\n")
        .append("4. 장바구니 상품 추가\n")
        .append("5. 장바구니 주문수량 변경\n")
        .append("6. 장바구니 상품 삭제\n")
        .append("7. 장바구니 영수증 출력\n")
        .append("0. 장바구니 종료\n")
        .append("-------------------------------------\n")
        .append("작업을 선택하세요 : ");
        System.out.print(sb);
        String menu = sc.next();    // 작업할 메뉴 입력받기

        return menu;
    }

   //메뉴 분기 처리
    public void processMenu(String menu){
        switch (menu){
            case "1":
                System.out.println("\n고객정보 확인");
                 System.out.println(m);
                break;
            case "2":
                System.out.println("\n장바구니 상품 목록\n"); break;
            case "3": System.out.println("\n장바구니 비우기\n"); break;
            case "4": System.out.println("\n장바구니 상품 추가\n"); break;
            case "5": System.out.println("\n주무수량 변경\n"); break;
            case "6": System.out.println("\n상품 삭제\n"); break;
            case "7": System.out.println("\n주문 영수증 출력\n"); break;
            case "0":
                System.out.println("프로그램을 종료합니다.");
                System.exit(0); break;  // 정상 종료
            default:
                System.out.println("\n 잘못 입력하셨습니다.\n");
        }   //switch

    }

    //회원 등록
    public void registerMember(){
        System.out.print("회원이름은?");
        String name = sc.next();
        System.out.print("회원 이메일은?");
        String email = sc.next();
        System.out.print("회원 전화번호은?");
        String hp = sc.next();

        m = new MemberShip(230410,name,email, hp);
    }

}
