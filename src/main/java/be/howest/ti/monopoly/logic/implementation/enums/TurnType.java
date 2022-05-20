package be.howest.ti.monopoly.logic.implementation.enums;

public enum TurnType {
    DEFAULT,
    GO_TO_JAIL,
    JAIL_STAY,
    GET_OUT_OF_JAIL;

    @Override
    public String toString(){
        return this.toString().replace("_", " ");
    }
}
