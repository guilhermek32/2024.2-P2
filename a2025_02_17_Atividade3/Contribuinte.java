package a2025_02_17_Atividade3;

import java.util.ArrayList;
import java.util.List;

abstract public class Contribuinte {
    private String name;
    private double anualIncome;
    private static List<Contribuinte> contributors = new ArrayList<>();

    public static void add(Contribuinte contributor) {
        contributors.add(contributor);
    }

    public static List<Contribuinte> getContributors() {
        return contributors;
    }

    public Contribuinte(String name, double anualIncome) {
        this.name = name;
        this.anualIncome = anualIncome;
    }

    public double getAnualIncome() {
        return anualIncome;
    }

    public abstract double taxCalc();

    public String getName() {
    return name;
    }
}