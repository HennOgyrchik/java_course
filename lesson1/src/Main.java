import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args){
       // task1();
       // task2();
        //task3();
        task4();
    }

    static  void task1(){
        Scanner sc = new Scanner(System.in);
        int hour =LocalDateTime.now().getHour();

        System.out.print("Введите имя: ");
        String name =sc.nextLine();

        String dayTime="";
        if (hour >= 4 && hour<11)
            dayTime="Доброе утро";
        else if (hour >= 11 && hour<17)
            dayTime="Добрый день";
            else if (hour >= 17 && hour<23)
            dayTime="Добрый вечер";
            else dayTime="Доброй ночи";

        System.out.printf("%s, %s!",dayTime,name);

        sc.close();
    }

    static void task2 (){
         int[] array= new int[] {1,1,1,0,1,1,1,1};

         int count=0;
         int max_count=0;
         for (int item :array){
             if (item==1) {
                 count++;
                 if (count>max_count)
                     max_count=count;
             }
             else if (count>max_count) {
                 max_count=count;
                 count=0;

             }
             else
                 count=0;
         }

        System.out.println(max_count);
    }

    static void task3(){
        int[] array = new int[]{1,7,3,6,5,6};

        for (int i=1;i<array.length-1;i++){
            int leftSum=0;
            int rightSum=0;
            for (int i1=0;i1<i;i1++){
                leftSum+=array[i1];
            }
            for (int i2=i+1;i2<array.length;i2++){
                rightSum+=array[i2];
            }

            if (leftSum==rightSum){
                System.out.println(i);
                return;
            }


        }
        System.out.println(-1);
    }

    static void task4(){
        Scanner sc=new Scanner(System.in);

        System.out.print("Введите фразу:");
        String phrase=sc.nextLine();

        String[] words=phrase.split(" ");
        String[] res=new String[words.length];


        for (int i=0;i<words.length;i++){
            res[i]=words[words.length-1-i];

        }

        for (String word:res) {
            System.out.print(word+" ");

        }

        sc.close();
    }
}