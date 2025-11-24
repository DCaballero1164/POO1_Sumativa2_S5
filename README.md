# 🧠 Sumativa 1 - Semana 3 – Desarrollo Orientado a Objetos I

👤 Autor del proyecto

Nombre completo: Daniel Francisco Caballero Salas

Sección: Programacion Orientada a Objetos I

Carrera: Analista Programador Computacional

Sede: Campus Virtual

📘 Descripción general del sistema

El sistema desarrollado corresponde a una aplicación académica en Java que modela y gestiona centros de cultivo de salmones, aplicando los principios fundamentales de la programación orientada a objetos: encapsulamiento, herencia, polimorfismo y composición.

Su propósito principal es ofrecer una estructura modular que permita:

- Representar entidades del dominio (centros de cultivo) mediante clases y objetos.

- Persistir datos en archivos CSV, garantizando la lectura y escritura de información de manera ordenada y reutilizable.

- Procesar y analizar la producción (expresada en toneladas) utilizando Java Streams, lo que facilita operaciones de filtrado, búsqueda y generación de reportes con un enfoque moderno y eficiente sobre colecciones.

- Separar responsabilidades en paquetes bien definidos (ui, model, data), siguiendo la convención de dominio invertido (cl.salmontt), lo que asegura escalabilidad y claridad en el código.

En términos funcionales, el sistema permite:

- Cargar datos desde un archivo CSV y transformarlos en objetos de dominio (CentroCultivo).

- Filtrar y analizar la producción, destacando los centros con mayor rendimiento.

- Exportar resultados nuevamente a CSV, manteniendo la persistencia de la información.

- Mostrar la información procesada a través de una interfaz de usuario simple basada en consola.

🧱 Estructura general del proyecto

El proyecto está organizado en paquetes siguiendo la convención de dominio invertido (cl.salmontt), lo que facilita la escalabilidad y la claridad del código.

El paquete principal es cl.salmontt, y dentro de este se encuentran los siguientes módulos (paquetes) funcionales:

```
📁 src/main/java/cl/salmontt
├── 📂 ui/                  # Interfaz de Usuario (Entrada/Salida)
│   └── Main.java            # Punto de entrada. Coordina el flujo, carga y filtrado.
│
├── 📂 model/              # Definición de Objetos de Dominio
│   └── CentroCultivo.java  # POJO que representa la entidad del negocio.
│
└── 📂 data/               # Lógica de Datos y Persistencia
    └── GestorDatos.java    # Maneja la lectura y escritura del archivo CSV.

📁 src/main/resources
    └── centros.csv     # Archivo generado con los datos de persistencia.
```

⚙️ Instrucciones para clonar y ejecutar el proyecto

Clonar el repositorio desde GitHub:

git clone https://github.com/DCaballero1164/POO1_Sumativa2_S5

Abrir el proyecto en IntelliJ IDEA. (Utilizar JDK 17 o superior)

Ejecutar el archivo Main.java desde el package ui/.

Visualizar los resultados en la consola o interfaz gráfica.

Repositorio GitHub: https://github.com/DCaballero1164/POO1_Sumativa1_S3 || Fecha de entrega: [24/11/2025]
