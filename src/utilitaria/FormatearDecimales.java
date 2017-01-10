/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaria;

/**
 *
 * @author Jesus
 */
public class FormatearDecimales {

    private static String formato = "";

    public static String darFormato(int cantidad) {
        int punto = 0, digito = 0;
        boolean bandera = true;
        while (bandera) {
            digito = cantidad % 10;
            punto++;
            if (punto > 3) {
                formato = "." + formato;
                punto = 1;
            }
            formato = digito + "" + formato;
            cantidad = cantidad / 10;
            if (cantidad < 10) {
                if (punto == 3) {
                    formato = cantidad + "." + formato;
                } else {
                    formato = cantidad + "" + formato;
                }
                bandera = false;
            }
        }
        return formato;
    }
}
