/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SaveDialog.java
 *
 * Created on Jun 29, 2010, 1:54:32 AM
 */

package resultEditor.save;

import java.io.File;
import java.util.Vector;
import javax.swing.Icon;

/**
 *
 * @author Chris
 */
public class SaveDialog extends javax.swing.JFrame {



    protected userInterface.GUI gui;
    protected static String outputpath = null;
    private static Icon notdone;
    private static Icon done;

    protected static Vector<Filelist> filelist = new Vector<Filelist>();

    /** Creates new form SaveDialog */
    public SaveDialog(userInterface.GUI gui) {
        initComponents();

        done = jLabel_done.getIcon();
        notdone = jLabel_notdone.getIcon();

        this.gui = gui;

        setDailogPosition( gui );
        
        filelist.clear();
        clearList();

        if(outputpath == null){
            if( env.Parameters.isUnixOS )
                jTextField1.setText("./output");
            else
                jTextField1.setText(".\\output");
        }else{
            jTextField1.setText(outputpath);
        }

        filelist.clear();
        filelist = buildLocalFilelist();

        listdisplay();

        this.setResizable(false);
        this.setTitle("Output Annotations to XML files...");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
 
    private void setDailogPosition(userInterface.GUI gui){
        int width = this.getWidth(), height = this.getHeight();
        int parentwidth = gui.getWidth(), parentheight = gui.getHeight();
        int parentX = gui.getX(), parentY = gui.getY();
        int x = parentX + (int)((parentwidth - width)/2);
        int y = parentY + (int)((parentheight - height)/2);
        this.setLocation(x, y);
    }

    private void clearList(){
        Vector c = new Vector();
        jList1.setListData(c);
    }

    public static void listdisplay() {
        
        
        Vector<Object> listentry = new Vector<Object>();
        for( Filelist textsource: filelist){
            String filename = textsource.textsourcefile.getName() + ".knowtator.xml";
            int annotationsAmount = countAnnotations(textsource.textsourcefile.getName()  );
            String str;
            
            iListEntry i;
            i = new iListEntry( filename, annotationsAmount, notdone, done,textsource.status );
            if (textsource.wantOutput)
                i.isCheckBoxSelected = true;
            else i.isCheckBoxSelected = false;

           

            listentry.add( i );

        }

        jList1.setListData( listentry );
        jList1.setCellRenderer(new iListCellRenderer());
        
    }

    class OutputfileListEntry{
        Icon icon;
        String lines;
    }

    /**To a given filename of text source, count how many annotations it has.*/
    private static int countAnnotations(String textsourcefilename){
        resultEditor.annotations.Depot depot = new resultEditor.annotations.Depot();
        resultEditor.annotations.Article article = depot.getArticleByFilename(textsourcefilename);
        if(article == null) return 0;
        if( article.annotations == null )   return 0;
        return article.annotations.size();
    }

    private Vector<Filelist> buildLocalFilelist(){



        Vector<env.clinicalNoteList.CorpusStructure> textsources = env.Parameters.corpus.LIST_ClinicalNotes;
        Vector<Filelist> lists = new Vector<Filelist>();
        for( env.clinicalNoteList.CorpusStructure textsource: textsources){
            Filelist list = new Filelist();
            list.textsourcefile = textsource.file;
            list.status = 0;
            lists.add(list);
        }

        return lists;
    }

    public static void setCheckBoxSelectedStatus(String output_filename, boolean flag){
        if ( filelist == null )
            return;

        for( Filelist file : filelist ){
            if ( file == null )
                continue;
            String filename = file.textsourcefile.getName().trim();
            if ( filename.equals( output_filename.trim() ) ) {
                file.wantOutput = flag;
                return;
            }
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel_notdone = new javax.swing.JLabel();
        jLabel_done = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jButton_save1 = new javax.swing.JButton();

        jLabel_notdone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/radiobutton_unchecked_pressed.png"))); // NOI18N
        jLabel_notdone.setText("<html>jLabel3------<br>dsd<br>dsdf</html>");
        jLabel_notdone.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel_done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/done.png"))); // NOI18N
        jLabel_done.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jList1.setFont(new java.awt.Font("Calibri", 0, 11));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("Calibri", 0, 11));
        jTextField1.setText("jTextField1");
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel1.add(jTextField1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 11));
        jLabel1.setText("Output Path:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 11));
        jLabel2.setText("<html>Destination<br>files<br>for<br>XML<br>output:</html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 30, 0);
        jPanel1.add(jLabel2, gridBagConstraints);

        jTabbedPane1.addTab("Output to XML", jPanel1);

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12));
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton_save.setFont(new java.awt.Font("Verdana", 0, 12));
        jButton_save.setText("Save");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_save1.setFont(new java.awt.Font("Calibri", 0, 11));
        jButton_save1.setText("Change Path");
        jButton_save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_save1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_save1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton_save, jButton_save1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton_save1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(19, 19, 19))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton_save, jButton_save1});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        closeDialog();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void closeDialog(){
        gui.setEnabled(true);
        this.dispose();
    }


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        closeDialog();
    }//GEN-LAST:event_formWindowClosing

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        beginSaveToDisk();
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_save1ActionPerformed
        selectOutputfolder();
    }//GEN-LAST:event_jButton_save1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        //if ( evt.getClickCount() == 1 ){
            int indexmax = jList1.getModel().getSize();
            int selectedindex = jList1.getSelectedIndex();
            if( ( selectedindex >= indexmax ) ||(selectedindex < 0))
                return;

            if( filelist == null )
                return;
            if ( selectedindex >= filelist.size()  )
                return;

            Filelist thisoutputfile = filelist.get( selectedindex );
            if ( thisoutputfile == null )
                return;

            thisoutputfile.wantOutput = !thisoutputfile.wantOutput;

            for( Filelist file : filelist  ){
                file.status = 0;
            }

            listdisplay();

        //}
    }//GEN-LAST:event_jList1MouseClicked

    private void beginSaveToDisk(){
        String path;
        if(outputpath == null){
            if( env.Parameters.isUnixOS )
                path  = "./output";
            else
                path = ".\\output";
        }else{
            path = outputpath;
        }

        jButton_save.setEnabled(false);

        for( Filelist textsource: filelist){
            if ( !textsource.wantOutput ) {
                textsource.status = 1;
                listdisplay();
                continue;
            }

            String textsourcefilename = textsource.textsourcefile.getName();            
            outputxml( path, textsourcefilename);
            textsource.status = 2;
            listdisplay();
        }

        jButton_save.setEnabled(true);
    }

    private void outputxml(String path, String textsourcefilename){
        OutputToXML toxml = new OutputToXML( textsourcefilename, path, null );
        toxml.write();
    }

    private void selectOutputfolder(){
        javax.swing.JFileChooser filechooser = new javax.swing.JFileChooser();
        filechooser.setDialogTitle("Choose foloer to save ...");
        filechooser.setMultiSelectionEnabled(false);
        filechooser.setSelectedFile(null);
        filechooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        int re = filechooser.showSaveDialog(this);

        // set the value of variable to record the selected path
        // if get valid return
        if (re == 0){
            String thisoutputpath;
            //jFileChooser1.setFileSelectionMode(1);
            File f = filechooser.getSelectedFile();
            if(!f.exists())
                thisoutputpath = filechooser.getCurrentDirectory().toString();
            else
                thisoutputpath = f.getAbsolutePath();
            outputpath = thisoutputpath;
            //env.Parameters.XML_OUTPUT_PATH = xmloutput_path;
            jTextField1.setText(outputpath);
        }
    }

    class Filelist{
        File textsourcefile;
        int status;
        boolean wantOutput = true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_save1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel_done;
    private static javax.swing.JLabel jLabel_notdone;
    protected static javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

