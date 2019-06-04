package dto;

import java.io.Serializable;

public class DelivaryDTO implements Serializable {
    private int dbId;
    private String delvryBot;

    public DelivaryDTO(int dbId,String delvryBot){
        this.dbId =dbId;
        this.delvryBot = delvryBot;
    }
    public int getDbId(){ return dbId;}

    public String getDelvryBot(){ return delvryBot;}
}
