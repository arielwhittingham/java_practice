package leetcode.q2_rewardtopkstudents;
import java.util.*;
/*
https://leetcode.com/problems/reward-top-k-students/
https://www.youtube.com/watch?v=SzzSwvQfKyk
https://mkyong.com/java8/java-8-lambda-comparator-example/ ---SORT with/without lambda
*/

import java.util.List;

class compareFeedback implements Comparator<int[]> {

    public int compare(int[] a, int[] b) {

        if (a[1] == b[1]) {
            return a[0] -  b[0];

        }
        else {
            return b[1] - a[1];
        }
    }
};

public class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {



        // positive_feedback = ["smart","brilliant","studious"],
        // negative_feedback = ["not"],
        // report = ["this student is studious","the student is smart"],
        // student_id = [1,2], k = 2

        //make a map for each student to store points

        List<String> lpositive_feedback = Arrays.asList(positive_feedback);
        List<String> lnegative_feedback = Arrays.asList(negative_feedback);

        List<int[]> points_array = new ArrayList<>();
        int ll = student_id.length;
        for(int s = 0; s < ll; s++) {
            int id = student_id[s];
            String sentence = report[s];
            String[] words = sentence.split(" ");
            int val = 0;


            for(String wd : words) {
                if(lpositive_feedback.contains(wd)) {
                    val += 3;
                } else if (lnegative_feedback.contains(wd)) {
                    val -= 1;
                }
            }

            int[] i = new int[]{id,val};

            points_array.add(i);
        }

        points_array.sort( new compareFeedback());
        List<Integer> top = new ArrayList<Integer>();
        points_array = points_array.subList(0,k);



        for(int[] z: points_array) {

            top.add(z[0]);
        }

        return top;




    }

    public static void main(String[] args) {

        String[] positive_feedback = {"smart","brilliant","studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious","the student is smart"};
        int[] student_id = {1,2};
        int k = 2;

        Solution d = new Solution();
        d.topStudents(positive_feedback, negative_feedback, report, student_id, k);



    }
}