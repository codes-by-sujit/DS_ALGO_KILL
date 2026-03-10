package greedy.level_6;

import java.util.Arrays;

public class LC_881_Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        //the goal is to create a pair with heaviest with thinest
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int count=0;
        while(i<=j){
            int weight=people[i]+people[j];
            if(weight<=limit){
                i++;
            }
            j--;
            count++;
        }
        return count;
    }
}
