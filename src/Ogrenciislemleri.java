
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Osman Karadeniz
 */
public class Ogrenciislemleri extends javax.swing.JFrame {

    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    /**
     * Creates new form Ogrenciislemleri
     */
    public Ogrenciislemleri() {
        initComponents();
        conn = javabaglanti.BaglantiDb();
        tablo_veri_doldur();
        fakulte_getir();
    }

  
    static int secilen_ogrenci_id;

    public void tablo_veri_doldur() {

        veritable.setDefaultEditor(Object.class, null);

        try {
//    String sql2 = "SELECT kitaplar.kitap_id as '#ID' ,kitaplar.kitap_baslik as 'Başlık' ,kitaplar.kitap_yazar as 'Yazar' ,kitaplar.kitap_turleri_id in kitap_turleri.kitap_tur as 'Tür' ,kitaplar.kitap_isbn as 'ISBN' ,kitaplar.kitap_baski_sayi as 'Baskı Sayısı',kitaplar.kitap_baski_yil 'Baskı Yılı',kitaplar.kitap_yayinevi as 'Yayınevi',kitaplar.kitap_sayfa_sayi as 'Sayfa Sayısı',kitaplar.kitap_fiyat as 'Fiyat' from kitaplar,kitap_turleri;";
            String sql = "select ogrenci_id as '#ID' , ogrenci_ad_soyad as 'Ad Soyad', ogrenci_no as 'Öğrenci No' , bolum.bolum_adi as 'Bölüm' , fakulte.fakulte_adi as 'Fakülte' from ogrenciler as ogrenci INNER JOIN bolumler as bolum on ogrenci.bolum_id=bolum.bolum_id inner JOIN fakulteler as fakulte on bolum.fakulte_id=fakulte.fakulte_id";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            
            veritable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
        }

    }
    
    void bolum_getir(String fakulte_adi) {

        yeni_bolum.removeAllItems();

        yeni_bolum.addItem("Seç");

        yeni_bolum.setSelectedIndex(0);

        try {

            String sql = "select bolum_adi from bolumler where fakulte_id in (select fakulte_id from fakulteler where fakulte_adi='"+fakulte_adi+"')";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {

                yeni_bolum.addItem(rs.getString("bolum_adi"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
        }
    }

    void fakulte_getir() {
        
        fakulte_bul.removeAllItems();
        fakulte_bul.addItem("Seç");
        fakulte_bul.setSelectedIndex(0);
        
        yeni_fakulte.removeAllItems();
        yeni_fakulte.addItem("Seç");
        yeni_fakulte.setSelectedIndex(0);
        
        try {

            String sql = "select fakulte_adi from fakulteler";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                fakulte_bul.addItem(rs.getString("fakulte_adi"));
                yeni_fakulte.addItem(rs.getString("fakulte_adi"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
        }
    }
    
    void ogrenci_bul(String ad_soyad, String ogr_no, String fakulte_adi) {
        if (fakulte_adi.equals("Seç")) {
            fakulte_adi = "";
        }

        try {
//   String sql = "SELECT kitaplar.kitap_id as '#ID' ,kitaplar.kitap_baslik as 'Başlık' ,kitaplar.kitap_yazar as 'Yazar' ,kitap_turleri.kitap_tur as 'Tür' ,kitaplar.kitap_isbn as 'ISBN' ,kitaplar.kitap_baski_sayi as 'Baskı Sayısı',kitaplar.kitap_baski_yil 'Baskı Yılı',kitaplar.kitap_yayinevi as 'Yayınevi',kitaplar.kitap_sayfa_sayi as 'Sayfa Sayısı',kitaplar.kitap_fiyat as 'Fiyat' from kitaplar,kitap_turleri where kitap_baslik like '%"+baslik+"%' && kitap_isbn like '%"+isbn+"%' && kitap_turleri.kitap_tur like '%"+tur+"%'";
            String sql = "select ogrenci_id as '#ID' , ogrenci_ad_soyad as 'Ad Soyad', ogrenci_no as 'Öğrenci No' , bolum.bolum_adi as 'Bölüm' , fakulte.fakulte_adi as 'Fakülte' from ogrenciler as ogrenci INNER JOIN bolumler as bolum on ogrenci.bolum_id=bolum.bolum_id inner JOIN fakulteler as fakulte on bolum.fakulte_id=fakulte.fakulte_id where ogrenci_ad_soyad like '%" + ad_soyad + "%' && ogrenci_no like '%" + ogr_no + "%' && fakulte_adi like '%" + fakulte_adi + "%'";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            veritable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI BAĞLANTISI BAŞARISIZ !: " + e.getSQLState());
        }
        //tablo_baslik_guncelle();
    }
    
    void tazele() {
        tablo_veri_doldur();
        fakulte_getir();
        adsoyad_bul.setText("");
        no_bul.setText("");
        ogrencibilgiler_temizle();
        ogrenci_id.setText("");
        ogrencibilgiler_ackapa(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        geri = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        no_bul = new javax.swing.JTextField();
        adsoyad_bul = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fakulte_bul = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        veritable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yeni_adsoyad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        yeni_ogrno = new javax.swing.JTextField();
        yeni_bolum = new javax.swing.JComboBox<>();
        sil = new javax.swing.JButton();
        temizle = new javax.swing.JButton();
        guncelle = new javax.swing.JButton();
        ogrenci_id = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        yeni_fakulte = new javax.swing.JComboBox<>();
        filtrereset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        hakkinda = new javax.swing.JMenuItem();
        cikis = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        fakulteislemleri = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        bolumislemleri = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        ogrenciekle = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fırat Üniversitesi Kütüphane Otomasyonu");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(155, 30, 72));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("ÖĞRENCİ (BUL / SİL / GÜNCELLE)");

        geri.setBackground(new java.awt.Color(255, 255, 255));
        geri.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        geri.setText("<< Geri Dön");
        geri.setFocusable(false);
        geri.setPreferredSize(new java.awt.Dimension(105, 25));
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GELİŞMİŞ FİLTRELEME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(155, 30, 72))); // NOI18N

        no_bul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_bulKeyReleased(evt);
            }
        });

        adsoyad_bul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                adsoyad_bulKeyReleased(evt);
            }
        });

        jLabel3.setText("No :");

        jLabel4.setText("Ad - Soyad :");

        fakulte_bul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seç" }));
        fakulte_bul.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                fakulte_bulPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel2.setText("Fakülte :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adsoyad_bul, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(no_bul, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fakulte_bul, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adsoyad_bul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(no_bul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fakulte_bul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 590, -1));

        jScrollPane1.setEnabled(false);

        veritable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        veritable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        veritable.setToolTipText("");
        veritable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        veritable.setEditingColumn(0);
        veritable.setName("veritablosu"); // NOI18N
        veritable.setRequestFocusEnabled(false);
        veritable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        veritable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        veritable.setShowGrid(false);
        veritable.getTableHeader().setReorderingAllowed(false);
        veritable.setUpdateSelectionOnSort(false);
        veritable.setVerifyInputWhenFocusTarget(false);
        veritable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                veritableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(veritable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 800, 240));

        jLabel5.setText("Bölüm :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 470, 50, 30));

        jLabel6.setText("Ad Soyad :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 60, 30));

        yeni_adsoyad.setEnabled(false);
        getContentPane().add(yeni_adsoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 150, 30));

        jLabel9.setText("Öğrenci No :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 70, 30));

        yeni_ogrno.setEnabled(false);
        getContentPane().add(yeni_ogrno, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 150, 30));

        yeni_bolum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seç" }));
        yeni_bolum.setEnabled(false);
        yeni_bolum.setFocusable(false);
        getContentPane().add(yeni_bolum, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 180, 30));

        sil.setText("SİL");
        sil.setEnabled(false);
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });
        getContentPane().add(sil, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 110, 40));

        temizle.setText("TEMİZLE");
        temizle.setEnabled(false);
        temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temizleActionPerformed(evt);
            }
        });
        getContentPane().add(temizle, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 110, 40));

        guncelle.setText("GÜNCELLE");
        guncelle.setEnabled(false);
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });
        getContentPane().add(guncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 110, 40));

        ogrenci_id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ogrenci_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(ogrenci_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 800, 30));

        jLabel7.setText("Fakülte :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 60, 30));

        yeni_fakulte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seç" }));
        yeni_fakulte.setEnabled(false);
        yeni_fakulte.setFocusable(false);
        yeni_fakulte.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                yeni_fakultePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        getContentPane().add(yeni_fakulte, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 180, 30));

        filtrereset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        filtrereset.setText("Filtreyi Temizle");
        filtrereset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtreresetActionPerformed(evt);
            }
        });
        getContentPane().add(filtrereset, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 130, 30));

        jMenu3.setText("Sistem");
        jMenu3.setAutoscrolls(true);
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jMenu3.setInheritsPopupMenu(true);

        hakkinda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim/bilgi.png"))); // NOI18N
        hakkinda.setText("Proje Hakkında");
        jMenu3.add(hakkinda);

        cikis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resim/cikis.png"))); // NOI18N
        cikis.setText("Çıkış Yap");
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });
        jMenu3.add(cikis);

        jMenuBar1.add(jMenu3);

        jMenu9.setText("|");
        jMenu9.setAutoscrolls(true);
        jMenu9.setEnabled(false);
        jMenu9.setFocusable(false);
        jMenu9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenu9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu9.setInheritsPopupMenu(true);
        jMenu9.setRequestFocusEnabled(false);
        jMenu9.setRolloverEnabled(false);
        jMenu9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu9);

        fakulteislemleri.setText("FAKÜLTE İŞLEMLERİ");
        fakulteislemleri.setAutoscrolls(true);
        fakulteislemleri.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        fakulteislemleri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fakulteislemleri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fakulteislemleri.setInheritsPopupMenu(true);
        fakulteislemleri.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        fakulteislemleri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fakulteislemleri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fakulteislemleriMouseClicked(evt);
            }
        });
        jMenuBar1.add(fakulteislemleri);

        jMenu5.setText("|");
        jMenu5.setAutoscrolls(true);
        jMenu5.setEnabled(false);
        jMenu5.setFocusable(false);
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu5.setInheritsPopupMenu(true);
        jMenu5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu5);

        bolumislemleri.setText("BÖLÜM İŞLEMLERİ");
        bolumislemleri.setAutoscrolls(true);
        bolumislemleri.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        bolumislemleri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bolumislemleri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bolumislemleri.setInheritsPopupMenu(true);
        bolumislemleri.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        bolumislemleri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bolumislemleri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bolumislemleriMouseClicked(evt);
            }
        });
        jMenuBar1.add(bolumislemleri);

        jMenu7.setText("|");
        jMenu7.setAutoscrolls(true);
        jMenu7.setEnabled(false);
        jMenu7.setFocusable(false);
        jMenu7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jMenu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenu7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenu7.setInheritsPopupMenu(true);
        jMenu7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jMenu7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jMenuBar1.add(jMenu7);

        ogrenciekle.setText("+ÖĞRENCİ EKLE");
        ogrenciekle.setAutoscrolls(true);
        ogrenciekle.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        ogrenciekle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ogrenciekle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ogrenciekle.setInheritsPopupMenu(true);
        ogrenciekle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ogrenciekle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ogrenciekle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ogrenciekleMouseClicked(evt);
            }
        });
        jMenuBar1.add(ogrenciekle);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(816, 588));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed
        setVisible(false);

        Giris girisform = new Giris();
        girisform.setVisible(true);
    }//GEN-LAST:event_cikisActionPerformed

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
        setVisible(false);
        new Anasayfa().setVisible(true);
    }//GEN-LAST:event_geriActionPerformed

    private void filtreresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtreresetActionPerformed
     tazele();
    }//GEN-LAST:event_filtreresetActionPerformed

    private void no_bulKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_bulKeyReleased
        ogrenci_bul(adsoyad_bul.getText().trim(), no_bul.getText().trim(), (String) fakulte_bul.getSelectedItem());
        ogrencibilgiler_temizle();
        ogrenci_id.setText("");
        ogrencibilgiler_ackapa(false);
    }//GEN-LAST:event_no_bulKeyReleased

    private void adsoyad_bulKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adsoyad_bulKeyReleased
        ogrenci_bul(adsoyad_bul.getText().trim(), no_bul.getText().trim(), (String) fakulte_bul.getSelectedItem());
        ogrencibilgiler_temizle();
        ogrenci_id.setText("");
        ogrencibilgiler_ackapa(false);
    }//GEN-LAST:event_adsoyad_bulKeyReleased

    private void fakulte_bulPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_fakulte_bulPopupMenuWillBecomeInvisible
        ogrenci_bul(adsoyad_bul.getText().trim(), no_bul.getText().trim(), (String) fakulte_bul.getSelectedItem());
        ogrencibilgiler_temizle();
        ogrenci_id.setText("");
        ogrencibilgiler_ackapa(false);
    }//GEN-LAST:event_fakulte_bulPopupMenuWillBecomeInvisible

    void ogrencibilgiler_ackapa(boolean kontrol) {
        if (kontrol == true) {
            yeni_ogrno.setEnabled(true);
            yeni_adsoyad.setEnabled(true);
            yeni_bolum.setEnabled(true);
            yeni_fakulte.setEnabled(true);
            temizle.setEnabled(true);
            guncelle.setEnabled(true);
            sil.setEnabled(true);
        } else {
            yeni_ogrno.setEnabled(false);
            yeni_adsoyad.setEnabled(false);
            yeni_bolum.setEnabled(false);
            yeni_fakulte.setEnabled(false);
            temizle.setEnabled(false);
            guncelle.setEnabled(false);
            sil.setEnabled(false);
        }

    }

    void ogrencibilgiler_temizle() {
        yeni_ogrno.setText("");
        yeni_adsoyad.setText("");
        yeni_bolum.setSelectedIndex(0);
        yeni_bolum.setEnabled(false);
        yeni_fakulte.setSelectedIndex(0);
    }
    
    
    
    
    
    private void veritableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_veritableMouseReleased

        DefaultTableModel model = (DefaultTableModel) veritable.getModel();

        int secilen_satir_indis = veritable.getSelectedRow();

        secilen_ogrenci_id = Integer.parseInt(model.getValueAt(secilen_satir_indis, 0).toString());
        
        String bolum = model.getValueAt(secilen_satir_indis, 3).toString();
        String fakulte = model.getValueAt(secilen_satir_indis, 4).toString();
        
        ogrenci_id.setText("► SEÇİLEN ÖĞRENCİ ID : " + secilen_ogrenci_id + " ◄");
        ogrencibilgiler_ackapa(true);
        
        yeni_adsoyad.setText(model.getValueAt(secilen_satir_indis, 1).toString());
        yeni_ogrno.setText(model.getValueAt(secilen_satir_indis, 2).toString());

        yeni_fakulte.setSelectedItem(fakulte);
        bolum_getir(fakulte);
        yeni_bolum.setSelectedItem(bolum);
      
    }//GEN-LAST:event_veritableMouseReleased

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed

        try {
            String sql = "delete from ogrenciler where ogrenci_id=" + secilen_ogrenci_id + ";";
            pst = conn.prepareStatement(sql);

            int deger = JOptionPane.showConfirmDialog(null, "İD : " + secilen_ogrenci_id + " olan öğrenciyi silme işlemine devam etmek istiyor musunuz ?");

            if (deger == 0) {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "ÖĞRENCİ SİLİNDİ !");
                tazele();
            } else {
                JOptionPane.showMessageDialog(null, "İŞLEM İPTAL EDİLDİ !");
            }

            pst.close();
            tablo_veri_doldur();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI HATA !: " + e.getSQLState());
        }
    }//GEN-LAST:event_silActionPerformed

    private void temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temizleActionPerformed
        ogrencibilgiler_temizle();
    }//GEN-LAST:event_temizleActionPerformed

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed

        try {

            String ogr_no = yeni_ogrno.getText().trim();
            String ad_soyad = yeni_adsoyad.getText().trim();
            String bolum = yeni_bolum.getSelectedItem().toString();
            String fakulte = yeni_fakulte.getSelectedItem().toString();
            
            String sql;
            sql = "select * from ogrenciler where ogrenci_no='" + ogr_no + "' and ogrenci_id!='"+secilen_ogrenci_id+"'";
            boolean kontrol_mevcutmu = false;
            //false'ü öğrencinin olmadığını varsayarak atadım.

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bu Öğrenci No. zaten mevcut!");
                kontrol_mevcutmu = true;
            } else {
                kontrol_mevcutmu = false;
            }

            if (kontrol_mevcutmu != true) {
                if (!(ogr_no.isBlank() || ad_soyad.isBlank()) && !(bolum.equals("Seç") || fakulte.equals("Seç"))) {
                    sql = "update ogrenciler set ogrenci_ad_soyad=? , ogrenci_no=?,bolum_id=(select bolum_id from bolumler where bolum_adi='"+bolum+"' and fakulte_id in (select fakulte_id from fakulteler where fakulte_adi='"+fakulte+"')) where ogrenci_id='" + secilen_ogrenci_id + "'";
                    pst = conn.prepareStatement(sql);

                    pst.setString(1, ad_soyad);
                    pst.setString(2, ogr_no);
                    pst.executeUpdate();
                    pst.close();
                    JOptionPane.showMessageDialog(null, "ÖĞRENCİ BİLGİLERİ GÜNCELLENDİ !");
                    tablo_veri_doldur();
                } else {
                    JOptionPane.showMessageDialog(null, "Geçersiz bir format girişi veya Boş alan !");

                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "VERİ TABANI HATA !: " + e.getSQLState());
            e.printStackTrace();
        }

    }//GEN-LAST:event_guncelleActionPerformed

    static String secilen;
    
    private void yeni_fakultePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_yeni_fakultePopupMenuWillBecomeInvisible
        secilen = yeni_fakulte.getSelectedItem().toString();
        
        if(secilen.equals("Seç"))
        {
        yeni_bolum.setEnabled(false);
        yeni_bolum.setSelectedIndex(0);
        }
        else
        {
         yeni_bolum.setEnabled(true);
         bolum_getir(secilen);
        }
        
    }//GEN-LAST:event_yeni_fakultePopupMenuWillBecomeInvisible

    private void ogrenciekleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ogrenciekleMouseClicked
        setVisible(false);
        new Yeniogrenci().setVisible(true); 
    }//GEN-LAST:event_ogrenciekleMouseClicked

    private void bolumislemleriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bolumislemleriMouseClicked
      setVisible(false);
        new Bolumislemleri().setVisible(true); 
    }//GEN-LAST:event_bolumislemleriMouseClicked

    private void fakulteislemleriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fakulteislemleriMouseClicked
        setVisible(false);
        new Fakulteislemleri().setVisible(true);
    }//GEN-LAST:event_fakulteislemleriMouseClicked
    
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
            java.util.logging.Logger.getLogger(Ogrenciislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ogrenciislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ogrenciislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ogrenciislemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ogrenciislemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adsoyad_bul;
    private javax.swing.JMenu bolumislemleri;
    private javax.swing.JMenuItem cikis;
    private javax.swing.JComboBox<String> fakulte_bul;
    private javax.swing.JMenu fakulteislemleri;
    private javax.swing.JButton filtrereset;
    private javax.swing.JButton geri;
    private javax.swing.JButton guncelle;
    private javax.swing.JMenuItem hakkinda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField no_bul;
    private javax.swing.JLabel ogrenci_id;
    private javax.swing.JMenu ogrenciekle;
    private javax.swing.JButton sil;
    private javax.swing.JButton temizle;
    private javax.swing.JTable veritable;
    private javax.swing.JTextField yeni_adsoyad;
    private javax.swing.JComboBox<String> yeni_bolum;
    private javax.swing.JComboBox<String> yeni_fakulte;
    private javax.swing.JTextField yeni_ogrno;
    // End of variables declaration//GEN-END:variables
}
