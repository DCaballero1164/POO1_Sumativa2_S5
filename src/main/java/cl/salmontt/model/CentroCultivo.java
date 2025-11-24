package cl.salmontt.model;
/**
 * Clase que representa un Centro de Cultivo de salmones.
 * <p>
 * Este objeto es <b>inmutable</b>, lo que significa que sus atributos
 * (nombre, comuna, toneladas) no pueden ser modificados una vez que el objeto es creado.
 * Se utiliza para asegurar la consistencia de los datos leídos o creados.
 * </p>
 */
public class CentroCultivo {

    //Definicion de Atributos (con final se garantiza la inmutabilidd)
    private final String nombre;  //Almacena el nombre del centro de cultivo
    private final String comuna;  //Almacena la comuna en donde se ubica
    private final int toneladas;  //Almacena las toneladas recolectadas en el lugar

    /**
     * Constructor de la clase CentroCultivo.
     * <p>Inicializa todos los atributos del centro de cultivo.</p>
     * @param nombre El nombre del centro de cultivo.
     * @param comuna La comuna donde se ubica el centro.
     * @param toneladas La cantidad de toneladas recolectadas (debe ser un entero).
     */
    public CentroCultivo(String nombre, String comuna, int toneladas) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.toneladas = toneladas;
    }

    //Getter
    /**
     * Retorna la comuna donde se ubica el centro.
     * @return El nombre de la comuna (String).
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Retorna el nombre del centro de cultivo.
     * @return El nombre del centro (String).
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna la cantidad de toneladas recolectadas en el centro.
     * @return La cantidad de toneladas (int).
     */
    public int getToneladas() {
        return toneladas;
    }

    /**
     * Genera una representación en cadena del objeto {@code CentroCultivo}.
     * <p>El formato es: "CentroCultivo{nombre='[nombre]', comuna='[comuna]', toneladas=[toneladas]}"</p>
     * @return Una cadena formateada con los atributos del centro.
     */
    @Override
    public String toString() {
        return "CentroCultivo{" +
                "nombre='" + getNombre() + '\'' +
                ", comuna='" + getComuna() + '\'' +
                ", toneladas=" + getToneladas() +
                '}';
    }

}
