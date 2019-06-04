package dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {
    private int oid;
    private String custName;
    private String address;
    private int tel;
    private int qty;
    private String status;
    private String cheff;
    private int recpId;
    private int cheffId;
    private String boyName;
    private String reception;
    private int boyId;
    private int typeId;
    private String type;
    private double amount;

    public OrderDTO(String custName, String address, int tel, int qty, String status, String cheff, String boyName,int typeId, String type, double amount) {
        this.custName = custName;
        this.address = address;
        this.tel = tel;
        this.qty = qty;
        this.status = status;
        this.cheff = cheff;
        this.boyName = boyName;
        this.type = type;
        this.amount = amount;
    }

    public OrderDTO(String custName, String address, int tel, int qty, String status, String cheff, int recpId, int cheffId, int boyId){
     this.custName=custName;
     this.address=address;
     this.tel=tel;
     this.qty=qty;
     this.status=status;
     this.cheff=cheff;
     this.recpId=recpId;
     this.cheffId=cheffId;
     this.boyId=boyId;
    }

    public OrderDTO(int oid, int qty, String status, int recpId, int cheffId, int boyId, int typeId, double amount) {
        this.oid = oid;
        this.qty = qty;
        this.status = status;
        this.recpId = recpId;
        this.cheffId = cheffId;
        this.boyId = boyId;
        this.typeId = typeId;
        this.amount = amount;
    }

    public OrderDTO(String custName, String address, int tel, int qty, int recpId, String boyName, double amount){
        this.custName=custName;
        this.address=address;
        this.tel=tel;
        this.qty=qty;
        this.status=status;
        this.cheff=cheff;
        this.recpId=recpId;
        this.boyName = boyName;
        this.recpId=typeId;
        this.type=type;
        this.reception=reception;
        this.amount=amount;
    }

    public String getReception (){ return  reception;}


    public OrderDTO(String custName, String address, int tel, int qty, String status){
        this.oid=oid;
        this.custName=custName;
        this.address=address;
        this.tel=tel;
        this.qty=qty;
        this.status=status;
    }

    public double getAmount() {
        return amount;
    }
    public int getTypeId(){
        return typeId;
    }
    public String getType(){
        return  type;
    }

    public void setType(String type){
        this.type=type;
    }

    public String getBoyName(){
        return boyName;
    }
    public void setBoyName(String boyName){
        this.boyName=boyName;
    }

    public void setCheffId(int cheffId){
        this.cheffId=cheffId;
    }

    public String getCustName(){
        return  custName;
    }

    public String getAddress(){
        return  address;
    }
    public int getTel(){
        return  tel;
    }

    public void setBoyId(int boyId){
        this.boyId=boyId;
    }
    public void setCheff(String cheff){
        this.cheff=cheff;
    }

    public int getOid(){
        return oid;
    }

    public String getCheff(){
        return  cheff;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public int getRecpId(){
        return recpId;
    }
    public int getCheffId(){
        return cheffId;
    }
    public int getBoyId(){
        return boyId;
    }

    public int getQty(){
        return  qty;
    }
    public String getStatus(){
        return  status;
    }

}
