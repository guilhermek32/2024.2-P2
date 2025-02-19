import a2025_02_17_Atividade3.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        double totalImpostos = 0;

        while(n>0){
            System.out.print("Individual or company (i/c)? ");
            String opc = scanner.nextLine();

            if (opc.equals("i")){

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Anual Income: ");
            double anualIncome = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Health Expenditures: ");
            double healthExpenditure = scanner.nextDouble();
            scanner.nextLine();

            Contribuinte.add(new PessoaFisica(name, anualIncome, healthExpenditure));


            } else if(opc.equals("c")) {
                System.out.print("Name: ");
                String name = scanner.nextLine();


                System.out.print("Anual Income: ");
                double anualIncome = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Number of Employees: ");
                int numberOfEmployees = scanner.nextInt();
                scanner.nextLine();

                Contribuinte.add(new PessoaJuridica(name, anualIncome, numberOfEmployees));
            }
            n--;
            System.out.println();
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        

        for (Contribuinte contribuinte : Contribuinte.getContributors()) {
            double imposto = contribuinte.taxCalc();
            System.out.println(contribuinte.getName() + ": $ " + String.format("%.2f", imposto));
            totalImpostos += imposto;
        }
        System.out.println();
        System.out.println("Total Taxes: $ " + String.format("%.2f", totalImpostos));

    }
}