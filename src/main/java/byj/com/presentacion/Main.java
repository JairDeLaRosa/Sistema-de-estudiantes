package byj.com.presentacion;

import byj.com.datos.EstudianteDao;
import byj.com.modelo.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scaner= new Scanner(System.in);
        var opcion= 0;

        do {
            menu();
            opcion=Integer.parseInt(scaner.nextLine());
            System.out.println(opcion);
            funcionesAPP(opcion,scaner);
        }while (opcion!=5);

    }
    public static void menu(){
        System.out.print("""
                ***Sistema de estudiantes***
                1. Agregar estudiante.
                2. Listar estudiantes.
                3. Editar estudiante.
                4. Eliminar estudiante.
                5. Salir.
                """);
        System.out.print("Inserte una opción: ");
    }
    public static void funcionesAPP(int opcion, Scanner scanner){
        var estudianteDao=new EstudianteDao();
        Estudiante estudiante= new Estudiante();
        switch (opcion){
            case 1->{
                System.out.print("Inserte nombre: ");
                estudiante.setNoombre(scanner.nextLine());
                System.out.print("Inserte apellido: ");
                estudiante.setApellido(scanner.nextLine());
                System.out.print("Inserte telefono: ");
                estudiante.setTelefono(scanner.nextLine());
                System.out.print("Inserte email: ");
                estudiante.setEmail(scanner.nextLine());
                boolean agregado=estudianteDao.addEstudiante(estudiante);
                if (agregado){
                    System.out.println("Estudiante "+estudiante+" agregado exitosamente!");
                }
            }
            case 2->{
                List<Estudiante> estudiantes=new ArrayList<>();
                estudiantes=estudianteDao.listar();
                System.out.println("El listado de los estudiantes es: ");
                estudiantes.forEach(System.out::println);
            }
            case 3->{
                System.out.print("Inserte ID del destudiante a editar: ");
                estudiante.setIdEstudiante(Integer.parseInt(scanner.nextLine()));
                if(estudianteDao.buscarEstudiantePorId(estudiante)){
                    System.out.print("Inserte nuevo nombre: ");
                    estudiante.setNoombre(scanner.nextLine());
                    System.out.print("Inserte nuevo apellido: ");
                    estudiante.setApellido(scanner.nextLine());
                    System.out.print("Inserte nuevo telefono: ");
                    estudiante.setTelefono(scanner.nextLine());
                    System.out.print("Inserte nuevo email: ");
                    estudiante.setEmail(scanner.nextLine());
                    boolean actualizado= estudianteDao.actualizarEstudiante(estudiante);
                    if (actualizado){
                        System.out.println("¡Estuadinte actualizado con exito!");
                    }else {
                        System.out.println("Error al actualizar");
                    }
                }else {
                    System.out.println("Estudiante no encontrado.");
                }

            }
            case 4->{
                System.out.print("Inserte id del estuaidnte a eliminar ");
                int id=Integer.parseInt(scanner.nextLine());
                estudiante.setIdEstudiante(id);
                if(estudianteDao.buscarEstudiantePorId(estudiante)){
                  boolean eliminado= estudianteDao.eliminar(estudiante);
                  if (eliminado){
                      System.out.println("Estudiante con id "+id+" eliminado exitosamente!");
                  }else {
                      System.out.println("Error al eliminar estudiante");
                  }
                }else {
                    System.out.println("Estudiante no encontrado.");
                }
            }
            case 5->{
                System.out.println("Haste luego...");
            }
        }
    }
}