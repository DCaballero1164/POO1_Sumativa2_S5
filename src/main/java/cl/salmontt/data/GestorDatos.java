package cl.salmontt.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cl.salmontt.model.CentroCultivo;

/**
 * La clase {@code GestorDatos} se encarga de las operaciones de entrada/salida
 * (I/O) relacionadas con los datos de los centros de cultivo.
 * <p>
 * Incluye métodos para escribir (guardar) una lista de centros en un archivo
 * CSV y para leer (cargar) la lista de centros desde dicho archivo.
 * Los archivos se gestionan en la carpeta {@code src/main/resources/}.
 * </p>
 */
public class GestorDatos {

    /**
     * Escribe una lista de objetos {@code CentroCultivo} en un archivo CSV
     * en la carpeta de recursos.
     * <p>
     * El metodo crea el archivo si no existe, lo sobrescribe si ya existe,
     * y genera una cabecera antes de escribir los datos.
     * </p>
     * * @param centros La lista de objetos CentroCultivo a guardar. Se recomienda usar {@code List}.
     * @param nombreArchivo El nombre del archivo CSV de destino (ej: "centros.csv").
     */
    public void agregarDatos(List<CentroCultivo> centros, String nombreArchivo) {
        try {
            //se almacena en una variable el directorio del archivo
            String directorioArchivo = "src/main/resources/";

            //Se crea el archivo
            File pathArchivo = new File(directorioArchivo+nombreArchivo);

            //Se inicia la escritura con FileWriter
            FileWriter archivoCSV = new FileWriter(pathArchivo);

            //título en el archivo
            archivoCSV.write("...::: Centros de cultivo :::...\n");
            archivoCSV.write("nombre;ciudad;toneladas\n");

            //Se recorren los centros creados y se agregan los datos al archivo CSV concatenados por ";"
            for (CentroCultivo c : centros) {
                archivoCSV.write(c.getNombre()+";"+c.getComuna()+";"+c.getToneladas()+"\n");
            }
            //cerrar archivo
            archivoCSV.close();

            //Mostrar mensaje de archivo creado
            System.out.println("Archivo "+nombreArchivo+" creado correctamente");

            //Mostrar la ruta
            System.out.println("Ruta: " + pathArchivo.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }
    }

    /**
     * Carga los centros de cultivo desde un archivo CSV ubicado en la carpeta
     * {@code src/main/resources/centros.csv}.
     * <p>
     * El metodo salta las dos primeras líneas (título y cabecera) antes de
     * procesar los datos. Implementa manejo de excepciones para errores de
     * formato numérico.
     * </p>
     * * @return Una lista de tipo {@code ArrayList} conteniendo los objetos {@code CentroCultivo} leídos del archivo.
     */
    public ArrayList<CentroCultivo> cargarCentros() {

        //Mensaje al inicio de lectura de datos
        System.out.println("Lectura de datos desde el archivo .csv");

        //Se crea la lista para almacenar los centros de cultivos leidos
        ArrayList<CentroCultivo> centrosLeidos = new ArrayList<>();

        //Se leen los datos del archivo .csv
        try {
            //Nombre del archivo .csv
            String nombreArchivo = "centros.csv";

            //Ruta del archivo
            String rutaArchivo = "src/main/resources/";

            // Cargar archivo desde la carpeta resources
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo+nombreArchivo));
            br.readLine(); //salto en lectura de linea 1 (titulo)
            br.readLine(); //salto en lectura de linea 2 (encabezado de la tabla)
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar por ';'
                String[] partes = linea.split(";");

                //lectura solo de lineas con 3 datos
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String comuna = partes[1].trim();
                    try {
                        int produccion = Integer.parseInt(partes[2].trim());

                        //Se agregan los datos a la lista centros leidos
                        centrosLeidos.add(new CentroCultivo(nombre, comuna, produccion));
                    } catch (NumberFormatException nfe) {
                        System.err.println("Error al leer producción en la línea: " + linea + ". Dato no es un numero entero.");
                    }

                }
            }
            br.close();

            //Excepcion en caso de no leer el archivo
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }

        return centrosLeidos;

    }
}