import java.util.Scanner;

public class ConvertIntToWords {
//    public static String conversion(int num) {
//        String[] ones = {"", "One", "Two", "Three", "Four", "Five",
//                "Six", "Seven", "Eight", "Nine", "Ten",
//                "Eleven", "Twelve", "Thirteen", "Fourteen",
//                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//        String[] tens = {"","Ten", "Twenty", "Thirty", "Forty",
//                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//        if(num <= 0)
//            return "zero";
//        else if(num < 20)
//            return ones[num];
//        else if (num < 100)
//            return tens[num/10]+((num%10 == 0) ? "": " ")+ones[num%10];
//        else if (num < 1000)
//            return ones[num/100]+" Hundred"+((num%100 == 0) ? "":" and ")+conversion(num%100);
//        else if (num < 100000)
//            return conversion(num/1000)+" Thousand"+((num%1000 == 0) ? "" : " ")+conversion(num%1000);
//       return "Cannot do more than this range";
//    }


        public static String conversion(int num) {
            if (num <= 0) {
                return "Zero";
            }
            return convertor(num);
        }

        private static String convertor(int num) {
            String[] ones = {"", "One", "Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                    "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                    "Seventeen", "Eighteen", "Nineteen"};

            String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty",
                    "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

            String result;

            // cases for up to 90
            switch (num) {
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19:
                    result = ones[num];
                    break;
                case 20, 30, 40, 50, 60, 70, 80, 90:
                    result = tens[num / 10];
                    break;
                default: // numbers more than 90
                    if (num < 100) { // up to 99
                        result = tens[num / 10] + ((num % 10 == 0) ? "" : " " + ones[num % 10]);
                    }
                    else if (num < 1000) { // up to 999
                        result = ones[num / 100] + " Hundred" + ((num % 100 == 0) ? "" : " and " + convertor(num % 100));
                    }
                    else if (num < 100000) { //up to 99999
                        result = convertor(num / 1000) + " Thousand" + ((num % 1000 == 0) ? "" : " " + convertor(num % 1000));
                    }
                    else {
                        result = "Cannot do more than this range";
                    }
                    break;
            }
            return result;
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        System.out.println(conversion(num));
    }
}
