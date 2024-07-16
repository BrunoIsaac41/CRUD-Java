package main;

import modelo.Financiamento;
import util.*;


import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static InterfaceUsuario Inter = new InterfaceUsuario();

    public static void main(String[] args)  {
          while (true) {
              SalvarDados SalvarDados = new SalvarDados();
              Menucategorias Menu = new Menucategorias();
              Menu.Menucategorias();
              if (Menu.opcao == 0){
                  break;
              }
          }

            }

        }






