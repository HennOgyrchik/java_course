import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.out.println(longStringBuilding(11,'a','b'));
        // System.out.println(stringCompress("aaaabbbcdd"));
        // System.out.println(isPalindrom("123e321"));

//        String pathProject=System.getProperty("user.dir");
//        String pathFile=pathProject.concat("\\seminar2-1.txt");
//        addingToFile(pathFile,longStringCreator("Hello! ",5));

        String pathProject=System.getProperty("user.dir");
        String pathFile=pathProject.concat("\\seminar2-2.txt");
        addListToFile(pathFile,showCurrentFiles(pathProject));
    }

    static String longStringBuilding(int n, char c1,char c2){
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < n/2; i++) {
            newStr.append(c1);
            newStr.append(c2);


        }
        return newStr.toString();
    }

    static String stringCompress(String str){
        StringBuilder newStr = new StringBuilder();
        int count =0;
        char symbol=str.charAt(0);
        newStr.append(symbol);

        for (char letter: str.toCharArray()) {
            if (letter==symbol){
                count++;
            }
            else {
                if (count!=1) newStr.append(count);
                newStr.append(letter);
                symbol=letter;
                count=1;
            }
        }
        if (count!=1) newStr.append(count);
        return newStr.toString();

    }

    static boolean isPalindrom(String str){

        for (int i=0;i<str.length()/2;i++){
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;

    }

    static String longStringCreator(String word, int iters){
        StringBuilder newStr= new StringBuilder();

        for (int i = 0; i < iters; i++) {
            newStr.append(word);
        }

        return newStr.toString()+"\n";
    }

    static void addingToFile(String filePath, String text){
        try {
            File myFile= new File(filePath);
            FileWriter writer = new FileWriter(myFile,true);

            writer.write(text);

            writer.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static String[] showCurrentFiles(String dirPath){
        File currentDir = new File(dirPath);
        return currentDir.list();
    }

    static void addListToFile(String filePath, String[] list) throws IOException {
        Logger logger = Logger.getLogger(Main.class.getName());
        FileHandler fh = new FileHandler("log.txt");

        logger.addHandler(fh);
        SimpleFormatter simple = new SimpleFormatter();
        fh.setFormatter(simple);

        try {
            File myFile = new File(filePath);
            FileWriter writer = new FileWriter(myFile);

            for (String str: list) writer.write(str+"\n");
            writer.close();

        } catch (Exception e){
            logger.warning(e.getMessage());
        }

    }
}