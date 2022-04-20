package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean correct = false;
        double start = 0.0, monthly = 0.0, rate = 0.0, inflation = 0.0;
        int t = 0;

        while (!correct) {
            System.out.println("Starting amount:");
            start = scan.nextDouble();
            System.out.println("Monthly disposal:");
            monthly = scan.nextDouble();
            System.out.println("Interest rate(p.a. in %):");
            rate = scan.nextDouble();
            System.out.println("Inflation(p.a. in %):");
            inflation = scan.nextDouble();
            System.out.println("Years:");
            t = scan.nextInt();
            String startB = beautify(start);
            String monthlyB = beautify(monthly);
            System.out.println("Starting amount: " + startB + "€\nMonthly disposal: " + monthlyB + "€\nInterest rate: " + Math.round(rate)+ "%\nInflation: "+ Math.round(inflation)+"%\nYears: "+t);

            boolean answered = false;
            while (!answered) {
                System.out.println("Correct? (Y|N)");
                String ans = scan.next();
                ans = ans.toLowerCase();
                if (ans.equals("y")) {
                    answered = true;
                    correct = true;
                }
                if (ans.equals("n")) {
                    System.out.println("Sad! Then try again!");
                    answered = true;
                }
            }}

            System.out.println("Cool!");
            // A = P(1+(r/n))^(n*t)
            //double x = start * Math.pow((1+(rate/1)), (1*t));
            for(int i = 0; i < t; i++ ){
                start = (start + monthly*12)+((start + monthly*12)*(rate/100));
                System.out.println((i+1)+ ". Year: "+beautify(start)+"€");
            }

            inflation = (inflation/100)*t;
            double realValue = start - (start* inflation);

            String resultB = beautify(start);
            String realValueB = beautify(realValue);


            System.out.println("After "+t+" years you will have "+ resultB +"€ but it will be worth just like "+ realValueB+"€ today.");




    }

    public static String beautify(double num){
        int numInt = (int) num;
        String x = Integer.toString(numInt);
        if(x.length() > 3){
            x = new StringBuilder(x).insert(x.length()-3, ".").toString();
        }
        if(x.length() > 7){
            x = new StringBuilder(x).insert(x.length()-7, ".").toString();
        }

        return x;
    }
}
