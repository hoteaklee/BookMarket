package riho;

public class Welcome {
    public static void main(String[] args) {
        //System.out.println("Welcome to Shopping Mall");
        //System.out.println("Welcome to Book Market");
        String greeting = "Welcome to Shopping Mall";
        String tagline = "Welcome to Book Market";

        System.out.println("******************************************************");
        System.out.println("\t" +greeting);
        System.out.println("\t" +tagline);
        System.out.println("******************************************************");
        System.out.println("1. 고객 정보 확인하기     \t 4.바구니에 항목 추가하기");
        System.out.println("2. 장바구니 상품 목록 보기 \t 5.바구니에 항목 수량 줄이기");
        System.out.println("3. 장바구니 비우기        \t 6.바구니에 항목 삭제하기");
        System.out.println("7. 고객 정보 확인하기      \t 8.종료");
        System.out.println("******************************************************");
    }
}
