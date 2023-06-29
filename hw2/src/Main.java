import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        //task 1
//        String pathProject=System.getProperty("user.dir");
//        printFilesExt(showCurrentFiles(pathProject));

        //task 2

        int[] arr = new int[]{2,4,1,4,6,7,3,5,3,6,0,8};
        sort(arr);
        }

    /*Напишите метод, который определит тип (расширение) файлов из текущей папки
    и выведет в консоль результат вида
        1 Расширение файла: txt
        2 Расширение файла: pdf
        3 Расширение файла:
        4 Расширение файла: jpg*/

    static String[] showCurrentFiles(String dirPath){
        File currentDir = new File(dirPath);
        return currentDir.list();
    }
    static void printFilesExt(String[] list){
        for (int i=0;i<list.length;i++) {
            int index = list[i].lastIndexOf(".");
            if (index<0) index=list[i].length();
            System.out.printf("%d) %s\n",i+1,list[i].substring(index));
        }
    }

    /*Реализуйте алгоритм сортировки пузырьком
    числового массива, результат после каждой итерации запишите в лог-файл.*/

    static void sort(int[] arr) throws IOException {
        Logger logger=createLogger();

        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            logger.warning(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    static Logger createLogger() throws IOException {
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fh = new FileHandler("log.txt");

        logger.addHandler(fh);
        SimpleFormatter simple = new SimpleFormatter();
        fh.setFormatter(simple);

        return logger;
    }
}