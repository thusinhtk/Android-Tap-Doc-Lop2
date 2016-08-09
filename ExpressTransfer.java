/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMBank;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP-VANTUUHO
 */
public class ExpressTransfer {
    int accountID;
    int toAccountID;

    public int getAccountID() {
        return accountID;
    }

    public int getToAccountID() {
        return toAccountID;
    }
    public ExpressTransfer()
    {
    try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ExpressTransfer(int accID,int toAccID){
        this.accountID=accID;
        this.toAccountID=toAccID;
    }
    public ResultSet toAccID(int accID) throws Exception{
    try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:jtds:sqlserver://HP-VANTUUHO:1433/VANTUUHOBANK","sa","tuu123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from ExpressTransfer where AccountID="+accID);
            if(rs.next()){              
                return rs;     
            }
            else
                throw new Exception("B&#7841;n Ch&#432;a &#272;&#259;g K&#253; D&#7883;ch V&#7909; Chuyern Ti&#7873;n Nh&#7841;n!");
            
        } catch (Exception ex) {
                throw new Exception(ex.getMessage());
              
        }
    }
    
    public ResultSet viewAllToAcc(int accID) throws Exception{
    try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:jtds:sqlserver://HP-VANTUUHO:1433/VANTUUHOBANK","sa","tuu123");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select ToAccountID,CustomerName from ExpressTransfer,Account where ExpressTransfer.AccountID="+accID+"and ExpressTransfer.ToAccountID=Account.AccountID");
            if(rs!=null) {         
                return rs;     
            }
            else
                throw new Exception("B&#7841;n Ch&#432;a &#272;&#259;g K&#253; D&#7883;ch V&#7909; Chuyern Ti&#7873;n Nh&#7841;n!");
            
        } catch (Exception ex) {
                throw new Exception(ex.getMessage());
              
        }
    }
    
     public boolean regisExpressTransfer() throws Exception{
        try {
             Class.forName("net.sourceforge.jtds.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:jtds:sqlserver://HP-VANTUUHO:1433/VANTUUHOBANK","sa","tuu123");
              
             PreparedStatement stmt= con.prepareStatement("Insert into ExpressTransfer(AccountID,ToAccountID)  values(?,?)");         
             stmt.setInt(1,accountID);
             stmt.setInt(2,toAccountID); 
            stmt.execute();
             con.close();
             return true;
            
        } catch (Exception ex) {
            throw new Exception("M&#227; T&#224;i Kho&#7843;n "+toAccountID+" &#272;&#227; C&#243; Trong D&#7883;ch V&#7909; Chuy&#7875;n Ti&#7873;n Nhanh C&#7911;a B&#7841;n<p>Vui L&#242;ng Ki&#7875;m Tra L&#7841;i!");
        }
    }
     public boolean deleteExpressAcc() throws Exception{
        try {
             Class.forName("net.sourceforge.jtds.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:jtds:sqlserver://HP-VANTUUHO:1433/VANTUUHOBANK","sa","tuu123");
              PreparedStatement stmt= con.prepareStatement("Delete from ExpressTransfer where AccountID=? and ToAccountID=?"); 
           stmt.setInt(1,accountID);
           stmt.setInt(2,toAccountID);
           stmt.executeUpdate();
             con.close();
             return true;
            
        } catch (Exception ex) {
            throw new Exception(""+ex.getMessage());
        }
    }
     public static boolean deleteAcc(int acc) throws Exception{
        try {
             Class.forName("net.sourceforge.jtds.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:jtds:sqlserver://HP-VANTUUHO:1433/VANTUUHOBANK","sa","tuu123");
              PreparedStatement stmt= con.prepareStatement("Delete from ExpressTransfer where AccountID=?"); 
           stmt.setInt(1,acc);
           stmt.executeUpdate();
             con.close();
             return true;
            
        } catch (Exception ex) {
            throw new Exception(""+ex.getMessage());
        }
    }
   
}
