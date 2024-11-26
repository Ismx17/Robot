package org.iesalandalus.programacion.robot.modelo;

public record Zona() {
    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    private static int ancho;
    private static int alto;

    public Zona(int x, int y) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public Zona() {
        ancho = ANCHO_MAXIMO;
        alto = ALTO_MAXIMO;
    }

    private int validarAncho(int ancho) {
        return ancho;
    }

    private int validarAlto(int alto) {
        return alto;
    }

    public static void getCentro(Coordenada coordenada) {
    }

    public boolean pertenece(Coordenada coordenada) {
        return
    }
}