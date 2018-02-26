package chater2.lsp2;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class Test {
    public static void main(String[] args) {
        f(new Square());
    }

    public static void f(Rectangle r) {
        r.setWidth(32);
    }

    public static void g(Rectangle r) {
        r.setWidth(5);
        r.setHeight(5);
        //assert (r.Area() == 20);
    }
}
