package mikhailov;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Создаем ArrayList из случайных чисел
        List<Integer> randomNumberList = generateArrayList(10, 5);
        System.out.println("ArrayList из случайных чисел: " + randomNumberList + " имеет длину " + randomNumberList.size());

        //Используем созданный ArrayList для создания HashSet
        Set<Integer> numberSet = new HashSet<>(randomNumberList);
        System.out.println("HeshSet созданный из этого ArrayList: " + numberSet + " имеет длину " + numberSet.size() +
                " и получится короче, поскольку содержит только уникальные значения");

        System.out.println();

        List<Integer> consecutiveArrayList = generateConsecutiveArrayList(10);
        System.out.println("ArrayList представляющий последовательность целых чисел: " + consecutiveArrayList);
        Set<Integer> consecutiveSet = new HashSet<>(consecutiveArrayList);
        System.out.println("HeshSet созданный из этого оследовательного ArrayList: " + consecutiveSet);
        System.out.println("Увеличим количество элементов ");

        //Операции на больших коллекциях с замером времени
        final int LENGTH = 50000000;
        System.out.println("BigArrayList (length " + LENGTH + "): ");
        List<Integer> bigConsecutiveArrayList = generateConsecutiveArrayList(LENGTH);
        long startTime = System.currentTimeMillis();

        int numberToFind = LENGTH - 1;
        int count = 0;
        for(Integer elem : bigConsecutiveArrayList){
            count += 1;
            if (elem == numberToFind){
                System.out.println("number " + numberToFind + " is found after " + count + " iterations");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time spend: " + (endTime - startTime));


        System.out.println("BigHashSet (length " + LENGTH + "): ");
        Set<Integer> bigConsecutiveHashSet = new HashSet<>(bigConsecutiveArrayList);
        startTime = System.currentTimeMillis();

        numberToFind = LENGTH - 1;
        count = 0;
        for(Integer elem : bigConsecutiveHashSet){
            count += 1;
            if (elem == numberToFind){
                System.out.println("number " + numberToFind + " is found after " + count + " iterations");
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time spend: " + (endTime - startTime));


        System.out.println("Вставим элемент в середину ArrayList");
        startTime = System.currentTimeMillis();
        bigConsecutiveArrayList.add(0, LENGTH + 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time spend: " + (endTime - startTime));

        System.out.println("Добавим элемент в HashSet");
        startTime = System.currentTimeMillis();
        bigConsecutiveHashSet.add(LENGTH + 1);
        endTime = System.currentTimeMillis();
        System.out.println("Time spend: " + (endTime - startTime));
    }

    static List<Integer> generateArrayList (int size, int maxValue){
        List<Integer> myArrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++){
            myArrayList.add(random.nextInt(0, maxValue + 1));
        }
        return myArrayList;
    }

    static List<Integer> generateConsecutiveArrayList (int max){
        List<Integer> myArrayList = new ArrayList<>();
        int temp = 0;
        while (temp < max){
            myArrayList.add(++temp);
        }
        return myArrayList;
    }
}