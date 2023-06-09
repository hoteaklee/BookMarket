package riho;

import java.util.ArrayList;
import java.util.List;

public class J21Collection {
    //Collection
    // 데이터를 저장하는 자료구조와
    // 데이터를 처리(CRUD)하는 알고리즘
    // 체계적으로 정리(구조화)해서 인터페이스와 클래스로 구현해 놓은 프레임워크
    public static void main(String[] args) {
    // ArrayList
    // 동적배열의 한 종류
    // List 인터페이스를 구현해서 만든 컬렉션 프레임워크
    // 요소의 저장순서가 유지
    // 중복으로 데이터를 저장할 수 있음
    // 크기가 늘어나면 새로운 배열을 생성하고
    // 기존의 요소들을 옮겨야 하는 복잡한 과정이 동반됨
    List<String> names= new ArrayList<>();  //인터페이스를 이욯해서 사용
    //ArrayList names= new ArrayList(); //추천하지 않음

        //데이터 추가 : add(대상) -순서대로 저장
        names.add("혜교");
        names.add("지현");
        names.add("수지");

        // 특정위치에 데이터 추가 : add(위치, 대상)
        names.add(1,"원형");

        //조회 : enhanced for, foreach
        for (String name : names){
            System.out.print(name + " ");
        }
        System.out.println(" ");

        // 특정요소 조회 : get(위치)
        System.out.println(names.get(1));

        // 특정요소 변경 : set(위치 , 새로운 값)
        names.set(1, "윤아");
        System.out.println(names.get(1));

        // 특정요소 제거 : remove(위치)
        names.remove(1);
        System.out.println(names.get(1));

        // 특정요소 제거 : remove(값)
        names.remove("수지");
        System.out.println("수지 삭제후 : " + names.get( names.size()-1 ));


        // 데이터 검색
        // 위치로 찾음 : get(위치), indexOf
        // 값으로 찾기 : foreach ,contains

        // '지현'을 검색1
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals("지현")){
                System.out.println( (i+1)+ "번째에서 찾음!");
            }
        }   //위치 기반 검색

        // '지현'을 검색2
        for ( String name: names){
            if (name.equals("지현")){
                System.out.println("데이터 찾음!!2");
            }
        }   //값기반 검색

        // '지현'을 검색 3
        if (names.contains("지현")){
            System.out.println("데이터 찾음 !!3");
        }   //값 기반 검색

        // '지현'을 검색 4
        if (names.indexOf("지현") > -1){
            System.out.println("데이터 찾음 !!4");
        }   // 위치 기반 검색

        //------------------------------------------------------

        // 게임정보 동적배열 생성
        List<GameInfo> games = new ArrayList<>();
        games.add(new GameInfo("디아블로4",89600));
        games.add(new GameInfo("젤다의 전설",74800));
        games.add(new GameInfo("바이오하자드 4RE",67000));


        // 조회
        // GameInfo 타입은 객체형이므로
        // 객체자체를 출력하시 객체의 메모리 주소가 출력
        // 따라서, toString을 재정의 해두어야 올바른 값이 출력
        for (  GameInfo game :games){
            System.out.println(game);
        }

        //'젤다의 전설'의 가격을 조회 - for
        System.out.println("젤다의 전설 가격은? ");
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getName().equals("젤다의 전설")){
                System.out.println(games.get(i).getPrice());
            }
        }
        //'젤다의 전설'의 가격을 조회 - foreach
        for (GameInfo game : games){
            if (game.name.equals("젤다의 전설")){
                System.out.println(game.price);
            }
        }
        //'젤다의 전설'의 가격을 조회 - contains (boolean 으로 출력)
        for (GameInfo game : games){
            if (game.name.contains("젤다의 전설")){
                System.out.println(game.price);
            }
        }
        //'젤다의 전설'의 가격을 조회 - indexOf ( 못찾으면  -1 로 출력)
        for (GameInfo game : games){
            if (game.name.indexOf("젤다의 전설") > -1){
                System.out.println(game.price);
            }
        }



    }
}

class GameInfo {
    String name;
    int price;

    public GameInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String fmt = "%s %,d";
        return String.format(fmt,name,price);
    }
}