package a2025_02_17_Atividade3;

public class PessoaFisica extends Contribuinte{
    private double healthExpenditures;

    public PessoaFisica (String name, double anualIncome, double healthExpenditures){
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public double getHealthExpenditures(){
        return healthExpenditures;
    }

    public double taxCalc() {
        if (getAnualIncome() < 20000.00) {
            return getAnualIncome() * 0.15 - healthExpenditures * 0.5;
        } else {
            return getAnualIncome() * 0.25 - healthExpenditures * 0.5;
        }
    }
}