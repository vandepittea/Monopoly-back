package be.howest.ti.monopoly.logic.implementation.tile;

import be.howest.ti.monopoly.logic.implementation.Game;
import be.howest.ti.monopoly.logic.implementation.Player;
import be.howest.ti.monopoly.logic.implementation.enums.TileType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public abstract class Property extends Tile {
    private final int cost;
    private final int mortgage;
    private final int groupSize;
    private final String color;

    private boolean mortgaged;

    public Property(int position, String name, int cost, int mortgage, int groupSize, String color, TileType type) {
        super(position, name, type);
        this.mortgaged = false;

        this.cost = cost;
        this.mortgage = mortgage;
        this.groupSize = groupSize;

        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public int getMortgage() {
        return mortgage;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public String getColor() {
        return color;
    }

    @JsonIgnore
    public boolean isMortgaged() {
        return mortgaged;
    }

    public void takeMortgage() {
        mortgaged = true;
    }

    public void payMortgage() {
        mortgaged = false;
    }

    public abstract int calculateRent(Player player, Game game);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Property property = (Property) o;
        return cost == property.cost && mortgage == property.mortgage && groupSize == property.groupSize && color.equals(property.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cost, mortgage, groupSize, color);
    }
}
