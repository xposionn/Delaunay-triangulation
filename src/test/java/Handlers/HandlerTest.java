package Handlers;

import org.junit.Assert;

import static org.junit.Assert.*;

public class HandlerTest {

    @org.junit.Test
    public void determinant3() {
        int[] r1 = {1,2,3};
        int[] r2 = {3,4,5};
        int[] r3 = {2,1,5};

        Assert.assertEquals(-10,Handler.determinant3(r1,r2,r3));
        Assert.assertEquals(0,Handler.determinant3(r1,r2,r1));


    }
}