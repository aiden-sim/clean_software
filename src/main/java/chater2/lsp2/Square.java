package chater2.lsp2;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class Square extends Rectangle {

    Rectangle r = new Rectangle();

    @Override
    public void setWidth(double w) {
        r.setWidth(w);
        r.setHeight(w);
    }

    @Override
    public void setHeight(double h) {
        r.setWidth(h);
        r.setHeight(h);
    }
}
