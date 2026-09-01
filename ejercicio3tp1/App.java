package ejercicio3tp1;
import java.util.ArrayList;
import java.util.List;
public class App {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("1001", "Ana Gomez"));
        estudiantes.add(new Estudiante("1002", "Luis Perez"));
        estudiantes.add(new Estudiante("1003", "Marta Diaz"));

        EventoUniversitario evento1 = new EventoUniversitario("EV01", "Encuentro", 3000, false);

        evento1.asignarSala(new Sala(1, "Sala 1"));

        evento1.crearActividad(01, "Taller de java", 40, "Taller", "True");
        evento1.crearActividad(02, "Charla sobre inversiones", 60, "Taller", "true");

        List<Actividad> actividades = evento1.getActividades();
        actividades.get(0).inscribir(estudiantes.get(0));
        actividades.get(0).inscribir(estudiantes.get(1));
        actividades.get(1).inscribir(estudiantes.get(1));
        actividades.get(1).inscribir(estudiantes.get(2));

        System.out.println("Resumen de eventos");
        evento1.mostrarDatos();

        System.out.println("\nTotal de eventos creados: " + EventoUniversitario.getCantidadEventos());


    }
}
