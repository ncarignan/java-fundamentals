/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basiclibrary;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class App {
    public static int[] roll(int count) {
       int[] results = new int[count];
        Random random = new Random();
       for(int i = 0; i < count; i++){
           results[i] = random.nextInt(6);
       }
       return results;
    }

    private static boolean containsDuplicates(int[] rolls){
        int i = 0;
        if(rolls.length > 6) return true;
        while(i < rolls.length){
            for(int j = i + 1; j < rolls.length; j++){
                if(rolls[i] == rolls[j]) return true;
            }
            i++;
        }
        return false;
    }

    private static float calculateAverage(int[] rolls){
        int total = 0;
        for(int roll : rolls){
            total  += roll;
        }
        return (float) total / rolls.length;
    }

    public static float calculateMinAverage(int[][] rolls){
        float min = Integer.MAX_VALUE;
        for(int[] arr : rolls){
            if(calculateAverage(arr) < min) min = calculateAverage(arr);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] manyRolls = roll(7);
        int[] oneRoll = roll(1);
        System.out.println("Many rolls " + Arrays.toString(manyRolls) + " has duplicates " + containsDuplicates(manyRolls) + ", average : " + calculateAverage(manyRolls));
        System.out.println("One Roll " + Arrays.toString(oneRoll) + " has duplicates " + containsDuplicates(oneRoll) + ", average : " + calculateAverage(oneRoll));
        int[][] weeklyMonthTemperatures = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };
        System.out.println(calculateMinAverage(weeklyMonthTemperatures));
    }

}
