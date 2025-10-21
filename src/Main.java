package src;

public class Main {
    public static void main(String[] args) {


    // //teste de fichier memoire.java
    //     Memory mem = new Memory();

    //     // Écriture dans la mémoire
    //     mem.write(0, 42);
    //     mem.write(10, 255);

    //     // Lecture depuis la mémoire
    //     System.out.println("Valeur à l'adresse 0 : " + mem.read(0));
    //     System.out.println("Valeur à l'adresse 10 : " + mem.read(10));

    //     // Test adresse invalide
    //     mem.read(70000); // provoque un message d'erreur


    // //teste de fichier registre.java
    //      Registers reg = new Registers();

    //     // Affiche l'état initial des registres
    //     reg.show();

    //     // Test de modification
    //     reg.A = 10;
    //     reg.B = 200;
    //     reg.X = 0x1000;
    //     reg.PC = 0x2000;

    //     // Affiche les nouvelles valeurs
    //     reg.show();
    
    //Tester le fichier CPU
     // Création des composants
        Memory meme = new Memory();
        Registers regg = new Registers();
        CPU cpu = new CPU(meme, regg);

        // Réinitialisation du processeur
        cpu.reset();

        // Charger une instruction dans la mémoire
        meme.write(0, 0x86); // Exemple d’opcode (LDA immédiat)
        meme.write(1, 0x05); // Exemple d’opérande (valeur 5)

        // Exécuter l’instruction
        cpu.executeNextInstruction();

        // Afficher l’état du CPU après exécution
        cpu.showState();
    }
}
