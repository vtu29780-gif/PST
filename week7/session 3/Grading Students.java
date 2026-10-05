import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> roundedGrades = new ArrayList<>();

        for (int grade : grades) {
            if (grade >= 38 && grade % 5 >= 3) {
                grade += 5 - (grade % 5);
            }
            roundedGrades.add(grade);
        }

        return roundedGrades;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine().trim());
        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            grades.add(Integer.parseInt(reader.readLine().trim()));
        }

        List<Integer> result = gradingStudents(grades);

        for (int grade : result) {
            System.out.println(grade);
        }
    }
}