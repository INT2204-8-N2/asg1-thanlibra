/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaapplication1;


import com.dict.javaconnect;
import com.dict.lichsutim;
import com.dict.speak;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
/**
 *
 * @author CCNE
 */
public class NewJFrame extends javax.swing.JFrame {
    public NewJFrame() {
        initComponents();
        this.initData("lsdic.txt");
    }
    @SuppressWarnings("unchecked")
    private void initData(String namefile){
        DefaultListModel <String> model= new DefaultListModel<>();      
        File file = new File(namefile);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            int i = 0;
            String line = "";
            for (i = 0; (line = br.readLine()) != null; i++){
                String[] a = line.split("\\s", 2);
                model.addElement(a[0]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }        
        btlist.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dictionary = new javax.swing.JPanel();
        btnhap = new javax.swing.JTextField();
        btsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        btlist = new javax.swing.JList();
        btthem = new javax.swing.JButton();
        btmodify = new javax.swing.JButton();
        btxoa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btloa = new javax.swing.JButton();
        bttimtuongdoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        btmean1 = new javax.swing.JLabel();
        bttran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dictionary");
        setBackground(new java.awt.Color(0, 102, 204));

        Dictionary.setBackground(new java.awt.Color(0, 102, 204));

        btnhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnhap.setToolTipText("nhập từ cần tìm");
        btnhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btnhapKeyReleased(evt);
            }
        });

        btsearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btsearch.setToolTipText("Tìm từ tuyệt đối");
        btsearch.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btsearchAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsearchActionPerformed(evt);
            }
        });

        btlist.setToolTipText("Danh sách từ");
        btlist.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                btlistValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(btlist);

        btthem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btthem.setText("Insert");
        btthem.setToolTipText("Thêm từ");
        btthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthemActionPerformed(evt);
            }
        });

        btmodify.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btmodify.setText("Modify");
        btmodify.setToolTipText("Sửa từ");
        btmodify.setAlignmentY(0.3F);
        btmodify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmodifyActionPerformed(evt);
            }
        });

        btxoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btxoa.setText("Delete");
        btxoa.setToolTipText("Xóa từ");
        btxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("TỪ ĐIỂN ANH - VIỆT");

        btloa.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btloa.setToolTipText("Phát âm tiếng anh");
        btloa.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btloaAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btloa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btloaActionPerformed(evt);
            }
        });

        bttimtuongdoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bttimtuongdoi.setText("Find");
        bttimtuongdoi.setToolTipText("Tìm từ tương đối ");
        bttimtuongdoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttimtuongdoiActionPerformed(evt);
            }
        });

        btmean1.setBackground(new java.awt.Color(255, 255, 255));
        btmean1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btmean1.setToolTipText("Hiển thị thông tin của từ");
        btmean1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btmean1.setOpaque(true);
        btmean1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jScrollPane2.setViewportView(btmean1);

        bttran.setToolTipText("Dịch đoạn văn");
        bttran.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                bttranAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        bttran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DictionaryLayout = new javax.swing.GroupLayout(Dictionary);
        Dictionary.setLayout(DictionaryLayout);
        DictionaryLayout.setHorizontalGroup(
            DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DictionaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DictionaryLayout.createSequentialGroup()
                        .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btmodify)
                            .addComponent(btxoa)
                            .addComponent(btthem)
                            .addComponent(btsearch)
                            .addComponent(bttran)))
                    .addComponent(bttimtuongdoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DictionaryLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btloa))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        DictionaryLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btmodify, btthem, btxoa});

        DictionaryLayout.setVerticalGroup(
            DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DictionaryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DictionaryLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btsearch)
                            .addComponent(btnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttran)
                        .addGap(18, 18, 18)
                        .addComponent(btthem)
                        .addGap(18, 18, 18)
                        .addComponent(btmodify)
                        .addGap(18, 18, 18)
                        .addComponent(btxoa)
                        .addGap(44, 44, 44))
                    .addGroup(DictionaryLayout.createSequentialGroup()
                        .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(DictionaryLayout.createSequentialGroup()
                                .addComponent(bttimtuongdoi)
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DictionaryLayout.createSequentialGroup()
                                .addGroup(DictionaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DictionaryLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(btloa)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2)))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Dictionary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Dictionary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoaActionPerformed
        // TODO add your handling code here:
        Xoa xoa=new Xoa();
        xoa.setVisible(true);
        xoa.setLocation(500, 300);        
    }//GEN-LAST:event_btxoaActionPerformed

    private void btmodifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmodifyActionPerformed
        // TODO add your handling code here:
        Sua sua= new Sua();
        sua.setVisible(true);
        sua.setLocation(500, 300);
    }//GEN-LAST:event_btmodifyActionPerformed

    private void btthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthemActionPerformed
        // TODO add your handling code here:
        Them them= new Them();
        them.setVisible(true);
        them.setLocation(500, 300);
    }//GEN-LAST:event_btthemActionPerformed

    private void btsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsearchActionPerformed
        lichsutim ls= new lichsutim();
        javaconnect jav= new javaconnect();
        String wordE=btnhap.getText();
        if(jav.find(wordE)=="khong tim thay"){
            btmean1.setText("không có từ cần tìm");
            JOptionPane.showMessageDialog(null,"NOT Found!!");
        }
        else {
            ls.luutu(wordE);
            btmean1.setText("<html>"+jav.find(wordE)+"</html>");
        }
    }//GEN-LAST:event_btsearchActionPerformed

    private void bttimtuongdoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttimtuongdoiActionPerformed
        // TODO add your handling code here:
        javaconnect jav= new javaconnect();
        String Engtd=btnhap.getText();
        try{
            if(jav.findtd(Engtd)==0){
                JOptionPane.showMessageDialog(null, "Can't find");
            }
            else {
                this.initData("newdic.txt");           
            }
        }catch(NullPointerException e){
            return;
        }
    }//GEN-LAST:event_bttimtuongdoiActionPerformed

    private void btlistValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_btlistValueChanged
        // TODO add your handling code here:
        javaconnect jav= new javaconnect();
        String value= btlist.getSelectedValue().toString();       
        btmean1.setText("<html>"+jav.find(value)+"</html>");
        btnhap.setText(value);
        lichsutim ls= new lichsutim();
        ls.luutu(value);
    }//GEN-LAST:event_btlistValueChanged

    private void btloaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btloaAncestorAdded
        // TODO add your handling code here:
        ImageIcon icon= new ImageIcon("loa.jpg");
        btloa.setIcon(icon);
    }//GEN-LAST:event_btloaAncestorAdded

    private void btsearchAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btsearchAncestorAdded
        // TODO add your handling code here:
        ImageIcon icon= new ImageIcon("klup.jpg");
        btsearch.setIcon(icon);
    }//GEN-LAST:event_btsearchAncestorAdded

    private void btloaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btloaActionPerformed
        // TODO add your handling code here:
        String word= btnhap.getText();
        speak sp= new speak();
        sp.speech(word);
    }//GEN-LAST:event_btloaActionPerformed

    private void bttranAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bttranAncestorAdded
        // TODO add your handling code here:
        ImageIcon icon= new ImageIcon("ggtran.png");
        bttran.setIcon(icon);
    }//GEN-LAST:event_bttranAncestorAdded

    private void bttranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttranActionPerformed
        // TODO add your handling code here:
        Translate tran= new Translate();
        tran.setVisible(true);
        tran.setLocation(400, 200);
    }//GEN-LAST:event_bttranActionPerformed

    private void btnhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnhapKeyReleased
        // TODO add your handling code here:
        javaconnect jav= new javaconnect();
        String Engtd=btnhap.getText();        
        try{
            if(Engtd.length()==0){
                this.initData("lsdic.txt");
            }
            else if(jav.findtd(Engtd)==0){
                this.initData("null.txt");
            }
            else {
                this.initData("newdic.txt");   
            }
        }catch(NullPointerException e){
            return;
        }
        
    }//GEN-LAST:event_btnhapKeyReleased

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {              
                NewJFrame dic =new NewJFrame();
                dic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                dic.setVisible(true);
                dic.setLocation(400, 200);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dictionary;
    private javax.swing.JList btlist;
    private javax.swing.JButton btloa;
    private javax.swing.JLabel btmean1;
    private javax.swing.JButton btmodify;
    private javax.swing.JTextField btnhap;
    private javax.swing.JButton btsearch;
    private javax.swing.JButton btthem;
    private javax.swing.JButton bttimtuongdoi;
    private javax.swing.JButton bttran;
    private javax.swing.JButton btxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
