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
    
    // //Tester le fichier CPU
    //  // Création des composants
    //     Memory meme = new Memory();
    //     Registers regg = new Registers();
    //     CPU cpu = new CPU(meme, regg);

    //     // Réinitialisation du processeur
    //     cpu.reset();

    //     // Charger une instruction dans la mémoire
    //     meme.write(0, 0x86); // Exemple d’opcode (LDA immédiat)
    //     meme.write(1, 0x05); // Exemple d’opérande (valeur 5)

    //     // Exécuter l’instruction
    //     cpu.executeNextInstruction();

    //     // Afficher l’état du CPU après exécution
    //     cpu.showState();


    // vérification de la communication de Registre memoire et CPU 
 

        // // --- Étape 1 : Création des composants ---
        // Memory mem = new Memory();      // Crée la mémoire (64 Ko)
        // Registers reg = new Registers(); // Crée les registres (A, B, X, Y, etc.)
        // CPU cpu = new CPU(mem, reg);     // Crée le CPU en le reliant à la mémoire et aux registres

        // // --- Étape 2 : Réinitialisation du CPU ---
        // cpu.reset(); // Le PC (Program Counter) revient à 0

        // // --- Étape 3 : Charger une instruction en mémoire ---
        // mem.write(0, 0x86);  // Exemple d’opcode : LDA immédiat
        // mem.write(1, 0x05);  // Exemple d’opérande : charger la valeur 5 dans A (pour plus tard)

        // // --- Étape 4 : Exécuter l'instruction ---
        // cpu.executeNextInstruction();

        // // --- Étape 5 : Afficher l’état des registres ---
        // reg.show();  // Permet de vérifier que tout fonctionne correctement
  


    //tester la modification de notre executeNextInstruction dans notre CPU 

        //  Memory mem = new Memory();
        // Registers reg = new Registers();
        // CPU cpu = new CPU(mem, reg);

        // // Charger quelques opcodes de test en mémoire
        // mem.write(0, 0x86); // LDA
        // mem.write(1, 0x8B); // ADD
        // mem.write(2, 0x97); // STA
        // mem.write(3, 0x7E); // JMP
        // mem.write(4, 0xFF); // Inconnu

        // // Exécuter chaque instruction
        // for (int i = 0; i < 5; i++) {
        //     cpu.executeNextInstruction();
        // }

    //tester la méthode executeLDA()

     Memory mem = new Memory();
        Registers reg = new Registers();
        CPU cpu = new CPU(mem, reg);

        // Charger une instruction LDA dans la mémoire
        mem.write(0, 0x86); // opcode LDA
        mem.write(1, 0x05); // valeur immédiate à charger (5)

        // Exécuter l’instruction
        cpu.executeNextInstruction();

        // Vérification : afficher la valeur du registre A
        System.out.println("Valeur actuelle de A = " + reg.A);

    }
}
 

