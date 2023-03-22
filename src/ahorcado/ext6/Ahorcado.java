package ahorcado.ext6;

import java.util.Scanner;

public class Ahorcado {

    private String[] palabra;
    private String[] palabraaux;
    private int cantEncontradas;
    private int cantJugadas;

    public Ahorcado() {
    }

    public Ahorcado(String[] palabra, String[] palabraaux, int cantEncontradas, int cantJugadas) {
        this.palabra = palabra;
        this.palabraaux = palabraaux;
        this.cantEncontradas = cantEncontradas;
        this.cantJugadas = cantJugadas;
    }

    public String[] getPalabra() {
        return palabra;
    }

    public void setPalabra(String[] palabra) {
        this.palabra = palabra;
    }

    public String[] getPalabraaux() {
        return palabraaux;
    }

    public void setPalabraaux(String[] palabraaux) {
        this.palabraaux = palabraaux;
    }

    public int getCantEncontradas() {
        return cantEncontradas;
    }

    public void setCantEncontradas(int cantEncontradas) {
        this.cantEncontradas = cantEncontradas;
    }

    public int getCantJugadas() {
        return cantJugadas;
    }

    public void setCantJugadas(int cantJugadas) {
        this.cantJugadas = cantJugadas;
    }

    public void crearJuego() {
        Scanner leer = new Scanner(System.in);
        System.out.println("igrese la palabra");
        String frase = leer.nextLine();
       
        System.out.println("ingrese la cantidad de jugada");
        cantJugadas = leer.nextInt();
      
        cantEncontradas = 0;
        palabra = new String[frase.length()];
        palabraaux = new String[frase.length()];
        for (int i = 0; i < frase.length(); i++) {
            palabra[i] = frase.substring(i, i + 1);
            palabraaux[i] = "_";

        }
    }

    public void longitud() {
        System.out.println("la palabra tiene una longuitud de  " + palabra.length);
    }

    public boolean buscarLetra(String letra) {
        int cont = 0;
        boolean ban = false;
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].equals(letra)) {

                cont++;
                ban = true;
            }
        }
        if (cont == 0) {
            System.out.println("la letra  "+ letra + "  no esta en la palabra " );

        } else {
            System.out.println("la letra  "+ letra + "  esta en la palabra se repite  "+cont );
        }
        return ban;
    }

    public boolean encontradas(String letra) {
        boolean ban = false;
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i].equals(letra)) {
                if (palabraaux[i].equals("_")) {
                    palabraaux[i]=letra;
                    cantEncontradas++;
                }
                ban = true;
            }
        }
        if (!ban) {
            cantJugadas--;
        }
        return buscarLetra(letra);
    }

    public void intentos() {
        System.out.println("le quedan  " + cantJugadas + " intentos");

    }

    public void mostrarjuego() {
        for (int i = 0; i < palabraaux.length; i++) {
            System.out.print(palabraaux[i] + " ");

        }
        System.out.println("");
    }

    public void juego() {
        Scanner leer = new Scanner(System.in);
        String letra;
        crearJuego();
        do {
            mostrarjuego();
            intentos();
            longitud();
            System.out.println("ingrese la letra a buscar en la palabra");
            letra = leer.nextLine();
            encontradas(letra);
        } while (cantJugadas != 0 && cantEncontradas != palabra.length);
        if (cantEncontradas == palabra.length) {
            System.out.println("la palabra encontrada es ");
            mostrarjuego();

        } else {
            System.out.println("la palabra no se encontrada ");
        }

    }
}
