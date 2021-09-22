package _14_exception_and_debug.exercise.use_class_IllegalTriangleException;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] triangle;
        boolean flag = false;
        while(!flag){
            try{
                System.out.println("Nhập 3 cạnh tam giác");
                triangle = creatTriangle();
                System.out.println("triangle: " + Arrays.toString(triangle));
                flag = true;
            }
            catch (IllegalTriangleException e) {
                System.err.println("Xảy ra ngoại lệ: " + e.getMessage());
                System.err.println("Mời nhập lại" );
            }
        }
    }
    public static int[] creatTriangle() throws IllegalTriangleException{
        System.out.println("Enter a");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Enter b");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("Enter c");
        int c = Integer.parseInt(sc.nextLine());
        if(a<=0 || b <= 0 || c <=0){
            throw new IllegalTriangleException("Lỗi cạnh tam giác bé hơn 0");
        }
        else if(a+b<=c || b+c<=a || a+c<=b){
            throw new IllegalTriangleException("Lỗi tổng 2 cạnh tam giác không lớn hơn cạnh còn lại");
        }
        int[] triangle = {a,b,c};
        return triangle;
    }
}

