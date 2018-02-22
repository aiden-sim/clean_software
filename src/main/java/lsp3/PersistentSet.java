package lsp3;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class PersistentSet extends Set {
    public void add(Object o) {
        /*
        if(o instanceof PersistentObject) {
            PersistentObject p = (PersistentObject)o;
            itsThirdPartyPersistentSet.Add(p);
        }else {
            throw new Exception();
        }*/
    }

    public void delete(Object o) {

    }

    public boolean isMember(Object o) {
        return false;
    }
}
