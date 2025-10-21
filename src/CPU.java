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
        // Lire le code de l’instruction (opcode)
        int opcode = memory.read(regs.PC);

        System.out.printf("Instruction lue à l’adresse %04X : %02X\n", regs.PC, opcode);

        // Pour l’instant, on se contente d’avancer le compteur de programme
        regs.PC++;

        // Plus tard, on décodera ici le type d’instruction (LDA, ADD, JMP, etc.)
    }

    // --- (Optionnel) méthode pour afficher l’état CPU ---
    public void showState() {
        System.out.println("=== État du CPU ===");
        regs.show();
        System.out.println("====================");
    }
}
