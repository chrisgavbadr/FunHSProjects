/* Admit.java
 *
 * Christian Baduria, Java 2017
 * Ch 4 Project (Admissions), 11/30/17
 *
 * This program evaluates and compares the scores of two
 * applicants. The applicant records either their SAT or
 * ACT scores and the final exam score is calculated. The
 * GPA and Transcript Multiplier are also recorded and the
 * final GPA score is calculated. Their overall score is
 * then evaluated as the sum of the two scores and the
 * smarter applicant is determined.
 */

import java.util.Scanner;

public class Admit {
    // Introduces program, records applicant info, and displays final results
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double applicant1OverallScore = 0;
        double applicant2OverallScore = 0;

        introduceAdmit();

        applicant1OverallScore = recordApplicantInfo(console, 1);
        applicant2OverallScore = recordApplicantInfo(console, 2);

        displayResults(applicant1OverallScore, applicant2OverallScore);
    }

    // Introduces program
    public static void introduceAdmit() {
        System.out.println("This program compares two applicants to");
        System.out.println("determine which one seems like the stronger");
        System.out.println("applicant.  For each candidate I will need");
        System.out.println("either SAT or ACT scores plus a weighted GPA.");
    }

    // Records each applicant's information
    public static double recordApplicantInfo(Scanner console, int applicantNumber) {
        double examScore = 0;
        System.out.println("\nInformation for applicant #" + applicantNumber + ":");
        System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
        int testType = console.nextInt();

        if (testType == 1) {
            examScore = recordSAT(console);
        } else {
            examScore = recordACT(console);
        }
        double gpaScore = recordGPA(console);

        return (examScore + gpaScore);
    }

    // Records SAT scores for each subject, then calculates final SAT score
    public static double recordSAT(Scanner console) {
        System.out.print("    SAT math? ");
        int mathScore = console.nextInt();
        System.out.print("    SAT critical reading? ");
        int readingScore = console.nextInt();
        System.out.print("    SAT writing? ");
        int writingScore = console.nextInt();

        double satScore = (2 * mathScore + readingScore + writingScore) / 32.0;
        System.out.printf("    exam score = %.1f\n", satScore);

        return satScore;
    }

    // Records ACT scores for each subject, then calculates final ACT score
    public static double recordACT(Scanner console) {
        System.out.print("    ACT English? ");
        int englishScore = console.nextInt();
        System.out.print("    ACT math? ");
        int mathScore = console.nextInt();
        System.out.print("    ACT reading? ");
        int readingScore = console.nextInt();
        System.out.print("    ACT science? ");
        int scienceScore = console.nextInt();

        double actScore = (englishScore + 2 * mathScore + readingScore + scienceScore) / 1.8;
        System.out.printf("    exam score = %.1f\n", actScore);

        return actScore;
    }

    // Records GPA and Transcript Multiplier, then calculates final GPA score
    public static double recordGPA(Scanner console) {
        System.out.print("    overall GPA? ");
        double overallGPA = console.nextDouble();
        System.out.print("    max GPA? ");
        double maxGPA = console.nextDouble();
        System.out.print("    Transcript Multiplier? ");
        double transcriptMultiplier = console.nextDouble();

        double gpaScore = (overallGPA / maxGPA) * 100 * transcriptMultiplier;
        System.out.printf("    GPA score = %.1f\n", gpaScore);

        return gpaScore;
    }

    // Displays final results of the applicants
    public static void displayResults(double applicant1OverallScore, double applicant2OverallScore) {
        System.out.printf("\nFirst applicant overall score  = %.1f\n", applicant1OverallScore);
        System.out.printf("Second applicant overall score = %.1f\n", applicant2OverallScore);

        if (applicant1OverallScore > applicant2OverallScore) {
            System.out.println("The first applicant seems to be better");
        } else if (applicant1OverallScore < applicant2OverallScore) {
            System.out.println("The second applicant seems to be better");
        } else {
            System.out.println("The two applicants seem to be equal");
        }
    }
}