import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declarar escaner
        Scanner scanner = new Scanner(System.in);
        //Declarar opcion
        String opcion;

        // Crear instancias
        Doctor doctor = new Doctor();

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
            System.out.println("6 = Salir");
            System.out.println("--------------------------------------");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("- Dar de alta a doctor");
                    doctor.altaDoctor();
                    break;
                case "2":
                    System.out.println("- Dar de alta a paciente");

                    break;
                case "3":
                    System.out.println("- Crear cita");

                    break;
                case "4":
                    System.out.println("- Ver lista de dcotores");

                    break;
                case "5":
                    System.out.println("- Ver lista de pacientes");

                    break;
                case "6":
                    System.out.println("- Salir");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Favor de seleccionar una opcion valida");
            }


        }
    }
}