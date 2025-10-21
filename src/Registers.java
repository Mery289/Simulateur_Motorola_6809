package src;
public class Registers {

    // --- Registres 8 bits ---
    public int A; // Accumulateur A
    public int B; // Accumulateur B

    // --- Registres 16 bits ---
    public int X; // Index Register X
    public int Y; // Index Register Y
    public int PC; // Program Counter
    public int SP; // Stack Pointer

    // --- Registre d’état ---
    public int CC; // Condition Code (flags : Z, N, C, etc.)

    // --- Constructeur ---
    public Registers() {
        // Initialisation des registres à 0
        A = B = 0;
        X = Y = 0;
        PC = 0;
        SP = 0xFFFF; // La pile commence souvent à la fin de la mémoire
        CC = 0;
    }

    // --- Méthode d'affichage pour debug ---
    public void show() {
        System.out.println("=== État des registres ===");
        System.out.printf("A  = %02X\n", A);
        System.out.printf("B  = %02X\n", B);
        System.out.printf("X  = %04X\n", X);
        System.out.printf("Y  = %04X\n", Y);
        System.out.printf("PC = %04X\n", PC);
        System.out.printf("SP = %04X\n", SP);
        System.out.printf("CC = %02X\n", CC);
        System.out.println("==========================");
    }
}
