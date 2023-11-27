package arrayList;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList<>();
        array.addElement(5);
        array.addElement(7);
        array.addElement(12);
        array.addElement(38);
        array.addElement(14);
        array.addElement(152);
        array.addElement(13);
        array.addElement(3);
        array.addElement(18);
        array.addElement(55);
        array.addElementIndex(3, 45);
        array.removeElementIndex(7);
        System.out.println(array);
        array.sort();
        System.out.println(array);
        array.getElement(5);
        array.clearArrayList();
    }
}
