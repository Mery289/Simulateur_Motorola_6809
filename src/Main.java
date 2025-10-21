package src;

public class Main {
    public static void main(String[] args) {
    //teste de fichier memoire.java
        Memory mem = new Memory();

        // Écriture dans la mémoire
        mem.write(0, 42);
        mem.write(10, 255);

        // Lecture depuis la mémoire
        System.out.println("Valeur à l'adresse 0 : " + mem.read(0));
        System.out.println("Valeur à l'adresse 10 : " + mem.read(10));

        // Test adresse invalide
        mem.read(70000); // provoque un message d'erreur
    //teste de fichier registre.java
         Registers reg = new Registers();

        // Affiche l'état initial des registres
        reg.show();

        // Test de modification
        reg.A = 10;
        reg.B = 200;
        reg.X = 0x1000;
        reg.PC = 0x2000;

        // Affiche les nouvelles valeurs
        reg.show();
    }
}
