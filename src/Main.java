package src;

public class Main {
    public static void main(String[] args) {
        Memory mem = new Memory();

        // Écriture dans la mémoire
        mem.write(0, 42);
        mem.write(10, 255);

        // Lecture depuis la mémoire
        System.out.println("Valeur à l'adresse 0 : " + mem.read(0));
        System.out.println("Valeur à l'adresse 10 : " + mem.read(10));

        // Test adresse invalide
        mem.read(70000); // provoque un message d'erreur
    }
}
