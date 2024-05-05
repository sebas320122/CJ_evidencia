import java.io.File;
public class Instalacion {
    public static void verificarRuta() {
        String dbFolderPath = "src/db";
        File directorio = new File(dbFolderPath);

        // Verificar si el directorio existe
        if (!directorio.exists()) {
            // Intentar crear el directorio
            boolean directorioCreado = directorio.mkdirs();
            if (directorioCreado) {
                System.out.println("Instalacion exitosa");
            } else {
                System.out.println("Error al crear el directorio.");
            }
        } else {
            System.out.println("Iniciando ejecucion...");
        }
    }

}
