package Example;


import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {

    private ArrayList<Integer> arrayList;

    public ArrayCreator (int n) {

        arrayList = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }
    }

    public ArrayList<Integer> call () {
        return arrayList;
    }

}
