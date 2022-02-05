package test;

//import aritmetica.Aritmetica;
import static aritmetica.Aritmetica.division;
import excepciones.OperacionExcepcion;

public class TestExcepciones {

    public static void main(String[] args) {

        int resultado = 0;

        try {
            //resultado = Aritmetica.division(10, 0);
            resultado = division(10, 0);
        } catch (OperacionExcepcion e) { 
            System.out.println("Ha ocurrido un error, tipo OperacionExcepcion");
            System.out.println(e.getMessage());
        } catch (Exception e) {
//            e.printStackTrace(System.out);
            System.out.println("Ha ocurrido un error, tipo Exception");
            System.out.println(e.getMessage());
        } finally { // Siempre se ejecuta aunque haya un error Puede servir para cerrar recursos
            System.out.println("Se revisó la división entre cero");
        }
        
        System.out.println(resultado);
    }
}
