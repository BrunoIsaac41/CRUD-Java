package util;



public class Ativos {
    InterfaceUsuario Inter = new InterfaceUsuario();
    public double valor;
    public double taxa;
    public float prazo;
    public String nomeCliente;
    public double tamanhoImovel;


    public Ativos() {

    }

    public void FinanAtivos() {

            InterfaceUsuario NomeCliente = new InterfaceUsuario();
            nomeCliente = NomeCliente.setNomeCliente();

            Inter.InputTaxaJuros();
            taxa = Inter.taxa;

            Inter.InputPrazoFinanciamento();
            prazo = Inter.prazo;

            Inter.InputValorImovel();
            valor = Inter.valorimovel;

            Inter.InputTamanhoImovel();
            tamanhoImovel = Inter.tamanhoImovel;


    }



    }

