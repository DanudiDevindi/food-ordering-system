package dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
    private int cid;
    private String name;
    private String address;
    private int tel;

    public CustomerDTO(int cid,String name,String address,int tel){
        this.cid = cid;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }
    public CustomerDTO(String name, String address, int tel){
        this.name=name;
        this.address= address;
        this.tel=tel;

    }
     public int getcid(){return cid;}
     public String getName(){return name;}
     public String getAddress(){return address;}
     public int getTel(){ return tel;}

}
