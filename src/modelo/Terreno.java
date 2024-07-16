package modelo;

public class Terreno extends Financiamento{
    protected static String tipoZona;

    public Terreno (double taxaTerreno, float prazoTerreno, double valorTerreno, String nomeCliente, String tipoZona){
        super(taxaTerreno,prazoTerreno,valorTerreno,nomeCliente);
        this.tipoZona = tipoZona;
    }

    @Override
    public double PagamentoMensal() {
        double juros = this.valorImovel * (this.taxaAnualJuros / 12 )/ 100;
        double valorfixo = this.valorImovel/this.prazoFinanciamento ;
        parcelamensal = valorfixo +juros;
        return this.parcelamensal*1.02;
    }
}
