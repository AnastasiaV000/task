package arrayList;

import java.util.Arrays;

public class MyArrayList<T> { // <T> тип элементов в массиве
    private int sizeOfArrayList = 0;
    private static final int CAPACITY = 15;
    private Object[] array = new Object[CAPACITY];

    /*
    метод добавляет элемент типа Т в конец массива,
    если массив заполнен, происходит увеличение его емкости в 2 раза,
    после добавления элемента размер массива увеличивается на 1
    */
    public void addElement(T element) {
        if (sizeOfArrayList >= array.length) {
            int capacity = CAPACITY * 2;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, sizeOfArrayList);
            array = newArray;
        }
        array[sizeOfArrayList] = element;
        sizeOfArrayList++;
    }

    /*
     * метод добавляет элемент типа Т по указанному в параметрах метода индексу,
     * если значение индекса соответвует условию: индекс должен быть меньше, чем длина массива - 1,
     * так как длина массива всегда больше на единицу, чем последнее значение индекса, потому что индекс начинается с 0,
     * в противном случае будет выдавать ошибку
     * если массив заполнен, то происходит увеличение его емкости в 2 раза
     * пробегаемся по массиву с его конца, пока индекс не будет равен индексу, пришедшему в параметрах метода, сдвигая элементы,
     * после чего добавляем (заменяем) элемент на позицию под этим индексом
     * и увеличиваем размер массива на 1 */
    public void addElementIndex(int index, T element) {
        if (index > array.length - 1) {
            throw new IllegalThreadStateException();
        }
        if (sizeOfArrayList > array.length) {
            int capacity = CAPACITY * 2;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, sizeOfArrayList);
            array = newArray;
        }
        for (int i = sizeOfArrayList; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        sizeOfArrayList++;
    }

    /*
     * метод удаляет элемент по заданному индексу,
     * если значение индекса соответвует условию: индекс должен быть меньше, чем длина массива - 1,
     * в противном случае будет выдавать ошибку
     * копируем часть массива, начиная с индекса следующего за индексом, элемент под которым мы хотим удалить,
     * и вставляем в новый массив с позиции под заданным индексом,
     * уменьшаем размер массива на 1 */
    public void removeElementIndex(int index) {
        if (index > array.length - 1) {
            throw new IllegalThreadStateException();
        }
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        array[sizeOfArrayList - 1] = null;
        sizeOfArrayList = sizeOfArrayList - 1;
    }

    /*
     * метод выводит элемент по заданному индексу,
     * если он отвечает условию: индекс должен быть меньше, чем длина массива - 1,
     * в противном случае будет выдавать ошибку */
    public void getElement(int index) {
        if (index > array.length - 1) {
            throw new IllegalThreadStateException();
        }
        System.out.println(array[index]);
    }

    /*
     * метод очищает всю коллекцию,
     * в результате все ячейки будут пустыми,
     * а размер будет равен 0 */
    public void clearArrayList() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        sizeOfArrayList = 0;
    }

    /* метод сортирует массив в порядке возрастания */
    public void sort() {

        Arrays.sort(array, 0, sizeOfArrayList);
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "sizeOfArrayList=" + sizeOfArrayList +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}


