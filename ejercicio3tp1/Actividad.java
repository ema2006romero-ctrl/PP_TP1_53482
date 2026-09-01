package ejercicio3tp1;

import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int cupoMinimo = 5;
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad(int id, String titulo, int cupo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupo;
        this.inscripciones = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (inscripciones.size() >= cupoMaximo) {
            System.out.println("No se pudo inscribir a " + estudiante.getNombre() + " ya que se alcanzo el cupo maximo en la actividad " + titulo);
            return null;
        }
        Inscripcion inscripcion = new Inscripcion(estudiante, this);
        inscripciones.add(inscripcion);
        return inscripcion;
    }

    public void mostrarInscripciones() {
        System.out.println("Actividad: " + titulo + " (id= " + id + ", cupoMaximo = " + cupoMaximo + ")");
        if (inscripciones.isEmpty()) {
            System.out.println("Sin inscripciones");
        } else {
            for (Inscripcion i : inscripciones) {
                System.out.println("       " + i.getEstudiante().getNombre() + " (legajo " + i.getEstudiante().getLegajo() + ") - " + i.getEstado() + " - " + i.getFecha());
            }
        }
    }

    public final void mostrarIdentificacion(){
        System.out.println("[" + getTipo() + "]" + titulo + "(id= " + id + ")");
    }

    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

}
