

public class a {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 0, 0, 3, 2, 1, 3, 0, 3};
        getElement(a);

    }

    private static void getElement(int[] a) {
        int b = 0,max=0;
        for (int i = 0; i<a.length-1;i++){
            for (int j = i+1; j<a.length-1;j++){
                if (a[i]==a[j]){
                        b++;
                }
            }
            if (b>max){
                max = b;
            }
        }
        System.out.println(max);
    }

}
