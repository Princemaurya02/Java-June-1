
import java.util.ArrayList;
public record arraylistex() {
    public static void main(String args[]) {

        //Classname Objectname = new Classname();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list2.add("Hello");

        System.out.println(list);
        System.out.println(list2);


        //get operation
        int element = list.get(2);
        System.out.println(element);


        //remove operation
        list.remove(2);
        System.out.println(list);

        //set operation
        list.set(3, 10);
        System.out.println(list);

        //contains operation
        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

    }
    
}
