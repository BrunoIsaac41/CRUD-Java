package util;

import java.util.Scanner;


public class InterfaceUsuario {
        protected static double valorimovel;
        protected static double taxa;
        protected static float prazo;
        protected static String NomeCliente;
        protected static double tamanhoImovel;

    public String setNomeCliente(){
        Scanner nomefinan = new Scanner(System.in);
        System.out.println("\n" + "================================\n" +
                "Digite o nome do cliente: ");
        NomeCliente= nomefinan.nextLine();
        return NomeCliente;
    }

    public String getNomefinan(){return NomeCliente;}

    public void InputValorImovel() {
           try{ // Scaneia um valor a cada loop
               while (true) {Scanner inputVimovel = new Scanner(System.in);
                    System.out.println("===========================\n"+
                        "Digite o valor do imovél:");
                    valorimovel = inputVimovel.nextDouble();
                if  (valorimovel <= 0) {
                    throw new RuntimeException ("O valor é inválido");
                        }
                break;}

           } catch (RuntimeException e){
               System.out.println("Erro"+e.getMessage());
           }
        }




    public void InputTaxaJuros() {
        boolean taxa_verificação = true;
        while (true){
        try {
                Scanner taxa1 = new Scanner(System.in);
                System.out.println("===========================\n" +
                        "Digite a taxa anual de juros:");
                taxa = taxa1.nextDouble();
                
                    
                    if (taxa <= 0 || taxa > 100) {
                        System.out.println("Taxa é inválida.\n");
                        continue;
                        }
                    else {
                        break;
                    }
                    
                 
                     
                    
                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                } 
            }

        }

    public void InputPrazoFinanciamento() {
        try {
            while (true) {
                Scanner inputPrazo = new Scanner(System.in);
                System.out.println("===========================\n" +
                        "Digite o Prazo em MESES:");
                prazo = inputPrazo.nextInt();

                if (prazo <= 0) {throw new RuntimeException("O prazo é inválido\n");}

                break;
            }
        }
            catch (RuntimeException e){
                System.out.println(e.getMessage());

            }
        }

    public double InputTamanhoImovel(){
        Scanner tamanho = new Scanner(System.in);
        System.out.println("===========================\n" +
                "Digite a metragem do imovel em metros: ");
        tamanhoImovel = tamanho.nextDouble();
        return  tamanhoImovel;

}


 // Getters:
    public static double getTamanhoImovel(){return tamanhoImovel;}

}










