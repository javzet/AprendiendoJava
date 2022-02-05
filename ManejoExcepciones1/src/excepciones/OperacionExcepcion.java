
package excepciones;

//public class OperacionExcepcion extends Exception {
public class OperacionExcepcion extends RuntimeException {
    public OperacionExcepcion(String msg) {
        super(msg);
    }
}
