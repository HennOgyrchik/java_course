import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    /*
    Task 1. Создайте метод, формирующий массив из N случайных целых чисел.
    Посчитать процент уникальных значений.
 */
        System.out.printf("%.2f",task1(createRandomArray(8, 10)));

    }

    static int[] createRandomArray(int n, int max){
        int[] array = new int[n];
        Random rand = new Random();
        
        for (int i = 0; i < array.length; i++) {
            array[i]=rand.nextInt(max);
            System.out.print(array[i]+" ");
        }
        System.out.println();

        return array;
    }
    
    static double task1(int[] randArray){
        Set<Integer> uniq = new HashSet<>();

        for (int num :randArray) {
            uniq.add(num);
        }
        System.out.println(uniq);
        return (double)uniq.size()/randArray.length;
    }
}
























