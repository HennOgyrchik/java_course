import java.util.*;

public class Main {
    public static void main(String[] args) {
        //randomNum(5,10);

        //planetsCounter(5);

        createTable(3);
    }

    //заполнить массив n случайными числами. Отсортировать массив методом sort
    static void randomNum(int size, int maxValue){
        ArrayList<Integer> nums = new ArrayList<>(size);

        Random rand = new Random();

        for (int i = 0; i < size; i++)
            nums.add(rand.nextInt(maxValue));

        for (int num :nums)
            System.out.print(num+" ");
        System.out.println();

        nums.sort(Comparator.naturalOrder());

        Iterator<Integer> iter = nums.iterator();

        while (iter.hasNext()){
            System.out.print(iter.next()+" ");
        }
    }

    //заполнить список названиями планет в произвольном порядке с повторениями.
    //вывести на экран каждое название и количество их повторений

    static void planetsCounter(int size){
        List<String> listPlanets = List.of("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune");
        List<String> randPlanets = new ArrayList<String>(size);

        int[] counts = new int[listPlanets.size()];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i)+" ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;
        }

        System.out.println();


        for (int i = 0;i<listPlanets.size();i++)
            System.out.printf("%s\t-\t%d\n", listPlanets.get(i),counts[i]);

    }

    //каталог товаров сохранен в виде двумерного массива...

    static void createTable(int size){
        List<String> genres = List.of("Фантастика","Комедия","Детектив","Ужасы");
        List<ArrayList<String>> table = new ArrayList<>(genres.size());

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < genres.size(); i++) {
            ArrayList<String> booksOfGenre = new ArrayList<>(size);
            booksOfGenre.add(genres.get(i));
            System.out.printf("Input %d titles of %s genre down here:\n",size,genres.get(i));
            for (int j = 0; j < size; j++)
                booksOfGenre.add(input.nextLine());

            table.add(booksOfGenre);
        }

        input.close();

        for (ArrayList<String> books: table) {
            for (String book: books) {
                System.out.print(book+"\t");
            }
            System.out.println();
        }

    }
}