package be.howest.ti.monopoly.logic.implementation.turn;

public enum TurnType {
    DEFAULT, GO_TO_JAIL, JAIL_STAY;

    @Override
    public String toString(){
        return this.toString().replace("_", " ");
    }
}
