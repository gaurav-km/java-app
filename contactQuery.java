
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

 
public class contactQuery {
    
    
    public void  InsertContact(contact cont)
    
    {
        
        
        try {
            Connection con=myconnection.getconnection();
            
            PreparedStatement ps;
            
            String qury="INSERT INTO `mycontact`( `fname`, `lname`, `groupc`, `phone`, `email`, `adress`, `pic`, `userid`) VALUES (?,?,?,?,?,?,?,? )";
            
            ps=con.prepareStatement(qury);
            
            ps.setString(1,cont.getFname());
            
               ps.setString(2,cont.getLname());
            ps.setString(3,cont.getGroupc());   
            
               ps.setString(4,cont.getPhone());
                  ps.setString(5,cont.getEmail());
                                    

                     ps.setString(6,cont.getAddress());
                     ps.setBytes(7,cont.getPic());
                        ps.setInt(8,cont.getUid());
                        
                           if(ps.executeUpdate()!=0)
                
            {   
                
                JOptionPane.showMessageDialog(null,"new contact added");    
              
                  
           }
            
           else
            {
             
                JOptionPane.showMessageDialog(null,"something wrong"); 
                
            }
           
         
                  
                  
                  
                  
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
     public void  UpdateContact(contact cont, boolean withImage)
    
    { 
        
           Connection con=myconnection.getconnection();
            
          PreparedStatement ps;  
         
        
        
         String updateQuery=null;
        if(withImage==true)//id user want to update his/her iprofilepic 
       {
           
           
      updateQuery="UPDATE `mycontact` SET `fname`= ?,lname =?,`groupc`=?,`phone`=?,`email`=?,adress=?,pic=? WHERE id=?";   
          
        try {
           
            ps=con.prepareStatement(updateQuery);
            
            ps.setString(1,cont.getFname());
            
               ps.setString(2,cont.getLname());
            ps.setString(3,cont.getGroupc());   
            
               ps.setString(4,cont.getPhone());
                  ps.setString(5,cont.getEmail());
                                    

                     ps.setString(6,cont.getAddress());
                     ps.setBytes(7,cont.getPic());
                         
                        ps.setInt(8,cont.getCid()); 
                           if(ps.executeUpdate()!=0)
                
            {   
                
                JOptionPane.showMessageDialog(null,"Contact data is Updated");    
              
                  
           }
            
           else
            {
             
                JOptionPane.showMessageDialog(null,"something wrong"); 
                
            }
           
         
                  
                  
                  
                  
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       }
       
       
       
       else         //the user want to keep the same IMage
       {
         updateQuery="UPDATE `mycontact` SET `fname`= ?,lname =?,groupc =?,`phone`=?,`email`=?,adress=? WHERE id=?";     
           
        try {
           
           
            ps=con.prepareStatement( updateQuery);
            
            ps.setString(1,cont.getFname());
            
               ps.setString(2,cont.getLname());
            ps.setString(3,cont.getGroupc());   
            
               ps.setString(4,cont.getPhone());
                  ps.setString(5,cont.getEmail());
                                    

                     ps.setString(6,cont.getAddress());
                     
                        ps.setInt(7,cont.getCid());
                        
                           if(ps.executeUpdate()!=0)
                
            {   
                
                JOptionPane.showMessageDialog(null,"Contact data is Updated");    
              
                  
           }
            
           else
            {
             
                JOptionPane.showMessageDialog(null,"something wrong"); 
                
            }
           
         
                  
                  
                  
                  
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
       }
      /*  try {
           
            ps=con.prepareStatement( updateQuery);
            
            ps.setString(1,cont.getFname());
            
               ps.setString(2,cont.getLname());
            ps.setString(3,cont.getGroupc());   
            
               ps.setString(4,cont.getPhone());
                  ps.setString(5,cont.getEmail());
                                    

                     ps.setString(6,cont.getAddress());
                     ps.setBytes(7,cont.getPic());
                        ps.setInt(8,cont.getUid());
                        
                           if(ps.executeUpdate()!=0)
                
            {   
                
                JOptionPane.showMessageDialog(null,"new contact added");    
              
                  
           }
            
           else
            {
             
                JOptionPane.showMessageDialog(null,"something wrong"); 
                
            }
           
         
                  
                  
                  
                  
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
      */
    }
   
    
    
      public void  DeleteContact(int cid)
    
    {
        
        
        try {
            Connection con=myconnection.getconnection();
            
            PreparedStatement ps;
            
            String qury=  "DELETE FROM `mycontact` WHERE `id`=?";
            
            
            
            ps=con.prepareStatement(qury);
            
            ps.setInt(1, cid);
            
            if(ps.executeUpdate()!=0)
                      
                
            {   
                
                JOptionPane.showMessageDialog(null,"Contacted deleted");    
              
                  
           }
            
           else
            {
             
                JOptionPane.showMessageDialog(null,"something wrong"); 
                
            }
           
         
                  
                  
                  
                  
            
        } catch (SQLException ex) {
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    
    public ArrayList<contact>contactList(int userid)
    {
        
      ArrayList<contact> clist=new ArrayList<contact>();
      try {
      
       Connection con=myconnection.getconnection();
       
           Statement st;
           
           ResultSet rs;
     //  String query="SELECT `id`, `fname`, `lname`, `groupc`, `phone`, `email`, `adress`, `pic`, FROM `mycontact`";
       
       
      st= con.createStatement();
      
      rs=st.executeQuery("SELECT `id`, `fname`, `lname`, `groupc`, `phone`, `email`, `adress`, `pic`from mycontact where userid="+userid);
             
           
            
        
             
        
        contact ct;
        
        while(rs.next())
        {
            
            ct=new contact(rs.getInt("id"),
                    rs.getString("fname"),
                    rs.getString("lname"),
                        rs.getString("groupc"),
                    rs.getString("phone"),
                    rs.getString("email"),
                     rs.getString("adress"),
                    rs.getBytes("pic"), userid);
             
            
            
            
            
            clist.add(ct);
            
        }
        
        
       
        
        
        
        } catch (SQLException ex) {
            
            Logger.getLogger(contactQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
           
       
       
       return clist;
    }
        
    }
    


    
