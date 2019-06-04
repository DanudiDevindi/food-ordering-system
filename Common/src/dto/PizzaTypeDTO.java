package dto;

import java.io.Serializable;

public class PizzaTypeDTO implements Serializable {
    private int typeId;
    private String type;
    private double price;

    public PizzaTypeDTO(int typeId, String type, double price) {
        this.typeId = typeId;
        this.type = type;
        this.price = price;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
