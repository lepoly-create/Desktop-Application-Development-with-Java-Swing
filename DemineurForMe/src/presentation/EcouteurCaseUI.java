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
/*
 * MouseAdapter est une classe abstraite pas une interface ,
 * donc ova redefinir la methode MouseClicked
 */
public class EcouteurCaseUI extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent e) {
        /*
         * puisque chaque bouteur a un écouteur,
         * donc on va recuper celui qui est l'origine de son evenement,
         * recuperer l'objet qui a ete a la source de l'evenement
         */
        /* il faut faire un cast pour transformer lobjet */
        CaseUI caseUI = (CaseUI) e.getSource();

        /*
         * autre facon de faire est dobtenir la position de l'objet
         * qui est un peu difficiel a faire
         */

        /*
         * comment savoir si cest un clic droit ou un clic gauche c'est a ce probleme on
         * va résourdre
         */
        if (SwingUtilities.isRightMouseButton(e)) {
            caseUI.getCaseMetier().marquer();
            caseUI.afficher();
        }
        if (SwingUtilities.isLeftMouseButton(e)) {
            caseUI.getCaseMetier().devoiler();
            caseUI.getPlateau().afficher();

        }
    }

}
