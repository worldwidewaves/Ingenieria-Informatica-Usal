package listastiposbasicosjava;

/**
 *
 * @author coti
 */
public class ListasTiposBasicosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte[] listaBytes = {0x68, 0x6f, 0x6c, 0x61};
        int[][] tablaInt;
        double[][][] prisma = {
            {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            },
            {
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
            }
        };
        int n = 2;
        // Las listas de Java son clases, y contienen como atributo su
        // longitud (length). Una tabla es una lista de filas.
        // Un prisma es una lista de tablas (capas), etc.
        // 
        // En Java no hay aritmética de punteros explícita.
        //
        // Las variables matriciales, bien sean listas, tablas, 
        // prismas o de cualquier numero de dimensiones, se crean normalmente
        // sin indicar unas dimensiones concretas. Se  pueden recorren empleando
        // una expresión con o sin índices. NO hay aritmética de punteros
        // (todas las clases de Java se manejan mediante punteros).
        //
        int capas = prisma.length;
        int filas = prisma[0].length;
        int columnas = prisma[0][0].length;
        int aux = 0;
        System.out.printf("%nCapas    = %d%nFilas    = %d%nColumnas = %d%n",
                capas, filas, columnas);
        // Aquí se muestra el contenido almacenado en la lista de bytes
        System.out.printf("%nEl contenido de la lista de bytes es:%n%n");
        for (byte b : listaBytes) {
            System.out.printf("%c", b);
        }
        System.out.printf("%n%n");
        //
        // Aquí se crea una tabla. Obsérvese que filas y columnas
        // no son constantes.
        // Por supuesto, si se modifica el valor de filas y columnas
        // después de crear la tabla mediante new, las dimensiones de
        // la tabla no se verán modificadas.
        //
        System.out.printf("El contenido de la tabla de int es:%n%n");
        tablaInt = new int[filas][columnas];
        // Aquí se dan valores a los elementos de la tabla, empleando un for()
        // convencional.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablaInt[i][j] = 10 * (i + 1) + j + 1;
            }
        }
        // Aquí se muestra el contenido de la tabla
        for (int[] fila : tablaInt) {
            for (int m : fila) {
                System.out.printf((0 == (++aux % columnas)) ? "%3d%n" : "%3d", m);
            }
        }
        System.out.printf("%n%n");
        // Aquí se muestran los valores del prisma 
        prisma[1][2][3] = -999;
        for (int i = 0; i < capas; i++) {
            for (int j = 0; j < filas; j++) {
                for (int k = 0; k < columnas; k++) {
                    System.out.printf("prisma[%d][%d][%d] = %7.2f%n", i, j, k, prisma[i][j][k]);
                }
            }
        }
        
        // Aquí se muestra que los valores de filas y columnas solo influyen
        // en el momento en que se crea la tabla
        filas = 433;
        columnas = 827;
        System.out.printf("%nfilas    = %d pero el número de filas    es %d%n", filas, tablaInt.length);
        System.out.printf("columnas = %d pero el número de columnas es %d%n", columnas, tablaInt[0].length);

    }
}
