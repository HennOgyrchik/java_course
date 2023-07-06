import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
       /* Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
        1) Умножьте два числа и верните произведение в виде связанного списка.*/

        Deque<Integer> a= createDeque(12);
        Deque<Integer> b= createDeque(1);

        System.out.println(multiplication(a,b));

        /* 2) Сложите два числа и верните сумму в виде связанного списка. Одно или два числа должны быть отрицательными.*/
        Deque<Integer> x= createDeque(-532);
        Deque<Integer> y= createDeque(123);

        System.out.println(sum(x,y));


    }

    static LinkedList<Integer> sum(Deque<Integer> a, Deque<Integer> b) {
        int sum=0;
        int signX=a.getLast()/ Math.abs(a.getLast());
        int signY=b.getLast()/ Math.abs(b.getLast());

        if (a.size()>=b.size()){
            for (int i = 0; i <= a.size()-b.size(); i++) {
                b.addLast(0);
            }

        }else {
            for (int i = 0; i <= b.size()-a.size(); i++) {
                a.addLast(0);
            }
        }

        int  i=0;
        while (!a.isEmpty()){
            int x= a.pollFirst()*(int) Math.pow(10,i);
            int y= b.pollFirst()*(int) Math.pow(10,i);

            sum+=(Math.abs(x)*signX)+(Math.abs(y)*signY);
            i++;
        }

        return linkedRes(sum);
    }

    static LinkedList<Integer> multiplication(Deque<Integer> a, Deque<Integer> b){

        int mult=0;
        int i=0;

        for (int x :a) {
            int j=0;
            for (int y :b) {
                mult+=(x* (int) Math.pow(10,i))*(y*(int)Math.pow(10,j));
                j++;
            }
            i++;
        }

        return linkedRes(mult);
    }

    static Deque<Integer> createDeque (int x){
        Deque<Integer> a = new LinkedList<>();
        while (x!=0){
            a.add(x%10);
            x/=10;
        }

        return a;
    }

    static LinkedList<Integer> linkedRes (int x){
        LinkedList<Integer> res = new LinkedList<>();

        while (x!=0){
            if (x<10 &&x>-10){
                res.addFirst(x%10);
            } else {
                res.addFirst(Math.abs(x)%10);
            }

            x/=10;
        }

        return res;
    }

}