/*
 * CertificateDialog.java
 *
 * Created on April 29, 2004, 2:20 PM
 */

package org.owasp.webscarab.ui.swing;

import org.owasp.webscarab.plugin.Framework;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.JOptionPane;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.logging.Logger;

import org.owasp.webscarab.httpclient.HTTPClientFactory;
import org.owasp.webscarab.model.Preferences;

/**
 *
 * @author  knoppix
 */
public class CertificateDialog extends javax.swing.JDialog {
    
    private Logger _logger = Logger.getLogger(this.getClass().getName());
    
    private Framework _framework;
    
    private HTTPClientFactory _factory = HTTPClientFactory.getInstance();
    
    /** Creates new form CertificateDialog */
    public CertificateDialog(java.awt.Frame parent, Framework framework) {
        super(parent, true);
        _framework = framework;
        
        initComponents();
        initValues();
        enableFields();
    }
    
    private void initValues() {
        boolean useCert = Preferences.getPreference("WebScarab.clientCertificate", "false").equals("true");
        String file = Preferences.getPreference("WebScarab.clientCertificateFile",  "");
        String keystorePass = Preferences.getPreference("WebScarab.keystorePassword", "");
        String keyPass = Preferences.getPreference("WebScarab.keyPassword", "");
        
        useCertCheckBox.setSelected(useCert);
        keystoreTextField.setText(file);
        keystorePassTextField.setText(keystorePass);
        keyPassTextField.setText(keyPass);
    }
    
    private void enableFields() {
        jLabel1.setEnabled(useCertCheckBox.isSelected());
        keystoreTextField.setEnabled(useCertCheckBox.isSelected());
        jLabel2.setEnabled(useCertCheckBox.isSelected());
        keystorePassTextField.setEnabled(useCertCheckBox.isSelected());
        jLabel3.setEnabled(useCertCheckBox.isSelected());
        keyPassTextField.setEnabled(useCertCheckBox.isSelected());
        browseButton.setEnabled(useCertCheckBox.isSelected());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel4 = new javax.swing.JLabel();
        useCertCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        keystoreTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        keystorePassTextField = new javax.swing.JTextField();
        keyPassTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Dialog", 1, 12));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel4.setText("Use certificate?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(jLabel4, gridBagConstraints);

        useCertCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        useCertCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useCertCheckBoxActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        getContentPane().add(useCertCheckBox, gridBagConstraints);

        jLabel1.setText("Keystore");
        jLabel1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(jLabel1, gridBagConstraints);

        jLabel2.setText("Keystore Password");
        jLabel2.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setLabelFor(keyPassTextField);
        jLabel3.setText("Key Password");
        jLabel3.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(jLabel3, gridBagConstraints);

        keystoreTextField.setMinimumSize(new java.awt.Dimension(80, 19));
        keystoreTextField.setPreferredSize(new java.awt.Dimension(160, 19));
        keystoreTextField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(keystoreTextField, gridBagConstraints);

        browseButton.setText("Browse");
        browseButton.setEnabled(false);
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        getContentPane().add(browseButton, gridBagConstraints);

        keystorePassTextField.setToolTipText("This is the key to decrypt the KeyStore itself");
        keystorePassTextField.setMinimumSize(new java.awt.Dimension(80, 19));
        keystorePassTextField.setPreferredSize(new java.awt.Dimension(160, 19));
        keystorePassTextField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(keystorePassTextField, gridBagConstraints);

        keyPassTextField.setToolTipText("This is the key to decrypt the private key. It is often the same as the KeyStore password.");
        keyPassTextField.setMinimumSize(new java.awt.Dimension(80, 19));
        keyPassTextField.setPreferredSize(new java.awt.Dimension(160, 19));
        keyPassTextField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(keyPassTextField, gridBagConstraints);

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        jPanel1.add(applyButton);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.add(cancelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }//GEN-END:initComponents
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed
    
    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        boolean useCert = useCertCheckBox.isSelected();
        String file = keystoreTextField.getText().trim();
        String keystorePass = keystorePassTextField.getText();
        String keyPass = keyPassTextField.getText();
        if (useCert && file.equals("")) {
            JOptionPane.showMessageDialog(null, new String[] {"Provide a file to read the certificate from!"}, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean running = _framework.isRunning();
        if (running) {
            if (_framework.isBusy()) {
                String[] status = _framework.getStatus();
                JOptionPane.showMessageDialog(this, status, "Error - plugins are busy", JOptionPane.ERROR_MESSAGE);
                return;
            }
            _framework.stopPlugins();
        }
        boolean error = false;
        try {
            if (useCert) {
                _factory.setClientCertificateFile(file, keystorePass, keyPass);
            } else {
                _factory.setClientCertificateFile(null, null, null);
            }
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, new String[] {"File not found!", fnfe.toString()}, "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, new String[] {"Error reading from " + file, ioe.toString()}, "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, new String[] {"Unable to load client cert from " + file, e.toString()}, "Error", JOptionPane.ERROR_MESSAGE);
            error = true;
        }
        if (running) {
            _framework.startPlugins();
        }
        if (error) return;
        
        Preferences.setPreference("WebScarab.clientCertificate", useCertCheckBox.isSelected() ? "true" : "false");
        Preferences.setPreference("WebScarab.clientCertificateFile",  file);
        Preferences.setPreference("WebScarab.keystorePassword", keystorePass);
        Preferences.setPreference("WebScarab.keyPassword", keyPass);
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_applyButtonActionPerformed
    
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "*.p12";
            }
            public boolean accept(File file) {
                return file.getName().endsWith(".p12");
            }
        });
        jfc.setDialogTitle("Choose a file that contains a PKCS12 encoded keypair");
        int returnVal = jfc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            if (file != null) {
                keystoreTextField.setText(file.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_browseButtonActionPerformed
    
    private void useCertCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useCertCheckBoxActionPerformed
        enableFields();
    }//GEN-LAST:event_useCertCheckBoxActionPerformed
    
    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField keyPassTextField;
    private javax.swing.JTextField keystorePassTextField;
    private javax.swing.JTextField keystoreTextField;
    private javax.swing.JCheckBox useCertCheckBox;
    // End of variables declaration//GEN-END:variables
    
}
