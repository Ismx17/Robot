package org.iesalandalus.programacion.robot.modelo;

public class Zona {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    private int ancho;
    private int alto;

    public Zona(int ancho, int alto) {
        this();
        this.ancho = ancho;
        this.alto = alto;
    }

    public Zona() {
        this.ancho = ANCHO_MAXIMO;
        this.alto = ALTO_MAXIMO;
    }

    private int validarAncho(int ancho) {
        if (ancho >= ANCHO_MINIMO && ancho <= ANCHO_MAXIMO) {
            return ancho;
        } else {
            throw new IllegalArgumentException("Ancho fuera de los límites permitidos");
        }
    }

    private int validarAlto(int alto) {
        if (alto >= ALTO_MINIMO && alto <= ALTO_MAXIMO) {
            return alto;
        } else {
            throw new IllegalArgumentException("Alto fuera de los límites permitidos");
        }
    }

    public static Coordenada getCentro(int ancho, int alto) {
        int centroX = (ancho / 2);
        int centroY = (alto / 2);
        return new Coordenada(centroX, centroY);
    }

    public boolean pertenece(Coordenada coordenada) {
        if (coordenada.x() >= 10 & coordenada.x() <= 100 & coordenada.y() >= 10 & coordenada.y() <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public boolean perteneceX(int x) {
        if (x >= 10 && x <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public boolean perteneceY(int y) {
        if (y >= 10 && y <= 100) {
            return true;
        } else {
            return false;
        }
    }
}
