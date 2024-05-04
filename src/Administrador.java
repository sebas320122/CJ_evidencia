import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Administrador {
    // Declarar scanner
    Scanner scanner = new Scanner(System.in);

    // Atributos
    public String nombre,password;
    public int id;


    // Asignar ruta de administradores.csv
    String dbFolderPath = "src/db";
    String fileName = "administradores.csv";
    String rutaArchivo = new File(dbFolderPath, fileName).getAbsolutePath();

    // Función para dar de alta a administrador
    public void altaAdministrador(){
        try {
            // Leer administradores.csv y si no existe, crearlo
            File file = new File(rutaArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Pedir datos
            System.out.println("> Ingresa el nombre del administrador:");
            nombre = scanner.nextLine();
            System.out.println("> Ingresa el password del administrador:");
            password = scanner.nextLine();

            // Verificar si el administrador ya existe en el archivo
            if (!validarAlta(nombre, password)) {
                // Generar registro en administradores.csv
                FileWriter writer = new FileWriter(file, true);
                writer.write(asignarId() + "," + nombre + "," + password + "\n");
                writer.close();

                System.out.println("Administrador dado de alta exitosamente");
            } else {
                System.out.println("El administrador ya está registrado");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Funcion para ver lista de administradores
    public void listaAdministradores() {
        try {
            // Leer administradores.csv
            File file = new File(rutaArchivo);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partes = line.split(",");
                if (partes.length > 2) {
                    // Solo mostrar id y nombre
                    System.out.println(partes[0] + ", " + partes[1]);
                } else {
                    System.out.println(line);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // Función complementaria para validar si el administrador ya existe
    private boolean validarAlta(String nombre, String password) throws IOException {
        File file = new File(rutaArchivo);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] partes = line.split(",");
            if (partes.length >= 3 && partes[1].equals(nombre))  {
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
