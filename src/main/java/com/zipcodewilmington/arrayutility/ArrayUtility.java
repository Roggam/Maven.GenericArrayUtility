package com.zipcodewilmington.arrayutility;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<AnyType> {
    private AnyType[] inputArray;

    public ArrayUtility(AnyType[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(AnyType[] arrayToMerge, AnyType valueToEvaluate) {

        Integer countDuplicates = 0;

        for (AnyType value : mergeTwoArrays(arrayToMerge)) {
            if (value == valueToEvaluate) {
                countDuplicates++;
            }
        }
        return countDuplicates;
    }

    public AnyType getMostCommonFromMerge(AnyType[] arrayToMerge) {
        Map<AnyType, Integer> map = new HashMap();

        for (AnyType value : mergeTwoArrays(arrayToMerge)) {
            Integer count = map.get(value);
            map.put(value, count != null ? count + 1 : 1);
        }

        return Collections.max(map.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }


    public AnyType[] mergeTwoArrays(AnyType[] arrayToMerge) {
        Integer count = 0;
        AnyType[] mergedArray = (AnyType[]) new Object[this.inputArray.length + arrayToMerge.length];

        for (int i = 0; i < inputArray.length; i++) {
            mergedArray[i] = inputArray[i];
            count++;
        }
        for (int j = 0; j < arrayToMerge.length; j++) {
            mergedArray[count++] = arrayToMerge[j];
        }
        return mergedArray;
    }
}
