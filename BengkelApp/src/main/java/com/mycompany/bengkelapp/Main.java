package com.mycompany.bengkelapp;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.bengkelapp.view.LoginFrame;

import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    new FlatDarkLaf()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        new LoginFrame().setVisible(true);
    }
}