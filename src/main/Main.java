package main;

import util.*;

public class Main {
    public static InterfaceUsuario Inter = new InterfaceUsuario();

    public static void main(String[] args)  {
          while (true) {
              Menucategorias Menu = new Menucategorias();
              Menu.Menucategorias();
              if (Menu.opcao == 0){
                  break;
              }
          }

            }

        }






