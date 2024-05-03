import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Doctor {
    // Declarar scanner
    Scanner scanner = new Scanner(System.in);

    // Atributos
    public String nombre, especialidad;
    public int id;

    // Asignar ruta de doctores.csv
    String dbFolderPath = "src/db";
    String fileName = "doctores.csv";
    String rutaArchivo = new File(dbFolderPath, fileName).getAbsolutePath();

    // Función para dar de alta a doctor
    public void altaDoctor(){
        try {
            // Leer doctores.csv y si no existe, crearlo
            File file = new File(rutaArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Pedir datos
            System.out.println("> Ingresa el nombre:");
            nombre = scanner.nextLine();
            System.out.println("> Ingresa la especialidad:");
            especialidad = scanner.nextLine();

            // Verificar si el doctor ya existe en el archivo
            if (!validarAlta(nombre, especialidad)) {

                // Generar registro en doctores.csv
                FileWriter writer = new FileWriter(file, true);
                writer.write(asignarId() + "," + nombre + "," + especialidad + "\n");
                writer.close();

                System.out.println("Doctor dado de alta");

            } else {
                System.out.println("El doctor ya está registrado");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Función complementaria para revisar si el doctor ya existe
    private boolean validarAlta(String nombre, String especialidad) throws IOException {
        File file = new File(rutaArchivo);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] partes = line.split(",");
            if (partes.length >= 2 && partes[1].equalsIgnoreCase(nombre) && partes[2].equalsIgnoreCase(especialidad)) {
                return true;
            }
        }
        return false;
    }

    // Funcion complementaria para asignar id unico a registro
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
