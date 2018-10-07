
import javax.swing.table.AbstractTableModel;

 import javax.swing.ImageIcon;

//to display the details in jtable
public class mymodel extends AbstractTableModel{

    private String[] columns;
    private  Object[][] rows;
    
    public mymodel(){}
    
    
    public mymodel(Object[][] data,String[] columnName)
    {
        
     this.columns=columnName;
     
     this.rows=data;
     
    }
    @Override
    public Class getColumnClass(int col)
    {
        
        
        
   if(col==8)
    {
         
        return ImageIcon.class; 
      
     }
     else{ 
          return getValueAt(0,col).getClass();
    }
  }
   
        
   
    
    @Override
    public int getRowCount() {
         
        
        return this.rows.length;
        
        
    }
    @Override
    public int getColumnCount() {
      
        
      return this.columns.length;  
        
        
        
    }  
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
    
        return this.rows[rowIndex][columnIndex];
    
    }
    
    @Override
    public String getColumnName(int col)
    {
        
        
        return this.columns[col];
        
    }
    
    
    
}
