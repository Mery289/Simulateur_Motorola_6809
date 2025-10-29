package src;
public class CPU {

    // --- Attributs principaux ---
    private Memory memory;    // la mémoire du processeur
    private Registers regs;   // les registres (A, B, X, Y, PC, ....)

    // --- Constructeur ---
    public CPU(Memory mem, Registers reg) {
        this.memory = mem;
        this.regs = reg;
    }

    // --- Méthode de réinitialisation ---
    public void reset() {
        regs.PC = 0; // on démarre l’exécution à l’adresse 0
        System.out.println("CPU réinitialisé. PC = " + regs.PC);
    }

    // --- Lecture et exécution d'une instruction ---
    public void executeNextInstruction() {
    // Lire l’opcode à l’adresse du PC
    int opcode = memory.read(regs.PC);
    System.out.printf("Instruction lue à l’adresse %04X : %02X\n", regs.PC, opcode);

    // Avancer le compteur de programme (PC)
    regs.PC++;

    // Identifier et exécuter l’instruction correspondante
    switch (opcode) {
        case 0x86: // LDA immédiat
            executeLDA();
            break;

        case 0x8B: // ADD A immédiat
            executeADD();
            break;

        case 0x97: // STA direct
            executeSTA();
            break;

        case 0x7E: // JMP
            executeJMP();
            break;

        default:
            System.out.printf("Opcode inconnu : %02X\n", opcode);
    }
}

// Instruction : LDA (Load Accumulator A)
private void executeLDA() {
    // Lire la valeur située juste après l’opcode
    int value = memory.read(regs.PC);

    // Avancer le compteur de programme
    regs.PC++;

    // Charger la valeur dans le registre A
    regs.A = value;

    // Afficher pour vérifier le résultat
    System.out.printf("LDA exécutée : A <-- %02X\n", regs.A);
}


// Instruction : ADD
private void executeADD() {
    System.out.println("→ Instruction ADD détectée (à implémenter)");
}

// Instruction : STA
private void executeSTA() {
    System.out.println("→ Instruction STA détectée (à implémenter)");
}

// Instruction : JMP
private void executeJMP() {
    System.out.println("→ Instruction JMP détectée (à implémenter)");
}


    // --- (Optionnel) méthode pour afficher l’état CPU ---
    public void showState() {
        System.out.println("=== État du CPU ===");
        regs.show();
        System.out.println("====================");
    }
}
