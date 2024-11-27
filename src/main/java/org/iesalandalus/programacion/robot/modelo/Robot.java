package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {

    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;

    public Robot() {
    }

    public Coordenada getPosicion() {
        return coordenada;
    }


    public Robot(Zona zona) {
        this.zona = zona;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this.zona = zona;
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = coordenada;
    }

    public Robot(Robot robot) {
        this.zona = robot.zona;
        this.orientacion = robot.orientacion;
        this.coordenada = robot.coordenada;
    }

    public Zona getZona() {
        return this.zona;
    }

    private Zona setZona(Zona zona) {
        return zona;
    }

    public Orientacion getOrientacion() {
        return this.orientacion;
    }

    private Orientacion setOrientacion(Orientacion orientacion) {
        return orientacion;
    }

    public Coordenada getCoordenada() {
        return this.coordenada;
    }

    private Coordenada setCoordenada(Coordenada coordenada) {
        return coordenada;
    }

    public void avanzar() throws OperationNotSupportedException {
        int nuevaX = coordenada.x();
        int nuevaY = coordenada.y();
        switch (orientacion) {
            case NORTE -> nuevaY++;
            case NORESTE -> {nuevaX++; nuevaY++;}
            case ESTE -> nuevaX++;
            case SURESTE -> {nuevaY--; nuevaX++;}
            case SUR -> nuevaY--;
            case SUROESTE -> {nuevaX--; nuevaY--;}
            case OESTE -> nuevaX--;
            case NOROESTE -> {nuevaX--; nuevaY++;}
        }
        try {
            setCoordenada(new Coordenada(nuevaX, nuevaY));
        } catch (IllegalArgumentException e) {
            throw new OperationNotSupportedException("No se puede avanzar, ya que se sale de la zona.");
        }
    }

    public void girarALaIzquierda() {
        orientacion = switch (orientacion) {
            case NORTE -> Orientacion.NOROESTE;
            case NORESTE -> Orientacion.NORTE;
            case ESTE -> Orientacion.NORESTE;
            case SURESTE -> Orientacion.ESTE;
            case SUR -> Orientacion.SURESTE;
            case SUROESTE -> Orientacion.SUR;
            case OESTE -> Orientacion.SUROESTE;
            case NOROESTE -> Orientacion.OESTE;
        };
    }

    public void girarALaDerecha() {
        orientacion = switch (orientacion) {
            case NORTE -> Orientacion.NORESTE;
            case NORESTE -> Orientacion.ESTE;
            case ESTE -> Orientacion.SURESTE;
            case SURESTE -> Orientacion.SUR;
            case SUR -> Orientacion.SUROESTE;
            case SUROESTE -> Orientacion.OESTE;
            case OESTE -> Orientacion.NOROESTE;
            case NOROESTE -> Orientacion.NORTE;
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Robot robot)) return false;
        return Objects.equals(zona, robot.zona) && orientacion == robot.orientacion && Objects.equals(coordenada, robot.coordenada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, orientacion, coordenada);
    }

    @Override
    public String toString() {
        return String.format("Robot[zona=%s, orientacion=%s, coordenada=%s]", this.zona, this.orientacion, this.coordenada);
    }
}
