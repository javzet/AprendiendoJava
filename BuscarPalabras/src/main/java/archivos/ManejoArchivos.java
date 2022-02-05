package archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejoArchivos {
    private String ruta;
    
    public ManejoArchivos(String ruta) {
        this.setRuta(ruta);
    }
    
    public ManejoArchivos() {
        this.ruta = "";
    }
    
    public List<String> leerArchivo(String nombreArchivo) {
        
        List<String> palabrasEnArchivo = new ArrayList<>();
        
        File archivo = new File(this.ruta + nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            String lectura = entrada.readLine();
            
            while(lectura != null) {
                palabrasEnArchivo.add(lectura);
                lectura = entrada.readLine();
            }
            entrada.close();  
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return palabrasEnArchivo;
    }
    
    public void setRuta(String ruta) {
       char caracterActual;
       String rutaFinal = "";
       char caracterRuta = ' ';
       
       for(int i = 0; i < ruta.length(); i++) {
           caracterActual = ruta.charAt(i);
           if(caracterActual == '\\') {
               rutaFinal += "\\" + caracterActual;
               caracterRuta = '\\';
           } else {
               rutaFinal += caracterActual;
               caracterRuta = '/';
           } 
       }
       
       this.ruta = rutaFinal + caracterRuta;
       
    }
    
    
}
