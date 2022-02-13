public class MetodoBurbuja {
    public static void main(String[] args) {
        String[] productos = {"Jabon", "Aceite",
                "Martillo", "PC", "Trompeta", "Arroz", "Peine", "Desodorante",
                "alcohol", "Tequila", "tequila", "Cerveza", "Celular"};

        int totalProductos = productos.length;

        int contadorIteraciones = 0;

        for(int i = 0; i < totalProductos; i++) {
            for(int j = 0; j < totalProductos - 1 - i; j++) {
                if(productos[j+1].compareTo(productos[j]) < 0) {
                    String aux = productos[j];
                    productos[j] = productos[j + 1];
                    productos[j + 1] = aux;
                }

                contadorIteraciones++;
            }
        }

        for(int i = 0; i < totalProductos; i++) {
            System.out.println(productos[i]);
        }

        System.out.println("contadorIteraciones = " + contadorIteraciones);
    }
}
