package ejercicio3tp1;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
        cantidadEventos++;
    }

    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0.0;
        }
        double costoActividades = 0.0;
        for (Actividad a : actividades) {
            costoActividades += a.calcularCostoMateriales(); // polimorfismo: cada actividad sabe lo suyo
        }
        return (costoBase + costoActividades) * 1.21;
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo, String tipo) {
        crearActividad(id, titulo, cupo, tipo, null);
    }

    public void crearActividad(int id, String titulo, int cupo, String tipo, String detalleExtra) {
        Actividad actividad;

        if (tipo.equalsIgnoreCase("Charla")) {
            String disertante = (detalleExtra != null) ? detalleExtra : "A confirmar";
            actividad = new Charla(id, titulo, cupo, disertante);


        } else if (tipo.equalsIgnoreCase("Taller")) {
            boolean requiereNotebook = (detalleExtra != null) && Boolean.parseBoolean(detalleExtra);
            actividad = new Taller(id, titulo, cupo, requiereNotebook);

        } else {
            System.out.println("Tipo de actividad no reconocido: " + tipo);
            return;
        }

        actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void mostrarDatos() {
        System.out.println("Evento: " + titulo + " (id=" + id + ")");
        System.out.println("  Costo base: " + costoBase + " | Gratuito: " + gratuito
                + " | Costo estimado: " + calcularCostoEstimado());
        System.out.println("  Sala asignada: " + (sala != null ? sala : "sin asignar"));
        System.out.println("  Actividades (" + actividades.size() + "):");
        for (Actividad a : actividades) {
            a.mostrarIdentificacion();
            a.mostrarInscripciones();
        }
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }


    }
