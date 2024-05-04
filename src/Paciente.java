import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Paciente {
    // Declarar scanner
    Scanner scanner = new Scanner(System.in);

    // Atributos
    public String nombre;
    public int id;

    // Asignar ruta de pacientes.csv
    String dbFolderPath = "src/db";
    String fileName = "pacientes.csv";
    String rutaArchivo = new File(dbFolderPath, fileName).getAbsolutePath();

    // Función para dar de alta a paciente
    public void altaPaciente(){
        try {
            // Leer pacientes.csv y si no existe, crearlo
            File file = new File(rutaArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Pedir datos
            System.out.println("> Ingresa el nombre:");
            nombre = scanner.nextLine();

            // Verificar si el paciente ya existe en el archivo
            if (!validarAlta(nombre)) {
                // Generar registro en pacientes.csv
                FileWriter writer = new FileWriter(file, true);
                writer.write(asignarId() + "," + nombre + "\n");
                writer.close();

                System.out.println("Paciente dado de alta");

            } else {
                System.out.println("El paciente ya está registrado");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    
    // Función complementaria para revisar si el paciente ya existe
    private boolean validarAlta(String nombre) throws IOException {
        File file = new File(rutaArchivo);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] partes = line.split(",");
            if (partes.length >= 2 && partes[1].equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    // Función complementaria para asignar id único a registro
    private int asignarId() throws IOException {
        File file = new File(rutaArchivo);
        Scanner scanner = new Scanner(file);
        int maxId = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] partes = line.split(",");
            if (partes.length >= 1) {
                int id = Integer.parseInt(partes[0]);
                if (id > maxId) {
                    maxId = id;
                }
            }
        }
        return maxId + 1;
    }

}
