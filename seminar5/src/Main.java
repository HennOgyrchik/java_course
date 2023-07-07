import java.util.*;

public class Main {
    public static void main(String[] args) {
        //ex1();
       // ex2();
        ex3_2();
    }
    //Task 1. Создать структуру для хранения номеров паспортов и фамилий сотрудников.
    static void ex1(){
        Map<String, String> workers = new HashMap<>();
        workers.put("100","Иванов");
        workers.put("101","Петров");
        workers.put("102","Иванов");
        workers.put("103","Сидоров");
        workers.put("104","Иванов");
        workers.put("105","Пупкин");

        for (Map.Entry<String, String> worker : workers.entrySet()) {
            if (worker.getValue().equals("Иванов")){
                System.out.printf("Passport number: %s\tWorker surname: %s\n", worker.getKey(),worker.getValue());

            }
        }
    }

    //Task 2. Написать метод, который переведет число из римского формата записи в арабский.

    static void ex2(){
        Map<Character, Integer> rimNums = new HashMap<>();

        rimNums.put('I', 1);
        rimNums.put('V', 5);
        rimNums.put('X', 10);
        rimNums.put('L', 50);
        rimNums.put('C', 100);
        rimNums.put('D', 500);
        rimNums.put('M', 1000);

        Scanner input = new Scanner(System.in);
        System.out.print("Введите римское число: ");
        char[] romeNum = input.nextLine().toUpperCase().toCharArray();
        input.close();

        int res=0;

        for (int i =0;i<romeNum.length;i++){
            if (i!=romeNum.length-1 &&  rimNums.get(romeNum[i])<rimNums.get(romeNum[i+1])){
                res+=rimNums.get(romeNum[i+1])-rimNums.get(romeNum[i]);
                i++;
            } else {
                res +=rimNums.get(romeNum[i]);
            }
        }

        System.out.println(res);


    }

    //Написать метод, который сортирует строки по длине с помощью TreeMap.
    // //Строки с одинаковой длиной не должны “потеряться”.
    static void ex3_1(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String[] words = input.nextLine().split(" ");
        input.close();

        Map<Integer, String> sortedWords = new TreeMap<>();

        for (String word : words) {
            sortedWords.put(word.length(),word);
        }
        System.out.println(sortedWords);
    }

    static void ex3_2(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String[] words = input.nextLine().split(" ");
        input.close();

        Map<Integer, LinkedList<String>> sortedWords = new TreeMap<>();

        for (String word:words) {
            if (sortedWords.containsKey(word.length())){
                sortedWords.get(word.length()).add(word);
            }else{
                sortedWords.put(word.length(),new LinkedList<>());
                sortedWords.get(word.length()).add(word);
            }

        }

        System.out.println(sortedWords);
    }
}