
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shadab
 */
public class myfunc {
    
    
    public ImageIcon ResizePic(String picPath,byte[] BLOBpic,int widh,int hgt)
    {
        ImageIcon myimage;
       if(picPath!=null) 
       {
           myimage=new ImageIcon(picPath);   
       }  
     else
       {
           
             myimage=new ImageIcon(BLOBpic); 
       }
        
      
    Image img = myimage.getImage().getScaledInstance( widh, hgt,Image.SCALE_SMOOTH);
       
       ImageIcon mypicture=new ImageIcon(img);       
              
            return mypicture;  
    }
    
    public String BrowseImage(JLabel lb1)
    {
        String path="";
         JFileChooser filec=new JFileChooser();  

        filec.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        
        FileNameExtensionFilter filefilter= new FileNameExtensionFilter("*images","jpg","png","gif");
        
        filec.addChoosableFileFilter(filefilter);
        
        int filestate= filec.showSaveDialog(null);
        
        if(filestate==JFileChooser.APPROVE_OPTION)

        {
              File SelectedFile=filec.getSelectedFile();
              
               path=SelectedFile.getAbsolutePath();
              
             // imgpth=path;
               lb1.setIcon(ResizePic(path,null,lb1.getWidth(),lb1.getHeight()));
        }
            // jLabel2_picc.setIcon(new ImageIcon(path)); 

        else if(filestate==JFileChooser.CANCEL_OPTION)     
        {
        
        System.out.println("no image selected");
        
        
        }  
    
return path;
    }}
        
    

