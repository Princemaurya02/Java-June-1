import java.util.ArrayList;

public class sortandrotate {
    public static boolean pairsum2(ArrayList<Integer> list, int target){
        int n = list.size();   // size of the arraylist
        if(n == 0) {
            return false;
        }

        int bp = -1; // break point
        for(int i = 0; i < n - 1; i++){
            if(list.get(i) > list.get(i+1)){
                bp = i;  // break point found
                break;
            }
        }

        if(bp == -1){
            bp = n - 1;
        }

        int lp = (bp + 1) % n;  // smallest element index
        int rp = bp;   // largest element index

        while(lp != rp) {
            int sum = list.get(lp) + list.get(rp);
            if(sum == target){
                return true;
            }

            if(sum < target){
                lp = (lp + 1) % n;  // move to the next index in a circular manner
            } else {
                rp = (n + rp - 1) % n;  // move to the previous index in a circular manner
            }
        }

        return false;
    }

    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(12);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 150;
        System.out.println(pairsum2(list, target));
    }
}
