import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ChainingTest {

    @Test
    void insertKey() {
        Chaining c = new Chaining(5,5,5);
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        c.insertKey(44);
        hm.put(44,44);
        c.insertKey(46);
        hm.put(46,46);
        c.insertKey(1);
        c.insertKey(5);


    }

    @Test
    void insertKeyArray() {
    }
}