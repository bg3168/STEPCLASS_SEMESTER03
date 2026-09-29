import java.util.*;

abstract class Question {
    String correct, student;
    double points;

    Question(String c, String s, double p) {
        correct = c;
        student = s;
        points = p;
    }

    abstract double score();
}

class MCQ extends Question {
    MCQ(String c, String s, double p) {
        super(c, s, p);
    }

    double score() {
        return correct.equals(student) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String s, double p) {
        super(c, s, p);
    }

    double score() {
        return correct.equals(student) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String s, double p) {
        super(c, s, p);
    }

    double score() {
        String[] words = correct.split(",");
        int count = 0;

        for (String word : words) {
            if (student.toLowerCase().contains(word.trim().toLowerCase()))
                count++;
        }

        if (count >= 2)
            return points * 0.75;
        if (count == 1)
            return points * 0.50;

        return 0;
    }
}

public class Main {

    static String[] getParts(String line) {
        ArrayList<String> list = new ArrayList<>();
        java.util.regex.Matcher m =
            java.util.regex.Pattern.compile("\"([^\"]*)\"").matcher(line);

        while (m.find())
            list.add(m.group(1));

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String type = line.substring(0, line.indexOf(" "));

            String[] p = getParts(line);

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(p[1], p[2], Double.parseDouble(p[3]));
            else if (type.equals("TF"))
                q = new TF(p[1], p[2], Double.parseDouble(p[3]));
            else
                q = new Essay(p[1], p[2], Double.parseDouble(p[3]));

            double score = q.score();
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}