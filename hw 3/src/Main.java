import java.util.*;

public class Main {
    public static void main(String[] args) {
        //задание 1
        ArrayList<Integer> arr = createArray(10,20);
        printArray(arr);
        printArray(deleteEven(arr));
        System.out.println("Минимальный: "+findMin(arr));
        System.out.println("Максимальный: "+findMax(arr));
        System.out.printf("Среднее: %.2f\n",findAvg(arr)); //примечательно, что используется массив после удаления четных чисел

        //задание 2
        planetsCounter(10);
    }

    /*
    Пусть дан произвольный список целых чисел.
    1) Нужно удалить из него чётные числа
    2) Найти минимальное значение
    3) Найти максимальное значение
    4) Найти среднее значение*/

    static ArrayList<Integer> createArray (int size,int maxValue){
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();

        for (int i = 0; i<size;i++)
            nums.add(rand.nextInt(maxValue));

        return nums;
    }

    static ArrayList<Integer> deleteEven(ArrayList<Integer> arr){
        for (int i=0;i<arr.size();i++){
            if (arr.get(i)%2==0){
                arr.remove(i);
                i--;
            }
        }

        return arr;

    }

    static void printArray(ArrayList arr){
        Iterator iter = arr.iterator();

        while (iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
        System.out.println();
    }

    static int findMin(ArrayList<Integer> arr){
        int min=arr.get(0);
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    static int findMax(ArrayList<Integer> arr){
        int max=arr.get(0);
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    static float findAvg(ArrayList<Integer> arr){
        int sum=0;
        for (int n : arr) {
            sum+=n;
        }

        return (float) sum/arr.size();

    }

    /*Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.*/
    static void planetsCounter(int size){
        List<String> listPlanets = List.of("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune");
        ArrayList<String> randPlanets = new ArrayList<String>(size);

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i)+" ");
        }

        System.out.println();

        for (int i = 0;i<randPlanets.size();i++){
            if (randPlanets.subList(0,i).contains(randPlanets.get(i))){
                randPlanets.remove(i);
                i--;
            }
        }
        printArray(randPlanets);

    }

}