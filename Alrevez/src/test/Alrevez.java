package test;

public class Alrevez {
    public String alrevez(String palabra) {
        
        String nuevaPalabra = "";
        char[] nuevaPalabraArr = new char[palabra.length()];
        
        for(int i = 0; i < palabra.length(); i++) {
           nuevaPalabraArr[i] = palabra.charAt(i);
        }
        
        for(int i = 0; i < palabra.length(); i++) {
            nuevaPalabra += nuevaPalabraArr[nuevaPalabraArr.length  - i - 1];
        }
        
        return nuevaPalabra;
    }
}
