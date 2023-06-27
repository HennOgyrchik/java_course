import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     //1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
       // task1();
        //2) Вывести все простые числа от 1 до 1000
       // task2();
       // 3) Реализовать простой калькулятор
       // task3();
    }

    static void task1(){
        System.out.print("Введите число n: ");

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        int sum=0;
        int fact=1;
        for (int i=1;i<=n;i++){
            sum+=i;
            fact*=i;
        }

        System.out.printf("Треугольное число: %d    Факториал: %d",sum,fact);
    }

    static void task2(){
        int[] arr =new int[1000];

        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }

        for (int i=0;i<arr.length;i++){

            for (int j=2;j<=i;j++){
                if (arr[i]%j==0){
                    arr[i]=0;
                    break;
                }
            }
        }


        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                System.out.printf("%d, ",arr[i]);
            }
        }

    }

    static void task3(){

        Scanner sc = new Scanner(System.in);

        while (true){
        menu();

        int choice = sc.nextInt();

        switch (choice){
            case 1:{
                int[] x=quest(sc);
                System.out.printf("%d + %d = %d\n",x[0],x[1],x[0]+x[1]);
                break;}
            case 2:{
                int[] x=quest(sc);
                System.out.printf("%d - %d = %d\n",x[0],x[1],x[0]-x[1]);
                break;}
            case 3:{
                int[] x=quest(sc);
                System.out.printf("%d * %d = %d\n",x[0],x[1],x[0]*x[1]);
                break;}
            case 4:{
                int[] x=quest(sc);
                System.out.printf("%d / %d = %.2f\n",x[0],x[1],((float)x[0])/x[1]);
                break;}
            case 5:
                sc.close();
                return;
            default:
                break;
        }
        }

    }

    static void menu(){
        System.out.print("1 - сложение\n2 - вычитание\n3 - умножение\n4 - деление\n5 - выход\nВыберите пункт меню:");
    }
    static int[] quest (Scanner sc){

        System.out.print("Введите первое число: ");
        int a=sc.nextInt();
        System.out.print("Введите второе число: ");
        int b=sc.nextInt();

        return new int[]{a,b};
    }
}