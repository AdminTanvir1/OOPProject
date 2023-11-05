package javaapplication1;
import java.awt.Color;
import static java.awt.Event.ENTER;
import java.awt.event.KeyEvent;
import java.sql.*;
import project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Patients_List extends javax.swing.JFrame {

    public Patients_List() {
        setUndecorated(true);
        initComponents();
        
        
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           ResultSet rs = st.executeQuery("select * from patientinfo");
           ResultSetMetaData rsmd = rs.getMetaData();
           int n = rsmd.getColumnCount();
           DefaultTableModel dtm = (DefaultTableModel) Patient_Table.getModel();
           dtm.setRowCount(0);
           while(rs.next()){
               Vector v = new Vector();
               for(int i = 1; i <= n; i++){
                   v.add(rs.getString("Patient_Name"));
                   v.add(rs.getString("Mobile_Number"));
                   v.add(rs.getString("Age"));
                   v.add(rs.getString("Gender"));
                   v.add(rs.getString("Assign_Doctor"));
                   v.add(rs.getString("Appointment_Time"));
                   v.add(rs.getString("Problem_in_Details"));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1360, 768));
        setMinimumSize(new java.awt.Dimension(1360, 768));
        setPreferredSize(new java.awt.Dimension(1360, 768));
        getContentPane().setLayout(null);

        Patient_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient_Name", "Mobile_Number", "Age", "Gender", "Assign_Doctor", "Date", "Details"
            }
        ));
        jScrollPane1.setViewportView(Patient_Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 40, 825, 402);

        jButton1.setText("All List");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 480, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patients_List.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patients_List().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JTable Patient_Table = new javax.swing.JTable();
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
