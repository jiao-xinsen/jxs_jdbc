package test;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lianjie lj = new lianjie();

        shiti st = new shiti();
        System.out.println("书名");
        st.setName(sc.next());
        System.out.println("作者");
        st.setAuthor(sc.next());
        System.out.println("价格");
        st.setPrices(sc.nextDouble());
 //       lj.add(st);
   //  lj.update(st);
//        st.setId(sc.nextInt());
//        lj.delet(st);
//        System.out.println("输入id");
//        st.setId(sc.nextInt());
   lj.select(st);
    }
}
