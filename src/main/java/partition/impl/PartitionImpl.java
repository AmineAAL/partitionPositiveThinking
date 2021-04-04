package partition.impl;

import partition.IPartition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionImpl implements IPartition {


    @Override
    public List<List> partition(List liste, int taille) {
        List<List> result = new ArrayList<>();
        List processedList = new ArrayList(liste);

        if(taille == 0 ||  liste == null || liste.isEmpty()){
            throw new RuntimeException("la taille ne peut pas etre nulle");
        } else if(taille > processedList.size()) {
            result.add(processedList);
        } else{
            while (processedList.size() > 0) {
                List<Integer> iter = takeFirstTaille(processedList, taille);
                processedList.removeIf(e -> iter.contains(e));
                result.add(iter);

            }
        }
        return result;
    }

    private List takeFirstTaille(List liste, int taille) {
        return IntStream.range(0, liste.size())
                .filter(i -> i < taille)
                .mapToObj(i -> liste.get(i))
                .collect(Collectors.toList());
    }
}
