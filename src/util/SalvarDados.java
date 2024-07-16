package util;

import util.*;
import modelo.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList ;
import java.util.List;

public class SalvarDados {
    Ativos ativos = new Ativos();
    ToCSV toCSV = new ToCSV();
    Menucategorias Menu = new Menucategorias();
    ArrayList <Financiamento> dadosFinanciamentos;
    public String [] cabecalho;


    public SalvarDados(){
    dadosFinanciamentos = new ArrayList<Financiamento>();

}
    public void salvar() {
        List dados = new ArrayList<>();
        try {

            for (Financiamento f : dadosFinanciamentos) {
                String nome = f.getNome();
                double valorfinanciamento = f.getvalorfinanciamento();
                double valorimovel = f.getValorImovel();
                float prazo = f.getPrazo();
                double juros = f.getTaxa();

                double tamanhoImovel = f.getTamanhoImovel();
                double terrenoCasa = f.getTerrenoCasa();


                if (f instanceof Casa) {
                    //Casa
                    this.cabecalho = new String[]{"Nome", "ValorImovel", "ValorFinanciamento", "TamanhoImovel"};
                    dados.add(new String[]{
                            String.valueOf(nome),
                            String.valueOf(valorimovel),
                            String.valueOf(valorfinanciamento),
                            String.valueOf(tamanhoImovel)});

                } else if (f instanceof Apartamento) {
                    //Apartamento
                     cabecalho = new String[]{"Nome", "ValorImovel", "ValorFinanciamento", "TamanhoImovel", "Vagas", "Andar"};
                    int vagas = f.getVagasGaragem();
                    int andar = f.getAndarAp();
                    dados.add(new String[]{
                            String.valueOf(nome),
                            String.valueOf(valorimovel),
                            String.valueOf(valorfinanciamento),
                            String.valueOf(tamanhoImovel),
                            String.valueOf(vagas),
                            String.valueOf(andar)
                    });
                } else if (f instanceof Terreno) {
                    cabecalho = new String[]{"Nome", "ValorImovel", "ValorFinanciamento", "TamanhoImovel", "TipoZona"};
                    String zonaTerreno = f.getZonaTerreno();
                    dados.add(new String[]{
                            String.valueOf(nome),
                            String.valueOf(valorimovel),
                            String.valueOf(valorfinanciamento),
                            String.valueOf(tamanhoImovel),
                            String.valueOf(zonaTerreno)
                    });
                }toCSV.gerarCSV("dados.csv", dados,cabecalho);

                System.out.println(dados);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}














