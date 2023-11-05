package javaapplication1;

import java.sql.*;
import project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javaapplication1.Dashboard1.loginName1;
import static javaapplication1.Dashboard1.myimg;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {
    

    public Login() {
        setUndecorated(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        ShowPassword = new javax.swing.JCheckBox();
        Password = new javax.swing.JPasswordField();
        ForgotPassword = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        NoAccount = new javax.swing.JLabel();
        BGImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 1, 16)); // NOI18N
        jLabel1.setText("Welcome Back");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, -1, -1));

        Email.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Enter Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 340, 280, 50));

        ShowPassword.setForeground(new java.awt.Color(235, 20, 73));
        ShowPassword.setContentAreaFilled(false);
        ShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(ShowPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 420, -1, -1));

        Password.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Passward", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 400, 280, 50));

        ForgotPassword.setFont(new java.awt.Font("Montserrat Medium", 0, 10)); // NOI18N
        ForgotPassword.setForeground(new java.awt.Color(29, 180, 254));
        ForgotPassword.setText("Forgot Password?");
        getContentPane().add(ForgotPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 460, -1, -1));

        LoginBtn.setBackground(new java.awt.Color(29, 180, 254));
        LoginBtn.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.setBorderPainted(false);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(LoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 490, 280, 40));

        NoAccount.setFont(new java.awt.Font("Montserrat Medium", 0, 10)); // NOI18N
        NoAccount.setForeground(new java.awt.Color(29, 180, 254));
        NoAccount.setText("Don't have an account? Sign Up!");
        NoAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NoAccountMouseClicked(evt);
            }
        });
        getContentPane().add(NoAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 530, 170, 20));

        BGImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/bg 2.png"))); // NOI18N
        getContentPane().add(BGImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
         String email = Email.getText();
         String pass = Password.getText();
         
         
       try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from signup where email = '"+email+"' and pass ='"+pass+"'");
          
           if(rs.next())
           {
               new Dashboard1().setVisible(true);
               loginName1.setText(rs.getString(1));
               String userEmail = rs.getString(2);
               
               String imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\DefaultImg.png";
                if (userEmail.equals("tanvir@gmail.com")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\tanvirImg.png";
             } else if (userEmail.equals("rakib@gmail.com")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\RakibImg.png";
             }
             else if (userEmail.equals("anim@gmail.com")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\AnimImg.png";
             }
             else if (userEmail.equals("polash@gmail.com")) {
                 imagePath = "C:\\Users\\wizar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1\\profileImages\\PolashImg.png";
             }
              myimg.setIcon(new ImageIcon(imagePath));
              setVisible(false);

           }else
               
           JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void ShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordActionPerformed
        // TODO add your handling code here:
        if (ShowPassword.isSelected()) { 
                Password.setEchoChar((char)0);
        } 
        else {
        Password.setEchoChar('*');
        }
    }//GEN-LAST:event_ShowPasswordActionPerformed

    private void NoAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoAccountMouseClicked

        setVisible(false);
        new SignUpDB().setVisible(true);
    }//GEN-LAST:event_NoAccountMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGImage;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel ForgotPassword;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel NoAccount;
    private javax.swing.JPasswordField Password;
    private javax.swing.JCheckBox ShowPassword;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
