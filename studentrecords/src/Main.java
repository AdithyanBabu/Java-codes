import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;


class Main {

    static int studentNumber = 2;
    static int numberOfSubjects = 3;
    static List<Integer>[] marks = new ArrayList[studentNumber];        //marks in the list of arrays and 2 is the no:of students
    static String[] names = new String[studentNumber];      //to store the names of the students
    static int[] id = new int[studentNumber];       //to store the id

    //path declaration for dir student details
    static File dir = new File("/home/sfm/IdeaProjects/studentrecords/src/studentdetails");

    //Writing into the file
    static void initialFileWriter(int num, LocalDate dob) {

        String filePath = dir.getPath() + "/" + (num + 1) + ".txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write("Name: " + names[num] + "\n");
            bw.write("id: " + id[num] + "\n");
            bw.write("dob: " + dob + "\n");
            bw.write("Marks:\t\t|Maths\tScience\tSocial\t|\n\t\t\t|");

            for (int i = 0; i < numberOfSubjects; i++) {    //to write the marks of each student to
                int m = marks[num].get(i);
                bw.write(m + "\t\t");
            }
            bw.write("|\n");
            bw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //to validate the name
    static String validName() {

        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        ;
        boolean isValid = true;     //to validate the name string
        while (isValid) {
            isValid = !(name.matches("[a-zA-Z\\s]+") && !name.isEmpty());
            if (isValid) {
                System.out.println("Enter a valid name");
            }
        }
        return name;
    }

    //to validate the date-of-birth
    static LocalDate validDob() {

        Scanner sc = new Scanner(System.in);
        boolean isValid = true;
        LocalDate dob = null;
        while (isValid) {
            try {
                String dobString = sc.next();
                DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dob = LocalDate.parse(dobString, form);
                isValid = false;
            } catch (Exception e) {
                isValid = true;
                System.out.println("Enter a valid date (yyyy-mm-dd)");
            }
        }
        return dob;
    }

    static int validId() {
        Scanner sc = new Scanner(System.in);
        boolean isId = true;
        int identity = 0;

        while (isId) {
            identity = sc.nextInt();

            if (identity > 0) {     // Check if the input ID is positive
                boolean isValid = true;

                for (int i = 0; i < id.length; i++) {       // Reset the index to 0 to check against all previously entered IDs
                    if (identity == id[i]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    isId = false;       // ID is valid, exit the loop
                } else {
                    System.out.println("ID already exists. Enter another ID.");
                }
            } else {
                System.out.println("ID must be a positive integer. Enter another ID.");
            }
        }
        return identity;        // Return the valid ID
    }


    //Reading the student details from user
    static void student(int num) {

        Scanner sc = new Scanner(System.in);
        String dobString;
        System.out.println("Enter the details of " + (num + 1) + " student");

        System.out.print("Enter Student Id: ");
        id[num] = validId();

        System.out.print("Enter Student name: ");
        names[num] = validName();     // to read only  the valid names

        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        LocalDate dob = validDob();     // to read only the valid dob

        System.out.print("Enter marks (3 subs upto 100): ");
        for (int i = 0; i < numberOfSubjects; i++) {
            int m = sc.nextInt();
            if (m >= 0 && m <= 100) {
                marks[num].add(m);
            } else {
                System.out.print("Enter the mark again: ");
                i--;
            }

        }
        initialFileWriter(num, dob);
    }

    //Performance of students and aggragte based on their score
    public static void studentPerformance(int num) {

        float avg;
        int total = 0;
        String status;
        String filePath = dir.getPath() + "/" + (num + 1) + ".txt";

        for (int i = 0; i < marks[num].size(); i++) {
            total += marks[num].get(i);
        }
        avg = (float) total / numberOfSubjects;
        if (avg >= 45.0) {
            status = "Pass";
        } else {
            status = "Fail";
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
            bw.write("Total Score: " + total + "\n");
            bw.write("Average: " + avg + "\n");
            bw.write("Status: " + status + "\n");
            bw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    //to get the highest and lowest of each subject and printing it to the console
    static void highestLowest() {

        for (int i = 0; i < numberOfSubjects; i++) {
            int highestScore = 0;
            int lowestScore = 100;
            for (int j = 0; j < marks.length; j++) {    //iterating each subjects

                if (highestScore < marks[j].get(i)) {     //to find the highest score
                    highestScore = marks[j].get(i);
                }
                if (lowestScore > marks[j].get(i)) {      //to fnd the lowest score
                    lowestScore = marks[j].get(i);
                }
            }
            System.out.println("Highest score in subject " + (i + 1) + " is: " + highestScore);
            System.out.println("Lowest score in subject" + (i + 1) + " is: " + lowestScore + "\n");
        }
    }

    static void rank() {

        String filePath;
        String students;
        double[] average = new double[2];

        //to get the average of each student from the file and storing it into a double array
        for (int i = 0; i < 2; i++) {
            filePath = dir.getPath() + "/" + (i + 1) + ".txt";
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                while ((students = br.readLine()) != null) {
                    if (students.startsWith("Average:")) {
                        String[] part = students.split("\\s+");
                        average[i] = Double.parseDouble(part[1]);
                    }
                }
            } catch (Exception e) {
                System.out.println("file not found");
            }
        }

        //sorting the array of average
        double tmp;
        for (int i = 0; i < average.length; ++i) {
            for (int j = 0; j < average.length-i-1; j++) {
                if(average[j+1] < average[j]) {
                    tmp = average[j];
                    average[j] = average[j+1];
                    average[j+1] = tmp;
                }
            }
        }
    }

    //bubble sort
    static void bubbleSort(int[] arr){
        int tmp;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j+1] < arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    //printing the files into console
    static void print(int fileNo) {
        String students;
        String filePath;
        for (int i = 0; i < 2; i++) {
            filePath = dir.getPath() + "/" + (i + 1) + ".txt";
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                while ((students = br.readLine()) != null) {
                    System.out.println(students);
                }
            } catch (Exception e) {
                System.out.println("file not found");
            }
            System.out.println();
        }

    }

    //main function
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            marks[i] = new ArrayList<>();
        }
        for (int i = 0; i < 2; i++) {
            student(i);
            studentPerformance(i);
        }
        rank();
        //Menu driven for sorting
//        do{
//            System.out.println("OPERATIONS\n\n" +
//                    "Find the highest and lowest score in each Subject\n" +
//                    "Ranking the students based on performance\n" +
//                    "Sorting");
//            int a = sc.nextInt();
//            switch (a){
//                case 1:
//                    highestLowest();
//                    break;
//                case 2:
//                    rank();
//
//            }
//        }while (true);
    }
}