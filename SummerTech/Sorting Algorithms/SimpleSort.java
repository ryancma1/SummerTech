public class SimpleSort {
    public static void print(int [] list){
        for (int i = 0; i < 2; i++){
            System.out.print(list[i] + ", ");
        }
        System.out.println("");
    }
    public static void main (String [] args){
        int holder = 0;
        int [] list = new int[]{6,2};
        System.out.println("Start List: ");
        print(list);
        if (list[0] > list[1]){
            holder = list [0];
            list[0] = list[1];
            list[1] = holder;
        }
        System.out.println("End List: ");
        print(list);
    }
}