package com.techreturners.teama.healthyfood.api.ui;

import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.util.Json;
import com.techreturners.teama.healthyfood.api.util.Util;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipePanel extends JPanel implements ActionListener {
    Meal meal;
    Font labelFont = new Font("Arial", Font.BOLD, 18);
    Font label1Font = new Font("Arial", Font.PLAIN, 14);

    JLabel titleLabel = new JLabel();
    JLabel picLabel = new JLabel();
    JLabel prepLabel = new JLabel();

    JLabel ingLabel = new JLabel();
    JButton saveButton = new JButton("Save");

    public RecipePanel(Meal meal) {
        super(new GridLayout(6, 1));
        this.meal = meal;
        LineBorder lineBorder = new LineBorder(Color.green, 4);
        EmptyBorder emptyBorder = new EmptyBorder(15, 15, 15, 15);
        setBorder(new CompoundBorder(lineBorder, emptyBorder));
        setOpaque(false);
        setPreferredSize(new Dimension(300, 400));
        titleLabel.setOpaque(false);
        titleLabel.setFont(labelFont);
        titleLabel.setForeground(Color.orange.brighter());
        add(titleLabel);
        picLabel.setOpaque(false);
        add(picLabel);
        prepLabel.setOpaque(false);
        prepLabel.setFont(label1Font);
        add(prepLabel);
        ingLabel.setOpaque(false);
        ingLabel.setFont(labelFont);
        add(ingLabel);

        // saveButton.setOpaque(false);
        saveButton.addActionListener(this);
        saveButton.setBackground(Color.orange);
        add(saveButton);

        update(meal);
    }


    public void update(Meal meal) {
        this.meal = meal;
        titleLabel.setText(meal.getName());
        try {
            picLabel.setIcon(new ImageIcon(Util.decodeImage(meal.getPhoto())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        prepLabel.setText("<html><b>Prep Time:</b> " + meal.getPreptime() + "<br/>" +
                "<b>Serve:</b> " + meal.getServings() + "</html>");
        ingLabel.setText(meal.getIngredients());
    }

    public void clear() {
        this.meal = null;
        titleLabel.setText("");

        picLabel.setIcon(null);

        prepLabel.setText("");

        ingLabel.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //save meal to plan
        Json.saveMealToPlan(meal);

    }
}
