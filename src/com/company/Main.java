package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean correct = false;
        double start = 0.0, monthly = 0.0, rate = 0.0, inflation = 0.0;
        int t = 0;

        while (!correct) {
            System.out.println("Anfangskapital:");
            start = scan.nextDouble();
            System.out.println("monatliche Sparrate:");
            monthly = scan.nextDouble();
            System.out.println("Zinsen/Rendite p.a.:");
            rate = scan.nextDouble();
            System.out.println("erwartete durchscnittliche Inflation p.a.:");
            inflation = scan.nextDouble();
            System.out.println("Laufzeit in Jahren:");
            t = scan.nextInt();
            String startB = beautify(start);
            String monthlyB = beautify(monthly);
            System.out.println("Anfangskapital: " + startB + "€\nmonatliche Sparrate: " + monthlyB + "€\nZinsen/Rendite p.a.: " + Math.round(rate)+ "%\nInflation: "+ Math.round(inflation)+"%\nLaufzeit in Jahren: "+t);

            boolean answered = false;
            while (!answered) {
                System.out.println("Korrekt? (J|N)");
                String ans = scan.next();
                ans = ans.toLowerCase();
                if (ans.equals("j")) {
                    answered = true;
                    correct = true;
                }
                if (ans.equals("n")) {
                    System.out.println("Dann nochmal!");
                    answered = true;
                }
            }}

            System.out.println("Cool!");

            for(int i = 0; i < t; i++ ){
                start = (start + monthly*12)+((start + monthly*12)*(rate/100));
                System.out.println((i+1)+ ". Jahr: "+beautify(start)+"€");
            }

            inflation = (inflation/100)*t;
            double realValue = start - (start* inflation);

            String resultB = beautify(start);
            String realValueB = beautify(realValue);


            System.out.println("Nach "+t+" Jahren haben Sie "+ resultB +"€, aber nur mit einer Kaufkraft wie "+ realValueB+"€ heutzutage.");




    }


    public static String beautify(double num){
        int numInt = (int) num;
        String s = Integer.toString(numInt);
        if(s.length() > 3){
            s = new StringBuilder(s).insert(s.length()-3, ".").toString();
        }
        if(s.length() > 7){
            s = new StringBuilder(s).insert(s.length()-7, ".").toString();
        }

        return s;
    }
}
