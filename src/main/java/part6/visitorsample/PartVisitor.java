package part6.visitorsample;

/**
 * Created by simjunbo on 2018-04-19.
 */
public interface PartVisitor {
    public void visit(PiecePart pp);

    public void visit(Assembly a);
}
