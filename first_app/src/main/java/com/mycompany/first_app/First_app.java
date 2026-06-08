/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.first_app;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author LePoly
 */
public class First_app {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Container c = f.getContentPane();
        c.add(new JButton("bouton"));
        f.setSize(200, 100);
        f.setVisible(true);
        
    }
}
