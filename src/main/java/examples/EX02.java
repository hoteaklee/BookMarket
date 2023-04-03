package examples;

public class EX02 {
    public static void main(String[] args) {
        //3,4,5,6번 문제 책p79

        //03번
        int colorPen = 5 * 12;
        int studentCount = 27;
        int divColorPen = colorPen/studentCount;
        System.out.println("학생당 나눠가지는 색열필수:" +divColorPen);

        int remainColorPen = colorPen%studentCount ;
        System.out.println("똑같이 나눠가지고 남은 볼펜수 :"+remainColorPen);

        //04번
        int age = 6;
        int height = 120;
        String parent = 6>= age && 120>=height ? "보호자 동반":"";
       // boolean hearchDease = true ? "실장질환자 탑승 불가";
        System.out.printf("%d세이상 탑승가능(단,키가 %dcm 이상이면 %s하에 탑승가능\n",age,height,parent);
        System.out.printf("키 %dcm 이상 탑승 가능",height);
        System.out.printf("심장질환자 탑승 불가");

    }
}
