/**
 * @author inforkgodara
 */

package view;

import javax.swing.JPanel;

public class CambiaPanel {
    //
    private JPanel container;
    private JPanel content;


    /**
     * Constructor de class
     */
    public CambiaPanel(JPanel container, JPanel content) {
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
    }

    CambiaPanel(ViewInvoice viewInvoice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//--> fin clase
