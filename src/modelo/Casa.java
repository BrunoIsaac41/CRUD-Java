package modelo;

import main.JurosMaiorQueParcelaException;
import util.InterfaceUsuario;


public class Casa extends Financiamento {
    protected double parcelaCasa;
    InterfaceUsuario Inter = new InterfaceUsuario();
    protected static double areaConstruidaCasa;
    protected static double terrenoCasa;

    public Casa(double taxaCasa,float prazo, double valorCasa, String nomeCliente, double tamanhoImovel, double terrenoCasa) {

        super(taxaCasa, prazo, valorCasa, nomeCliente);
        this.areaConstruidaCasa = tamanhoImovel;
        this.terrenoCasa = terrenoCasa;
        PagamentoMensal();

    }

    @Override
    public double PagamentoMensal() {


        if (juros > 2 * valorfixo) {
            throw new JurosMaiorQueParcelaException("Juros maior que valor da parcela.");
                }
        return super.PagamentoMensal()+80;

        }

    }
