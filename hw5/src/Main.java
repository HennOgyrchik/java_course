import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут
повторяющиеся имена с разными телефонами, их необходимо считать,
как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов.
 */
        Map<String, LinkedList<String>> contacts = new HashMap<>();
        Scanner input = new Scanner(System.in);

        while (true){
            showMenu();
            switch (input.nextLine()){
                case "1":
                    showContacts(contacts);
                    break;
                case "2":
                    addContact(contacts,input);
                    break;
                case "3":
                    deleteContact(contacts,input);
                    break;
                case "4":
                    input.close();
                    return;
            }
        }

        }

    private static void deleteContact(Map<String, LinkedList<String>> contacts, Scanner input) {
        System.out.print("Введите имя:\n");
        String name = input.nextLine();

        if (contacts.containsKey(name)){
            contacts.remove(name);
        }else {
            System.out.println("Такой контакт не найден!");
        }

    }

    private static void addContact(Map<String, LinkedList<String>> contacts, Scanner input) {
        System.out.print("Введите имя:\n");
        String name = input.nextLine();

        System.out.print("Введите телефон:\n");
        String number = input.nextLine();

        if (contacts.containsKey(name)){
            contacts.get(name).add(number);
        }else{
            contacts.put(name,new LinkedList<>());
            contacts.get(name).add(number);
        }
    }

    private static void showContacts(Map<String, LinkedList<String>> contacts) {
        if (contacts.size()<1) {
            System.out.println("Список контактов пуст");
            return;
        }

        String[][] sorted = new String[contacts.size()][2];
        int i=0;
        for (String contact :
                contacts.keySet()) {
            sorted[i][0]= contact;
            sorted[i][1]= Integer.toString(contacts.get(contact).size());
            i++;
        }

        bubbleSort(sorted);

        for (int j = 0; j < contacts.size(); j++) {

            System.out.println(sorted[j][0]+": "+contacts.get(sorted[j][0]));
        }
    }

    static void bubbleSort(String[][] array) {

        boolean sorted = false;
        String[] temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (  Integer.parseInt(array[i][1])   < Integer.parseInt(array[i+1][1]) ) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }


    static void showMenu(){
        System.out.printf(
                "1) Показать все контакты\n" +
                "2) Добавить новый контакт\n" +
                "3) Удалить контакт\n" +
                "4) Выход\n"+
                "Выберите пункт меню:");
        }


}