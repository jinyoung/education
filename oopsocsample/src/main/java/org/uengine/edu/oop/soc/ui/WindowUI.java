package org.uengine.edu.oop.soc.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by uengine on 2017. 1. 20..
 */
public class WindowUI extends UI{


    @Override
    public void doUI() {
        JFrame jFrame = new JFrame();
        jFrame.setTitle(getClass().getSimpleName());

        JLabel label = new JLabel();
        label.setText("결과는 " + getLogic().doLogic());

        jFrame.setLayout(new BorderLayout());
        jFrame.add(label);
        jFrame.setSize(100,100);
        jFrame.setVisible(true);


    }
}