package day1;

public class ToMaxOfNDigits_1 {
    public static void toMaxOfNDigits(int n){
        if (n < 1){
            return;
        }
        String str = "9";
        while (n != 1){
            n--;
            str += "9";
        }
        int m = Integer.parseInt(str);
        for (int i = 1; i <= m; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            toMaxOfNDigits(i);
        }
    }
}
