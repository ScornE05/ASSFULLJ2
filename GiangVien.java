package view;

import assignment2.model.QuanLyDiem;
import assignment2.resposity.Diem;
import assignment2.resposity.STUDENT;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GiangVien extends javax.swing.JFrame {

    private ArrayList<Diem> list = new ArrayList<>();
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private QuanLyDiem qld = new QuanLyDiem();
    private int bienHienTai;

    /**
     * Creates new form GiangVien
     */
    public GiangVien() {
        initComponents();
        setLocationRelativeTo(null);
        fillToTable();
    }

    public void fillToTable() {
        list = qld.top3();
        Comparator<Diem> com = Comparator.comparing(Diem::diemTrungBinh).reversed();
        Collections.sort(list, com);
        defaultTableModel = (DefaultTableModel) tblTop3.getModel();
        defaultTableModel.setRowCount(0);
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < Math.min(list.size(), 3); i++) {
            Diem d = list.get(i);
            Object[] row = {
                d.getMaSv(),
                d.getHoten(),
                d.getDiemTiengAnh(),
                d.getDiemTinHoc(),
                d.getDiemGDTC(),
                df.format(d.diemTrungBinh())
            };
            defaultTableModel.addRow(row);
        }
    }

    public void load(Diem d) {
        txtMaSv.setText(d.getMaSv());
        txtTen.setText(d.getHoten());
        txtDiemTiengAnh.setText(String.valueOf(d.getDiemTiengAnh()));
        txtDiemTinHoc.setText(String.valueOf(d.getDiemTinHoc()));
        txtDiemGDTC.setText(String.valueOf(d.getDiemGDTC()));
        DecimalFormat df = new DecimalFormat("#.##");
        txtDiemTb.setText(df.format(d.diemTrungBinh()));
    }

    public void hienThi(int i) {
        Diem d = list.get(i);
        txtMaSv.setText(d.getMaSv());
        txtTen.setText(d.getHoten());
        txtDiemTiengAnh.setText(String.valueOf(d.getDiemTiengAnh()));
        txtDiemTinHoc.setText(String.valueOf(d.getDiemTinHoc()));
        txtDiemGDTC.setText(String.valueOf(d.getDiemGDTC()));
        txtDiemTb.setText(String.valueOf(d.diemTrungBinh()));
    }

    public Diem read() {
        try {
            String maSv = txtMaSv.getText();
            String ten = txtTen.getText();
            float diemTiengAnh = Float.parseFloat(txtDiemTiengAnh.getText());
            float diemTinHoc = Float.parseFloat(txtDiemTinHoc.getText());
            float diemGDTC = Float.parseFloat(txtDiemGDTC.getText());
            if (diemTiengAnh < 0 || diemTiengAnh > 10) {
                JOptionPane.showMessageDialog(this, "Điểm Tiếng Anh phải nằm trong khoảng từ 0 đến 10.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (diemTinHoc < 0 || diemTinHoc > 10) {
                JOptionPane.showMessageDialog(this, "Điểm Tin Học phải nằm trong khoảng từ 0 đến 10.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (diemGDTC < 0 || diemGDTC > 10) {
                JOptionPane.showMessageDialog(this, "Điểm GDTC phải nằm trong khoảng từ 0 đến 10.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return new Diem(maSv, ten, diemTiengAnh, diemTinHoc, diemGDTC);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số vào các trường điểm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMaSv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiemTiengAnh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDiemTinHoc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDiemGDTC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDiemTb = new javax.swing.JTextField();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLui1 = new javax.swing.JButton();
        btnNext1 = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTop3 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Điểm");

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ ĐIỂM SINH VIÊN");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Mã Sinh Viên");

        btnSearch.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Assignment/Assignment2/Gakuseisean-Aire-Search.16.png")); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Họ tên:");

        txtTen.setEditable(false);

        jLabel5.setText("Mã SV:");

        txtMaSv.setEditable(false);

        jLabel6.setText("Tiếng anh:");

        jLabel7.setText("Tin học:");

        jLabel8.setText("GDTC:");

        jLabel9.setText("Điểm TB");

        txtDiemTb.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiemGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDiemTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiemTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDiemTb, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaSv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel9)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDiemTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(txtDiemTb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDiemTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnNew.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Assignment/Assignment2/Awicons-Vista-Artistic-Add.16.png")); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Assignment/Assignment2/Oxygen-Icons.org-Oxygen-Actions-document-save.16.png")); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Assignment/Assignment2/Awicons-Vista-Artistic-Delete.16.png")); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Assignment/Assignment2/Custom-Icon-Design-Pretty-Office-9-Edit-validated.16.png")); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Oxygen-Icons.org-Oxygen-Actions-arrow-left-double.32.png")); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnLui1.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Oxygen-Icons.org-Oxygen-Actions-arrow-left.32.png")); // NOI18N
        btnLui1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLui1ActionPerformed(evt);
            }
        });

        btnNext1.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Oxygen-Icons.org-Oxygen-Actions-arrow-right.32.png")); // NOI18N
        btnNext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext1ActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon("/Users/huy4205/Documents/Lập Trình Java 2/Oxygen-Icons.org-Oxygen-Actions-arrow-right-double.32.png")); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        tblTop3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sv", "Họ Tên", "Tiếng anh", "Tin học", "GDTC", "Điểm tb"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTop3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTop3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTop3);

        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Top 3 sinh viên có điểm cao nhất");

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNew)
                                    .addComponent(btnSave)
                                    .addComponent(btnDelete)
                                    .addComponent(btnUpdate)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnFirst)
                                .addGap(18, 18, 18)
                                .addComponent(btnLui1)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext1)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExit)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst)
                    .addComponent(btnLui1)
                    .addComponent(btnNext1)
                    .addComponent(btnLast))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnBack))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Diem d = qld.timTheoMa(txtMaSinhVien.getText());
        if (d != null) {
            load(d);
        } else {
            JOptionPane.showMessageDialog(this, "Sinh viên chưa có điểm");
            STUDENT st = qld.newD(txtMaSinhVien.getText());
            if (st != null) {
                txtMaSv.setText(st.getMaSv());
                txtTen.setText(st.getHoTen());
                txtDiemTiengAnh.setText("");
                txtDiemTinHoc.setText("");
                txtDiemGDTC.setText("");
                txtDiemTb.setText("");

                txtDiemTiengAnh.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Sinh viên không tồn tại");
            }

        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtMaSv.setText("");
        txtTen.setText("");
        txtDiemTiengAnh.setText("");
        txtDiemTinHoc.setText("");
        txtDiemGDTC.setText("");
        txtDiemTb.setText("");
        txtMaSinhVien.setText("");
        txtMaSinhVien.requestFocus();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Diem d = read();
        if (d != null && qld.nhapDiem(d) != 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            fillToTable();
            load(d);
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Diem d = read();
        if (d != null && qld.xoaDiem(d) != 0) {
            JOptionPane.showMessageDialog(this, "Xoá thành công");
            fillToTable();
            load(d);
        } else {
            JOptionPane.showMessageDialog(this, "Xoá thất bại");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        Diem d = read();
        if (d != null && qld.suaDiem(d) != 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            fillToTable();
            load(d);
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        bienHienTai = 0;
        hienThi(bienHienTai);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLui1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLui1ActionPerformed
        if (bienHienTai == 0) {
            bienHienTai = list.size() - 1;
            hienThi(bienHienTai);

        } else {
            bienHienTai--;
            hienThi(bienHienTai);
        }
    }//GEN-LAST:event_btnLui1ActionPerformed

    private void btnNext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext1ActionPerformed
        if (bienHienTai == list.size() - 1) {
            bienHienTai = 0;
            hienThi(bienHienTai);
        } else {
            bienHienTai++;
            hienThi(bienHienTai);
        }
    }//GEN-LAST:event_btnNext1ActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        bienHienTai = list.size() - 1;
        hienThi(bienHienTai);
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblTop3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTop3MouseClicked
        int i = tblTop3.getSelectedRow();
        load(list.get(i));
    }//GEN-LAST:event_tblTop3MouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        Login l = new Login();
        l.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(GiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiangVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnLui1;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTop3;
    private javax.swing.JTextField txtDiemGDTC;
    private javax.swing.JTextField txtDiemTb;
    private javax.swing.JTextField txtDiemTiengAnh;
    private javax.swing.JTextField txtDiemTinHoc;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtMaSv;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
