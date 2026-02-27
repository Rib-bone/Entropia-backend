package risto.turtiainen.entropia_backend.enums;


public enum MobType {
    ROBOT("Robot"),
    ANIMAL("Animal"),
    MUTANT("Mutant");

    private final String text;

    MobType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}