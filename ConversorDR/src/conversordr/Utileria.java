/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversordr;

/**
 *
 * @author Jahir
 */
public class Utileria {

    public static int miles = 0;
    public static int centenas = 0;
    public static int decenas = 0;
    public static int unidades = 0;
    public static int numeroDecimal = 0;
    public static String numeroRomano = "";

    public static void recibeNumero(int numero) {
        numeroDecimal = numero;
        if (validarNumeroDecimal()) {            
            separarMilesDecenasCentenasUnidades();
        } else {
            System.out.println("Por favor escribe un número entre 1 y 3999");
        }
    }

    public static boolean validarNumeroDecimal() {
        boolean bandera = false;
        if (numeroDecimal > 0 && numeroDecimal <= 3999) {
            bandera = true;
        }
        return bandera;
    }

    public static void separarMilesDecenasCentenasUnidades() {
        int tamanoNumero = tamanoNumeroDecimal(numeroDecimal);
        if (tamanoNumero > 3) {
            miles = numeroDecimal / 1000;
        }
        if (tamanoNumero > 2) {
            centenas = numeroDecimal / 100 % 10;
        }
        if (tamanoNumero > 1) {
            decenas = numeroDecimal / 10 % 10;
        }
        unidades = numeroDecimal % 10;
        convertirDecimalARomano();
    }

    public static int tamanoNumeroDecimal(int numeroDecimal) {
        int tamanoDecimal = 0;
        tamanoDecimal = Integer.toString(numeroDecimal).length();
        return tamanoDecimal;
    }

    public static void convertirDecimalARomano() {
        convierteMiles();
        convierteCentenas();
        convierteDecenas();
        convierteUnidades();
        System.out.println(numeroRomano);
    }

    public static void convierteMiles() {
        for (int i = 0; i < miles; i++) {
            numeroRomano = numeroRomano + "M";
        }
    }

    public static void convierteCentenas() {
        if (centenas == 9) {
            numeroRomano = numeroRomano + "CM";
        } else if (centenas >= 5) {
            numeroRomano = numeroRomano + "D";
            for (int i = 6; i <= centenas; i++) {
                numeroRomano = numeroRomano + "C";
            }
        } else if (centenas == 4) {
            numeroRomano = numeroRomano + "CD";
        } else {
            for (int i = 1; i <= centenas; i++) {
                numeroRomano = numeroRomano + "C";
            }
        }
    }

    public static void convierteDecenas() {
        if (decenas == 9) {
            numeroRomano = numeroRomano + "XC";
        } else if (decenas >= 5) {
            numeroRomano = numeroRomano + "L";
            for (int i = 6; i <= decenas; i++) {
                numeroRomano = numeroRomano + "X";
            }
        } else if (decenas == 4) {
            numeroRomano = numeroRomano + "XL";
        } else {
            for (int i = 1; i <= decenas; i++) {
                numeroRomano = numeroRomano + "X";
            }
        }
    }

    public static void convierteUnidades() {
        if (unidades == 9) {
            numeroRomano = numeroRomano + "IX";
        } else if (unidades >= 5) {
            numeroRomano = numeroRomano + "V";
            for (int i = 6; i <= unidades; i++) {
                numeroRomano = numeroRomano + "I";
            }
        } else if (unidades == 4) {
            numeroRomano = numeroRomano + "IV";
        } else {
            for (int i = 1; i <= unidades; i++) {
                numeroRomano = numeroRomano + "I";
            }
        }
    }
}
