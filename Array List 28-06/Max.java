import java.util.ArrayList;
public class Max {
    public static void main(String args[]) {

        //Classname Objectname = new Classname();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list.add(3);
        list.add(5);
        list.add(2);
        list.add(9);
        list.add(6);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<list.size(); i++) {
            if(max < list.get(i)) {
                max = list.get(i);
            }
        }

        System.out.println("Maxsimum value : " + max);
    }
        }

