/**
 * @author inforkgodara
 */

package model;

import domain.InvoiceDomain;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTableModel {
    List<InvoiceDomain> listInvoiceDomain=new ArrayList<InvoiceDomain>();
    private final String HEADER[]={"ID","Customer","Contact","Type","Amount","Other","Total","Created On"};
    
    public void setList(List<InvoiceDomain> listInvoiceDomain){
        this.listInvoiceDomain=listInvoiceDomain;
    }
    
    public void save(InvoiceDomain pelanggan){
        listInvoiceDomain.add(pelanggan);
//        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
    
    public void edit(int index,InvoiceDomain pelanggan){
        listInvoiceDomain.set(index, pelanggan);
//        fireTableRowsUpdated(index, index);
    }
    
    public void delete(int index){
        listInvoiceDomain.remove(index);
//        fireTableRowsDeleted(index, index);
    }
    
    public InvoiceDomain findOne(int index){
        return listInvoiceDomain.get(index);
    }
 
    public int getRowCount() {
        return listInvoiceDomain.size();
    }
 
    public int getColumnCount() {
        return HEADER.length;
    }
    
    public String getColumnName(int column){
        return HEADER[column];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceDomain pelanggan=listInvoiceDomain.get(rowIndex);
        
        switch(columnIndex){
            case 0:
            return pelanggan.getId();
            
            case 1:
            return pelanggan.getCustomer();
                
            case 2:
            return pelanggan.getContactNumber();
                
            case 3:
            return pelanggan.getType();
                
            case 4:
            return pelanggan.getAmount();
                
            case 5:
            return pelanggan.getOther();
             
            case 6:
            return pelanggan.getTotal();
                
            case 7:
            return pelanggan.getCreatedOn();
            default:
            return null;
        }
    }
}
