package examples;

public class EX01 {
     public static void main(String[] args) {
        System.out.println("*   *    **    ****    ****    *   *      /////    ");
        System.out.println("*   *   *  *   *   *   *   *   *   *     | o o |   ");
        System.out.println("*****  *    *  ****    ****     * *     (|  ^  |)  ");
        System.out.println("*   *  ******  *   *   *   *     *       | [_] |   ");
        System.out.println("*   *  *    *  *    *  *    *    *        _____   ");

         System.out.println("  ");
         System.out.println("            +---+ ");
         System.out.println("            |   | ");
         System.out.println("        +---+---+ ");
         System.out.println("        |   |   | ");
         System.out.println("    +---+---+---+      /\\_/\\       -----     ");
         System.out.println("    |   |   |   |     ( ' ' )    / Hello \\   ");
         System.out.println("+---+---+---+---+     (  -  )   <  Junior |  ");
         System.out.println("|   |   |   |   |      | | |     \\ Coder /   ");
         System.out.println("+---+---+---+---+     (__|__)      -----     ");

         int soju = 3000;
         int sj_qty = 2;
         int chicken = 12000;
         int chck_qty = 1;

         int total = (soju * sj_qty) + (chicken * chck_qty );
         double vat = total * 0.1;

         int money = 50000;
         int charge = money - total;

         System.out.println("\t");
         System.out.println("\t\t [ 음식나라 ] ");
         System.out.println("----------------------------");
         System.out.printf("소주\t\t%2d\t\t%5d\n",sj_qty,soju*sj_qty);
         System.out.printf("너나치킨\t%2d\t\t%5d\n",chck_qty,chicken*chck_qty);
         System.out.println("----------------------------");
         System.out.printf("과세합계\t\t\t%5d\n",total);
         System.out.printf("부가세\t\t\t%5.0f\n",vat);
         System.out.println("----------------------------");
         System.out.printf("총합계\t\t\t%5d\n",total);
         System.out.printf("받은금액\t\t\t%5d\n",money);
         System.out.printf("잔돈\t\t\t\t%5d\n",charge);
         System.out.println("----------------------------");
         System.out.println("2023. 03. 30\t 18:04:24");

       // %d 정수 , %f 실수, %s 문자열


    }
}
