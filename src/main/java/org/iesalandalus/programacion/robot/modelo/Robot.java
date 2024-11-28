package org.iesalandalus.programacion.robot.modelo;

import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {

    private Zona zona;
    private Orientacion orientacion;
    private Coordenada coordenada;

    public Robot() {
        zona = new Zona();
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }

    public Coordenada getPosicion() {
        return coordenada;
    }


    public Robot(Zona zona) {
        setZona(zona);
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion) {
        setZona(zona);
        setOrientacion(orientacion);
        coordenada = zona.getCentro();
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        if (zona == null) {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        if (orientacion == null) {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }

        setZona(zona);
        setOrientacion(orientacion);
        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        zona = robot.zona;
        orientacion = robot.orientacion;
        coordenada = robot.coordenada;
    }

    public Zona getZona() {
        return zona;
    }

    private Zona setZona(Zona zona) {
        return this.zona;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private Orientacion setOrientacion(Orientacion orientacion) {
        return this.orientacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private Coordenada setCoordenada(Coordenada coordenada) {
        return this.coordenada;
    }

    public void avanzar() {
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

        Coordenada nuevaCoordenada = new Coordenada(nuevaX, nuevaY);
        coordenada = nuevaCoordenada;
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