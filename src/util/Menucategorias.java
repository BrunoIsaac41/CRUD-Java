package util;
import modelo.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Menucategorias {
    public int opcao;
    Ativos Ativos = new Ativos();
    private int vagasGaragem;
    private int numeroAndar;
    private String zonaTerreno;
    public boolean verificador = false;
    public ArrayList<Financiamento> financiamentos;


    public void Menucategorias() {
        Scanner scanner = new Scanner(System.in);
        financiamentos = new ArrayList<Financiamento>();


        while (verificador == false) {
            exibirMenu();
            this.opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Saindo do programa.");
                break;
            }


            Ativos.FinanAtivos();

            switch (opcao) {
                case 1:
                    // opção Casa
                    Financiamento Casa = new Casa(Ativos.taxa, Ativos.prazo, Ativos.valor, Ativos.nomeCliente, Ativos.tamanhoImovel, 100);

                    financiamentos.add(Casa);
                    break;

                case 2:
                    // opção apartamento
                    System.out.println("===========================\n" +
                            "Digite a quantidade de vagas na garagem:");
                    this.vagasGaragem = scanner.nextInt();

                    System.out.println("===========================\n" +
                            "Digite o número do andar:");
                    this.numeroAndar = scanner.nextInt();

                    Financiamento Ap = new Apartamento(Ativos.taxa, Ativos.prazo, Ativos.valor, Ativos.nomeCliente, vagasGaragem, numeroAndar);
                    financiamentos.add(Ap);


                    break;

                case 3:
                    // opção terreno:
                    System.out.println("===========================\n" +
                            "Digite a zona do terreno. Ex: Zona Rural.");
                    zonaTerreno = scanner.nextLine();
                    Financiamento terreno = new Terreno(Ativos.taxa, Ativos.prazo, Ativos.valor, Ativos.nomeCliente, zonaTerreno);
                    financiamentos.add(terreno);

                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    break;


                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println("Financiamento criado com sucesso!"+
                                "\n=====================\n");
            this.verificador = true;


        }try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("O timer1 foi interrompidoa.");
            e.getStackTrace();
        }
        
        Imprimir();
        SalvarDados Salvar = new SalvarDados();
        Salvar.dadosFinanciamentos.addAll(financiamentos);
        Salvar.salvar();



    }


    private static void exibirMenu() {
        System.out.println("----- Menu de Categorias -----");
        System.out.println("1. Casa");
        System.out.println("2. Apartamento");
        System.out.println("3. Terreno");
        System.out.println("0. Sair");
        System.out.print("Digite a opção desejada: ");
    }

    public void Imprimir() {

        // Imprimindo os valores;
        double SomaValorImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento f1 : financiamentos) {
            if (f1 instanceof Casa) {
            System.out.println("Nome do Cliente: " + f1.getNome() +
                    "\nValor da Casa: R$ " + String.format("%.2f", f1.getValorImovel()) +
                    "\nValor do Financiamento: R$ " + String.format("%.2f", f1.getvalorfinanciamento()) +
                    "\nMetragem do Imóvel: " + String.format("%.2f", f1.getTamanhoImovel()) + "m²"+
                    "\n==========================\n\n");
            
                }else if (f1 instanceof Apartamento) {
                    System.out.println("Nome do Cliente: " + f1.getNome() +
                    "\nValor do Apartamento: R$ " + String.format("%.1f", f1.getValorImovel()) +
                    "\nValor do Financiamento: R$ " + String.format("%.1f", f1.getvalorfinanciamento()) +
                    "\nMetragem do Imóvel: " + String.format("%.1f", f1.getTamanhoImovel()) + "m²"+
                    "\nVagas: " + f1.getVagasGaragem()+
                    "\nAndar do Apartamento: "+ f1.getAndarAp()+
                    "\n==========================\n\n");

                }else if (f1 instanceof Terreno) {
                    System.out.println("Nome do Cliente: " + f1.getNome() +
                    "\nValor do Terreno: R$ " + String.format("%.2f", f1.getValorImovel()) +
                    "\nValor do Financiamento: R$ " + String.format("%.2f", f1.getvalorfinanciamento()) +
                    "\nMetragem do Imóvel: " + String.format("%.2f", f1.getTamanhoImovel()) + "m²"+
                    "\nZona do Terreno: " + String.format("%.2f", f1.getVagasGaragem())+
                    "\n==========================\n\n");
                }


            SomaValorImoveis += f1.getValorImovel();
            totalFinanciamentos += f1.getvalorfinanciamento();
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("O timer2 foi interrompido.");
                e.getStackTrace();
            }


           
        }
    }
}
