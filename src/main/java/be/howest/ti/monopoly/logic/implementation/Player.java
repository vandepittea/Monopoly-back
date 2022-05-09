package be.howest.ti.monopoly.logic.implementation;

import be.howest.ti.monopoly.logic.exceptions.IllegalMonopolyActionException;
import be.howest.ti.monopoly.logic.implementation.tile.Property;
import be.howest.ti.monopoly.logic.implementation.tile.Street;
import be.howest.ti.monopoly.web.views.PropertyView;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Player {
    private final String name;

    private String currentTile;
    private boolean jailed;
    private int money;
    private boolean bankrupt;
    private int getOutOfJailCards;
    private String taxSystem;
    private Set<PropertyView> properties;
    private int debt;

    public Player(String name){
        this.name = name;
        this.currentTile = "Go";
        this.jailed = false;
        this.money = 1500;
        this.bankrupt = false;
        this.getOutOfJailCards = 0;
        this.taxSystem = "ESTIMATE";
        properties = new HashSet<>();
        this.debt = 0;
    }

    public String getName() {
        return name;
    }
    public String getCurrentTile() {
        return currentTile;
    }
    public boolean isJailed() {
        return jailed;
    }
    public int getMoney() {
        return money;
    }
    public boolean isBankrupt() {
        return bankrupt;
    }
    public int getGetOutOfJailCards() {
        return getOutOfJailCards;
    }
    public String getTaxSystem() {
        return taxSystem;
    }
    public Set<PropertyView> getProperties() {
        return properties;
    }
    public int getDebt() {
        return debt;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public void buyProperty(Property pr){
        boolean succesfulPayment = payProperty(pr);

        if(succesfulPayment){
            addProperty(new PropertyView(pr));
        }
        else{
            throw new IllegalMonopolyActionException("You don't have enough money to buy this property");
        }
    }

    private void addProperty(PropertyView p){
        properties.add(p);
    }

    private boolean payProperty(Property pr){
        if(money > pr.getCost()){
            money -= pr.getCost();
            return true;
        }
        else{
            return false;
        }
    }

    public void buyHouse(Street s){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
