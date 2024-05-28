package model;

public enum Cargo {
    // alcalde, gobernador
    ALCALDE("Alcalde"), GOBERNADOR("Gobernador");

    private String cargo;

    private Cargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public static Cargo getCargo(String cargo) {
        for (Cargo c : Cargo.values()) {
            if (c.getCargo().equals(cargo)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return cargo;
    }
}
