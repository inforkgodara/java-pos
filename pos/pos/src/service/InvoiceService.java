/**
 * @author inforkgodara
 */

package service;


import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class InvoiceService {
    private Connection con;
    private PreparedStatement preparedStatement;
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }
    
    public List<domain.InvoiceDomain> findAll(int halaman,int banyakBaris){
        List<domain.InvoiceDomain> listInvoice=new ArrayList<domain.InvoiceDomain>();
        
        try{
            
            con=dataSource.getConnection();
            con.setAutoCommit(false);
            preparedStatement=con.prepareStatement("SELECT * FROM invoice limit ?,?");
            preparedStatement.setInt(1, banyakBaris*(halaman-1));
            preparedStatement.setInt(2, banyakBaris);
            ResultSet rs=preparedStatement.executeQuery();
            
            while(rs.next()){
                domain.InvoiceDomain p=new domain.InvoiceDomain();
                p.setId(rs.getLong("id"));
                p.setCustomer(rs.getString("customer"));
                p.setContactNumber(rs.getString("contact_number"));
                p.setType(rs.getString("type"));
                p.setAmount(rs.getFloat("amount"));
                p.setOther(rs.getFloat("other"));
                p.setOther(rs.getFloat("total"));
                p.setCreatedOn(rs.getTimestamp("created_on"));
                listInvoice.add(p);
            }
            
            con.commit();
            con.setAutoCommit(true);
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
            try{
                con.rollback();
            }catch(SQLException exRollBack){
                exRollBack.printStackTrace();
            }
        }finally{
            try{
                con.close();
            }catch(SQLException exClose){
                exClose.printStackTrace();
            }
            return listInvoice;
        }
    }
    
    public int count(){
        int jumlahBaris=0;
        
        try{
            con=dataSource.getConnection();
            con.setAutoCommit(false);
            preparedStatement=con.prepareStatement("SELECT count(id) from invoices");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                jumlahBaris=rs.getInt("count(id)");
            }
            
            con.commit();
            con.setAutoCommit(true);
            
        }catch(SQLException ex){
            ex.printStackTrace();
            try{
                con.rollback();
            }catch(SQLException exRollBack){
                exRollBack.printStackTrace();
            }
        }finally{
            try{
                con.close();
            }catch(SQLException exClose){
                exClose.printStackTrace();
            }
            return jumlahBaris;
        }
    }
}
