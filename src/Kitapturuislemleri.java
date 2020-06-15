
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Osman Karadeniz
 */
public class Kitapturuislemleri extends javax.swing.JFrame {
Connection conn;
ResultSet rs;
PreparedStatement pst=null;
PreparedStatement pst2=null;
    /**
     * Creates new form Kitapturu
     */
    public Kitapturuislemleri() {
        initComponents();
        conn=javabaglanti.BaglantiDb();
        kitap_turleri_getir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        kitap_tur = new javax.swing.JTextField();
        sil = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kitap_turleri_sil = new javax.swing.JComboBox<>();
        ekle = new javax.swing.JButton();
        kitap_turleri_guncelle = new javax.swing.JComboBox<>();
        yeni_tur_ad = new javax.swing.JTextField();
        guncelle = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fırat Üniversitesi Kütüphane Otomasyonu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Yeni Tür adı :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 100, 30));
        getContentPane().add(kitap_tur, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 180, 30));

        sil.setBackground(new java.awt.Color(255, 255, 255));
        sil.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sil.setText(" SİL");
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });
        getContentPane().add(sil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 180, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tür Adı :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 30));

        getContentPane().add(kitap_turleri_sil, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 180, 30));

        ekle.setBackground(new java.awt.Color(255, 255, 255));
        ekle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ekle.setText("EKLE");
        ekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleActionPerformed(evt);
            }
        });
        getContentPane().add(ekle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 180, 30));

        getContentPane().add(kitap_turleri_guncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, 30));
        getContentPane().add(yeni_tur_ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 180, 30));

        guncelle.setBackground(new java.awt.Color(255, 255, 255));
        guncelle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        guncelle.setText("GÜNCELLE");
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(guncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 180, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tür :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 120, 40, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tür :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 180, 40, 30));

        jPanel1.setBackground(new java.awt.Color(155, 30, 72));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("<< Geri Dön");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KİTAP TÜRÜ ( EKLE / SİL / GÜNCELLE)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 40));

        jMenu3.setText("Sistem");
        jMenu3.setAutoscrolls(true);
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jMenu3.setInheritsPopupMenu(true);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim/bilgi.png"))); // NOI18N
        jMenuItem2.setText("Proje Hakkında");
        jMenu3.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim/cikis.png"))); // NOI18N
        jMenuItem1.setText("Çıkış Yap");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(546, 319));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      setVisible(false);
      new Kitapislemleri().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleActionPerformed
              try{
  
  String kitap_turu = kitap_tur.getText().trim();
          
  String sql ="insert into kitap_turleri values (null,?)";
  String sql1 = "select * from kitap_turleri where kitap_tur='"+kitap_turu+"'";
  
  if(!(kitap_turu.isBlank()))
          {
   pst=conn.prepareStatement(sql1);
   rs=pst.executeQuery();
   
   if(rs.next())
   {
       JOptionPane.showMessageDialog(null, "Kitap Türü Eklenemedi ! -> Tür Zaten Mevcut. ");
   }
   else
   {
   pst = conn.prepareStatement(sql);
   pst.setString(1,kitap_turu);
   pst.execute();
   JOptionPane.showMessageDialog(null, "Kitap Türü Ekleme Başarılı !");
   kitap_tur.setText("");
   kitap_turleri_getir();
   pst.close();
        }
   rs.close();
          }
  else
  {
   JOptionPane.showMessageDialog(null, "Kitap Türü Eklenemedi ! -> Kitap Türü Alanı Boş Bırakılamaz ! ");
  }
   }
        catch(SQLException e)
        {
             JOptionPane.showMessageDialog(null,"VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
        }
        
    }//GEN-LAST:event_ekleActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
     
        String kitap_turu = (String) kitap_turleri_sil.getSelectedItem();
        String sql="delete from kitap_turleri where kitap_tur='"+kitap_turu.trim()+"'";
        String sql2="DELETE FROM kitaplar where kitap_turleri_id IN (select kitap_turleri_id from kitap_turleri where kitap_tur='"+kitap_turu.trim()+"')";
       
        
        try{
            
           int kontrol_0 =JOptionPane.showConfirmDialog(null,"DİKKAT ! -> SİLMEK ÜZERE OLDUĞUNUZ TÜRE AİT TÜM KİTAPLAR KAYITLARDAN SİLİNECEKTİR !\nBu işleme devam etmek istiyormusunuz ?");
           int kontrol_1=-1;
           
           if(kontrol_0==0)
           {
                kontrol_1 = JOptionPane.showConfirmDialog(null,kitap_turu+" Türünü Silmeyi Onaylıyorum");
           }
           
            if(kontrol_1==0)
            { 
               pst = conn.prepareStatement(sql2);
               pst.execute();
               pst.close();
               
               pst2 = conn.prepareStatement(sql);
               pst2.execute();
               pst2.close();
               
               JOptionPane.showMessageDialog(null, "SİLME İŞLEMİ BAŞARILI !");
               
               kitap_turleri_getir();
            }
            else{
            JOptionPane.showMessageDialog(null, "Silme İşlemi İptal Edildi !");
            }
       
      
        }catch(SQLException e)
        {
       JOptionPane.showMessageDialog(null,"VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
       e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_silActionPerformed

    
    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed
                             

        try {

            String eski_tur = kitap_turleri_guncelle.getSelectedItem().toString().trim();
            String yeni_tur = yeni_tur_ad.getText().trim();
            int tur_id = -1;

            String sql;

            sql = "select * from kitap_turleri where kitap_tur='" +yeni_tur+ "'";
            boolean kontrol_mevcutmu = false;
            // false'ü kitap tür olmadığını ifade ettiğini farz edelim.

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bu TÜR zaten mevcut ! , lütfen farklı bir TÜR girişi yapınız ...");
                kontrol_mevcutmu = true;
            } else {
                kontrol_mevcutmu = false;
            }
            
            
            if (kontrol_mevcutmu != true) {
                
                if (!(yeni_tur.isBlank() && !(eski_tur.equals("Seç")))) {
                    
                    
                    sql = "update kitap_turleri set kitap_tur=? where kitap_tur='" +eski_tur+ "'";
                    pst = conn.prepareStatement(sql);
                    
                    pst.setString(1, yeni_tur);
                    
                    int deger = JOptionPane.showConfirmDialog(null, "DİKKAT ! -> Tür güncellemesi güncellenen türe ait kitapların türlerini günceller.\nİşleme devam etmek istiyormusunuz ?");
                    
                    if(deger==0)
                    {
                     pst.executeUpdate();
                     JOptionPane.showMessageDialog(null, "TÜR GÜNCELLENDİ !");
                    }
                    else
                    JOptionPane.showMessageDialog(null, "İŞLEM İPTAL EDİLDİ !");
                    pst.close();
                    
                    kitap_turleri_getir();
                } else {
                    JOptionPane.showMessageDialog(null, "Geçersiz bir format girişi veya Boş alan !");

                }
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI HATA !: " + e.getSQLState());
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_guncelleActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        setVisible(false);

        Giris girisform = new Giris();
        girisform.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    
    
    void kitap_turleri_getir()
    {
        kitap_turleri_sil.removeAllItems();
        kitap_turleri_guncelle.removeAllItems();
        
          try{
         
           String sql ="select kitap_tur from kitap_turleri";
           pst=conn.prepareStatement(sql);
           rs=pst.executeQuery();
           int say=0;
           
           while(rs.next())
           {
           kitap_turleri_sil.addItem(rs.getString("kitap_tur"));
           kitap_turleri_guncelle.addItem(rs.getString("kitap_tur"));
           say++;
           }
        
           if(say==0)
           {
           kitap_turleri_sil.removeAllItems();
           kitap_turleri_guncelle.removeAllItems();
           
           kitap_turleri_sil.addItem("TÜR EKLEYİNİZ !");
           kitap_turleri_guncelle.addItem("TÜR EKLEYİNİZ !");
           
           kitap_turleri_sil.setEnabled(false);
           kitap_turleri_guncelle.setEnabled(false);
           
           sil.setEnabled(false);
           guncelle.setEnabled(false);
           }
           else
           {
           kitap_turleri_sil.setEnabled(true);
           kitap_turleri_guncelle.setEnabled(true);
           
           sil.setEnabled(true);
           guncelle.setEnabled(true);
           }
           
        }catch(SQLException e)
        {
         JOptionPane.showMessageDialog(null,"VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
        }
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Kitapturuislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kitapturuislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kitapturuislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kitapturuislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kitapturuislemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekle;
    private javax.swing.JButton guncelle;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kitap_tur;
    private javax.swing.JComboBox<String> kitap_turleri_guncelle;
    private javax.swing.JComboBox<String> kitap_turleri_sil;
    private javax.swing.JButton sil;
    private javax.swing.JTextField yeni_tur_ad;
    // End of variables declaration//GEN-END:variables
}
