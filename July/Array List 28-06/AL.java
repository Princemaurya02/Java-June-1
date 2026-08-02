import java.util.ArrayList;

public record AL() {
    public static void main(String args[]) {

        //Classname Objectname = new Classname();
        ArrayList<Integer> list = new ArrayList<>();
       
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

       
       
       int idx1 = 1;
       int idx2 = 3;
       System.out.println(list);
       swap(list, idx1, idx2);
       System.out.println(list);
        }

    private static void swap(ArrayList<Integer> list, int i, int j) {
        Integer tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
    }