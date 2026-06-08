/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */
public class EcouteurCaseUI extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e ) {
        CaseUI caseUI = (CaseUI) e.getSource();
        if (SwingUtilities.isRightMouseButton(e)) {
            caseUI.getCaseMetier().marquer();
                    
        }
        if (SwingUtilities.isLeftMouseButton(e)) {
            System.out.println("Clic gauche");
        }
    }
    
}
