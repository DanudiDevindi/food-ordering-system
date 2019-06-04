package dto;

import java.io.Serializable;

public class ReceptionDTO implements Serializable {
    private int recpId;
    private String name;

    public ReceptionDTO(int recpId, String name) {
        this.recpId = recpId;
        this.name = name;
    }

    public int getRecpId() {
        return recpId;
    }

    public String getName() {
        return name;
    }
}
