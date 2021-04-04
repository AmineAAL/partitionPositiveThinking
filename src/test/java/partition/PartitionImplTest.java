package partition;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import partition.impl.PartitionImpl;

import java.util.Arrays;

public class PartitionImplTest {

    IPartition service;


    @Before
    public void before_each_test() {
        service = new PartitionImpl();
    }


    @Test
    public void partirion_test() {
        Assert.assertEquals(3, service.partition(Arrays.asList(1, 2, 3, 4, 5), 2).size());
        Assert.assertEquals(2, service.partition(Arrays.asList(1, 2, 3, 4, 5), 3).size());
        Assert.assertEquals(5, service.partition(Arrays.asList(1, 2, 3, 4, 5), 1).size());
        Assert.assertEquals(1, service.partition(Arrays.asList(1, 2, 3, 4, 5), 100).size());
    }

    @Test(expected = RuntimeException.class)
    public void taille_nulle_partition() {
        service.partition(Arrays.asList(1, 2, 3, 4, 5), 0);
    }

    @Test(expected = RuntimeException.class)
    public void liste_vide_partition() {
        service.partition(Arrays.asList(), 6);
    }

    @Test(expected = RuntimeException.class)
    public void liste_null_partition() {
        service.partition(null, 6);
    }
}
