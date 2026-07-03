public class sorting {
    public static void swap(ArrayList<Integer> list, int idx1, int idex2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idex2));
        list.set(idex2, temp);
    }
    
}
