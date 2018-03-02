/*
 * DefineDialog.java
 *
 * Created on Nov 4, 2010, 11:43:10 AM
 */

package userInterface.differenceMatching;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * 
 * @author  Jianwei Chris Leng,
 *          Nov 4, 2010,
 *          Division of Epidemiolofy, School of Medicine, University of Utah.
 */
public class DefineDialog extends JFrame {

    protected JFrame jc;

    /** Creates new form DefineDialog */
    public DefineDialog(JFrame jc  ) {
        initComponents();
        this.jc = jc;

        setComponents();
        setDialogDisplayAttributes(jc);

    }


    /**set some initial values for component*/
    private void setComponents(){
        // Checkboxes could not be unselected and their default status
        // always are "selected";
        this.jCheckBox_spanchecking.setSelected(true);
        this.jCheckBox_samespan.setSelected(false);
        this.setPreferredSize(new Dimension(752,410));
        this.setResizable(false);

        // set checkbox selection status by global variables in
        // env.parameters.differencematching
        try{

            // only this one is allowed to be turnned on/off
            this.jCheckBox_crossspan.setSelected( env.Parameters.DifferenceMatching.checkCrossSpan );
            this.jCheckBox_samespan.setSelected( env.Parameters.DifferenceMatching.checkSameOverlappingSpan );

            // folloing are all for attributes checking
            jCheckBox_span.setSelected( env.Parameters.DifferenceMatching.checkatt_forSpan );
            jCheckBox4_category.setSelected( env.Parameters.DifferenceMatching.checkatt_forClass );
            jCheckBox_comments.setSelected( env.Parameters.DifferenceMatching.checkatt_forComment );
            jCheckBox_annotator.setSelected( env.Parameters.DifferenceMatching.checkatt_forAnnotator );
            jCheckBox_complex.setSelected( env.Parameters.DifferenceMatching.checkatt_forComplex );
            jCheckBox_normal.setSelected(env.Parameters.DifferenceMatching.checkatt_forNormal);
            

        }catch(Exception ex){
        }
    }


    /**
     * Set the display attributes for this dialog.
     * 
     * @param   jc
     *          the parent java visiable component
     */
    private void setDialogDisplayAttributes(JFrame jc){

        if (jc==null)
            return;

        // the the screen location of current dialog
        try{
            int xp=jc.getX(), yp=jc.getY();
            int widthp=jc.getWidth(), heightp=jc.getHeight();
            int width = this.getWidth(), height=this.getHeight();
            int x = xp + (int)((widthp - width)/2);
            int y = yp + (int)((heightp - height)/2);
            this.setLocation(x, y);
        }catch(Exception ex){
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jCheckBox_complex = new javax.swing.JCheckBox();
        jCheckBox_normal = new javax.swing.JCheckBox();
        jCheckBox4_category = new javax.swing.JCheckBox();
        jCheckBox_spanchecking = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox_samespan = new javax.swing.JCheckBox();
        jCheckBox_crossspan = new javax.swing.JCheckBox();
        jCheckBox_span = new javax.swing.JCheckBox();
        jCheckBox_annotator = new javax.swing.JCheckBox();
        jCheckBox_comments = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Define what's difference matching to annotations");
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox_complex.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_complex.setFont(new java.awt.Font("Verdana", 0, 13));
        jCheckBox_complex.setSelected(true);
        jCheckBox_complex.setText("different complex relationships");
        jCheckBox_complex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_complexActionPerformed(evt);
            }
        });

        jCheckBox_normal.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_normal.setFont(new java.awt.Font("Verdana", 0, 13));
        jCheckBox_normal.setSelected(true);
        jCheckBox_normal.setText("different attributes");
        jCheckBox_normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_normalActionPerformed(evt);
            }
        });

        jCheckBox4_category.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4_category.setFont(new java.awt.Font("Verdana", 0, 13));
        jCheckBox4_category.setSelected(true);
        jCheckBox4_category.setText("different markable category/class");
        jCheckBox4_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4_categoryActionPerformed(evt);
            }
        });

        jCheckBox_spanchecking.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_spanchecking.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheckBox_spanchecking.setSelected(true);
        jCheckBox_spanchecking.setText("Indicate annotations that match exactly or have overlapping spans with a rad wavy underline:");
        jCheckBox_spanchecking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_spancheckingActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102), 2));
        jPanel4.setMinimumSize(new Dimension(20, 20));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 4, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DifferenceMatching/overlapping.png"))); // NOI18N
        jPanel4.add(jLabel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(2, 0, 0, 4));

        jCheckBox_samespan.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_samespan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jCheckBox_samespan.setSelected(true);
        jCheckBox_samespan.setText("Spans match exactly");
        jCheckBox_samespan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_samespanActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox_samespan);

        jCheckBox_crossspan.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_crossspan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jCheckBox_crossspan.setSelected(true);
        jCheckBox_crossspan.setText("Overlapping spans");
        jCheckBox_crossspan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_crossspanActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBox_crossspan);

        jPanel4.add(jPanel5);

        jCheckBox_span.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_span.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        jCheckBox_span.setSelected(true);
        jCheckBox_span.setText("different spans");
        jCheckBox_span.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_spanActionPerformed(evt);
            }
        });

        jCheckBox_annotator.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_annotator.setFont(new java.awt.Font("Verdana", 0, 13));
        jCheckBox_annotator.setSelected(true);
        jCheckBox_annotator.setText("different annotator");
        jCheckBox_annotator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_annotatorActionPerformed(evt);
            }
        });

        jCheckBox_comments.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox_comments.setFont(new java.awt.Font("Verdana", 0, 13));
        jCheckBox_comments.setSelected(true);
        jCheckBox_comments.setText("different comments");
        jCheckBox_comments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_commentsActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 13));
        jLabel2.setText("Check differences to compare between annotations");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 455, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jCheckBox_spanchecking)
                        .addContainerGap(37, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jCheckBox_span)
                            .add(jCheckBox_complex)
                            .add(jCheckBox_comments))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 103, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jCheckBox_normal)
                            .add(jCheckBox_annotator)
                            .add(jCheckBox4_category))
                        .add(86, 86, 86))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jCheckBox_spanchecking)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jCheckBox_span)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox_comments)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox_complex))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jCheckBox4_category)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox_annotator)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox_normal)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(214, 214, 224));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(214, 214, 224));

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton2))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jButton2)
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Enables/disable checkboxs for checking differences in attributes 
     * attributes in class, complex relationship, normal relationship.
     */
    
    /**Checkbox is default and could not be unselected.*/
    private void jCheckBox_spancheckingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_spancheckingActionPerformed
        this.jCheckBox_spanchecking.setSelected(true);
    }//GEN-LAST:event_jCheckBox_spancheckingActionPerformed

    
    /**Checkbox is default and could not be unselected.*/
    private void jCheckBox_samespanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_samespanActionPerformed
        user_clicked_onCheckBoxesOfOverlapSpans();
        
    }//GEN-LAST:event_jCheckBox_samespanActionPerformed

    private void jCheckBox_crossspanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_crossspanActionPerformed
        user_clicked_onCheckBoxesOfOverlapSpans();
    }//GEN-LAST:event_jCheckBox_crossspanActionPerformed


    /**Set parameters to tell system whether user want to show cross overlap
     * spans or exact overlap spans.
     */
    private void user_clicked_onCheckBoxesOfOverlapSpans(){
        
        //##1## get current status before judging
        boolean samespan=this.jCheckBox_samespan.isSelected();
        boolean overlapspan=this.jCheckBox_crossspan.isSelected();

        //##2## if both are not selected, cross overlap will be set as default
        if((!samespan)&&(!overlapspan)){
            this.jCheckBox_crossspan.setSelected(true);
        }

        //##3## if anyone of these two checkboxes got selected
        //##3.1## exact overlap span
        if( jCheckBox_samespan.isSelected() ){
            env.Parameters.DifferenceMatching.checkSameOverlappingSpan=true;
        }else{
            env.Parameters.DifferenceMatching.checkSameOverlappingSpan=false;
        }
        //##3.2## only indicate cross part of overlappings by wavy red underline
        if (jCheckBox_crossspan.isSelected() ){
            env.Parameters.DifferenceMatching.checkCrossSpan=true;
        }else{
            env.Parameters.DifferenceMatching.checkCrossSpan=false;
        }

    }

    private void jCheckBox4_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4_categoryActionPerformed
        // TODO add your handling code here:]
        env.Parameters.DifferenceMatching.checkatt_forClass = jCheckBox4_category.isSelected();
    }//GEN-LAST:event_jCheckBox4_categoryActionPerformed

    private void jCheckBox_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_normalActionPerformed
        // set flag while checkbox of normal relationship is selected or dis-selected
        env.Parameters.DifferenceMatching.checkatt_forNormal = jCheckBox_normal.isSelected();
    }//GEN-LAST:event_jCheckBox_normalActionPerformed

    private void jCheckBox_complexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_complexActionPerformed
        // set flag while checkbox of complex relationship is selected or dis-selected
        env.Parameters.DifferenceMatching.checkatt_forComplex = jCheckBox_complex.isSelected();
    }//GEN-LAST:event_jCheckBox_complexActionPerformed

    private void jCheckBox_spanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_spanActionPerformed
        env.Parameters.DifferenceMatching.checkatt_forSpan = jCheckBox_span.isSelected();
    }//GEN-LAST:event_jCheckBox_spanActionPerformed

    private void jCheckBox_annotatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_annotatorActionPerformed
        env.Parameters.DifferenceMatching.checkatt_forAnnotator = jCheckBox_annotator.isSelected();
    }//GEN-LAST:event_jCheckBox_annotatorActionPerformed

    private void jCheckBox_commentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_commentsActionPerformed
        env.Parameters.DifferenceMatching.checkatt_forComment = jCheckBox_comments.isSelected();
    }//GEN-LAST:event_jCheckBox_commentsActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefineDialog().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox4_category;
    private javax.swing.JCheckBox jCheckBox_annotator;
    private javax.swing.JCheckBox jCheckBox_comments;
    private javax.swing.JCheckBox jCheckBox_complex;
    private javax.swing.JCheckBox jCheckBox_crossspan;
    private javax.swing.JCheckBox jCheckBox_normal;
    private javax.swing.JCheckBox jCheckBox_samespan;
    private javax.swing.JCheckBox jCheckBox_span;
    private javax.swing.JCheckBox jCheckBox_spanchecking;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
