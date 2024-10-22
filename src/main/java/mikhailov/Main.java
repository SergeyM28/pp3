package mikhailov;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Создаем ArrayList из случайных чисел
        List<Integer> randomNumberList = generateArrayList(10, 5);
        System.out.println("ArrayList из случайных чисел: " + randomNumberList + " имеет длину " + randomNumberList.size());

        //Используем созданный ArrayList для создания HashSet
        Set<Integer> numberSet = new HashSet<>(randomNumberList);
        System.out.println("HashSet созданный из этого ArrayList: " + numberSet + " имеет длину " + numberSet.size() +
                " и получится короче, поскольку содержит только уникальные значения");

        System.out.println();

        List<Integer> consecutiveArrayList = generateConsecutiveArrayList(10);
        System.out.println("ArrayList представляющий последовательность целых чисел: " + consecutiveArrayList);
        Set<Integer> consecutiveSet = new HashSet<>(consecutiveArrayList);
        System.out.println("HashSet созданный из этого оследовательного ArrayList: " + consecutiveSet);
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

        //Sorted Set
        List<Integer> randomArrayList = generateRandomArrayList(30, 100);
        System.out.println("\nСоздадим ArrayList со случайными целыми числами: " + randomArrayList);

        Set<Integer> tempHashList = new HashSet<>(randomArrayList);
        System.out.println("Создадим из него HashSet: " + tempHashList);
        Set<Integer> tempTreeSet = new TreeSet<>(tempHashList);
        System.out.println("Создадим из него TreeSet: " + tempTreeSet);

        System.out.println("Повторим то же самое, но на большом объеме данных с замером времени");

        List<Integer> randomBigArrayList = generateRandomArrayList(LENGTH/10, LENGTH/10);
        System.out.println("\nСоздадим ArrayList со случайными целыми числами длиной " + LENGTH/10);
        System.out.println("Создадим из него HashSet");
        startTime = System.currentTimeMillis();
        Set<Integer> bigTempHashList = new HashSet<>(randomBigArrayList);
        endTime = System.currentTimeMillis();
        System.out.println("Time spend: " + (endTime - startTime));

        System.out.println("Создадим из него TreeSet");
        startTime = System.currentTimeMillis();
        Set<Integer> bigTempTreeSet = new TreeSet<>(randomBigArrayList);
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

    static List<Integer> generateRandomArrayList (int size, int maxValue){
        List<Integer> myArrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++){
            myArrayList.add(random.nextInt(0, maxValue + 1));
        }
        return myArrayList;
    }
}