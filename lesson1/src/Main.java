import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name =sc.nextLine();
        System.out.printf("Привет, %s!",name);

        sc.close();
    }


}