import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declarar escaner
        Scanner scanner = new Scanner(System.in);
        //Declarar opcion
        String opcion;

        // Crear instancias
        Doctor doctor = new Doctor();
        Paciente paciente = new Paciente();
        Cita cita = new Cita();
        Administrador administrador = new Administrador();

        // Control de acceso
        System.out.println("--- Inicio de sesion ---");
        if (!administrador.login()) {
            return;
        }

        // Interfaz de consola
        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("SISTEMA DE CONSULTORIO 1.0");
            System.out.println("> Introduzca la opcion que desea realizar");
            System.out.println("1 = Dar de alta a doctor");
            System.out.println("2 = Dar de alta a paciente");
            System.out.println("3 = Crear cita");
            System.out.println("4 = Ver lista de doctores");
            System.out.println("5 = Ver lista de pacientes");
            System.out.println("6 = Ver lista de citas");
            System.out.println("7 = Dar de alta adminsitrador");
            System.out.println("8 = Ver lista de administradores");
            System.out.println("9 = Salir");
            System.out.println("--------------------------------------");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("- Dar de alta a doctor");
                    doctor.altaDoctor();
                    break;
                case "2":
                    System.out.println("- Dar de alta a paciente");
                    paciente.altaPaciente();
                    break;
                case "3":
                    System.out.println("- Crear cita");
                    cita.crearCita();
                    break;
                case "4":
                    System.out.println("- Ver lista de doctores");
                    doctor.listaDoctores();
                    break;
                case "5":
                    System.out.println("- Ver lista de pacientes");
                    paciente.listaPacientes();
                    break;
                case "6":
                    System.out.println("- Ver lista de citas");
                    cita.listaCitas();
                    break;
                case "7":
                    System.out.println("- Dar de alta administrador");
                    administrador.altaAdministrador();
                    break;
                case "8":
                    System.out.println("- Ver lista de administradores");
                    administrador.listaAdministradores();
                    break;
                case "9":
                    System.out.println("- Salir");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Favor de seleccionar una opcion valida");
            }


        }
    }
}