package modelo;


import static java.lang.Math.pow;

public class Apartamento extends Financiamento{
    protected double taxaAp;
    protected float prazoAp;
    protected static double parcelamensalAp;
    static int vagasGaragem;
    static int numeroAndar;

    public Apartamento (double taxaAp, float prazoAp, double valorAp, String nomeAp,int vagasGaragem, int numeroAndar){
        super(taxaAp, prazoAp, valorAp, nomeAp);
        this.vagasGaragem =  vagasGaragem;
        this.numeroAndar =  numeroAndar;
        PagamentoMensal();

        }
    public double PagamentoMensalAp() {
        taxaAp = (taxaAnualJuros / 12) / 100;
        prazoAp = prazoFinanciamento * 12;
        parcelamensalAp = (valorImovel * taxaAp * pow(1 + taxaAp, prazoAp)) / (pow(1 + taxaAp, prazoAp) - 1);
        return parcelamensalAp;

        }


    }

