package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrays{

    private static <T> boolean compareArrays(ArrayList<? extends T> src, ArrayList<? extends T> dst){
        if (!isSameSize(src, dst)){return false;}
        if (!isSameType(src, dst)) {return false;}
        for (int i = 0; i < src.size(); i++) {
            if (src.get(i) != dst.get(i)){
                return false;
            }
        }
        return true;
    }

    private static <T> boolean isSameType(ArrayList<? extends T> src, ArrayList<? extends T> dst) {
        if (src.getClass().getSimpleName() == dst.getClass().getSimpleName()){
            return true;
        }
        return false;
    }

    private static <T> boolean isSameSize(ArrayList<? extends T> src, ArrayList<? extends T> dst) {
        if (src.size() == dst.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arraySource = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> arrayListDst = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> arrayListDst1 = new ArrayList<>(Arrays.asList(2,2,3,4,5));
        ArrayList<String> arrayListDst2 = new ArrayList<>(Arrays.asList("One","2","3","4","5"));
        ArrayList<Integer> arrayListDst3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(compareArrays(arraySource, arrayListDst));
        System.out.println(compareArrays(arraySource, arrayListDst1));
        System.out.println(compareArrays(arraySource, arrayListDst2));
        System.out.println(compareArrays(arraySource, arrayListDst3));
        ArrayList<String> arrayListString = new ArrayList<>(Arrays.asList("One","2","3","4","5"));
        System.out.println(compareArrays(arrayListString, arrayListDst2));

    }

}
