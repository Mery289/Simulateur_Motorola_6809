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
    int value = memory.read(regs.PC); // lire l’opérande
    regs.PC++;
    int result = regs.A + value;

    if (result > 0xFF) { // gestion du dépassement (carry)
        regs.CC = 1;
        result &= 0xFF; // garde les 8 bits
    } else {
        regs.CC = 0;
    }

    regs.A = result;
    System.out.printf("ADD exécutée : A <-- %02X (après addition de %02X)\n", regs.A, value);
}


// Instruction : STA
private void executeSTA() {
    // Lire l’adresse de destination juste après l’opcode
    int addr = memory.read(regs.PC);

    // Avancer le compteur de programme
    regs.PC++;

    // Écrire la valeur du registre A dans la mémoire à cette adresse
    memory.write(addr, regs.A);

    // Afficher le résultat pour le débogage
    System.out.printf("STA exécutée : mémoire[%02X] <-- %02X\n", addr, regs.A);
}


// Instruction : JMP
private void executeJMP() {
    // Lire l’adresse de saut (prochaine case mémoire après l’opcode)
    int addr = memory.read(regs.PC);

    // Modifier directement le compteur ordinal pour “sauter” à cette adresse
    regs.PC = addr;

    // Afficher l’information pour vérification
    System.out.printf("JMP exécutée : saut vers %02X\n", addr);
}



    // --- (Optionnel) méthode pour afficher l’état CPU ---
    public void showState() {
        System.out.println("=== État du CPU ===");
        regs.show();
        System.out.println("====================");
    }
}
