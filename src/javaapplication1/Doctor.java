
package javaapplication1;

import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static javax.swing.text.html.HTML.Tag.OPTION;
import project.ConnectionProvider;
import static javaapplication1.Doc_popup.S_doc;
import static javaapplication1.Doc_popup.S_desig;
import static javaapplication1.Doc_popup.S_degr;
import static javaapplication1.Doc_popup.S_uni;
import static javaapplication1.Doc_popup.S_num;
import static javaapplication1.Doc_popup.S_img;
import static javaapplication1.Patients_List.Patient_Table;
import javax.swing.table.DefaultTableModel;
public class Doctor extends javax.swing.JFrame {
    private String imagePath;
    public Doctor() {
        setUndecorated(true);
        initComponents();
        find_Doctor.setVisible(false);
        
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           ResultSet rs = st.executeQuery("select * from doctor_info");
           ResultSetMetaData rsmd = rs.getMetaData();
           int n = rsmd.getColumnCount();
           DefaultTableModel dtm = (DefaultTableModel) Doc_Table.getModel();
           dtm.setRowCount(0);
           while(rs.next()){
               Vector v = new Vector();
               for(int i = 1; i <= n; i++){
                   v.add(rs.getString("name"));
                   v.add(rs.getString("number"));
                   v.add(rs.getString("designation"));
                   v.add(rs.getString("degree"));
               }
               dtm.addRow(v);
           }

        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
        
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void setDoctorInfo(String name, String number, String designation, String degree, String university, String imagePath) {
    try {
        Connection con = ConnectionProvider.getCon();
        InputStream is = new FileInputStream(new File(imagePath));
        
        // Assuming 'image' is the BLOB column in your database
        PreparedStatement pst = con.prepareStatement("INSERT INTO doctor_info (name, number, designation, degree, university, image) VALUES (?, ?, ?, ?, ?, ?)");
        
        pst.setString(1, name);
        pst.setString(2, number);
        pst.setString(3, designation);
        pst.setString(4, degree);
        pst.setString(5, university);
        pst.setBlob(6, is);
        
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data inserted successfully");
    } catch (SQLException ex) {
        Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_name = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_designation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        loginName2 = new javax.swing.JLabel();
        loginName3 = new javax.swing.JLabel();
        loginName4 = new javax.swing.JLabel();
        loginName5 = new javax.swing.JLabel();
        loginName6 = new javax.swing.JLabel();
        loginName7 = new javax.swing.JLabel();
        loginName8 = new javax.swing.JLabel();
        loginName9 = new javax.swing.JLabel();
        loginName = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Doc_Table = new javax.swing.JTable();
        Doc_University = new javax.swing.JTextField();
        Doc_Degree = new javax.swing.JTextField();
        select_image = new javax.swing.JButton();
        Doc_Image = new javax.swing.JLabel();
        find_Doctor = new javax.swing.JButton();
        newPatient = new javax.swing.JButton();
        bar1 = new javax.swing.JPanel();
        oldPatient = new javax.swing.JButton();
        bar2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1360, 768));
        setMinimumSize(new java.awt.Dimension(1360, 768));
        getContentPane().setLayout(null);

        txt_name.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Doctor's Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_name);
        txt_name.setBounds(410, 370, 280, 40);

        txt_phone.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Mobile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        txt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneActionPerformed(evt);
            }
        });
        getContentPane().add(txt_phone);
        txt_phone.setBounds(410, 420, 280, 40);

        txt_designation.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Designation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(txt_designation);
        txt_designation.setBounds(410, 470, 280, 40);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(470, 720, 180, 23);

        loginName2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName2.setForeground(new java.awt.Color(255, 255, 255));
        loginName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName2.setText("Dashboard");
        loginName2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName2MouseEntered(evt);
            }
        });
        loginName2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                loginName2PropertyChange(evt);
            }
        });
        getContentPane().add(loginName2);
        loginName2.setBounds(90, 300, 120, 18);

        loginName3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName3.setForeground(new java.awt.Color(29, 180, 254));
        loginName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName3.setText("Doctors");
        loginName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName3MouseClicked(evt);
            }
        });
        getContentPane().add(loginName3);
        loginName3.setBounds(90, 330, 120, 18);

        loginName4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName4.setForeground(new java.awt.Color(255, 255, 255));
        loginName4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName4.setText("Patients");
        getContentPane().add(loginName4);
        loginName4.setBounds(90, 360, 120, 18);

        loginName5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName5.setForeground(new java.awt.Color(255, 255, 255));
        loginName5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName5.setText("Appointments");
        getContentPane().add(loginName5);
        loginName5.setBounds(90, 390, 120, 18);

        loginName6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName6.setForeground(new java.awt.Color(255, 255, 255));
        loginName6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName6.setText("Prescription");
        getContentPane().add(loginName6);
        loginName6.setBounds(90, 420, 120, 18);

        loginName7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName7.setForeground(new java.awt.Color(255, 255, 255));
        loginName7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName7.setText("Lab Reports");
        getContentPane().add(loginName7);
        loginName7.setBounds(90, 450, 120, 18);

        loginName8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName8.setForeground(new java.awt.Color(255, 255, 255));
        loginName8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName8.setText("Medicines");
        getContentPane().add(loginName8);
        loginName8.setBounds(90, 480, 120, 18);

        loginName9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName9.setForeground(new java.awt.Color(255, 255, 255));
        loginName9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName9.setText("Ambulances");
        getContentPane().add(loginName9);
        loginName9.setBounds(90, 510, 120, 18);

        loginName.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName.setForeground(new java.awt.Color(255, 255, 255));
        loginName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName.setText("Payments");
        getContentPane().add(loginName);
        loginName.setBounds(90, 540, 120, 18);

        jButton3.setBackground(new java.awt.Color(29, 180, 254));
        jButton3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(90, 669, 75, 23);

        loginName1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName1.setForeground(new java.awt.Color(29, 180, 254));
        loginName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginName1.setText("Name");
        getContentPane().add(loginName1);
        loginName1.setBounds(40, 180, 170, 30);

        Doc_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Number", "Designation", "Degree"
            }
        ));
        jScrollPane1.setViewportView(Doc_Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(780, 340, 460, 402);

        Doc_University.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "University", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Doc_University.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Doc_UniversityActionPerformed(evt);
            }
        });
        getContentPane().add(Doc_University);
        Doc_University.setBounds(410, 570, 280, 40);

        Doc_Degree.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Degree", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        getContentPane().add(Doc_Degree);
        Doc_Degree.setBounds(410, 520, 280, 40);

        select_image.setText("Choose Image");
        select_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_imageActionPerformed(evt);
            }
        });
        getContentPane().add(select_image);
        select_image.setBounds(410, 650, 110, 23);
        getContentPane().add(Doc_Image);
        Doc_Image.setBounds(600, 620, 90, 90);

        find_Doctor.setText("Find");
        find_Doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_DoctorActionPerformed(evt);
            }
        });
        getContentPane().add(find_Doctor);
        find_Doctor.setBounds(470, 690, 180, 23);

        newPatient.setBackground(new java.awt.Color(29, 180, 254));
        newPatient.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        newPatient.setForeground(new java.awt.Color(255, 255, 255));
        newPatient.setText("New Patient");
        newPatient.setBorder(null);
        newPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newPatientMouseClicked(evt);
            }
        });
        newPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPatientActionPerformed(evt);
            }
        });
        newPatient.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                newPatientPropertyChange(evt);
            }
        });
        getContentPane().add(newPatient);
        newPatient.setBounds(400, 310, 110, 30);

        bar1.setBackground(new java.awt.Color(29, 180, 254));
        getContentPane().add(bar1);
        bar1.setBounds(400, 350, 110, 5);

        oldPatient.setBackground(new java.awt.Color(102, 102, 102));
        oldPatient.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        oldPatient.setForeground(new java.awt.Color(255, 255, 255));
        oldPatient.setText("Old Patient");
        oldPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oldPatientMouseClicked(evt);
            }
        });
        oldPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPatientActionPerformed(evt);
            }
        });
        getContentPane().add(oldPatient);
        oldPatient.setBounds(600, 310, 110, 30);

        bar2.setBackground(new java.awt.Color(204, 204, 204));
        bar2.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(bar2);
        bar2.setBounds(600, 350, 110, 5);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Das-board1 bg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setDoctorInfo(txt_name.getText(), txt_phone.getText(), txt_designation.getText(), Doc_Degree.getText(), Doc_University.getText(), imagePath);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loginName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseClicked
        // TODO add your handling code here:
        
        setVisible(false);
        new Doctor().setVisible(true);
    }//GEN-LAST:event_loginName3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void loginName2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_loginName2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_loginName2PropertyChange

    private void loginName2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_loginName2MouseEntered

    private void loginName2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName2MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Dashboard1().setVisible(true);
    }//GEN-LAST:event_loginName2MouseClicked

    private void Doc_UniversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Doc_UniversityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Doc_UniversityActionPerformed

    private void select_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_imageActionPerformed
        JFileChooser filechooser = new JFileChooser();
        filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif");
        filechooser.setFileFilter(filter);
        int result = filechooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filechooser.getSelectedFile();
            imagePath = selectedFile.getAbsolutePath(); // Set the imagePath
            Doc_Image.setIcon(ResizeImage(imagePath));
        }
    }//GEN-LAST:event_select_imageActionPerformed

    private void find_DoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_DoctorActionPerformed
        // TODO add your handling code here:
        String name = txt_name.getText();
        String number = txt_phone.getText();
        
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from doctor_info where name = '"+name+"' and number ='"+number+"'");
          
           if(rs.next())
           {
              
              new Doc_popup().setVisible(true);
              S_doc.setText(rs.getString(1)); 
              S_desig.setText(rs.getString(3));
              S_degr.setText(rs.getString(4));
              S_uni.setText(rs.getString(5));
              S_num.setText(rs.getString(2));
              
               Blob imageBlob = (Blob) rs.getBlob(6);

                if (imageBlob != null) {
                // Convert BLOB to byte array
                byte[] imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());

                // Convert byte array to ImageIcon
                ImageIcon imageIcon = new ImageIcon(imageBytes);
                S_img.setIcon(imageIcon);
               }
              
           }else
               
           JOptionPane.showMessageDialog(null,"No details found");
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }//GEN-LAST:event_find_DoctorActionPerformed

    private void newPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPatientMouseClicked
        // TODO add your handling code here:
        newPatient.setBackground(new Color(29,180,254));
        bar1.setBackground(new Color(29,180,254));

        oldPatient.setBackground(new Color(102,102,102));
        bar2.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_newPatientMouseClicked

    private void newPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientActionPerformed
        txt_designation.setVisible(true);
        Doc_Degree.setVisible(true);
        Doc_University.setVisible(true);
        select_image.setVisible(true);
        Doc_Image.setVisible(true);
        select_image.setVisible(true);
        jButton1.setVisible(true);
        
        find_Doctor.setVisible(false);
    }//GEN-LAST:event_newPatientActionPerformed

    private void newPatientPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_newPatientPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_newPatientPropertyChange

    private void oldPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldPatientMouseClicked
        // TODO add your handling code here:
        newPatient.setBackground(new Color(102,102,102));
        bar1.setBackground(new Color(102,102,102));

        oldPatient.setBackground(new Color(29,180,254));
        bar2.setBackground(new Color(29,180,254));
    }//GEN-LAST:event_oldPatientMouseClicked

    private void oldPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPatientActionPerformed
        // TODO add your handling code here:
        txt_designation.setVisible(false);
        Doc_Degree.setVisible(false);
        Doc_University.setVisible(false);

        select_image.setVisible(false);
        Doc_Image.setVisible(false);
        select_image.setVisible(false);
        jButton1.setVisible(false);
        
        find_Doctor.setVisible(true);

    }//GEN-LAST:event_oldPatientActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed
    public ImageIcon ResizeImage(String imgPath) {
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image image = MyImage.getImage();
        Image newImage = image.getScaledInstance(Doc_Image.getWidth(), Doc_Image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(newImage);
        return resizedImage;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Doc_Degree;
    private javax.swing.JLabel Doc_Image;
    private javax.swing.JTable Doc_Table;
    private javax.swing.JTextField Doc_University;
    private javax.swing.JPanel bar1;
    private javax.swing.JPanel bar2;
    private javax.swing.JButton find_Doctor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loginName;
    public static final javax.swing.JLabel loginName1 = new javax.swing.JLabel();
    private javax.swing.JLabel loginName2;
    private javax.swing.JLabel loginName3;
    private javax.swing.JLabel loginName4;
    private javax.swing.JLabel loginName5;
    private javax.swing.JLabel loginName6;
    private javax.swing.JLabel loginName7;
    private javax.swing.JLabel loginName8;
    private javax.swing.JLabel loginName9;
    private javax.swing.JButton newPatient;
    private javax.swing.JButton oldPatient;
    private javax.swing.JButton select_image;
    private javax.swing.JTextField txt_designation;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
