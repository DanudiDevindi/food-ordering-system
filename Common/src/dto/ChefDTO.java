package dto;

import java.io.Serializable;

public class ChefDTO implements Serializable {
    private int cheffId;
    private String cheff;
    private String password;

    public ChefDTO(int cheffId,String cheff){
        this.cheffId = cheffId;
        this.cheff = cheff;
    }

    public ChefDTO(int cheffId, String cheff, String password) {
        this.cheffId = cheffId;
        this.cheff = cheff;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getCheffId(){ return cheffId;}

    public String getCheff (){ return cheff; }

}
