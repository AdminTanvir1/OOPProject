package javaapplication1;

import java.awt.Color;
import java.sql.*;
import project.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import static javaapplication1.Prescription.Date1;
import static javaapplication1.Prescription.PetName;
import static javaapplication1.Prescription.patAge;
import static javaapplication1.Prescription.genderLevel;
import static javaapplication1.Prescription.problem12;
import static javaapplication1.Prescription.DoctorName1;
import static javaapplication1.Prescription.doc_degi_data;
import static javaapplication1.Prescription.Doc_uni_data;
import static javaapplication1.Prescription.Doc_degree_data;
import static javaapplication1.Prescription.Doc_mob_data;
import static javaapplication1.Patients_List.Patient_Table;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static javaapplication1.Prescription.Doc_degree_data;


public class Dashboard1 extends javax.swing.JFrame {
    public static String userEmail;

    public Dashboard1() {
        
        setUndecorated(true);
        initComponents();
        UpdateCombo();
        setDataToCard();
        patientFind.setVisible(false);
        
               try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement();
           
           ResultSet rs = st.executeQuery("select * from signup where email = "+userEmail);
          
           if(rs.next())
           {
               loginName1.setText(rs.getString("userEmail"));
           }
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
        
    }
    public void UpdateCombo(){
        try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery("select * from doctor_info");
          
           while(rs.next())
           {
              DocCombo.addItem(rs.getString(1));
              
           }
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }
            
   public void setDataToCard(){
       try{
           Connection conn = ConnectionProvider.getCon();
           Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           ResultSet rs = st.executeQuery("select * from patientinfo");
           rs.last();
           numberOfDoctor.setText(Integer.toString(rs.getRow()));
           
           rs = st.executeQuery("select * from signup");
           rs.last();
           numberOfDoctor1.setText(Integer.toString(rs.getRow()));
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

        grnder = new javax.swing.ButtonGroup();
        loginName = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        gender1 = new javax.swing.JLabel();
        problem1 = new javax.swing.JLabel();
        doctor1 = new javax.swing.JLabel();
        patientProblem = new javax.swing.JTextField();
        patientName = new javax.swing.JTextField();
        patientNumber = new javax.swing.JTextField();
        patientAge = new javax.swing.JTextField();
        patientGenderFemale = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        patientFind = new javax.swing.JButton();
        patientGenderMale = new javax.swing.JRadioButton();
        oldPatient = new javax.swing.JButton();
        newPatient = new javax.swing.JButton();
        patientRegistation = new javax.swing.JButton();
        loginName2 = new javax.swing.JLabel();
        loginName3 = new javax.swing.JLabel();
        loginName4 = new javax.swing.JLabel();
        loginName5 = new javax.swing.JLabel();
        loginName6 = new javax.swing.JLabel();
        loginName7 = new javax.swing.JLabel();
        loginName8 = new javax.swing.JLabel();
        loginName9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        numberOfDoctor1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numberOfDoctor = new javax.swing.JLabel();
        bar1 = new javax.swing.JPanel();
        bar2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1360, 768));
        setMinimumSize(new java.awt.Dimension(1360, 768));
        setPreferredSize(new java.awt.Dimension(1360, 768));
        getContentPane().setLayout(null);

        loginName.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName.setForeground(new java.awt.Color(255, 255, 255));
        loginName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName.setText("Payments");
        loginName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginNameMouseExited(evt);
            }
        });
        getContentPane().add(loginName);
        loginName.setBounds(90, 540, 120, 18);

        time1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        time1.setText("Appointment Date:");
        getContentPane().add(time1);
        time1.setBounds(540, 600, 180, 16);

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel3.setText("Patient Name: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 400, 110, 18);

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel4.setText("Mobile Number:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(540, 440, 150, 16);

        age1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        age1.setText("Age:");
        getContentPane().add(age1);
        age1.setBounds(540, 480, 110, 16);

        gender1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        gender1.setText("Gender:");
        getContentPane().add(gender1);
        gender1.setBounds(540, 520, 110, 16);

        problem1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        problem1.setText("Problem in Details:");
        getContentPane().add(problem1);
        problem1.setBounds(540, 640, 180, 16);

        doctor1.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        doctor1.setText("Doctor:");
        getContentPane().add(doctor1);
        doctor1.setBounds(540, 560, 180, 16);

        patientProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientProblemActionPerformed(evt);
            }
        });
        getContentPane().add(patientProblem);
        patientProblem.setBounds(740, 630, 280, 30);

        patientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameActionPerformed(evt);
            }
        });
        getContentPane().add(patientName);
        patientName.setBounds(740, 400, 280, 30);

        patientNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNumberActionPerformed(evt);
            }
        });
        getContentPane().add(patientNumber);
        patientNumber.setBounds(740, 440, 280, 30);

        patientAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientAgeActionPerformed(evt);
            }
        });
        getContentPane().add(patientAge);
        patientAge.setBounds(740, 480, 280, 30);

        grnder.add(patientGenderFemale);
        patientGenderFemale.setText("Female");
        patientGenderFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientGenderFemaleActionPerformed(evt);
            }
        });
        getContentPane().add(patientGenderFemale);
        patientGenderFemale.setBounds(840, 520, 70, 21);

        jButton1.setBackground(new java.awt.Color(29, 180, 254));
        jButton1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(90, 669, 75, 23);

        patientFind.setBackground(new java.awt.Color(29, 180, 254));
        patientFind.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        patientFind.setForeground(new java.awt.Color(255, 255, 255));
        patientFind.setText("Find");
        patientFind.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientFindMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientFindMouseExited(evt);
            }
        });
        patientFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientFindActionPerformed(evt);
            }
        });
        getContentPane().add(patientFind);
        patientFind.setBounds(680, 670, 190, 30);

        grnder.add(patientGenderMale);
        patientGenderMale.setText("Male");
        patientGenderMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientGenderMaleActionPerformed(evt);
            }
        });
        getContentPane().add(patientGenderMale);
        patientGenderMale.setBounds(740, 520, 49, 21);

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
        oldPatient.setBounds(880, 313, 150, 30);

        newPatient.setBackground(new java.awt.Color(29, 180, 254));
        newPatient.setFont(new java.awt.Font("Montserrat SemiBold", 0, 12)); // NOI18N
        newPatient.setForeground(new java.awt.Color(255, 255, 255));
        newPatient.setText("New Patient");
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
        newPatient.setBounds(490, 313, 150, 30);

        patientRegistation.setBackground(new java.awt.Color(29, 180, 254));
        patientRegistation.setFont(new java.awt.Font("Montserrat SemiBold", 0, 15)); // NOI18N
        patientRegistation.setForeground(new java.awt.Color(255, 255, 255));
        patientRegistation.setText("Registation");
        patientRegistation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientRegistationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientRegistationMouseExited(evt);
            }
        });
        patientRegistation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientRegistationActionPerformed(evt);
            }
        });
        getContentPane().add(patientRegistation);
        patientRegistation.setBounds(680, 710, 190, 30);

        loginName1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName1.setForeground(new java.awt.Color(29, 180, 254));
        loginName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginName1.setText("Name");
        getContentPane().add(loginName1);
        loginName1.setBounds(40, 180, 170, 30);

        loginName2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName2.setForeground(new java.awt.Color(29, 180, 254));
        loginName2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName2.setText("Dashboard");
        getContentPane().add(loginName2);
        loginName2.setBounds(90, 300, 120, 18);

        loginName3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName3.setForeground(new java.awt.Color(255, 255, 255));
        loginName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName3.setText("Doctors");
        loginName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName3MouseExited(evt);
            }
        });
        getContentPane().add(loginName3);
        loginName3.setBounds(90, 330, 120, 18);

        loginName4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName4.setForeground(new java.awt.Color(255, 255, 255));
        loginName4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName4.setText("Patients");
        loginName4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginName4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName4MouseExited(evt);
            }
        });
        getContentPane().add(loginName4);
        loginName4.setBounds(90, 360, 120, 18);

        loginName5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName5.setForeground(new java.awt.Color(255, 255, 255));
        loginName5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName5.setText("Appointments");
        loginName5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName5MouseExited(evt);
            }
        });
        getContentPane().add(loginName5);
        loginName5.setBounds(90, 390, 120, 18);

        loginName6.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName6.setForeground(new java.awt.Color(255, 255, 255));
        loginName6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName6.setText("Prescription");
        loginName6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName6MouseExited(evt);
            }
        });
        getContentPane().add(loginName6);
        loginName6.setBounds(90, 420, 120, 18);

        loginName7.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName7.setForeground(new java.awt.Color(255, 255, 255));
        loginName7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName7.setText("Lab Reports");
        loginName7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName7MouseExited(evt);
            }
        });
        getContentPane().add(loginName7);
        loginName7.setBounds(90, 450, 120, 18);

        loginName8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName8.setForeground(new java.awt.Color(255, 255, 255));
        loginName8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName8.setText("Medicines");
        loginName8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName8MouseExited(evt);
            }
        });
        getContentPane().add(loginName8);
        loginName8.setBounds(90, 480, 120, 18);

        loginName9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        loginName9.setForeground(new java.awt.Color(255, 255, 255));
        loginName9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loginName9.setText("Ambulances");
        loginName9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginName9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginName9MouseExited(evt);
            }
        });
        getContentPane().add(loginName9);
        loginName9.setBounds(90, 510, 120, 18);

        jLabel2.setText("Doctor");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 230, 37, 16);

        numberOfDoctor1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfDoctor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numberOfDoctor1);
        numberOfDoctor1.setBounds(670, 160, 100, 100);

        jLabel6.setText("Patient");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(700, 230, 50, 16);

        numberOfDoctor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        numberOfDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numberOfDoctor);
        numberOfDoctor.setBounds(410, 160, 100, 100);

        bar1.setBackground(new java.awt.Color(29, 180, 254));
        getContentPane().add(bar1);
        bar1.setBounds(490, 348, 150, 5);

        bar2.setBackground(new java.awt.Color(204, 204, 204));
        bar2.setForeground(new java.awt.Color(153, 153, 153));
        getContentPane().add(bar2);
        bar2.setBounds(880, 348, 150, 5);
        getContentPane().add(myimg);
        myimg.setBounds(76, 52, 110, 110);

        DocCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DocComboActionPerformed(evt);
            }
        });
        getContentPane().add(DocCombo);
        DocCombo.setBounds(740, 550, 280, 30);
        DocCombo.getAccessibleContext().setAccessibleName("Select Doctor");

        getContentPane().add(Appoit_time);
        Appoit_time.setBounds(740, 590, 280, 30);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Das-board1 bg.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(1300, 765));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 768);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void patientProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientProblemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientProblemActionPerformed

    private void patientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameActionPerformed

    private void patientNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNumberActionPerformed

    private void patientAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientAgeActionPerformed

    private void patientGenderFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientGenderFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientGenderFemaleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void patientGenderMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientGenderMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientGenderMaleActionPerformed

    private void oldPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPatientActionPerformed
        // TODO add your handling code here:
        age1.setVisible(false);
        gender1.setVisible(false);
        doctor1.setVisible(false);
        time1.setVisible(false);
        problem1.setVisible(false);
        patientRegistation.setVisible(false);
        patientFind.setVisible(true);
        
        patientAge.setVisible(false);
        patientGenderMale.setVisible(false);
        patientGenderFemale.setVisible(false);
        DocCombo.setVisible(false);
        
        
        Appoit_time.setVisible(false);
        patientProblem.setVisible(false);
    }//GEN-LAST:event_oldPatientActionPerformed

    private void newPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPatientActionPerformed
        // TODO add your handling code here:
        age1.setVisible(true);
        gender1.setVisible(true);
        doctor1.setVisible(true);
        time1.setVisible(true);
        problem1.setVisible(true);
        patientRegistation.setVisible(true);
        patientFind.setVisible(false);
        
        patientAge.setVisible(true);
        patientGenderMale.setVisible(true);
        patientGenderFemale.setVisible(true);
        DocCombo.setVisible(true);
        
        Appoit_time.setVisible(true);
        patientProblem.setVisible(true);
    }//GEN-LAST:event_newPatientActionPerformed

    private void newPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newPatientMouseClicked
        // TODO add your handling code here:
        newPatient.setBackground(new Color(29,180,254));
        bar1.setBackground(new Color(29,180,254));
        
        oldPatient.setBackground(new Color(102,102,102));
        bar2.setBackground(new Color(102,102,102));
    }//GEN-LAST:event_newPatientMouseClicked

    private void newPatientPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_newPatientPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_newPatientPropertyChange

    private void patientRegistationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientRegistationActionPerformed
        String Patient_Name = patientName.getText();
        String Mobile_Number = patientNumber.getText();
        String Age = patientAge.getText();
        String Gender;
        if (patientGenderMale.isSelected()) {
         Gender = "Male";
            } else if (patientGenderFemale.isSelected()) {
            Gender = "Female";
        } else {
          Gender = "Not specified";
        }
        String Assign_Doctor = DocCombo.getSelectedItem().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, y");
        String Appointment_Time = sdf.format(Appoit_time.getDate());
        String Problem_in_Details = patientProblem.getText();
        
        if(Patient_Name.equals("")|| Mobile_Number.equals("")||Age.equals("")||Gender.equals("")||Assign_Doctor.equals("")||Appointment_Time.equals("")||Problem_in_Details.equals(""))
            JOptionPane.showMessageDialog(null,"Every Field Is Required!");
        else{
           try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate("Insert into patientinfo value('"+Patient_Name+"','"+Mobile_Number+"','"+Age+"','"+Gender+"','"+Assign_Doctor+"','"+Appointment_Time+"','"+Problem_in_Details+"')");
            JOptionPane.showMessageDialog(null,"Successfully Updated");
            
         }
        
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e); 
        } 
        }
    }//GEN-LAST:event_patientRegistationActionPerformed

    private void patientFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientFindActionPerformed
         // TODO add your handling code here:
        String Patient_Name = patientName.getText();
        String Mobile_Number = patientNumber.getText();
        
       try{
           Connection patientConn = ConnectionProvider.getCon();
           Statement patientStatement = patientConn.createStatement();
           ResultSet patientRs = patientStatement.executeQuery("select * from patientinfo where Patient_Name = '"+Patient_Name+"' and Mobile_Number ='"+Mobile_Number+"'");
          
           if(patientRs.next())
           {
              String assignedDoctor = patientRs.getString("Assign_Doctor");
              
              Connection doctorConn = ConnectionProvider.getCon();
              Statement doctorStatement = doctorConn.createStatement();
              ResultSet doctorRs = doctorStatement.executeQuery("select * from doctor_info where name = '"+assignedDoctor+"'");
              

              if(doctorRs.next()){
                  
                new Prescription().setVisible(true);
                PetName.setText(patientRs.getString("Patient_Name")); 
                patAge.setText(patientRs.getString("Age"));
                Date1.setText(patientRs.getString("Appointment_Time"));
                genderLevel.setText(patientRs.getString("Gender"));
                problem12.setText(patientRs.getString("Problem_in_Details"));
                DoctorName1.setText(assignedDoctor);
              
                  
                doc_degi_data.setText(doctorRs.getString("designation")); 
                Doc_uni_data.setText(doctorRs.getString("university"));
                Doc_degree_data.setText(doctorRs.getString("degree"));
                Doc_mob_data.setText(doctorRs.getString("number"));
              }
              
           }else
               
           JOptionPane.showMessageDialog(null,"No details found");
        }
        catch(Exception e)
        {
          //JOptionPane.showMessageDialog(null,e);
            System.out.println(e);
        }
    }//GEN-LAST:event_patientFindActionPerformed

    private void loginName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseClicked
        // TODO add your handling code here:
        setVisible(false);
        new Doctor().setVisible(true);
    }//GEN-LAST:event_loginName3MouseClicked

    private void loginName3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseEntered
        // TODO add your handling code here:
        
        loginName3.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName3MouseEntered

    private void loginName3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName3MouseExited
        // TODO add your handling code here:
        loginName3.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName3MouseExited

    private void loginName4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseEntered
        // TODO add your handling code here:
        loginName4.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName4MouseEntered

    private void loginName4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseExited
        // TODO add your handling code here:
        loginName4.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName4MouseExited

    private void loginName5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseExited
        // TODO add your handling code here:
        loginName5.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName5MouseExited

    private void loginName5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName5MouseEntered
        // TODO add your handling code here:
        loginName5.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName5MouseEntered

    private void loginName6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName6MouseEntered
        // TODO add your handling code here:
        loginName6.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName6MouseEntered

    private void loginName6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName6MouseExited
        // TODO add your handling code here:
        loginName6.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName6MouseExited

    private void loginName7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName7MouseExited
        // TODO add your handling code here:
        loginName7.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName7MouseExited

    private void loginName7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName7MouseEntered
        // TODO add your handling code here:
        loginName7.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName7MouseEntered

    private void loginName8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseEntered
        // TODO add your handling code here:
        loginName8.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName8MouseEntered

    private void loginName8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName8MouseExited
        // TODO add your handling code here:
        loginName8.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName8MouseExited

    private void loginName9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName9MouseExited
        // TODO add your handling code here:
        loginName9.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginName9MouseExited

    private void loginName9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName9MouseEntered
        // TODO add your handling code here:
        loginName9.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginName9MouseEntered

    private void loginNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseEntered
        // TODO add your handling code here:
        loginName.setForeground(new Color(29,180,254));
    }//GEN-LAST:event_loginNameMouseEntered

    private void loginNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginNameMouseExited
        // TODO add your handling code here:
        loginName.setForeground(Color.WHITE);
    }//GEN-LAST:event_loginNameMouseExited

    private void patientRegistationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientRegistationMouseEntered
        // TODO add your handling code here:
        patientRegistation.setForeground(new Color(29,180,254));
        patientRegistation.setBackground(Color.WHITE);
    }//GEN-LAST:event_patientRegistationMouseEntered

    private void patientRegistationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientRegistationMouseExited
        // TODO add your handling code here:
        patientRegistation.setForeground(Color.WHITE);
        patientRegistation.setBackground(new Color(29,180,254));
    }//GEN-LAST:event_patientRegistationMouseExited

    private void patientFindMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientFindMouseEntered
        // TODO add your handling code here:
        patientFind.setForeground(new Color(29,180,254));
        patientFind.setBackground(Color.WHITE);
    }//GEN-LAST:event_patientFindMouseEntered

    private void patientFindMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientFindMouseExited
        // TODO add your handling code here:
        patientFind.setForeground(Color.WHITE);
        patientFind.setBackground(new Color(29,180,254));
    }//GEN-LAST:event_patientFindMouseExited

    private void oldPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oldPatientMouseClicked
        // TODO add your handling code here:
        newPatient.setBackground(new Color(102,102,102));
        bar1.setBackground(new Color(102,102,102));
        
        oldPatient.setBackground(new Color(29,180,254));
        bar2.setBackground(new Color(29,180,254));
    }//GEN-LAST:event_oldPatientMouseClicked

    private void DocComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DocComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DocComboActionPerformed

    private void loginName4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginName4MouseClicked
        setVisible(false); 
        new Patients_List().setVisible(true);
    }//GEN-LAST:event_loginName4MouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final com.toedter.calendar.JDateChooser Appoit_time = new com.toedter.calendar.JDateChooser();
    public static final javax.swing.JComboBox<String> DocCombo = new javax.swing.JComboBox<>();
    private javax.swing.JLabel age1;
    private javax.swing.JPanel bar1;
    private javax.swing.JPanel bar2;
    private javax.swing.JLabel doctor1;
    private javax.swing.JLabel gender1;
    private javax.swing.ButtonGroup grnder;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
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
    public static final javax.swing.JLabel myimg = new javax.swing.JLabel();
    private javax.swing.JButton newPatient;
    private javax.swing.JLabel numberOfDoctor;
    private javax.swing.JLabel numberOfDoctor1;
    private javax.swing.JButton oldPatient;
    private javax.swing.JTextField patientAge;
    private javax.swing.JButton patientFind;
    private javax.swing.JRadioButton patientGenderFemale;
    private javax.swing.JRadioButton patientGenderMale;
    private javax.swing.JTextField patientName;
    private javax.swing.JTextField patientNumber;
    private javax.swing.JTextField patientProblem;
    private javax.swing.JButton patientRegistation;
    private javax.swing.JLabel problem1;
    private javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
