import java.util.ArrayList;
public record AL() {
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

        System.out.println(list.size());
       
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        }
    }