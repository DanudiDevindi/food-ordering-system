package daoUtil;

import dbConnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    private static PreparedStatement getPreparedStatement(String sql,Object...param)throws SQLException,ClassNotFoundException{
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        for(int i=0;i<param.length;i++){
            stm.setObject(i+1,param[i]);
        }
        return stm;
    }
    public static boolean executeUpdate(String sql,Object...para)throws SQLException,ClassNotFoundException{
        return getPreparedStatement(sql,para).executeUpdate()>0;
    }
    public  static ResultSet executeQuery(String sql,Object...param)throws SQLException,ClassNotFoundException{
        return getPreparedStatement(sql,param).executeQuery();
    }
}
