package src;

public class Memory {

    // --- Déclaration de la mémoire ---
    private int[] mem = new int[65536]; // 64 Ko de mémoire (2^16 adresses)

    // --- Méthode d’écriture --- 
    public void write(int address, int value) {
        if (address < 0 || address >= mem.length) {
            System.out.println("Erreur : adresse mémoire invalide !");
            return;
        }
        mem[address] = value & 0xFF; // on garde seulement les 8 bits de la valeur
    }

    // --- Méthode de lecture ---
    public int read(int address) {
        if (address < 0 || address >= mem.length) {
            System.out.println("Erreur : adresse mémoire invalide !");
            return -1; // valeur de sécurité
        }
        return mem[address];
    }

    // --- Méthode pour afficher une plage mémoire (optionnelle pour test) ---
    public void dump(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("Adresse %04X : %02X\n", i, mem[i]);
        }
    }
}
