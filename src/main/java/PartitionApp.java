import partition.IPartition;
import partition.impl.PartitionImpl;

import java.util.Arrays;
import java.util.List;

public class PartitionApp {


    public static void main(String[] args) {
        List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
        IPartition librairie = new PartitionImpl();
        System.out.println(librairie.partition(liste, 2));
    }


}
