package View;

import Model.Produto;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciaProduto extends javax.swing.JFrame {

    private Produto objproduto;

    public GerenciaProduto() {
        initComponents();
        this.objproduto = new Produto();
        this.carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textProduto = new javax.swing.JTextField();
        textDesc = new javax.swing.JTextField();
        textEstoque = new javax.swing.JTextField();
        textPreco = new javax.swing.JTextField();
        alterarProduto = new javax.swing.JButton();
        apagarProduto = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textData = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque");

        tableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Produto", "Descrição", "Quantidade em estoque", "Preço", "Data de cadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProdutos);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel1.setText("Gerenciamento de Produtos");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Nome Do Produto:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Descrição do Produto:");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel4.setText("Quantidade em estoque:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel5.setText("Preço:");

        alterarProduto.setText("Alterar");
        alterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProdutoActionPerformed(evt);
            }
        });

        apagarProduto.setText("Apagar");
        apagarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarProdutoActionPerformed(evt);
            }
        });

        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel6.setText("Data de cadastro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textProduto)
                        .addComponent(textDesc)
                        .addComponent(textEstoque)
                        .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alterarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apagarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(alterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(apagarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_cancelActionPerformed

    private void alterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarProdutoActionPerformed
        // TODO add your handling code here:

        try {
            String nome_produto = "";
            String descrição_produto = "";
            int quantidade_estoque = 0;
            double preço = 0;
            Date data_cadastro;

            if (this.textProduto.getText().length() < 2) {
                throw new Mensagens("Nome do produto deve conter no mínimo 2 caracteres.");
            } else {
                nome_produto = this.textProduto.getText();
            }

            if (this.textDesc.getText().length() < 5) {
                throw new Mensagens("Descrição do produto deve conter no mínimo 5 caracteres.");
            } else {
                descrição_produto = this.textDesc.getText();
            }

            try {
                quantidade_estoque = Integer.parseInt(this.textEstoque.getText());
                if (quantidade_estoque < 0) {
                    throw new Mensagens("Número em estoque deve ser maior ou igual a 0");
                }

            } catch (Exception erro) {
                throw new Mensagens("Quantidade de estoque inválida");
            }

            if (this.textEstoque.getText().length() <= 0) {
                throw new Mensagens("Número em estoque deve ser maior ou igual a 0");
            } else {
                quantidade_estoque = Integer.parseInt(this.textEstoque.getText());
            }

            if (this.textPreco.getText().length() <= 2) {
               //  textPreco = preço.replace(",";".");
                throw new Mensagens("Formato invalido. Tente colocar '.' em vez de ','");
            } else {
                preço = Double.parseDouble(this.textPreco.getText());
            }

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String dateString = this.textData.getText();
                LocalDate date = LocalDate.parse(dateString, formatter);
                Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
                data_cadastro = Date.from(instant);
            } catch (DateTimeParseException e) {
                throw new Mensagens("Formato de data inválido. Correto yyyy-MM-dd");
            }
            int id;
            if (this.tableProdutos.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Aluno para Alterar");
            } else {
                id = Integer.parseInt(this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 0).toString());
            }

            if (this.objproduto.UpdateProdutoBD(id, nome_produto, descrição_produto, quantidade_estoque, preço, data_cadastro)) {

                this.textProduto.setText("");
                this.textEstoque.setText("");
                this.textPreco.setText("");
                this.textDesc.setText("");
                this.textData.setText("");
                JOptionPane.showMessageDialog(rootPane, "Produto alterado com sucesso.");
            }

            System.out.println(this.objproduto.getListaProdutos().toString());
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_alterarProdutoActionPerformed

    private void tableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutosMouseClicked
        // TODO add your handling code here:
        if (this.tableProdutos.getSelectedRow() != -1) {

            String nome_produto = this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 1).toString();
            String descrição_produto = this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 2).toString();
            String quantidade_estoque = this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 3).toString();
            String preço = this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 4).toString();
            String data_cadastro = this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 5).toString();

            this.textProduto.setText(nome_produto);
            this.textDesc.setText(descrição_produto);
            this.textEstoque.setText(quantidade_estoque);
            this.textPreco.setText(preço);
            this.textData.setText(data_cadastro);

        }
    }//GEN-LAST:event_tableProdutosMouseClicked

    private void apagarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarProdutoActionPerformed
        // TODO add your handling code here:
        try {
            // validando dados da interface gr�fica.
            int id = 0;
            if (this.tableProdutos.getSelectedRow() == -1) {
                throw new Mensagens("Primeiro Selecione um Aluno para APAGAR");
            } else {
                id = Integer.parseInt(this.tableProdutos.getValueAt(this.tableProdutos.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro bot�o | 1 -> segundo bot�o | 2 -> terceiro bot�o
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar este Produto?");

            if (resposta_usuario == 0) {// clicou em SIM

                // envia os dados para o Aluno processar
                if (this.objproduto.DeleteProdutoBD(id)) {

                    // limpa os campos
                    this.textProduto.setText("");
                    this.textDesc.setText("");
                    this.textEstoque.setText("");
                    this.textPreco.setText("");
                    this.textData.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Produto apagado com sucesso.");

                }

            }

            System.out.println(this.objproduto.getListaProdutos().toString());

        } catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            carregaTabela(); // atualiza a tabela.
        }
    }//GEN-LAST:event_apagarProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciaProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciaProduto().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    public void carregaTabela() {

        DefaultTableModel modelo = (DefaultTableModel) this.tableProdutos.getModel();
        modelo.setNumRows(0);

        ArrayList<Produto> listaprodutos = new ArrayList<>();
        listaprodutos = objproduto.getListaProdutos();
        System.out.println(listaprodutos.size());
        for (Produto a : listaprodutos) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome_produto(),
                a.getDescrição_produto(),
                a.getQuantidade_estoque(),
                a.getPreço(),
                a.getData_cadastro()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarProduto;
    private javax.swing.JButton apagarProduto;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProdutos;
    private javax.swing.JTextField textData;
    private javax.swing.JTextField textDesc;
    private javax.swing.JTextField textEstoque;
    private javax.swing.JTextField textPreco;
    private javax.swing.JTextField textProduto;
    // End of variables declaration//GEN-END:variables

}
