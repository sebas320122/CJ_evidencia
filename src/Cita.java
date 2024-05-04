import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cita {
    // Declarar scanner
    Scanner scanner = new Scanner(System.in);

    // Atributos
    public String fecha, hora, motivo;
    public int id_doctor, id_paciente;

    // Asignar ruta de citas.csv
    String dbFolderPath = "src/db";
    String fileName = "citas.csv";
    String rutaArchivo = new File(dbFolderPath, fileName).getAbsolutePath();

    // Función para crear una cita
    public void crearCita(){
        try {
            // Leer citas.csv y si no existe, crearlo
            File file = new File(rutaArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Pedir datos
            System.out.println("> Ingresa el ID del doctor:");
            id_doctor = scanner.nextInt();
            System.out.println("> Ingresa el ID del paciente:");
            id_paciente = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            System.out.println("> Ingresa la fecha (DD-MM-YYYY):");
            fecha = scanner.nextLine();
            System.out.println("> Ingresa la hora (HH:MM):");
            hora = scanner.nextLine();
            System.out.println("> Ingresa el motivo:");
            motivo = scanner.nextLine();

            // Verificar el doctor y paciente estan registrados
            if (validarDoctor(id_doctor) && validarPaciente(id_paciente)) {
                // Generar registro en citas.csv
                FileWriter writer = new FileWriter(file, true);
                writer.write(asignarId() + "," + id_doctor + "," + id_paciente + "," + fecha + "," + hora + "," + motivo + "\n");
                writer.close();

                System.out.println("Cita creada exitosamente");

            } else {
                System.out.println("El doctor o el paciente no están registrados");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void listaCitas() {
        try {
            // Leer doctores.csv y mostrar los registros
            File file = new File(rutaArchivo);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Función complementaria para verificar si el doctor existe
    private boolean validarDoctor(int id) throws IOException {
        File file = new File("src/db/doctores.csv");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] partes = line.split(",");
            if (partes.length >= 1 && Integer.parseInt(partes[0]) == id) {
                return true;
            }
        }
        return false;
    }

    // Función complementaria para verificar si el paciente existe
    private boolean validarPaciente(int id) throws IOException {
        File file = new File("src/db/pacientes.csv");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] partes = line.split(",");
            if (partes.length >= 1 && Integer.parseInt(partes[0]) == id) {
                return true;
            }
        }
        return false;
    }

    // Función complementaria para asignar ID único a registro
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
