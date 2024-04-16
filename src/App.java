import java.util.Scanner;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println("El Ahorcado");
        //Clase scanner que nos permite que el usuario escriba en la consola
        Scanner consola = new Scanner(System.in);
        
        //Declaraciones y asignaciones
        String palabraSecreta = "inteligencia".toLowerCase();
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;
        
        //arreglo:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }
        while(!palabraAdivinada && intentos < intentosMaximos){
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) +" ("+ palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor.");
            char letra = Character.toLowerCase(consola.next().charAt(0));

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("¡Incorrecto! te quedan " + (intentosMaximos - intentos) + " intentos.");
            }
            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Felicidades, Ganaste! Adivinaste la palabra Secreta: " + palabraSecreta);
            }
        }
        if(!palabraAdivinada){
            System.out.println("¡Que pena te quedaste sin intentos! GAME OVER");
        }
        consola.close();

    }
}
