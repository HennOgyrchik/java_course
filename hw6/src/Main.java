import java.lang.management.ThreadInfo;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cat vasya= new Cat();
        vasya.name="Васька";
        vasya.breed="Невская маскарадная";
        vasya.color="сил пойнт";
        vasya.owner="Петя";
        vasya.gender="female";
        vasya.age=2;
        vasya.weight=2.5;
        vasya.awards.add("Самый красивый кот");
        vasya.awards.add("Самый лучший кот");
        vasya.awards.add("Мисс вселенная 2023");


        vasya.showInfo();
        System.out.printf("Кот %s допущен к участию: %b\n", vasya.name,vasya.checkAdmission());
        vasya.photo();
        vasya.addAward("Милашка года 2023");
        vasya.feed(0.5);
        vasya.disqualification();
        System.out.printf("Кот %s допущен к участию: %b\n", vasya.name,vasya.checkAdmission());

        Cat murzik = new Cat();
        murzik.name="Мурзик";
        murzik.breed="Сиамская";
        murzik.color="Стандартный";
        murzik.owner="Люся";
        murzik.gender="male";
        murzik.age=5;
        murzik.weight=7.0;
        murzik.awards.add("Пышечка-пухляшечка <3");

        murzik.showInfo();



    }
}

class Cat {
    String breed;
    String color;
    String name;
    String owner;
    String gender;
    int age;
    Double weight;
    LinkedList<String> awards = new LinkedList<>();
    Boolean disqualification = false;

    void disqualification(){
        this.disqualification=true;
        System.out.println(this.name+" дисквалифицирован!");
    }

    boolean checkAdmission(){
        if (this.breed.equals("Невская маскарадная")&&this.disqualification==false)
            return true;
        else return false;

    }

    void photo(){
        System.out.println("Фото_кота_"+this.name+".png");
    }

    void addAward (String award){
        this.awards.add(award);
        System.out.println("Награда добавлена! Текущие награды: "+this.awards);
    }

    void feed (double mass){
        this.weight+=mass;
        System.out.printf("Кот %s успешно покормлен! Текущий вес кота %.2f кг\n",this.name, this.weight);
    }

    public void showInfo() {
        System.out.printf("1) Кличка: %s\n" +
                "2) Порода: %s\n" +
                "3) Окрас: %s\n" +
                "4) Возраст: %d\n" +
                "5) Пол: %s\n" +
                "6) Вес: %.2f\n" +
                "7) Владелец: %s\n" +
                "8) Награды: %s\n" +
                "9) Дисквалифицирован: %b\n", this.name,this.breed,this.color, this.age,this.gender,this.weight,this.owner,this.awards,this.disqualification);
    }
}