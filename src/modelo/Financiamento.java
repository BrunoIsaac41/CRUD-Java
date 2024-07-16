package modelo;

import util.InterfaceUsuario;

public abstract class Financiamento  {
    protected static double valorImovel ;
    protected static float prazoFinanciamento ;
    protected static double taxaAnualJuros ;
    protected static double valortotal;
    protected static String nomeCliente;
    protected double parcelamensal;
    public double juros;
    public double valorfixo;

    public Financiamento(double taxaAnualJuros, float prazoFinanciamento , double valorImovel, String nomeCliente)  {

        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaAnualJuros = taxaAnualJuros;
        this.nomeCliente= nomeCliente;
        PagamentoMensal();
        ValorTotal();
        getTamanhoImovel();
        getvalorfinanciamento();
        getPrazo();
        getTaxa();
        getNome();
        getValorImovel();
        getAndarAp();
        getVagasGaragem();
        getZonaTerreno();

        }

    public  double  PagamentoMensal() {
        juros = this.valorImovel * ((this.taxaAnualJuros / 12) / 100);
        valorfixo = this.valorImovel / this.prazoFinanciamento ;
        parcelamensal = (this.valorfixo + this.juros);
        return this.parcelamensal;

    }


    public double ValorTotal() {
        valortotal = (parcelamensal * prazoFinanciamento );
        return valortotal;
        }

    public String getNome(){
        return nomeCliente;
    }
    public static double getValorImovel(){
        return valorImovel;
    }
    public static float getPrazo(){return prazoFinanciamento;}
    public static double getTaxa(){return taxaAnualJuros;}
    public static double getvalorfinanciamento(){
        return valortotal;
    }
    public static int getVagasGaragem(){
        return Apartamento.vagasGaragem;
    }
    public static int getAndarAp(){
        return Apartamento.numeroAndar;
    }
    public static double getTamanhoImovel(){return InterfaceUsuario.getTamanhoImovel();}
    public static double getTerrenoCasa(){
        return Casa.terrenoCasa;
    }
    public static String getZonaTerreno(){
        return Terreno.tipoZona;
    }


}

