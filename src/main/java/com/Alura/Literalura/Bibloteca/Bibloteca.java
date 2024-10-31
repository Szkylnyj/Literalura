package com.Alura.Literalura.Bibloteca;

import java.util.Locale;
import java.util.Scanner;

public class Bibloteca {

   ;

    public static void menu() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Elija la Opcion a traves de su numero");
        System.out.println(" 1 - Buscar libro por titulo");
        System.out.println(" 2 - Listar libros registrados");
        System.out.println(" 3 - Listar autores registrados");
        System.out.println(" 4 - Listar autores vivos en un determinado año");
        System.out.println(" 5 - Listar libros por idioma" );
        System.out.println(" 0 - Salir ");

        String opcion =scanner.nextLine();
        try {
            int opcionNumero = Integer.parseInt(opcion);
            if (opcionNumero >= 0 && opcionNumero <= 5) {
                switch (opcionNumero) {
                    case 0:
                        System.out.println("0");
                        break;
                    case 1:
                        System.out.println("1");
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        menuIdiomas();
                        break;
                }
            } else {
                System.out.println("Opcion no valida, intente nuevamente");
            }
        }catch (NumberFormatException e){
            System.out.println("Entrada no válida. Por favor, ingresa un número entre 0 y 5.");

        }


    }
    public static void menuIdiomas(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Ingrese el idioma para buscar los libros:");
        System.out.println(" es - Espanol");
        System.out.println(" en - Ingles");
        System.out.println(" fr - Frances");
        System.out.println(" pt - Portugues");
        String opcion  = scanner.nextLine().toLowerCase();
        switch (opcion){
            case ("es"):
                System.out.println("espanol");
                break;
            case ("en"):
                System.out.println("Ingles");
                break;
            case("fr"):
                System.out.println("Frances");
                break;
            case ("pt"):
                System.out.println("Portugues");
                break;
        }
    }



}
