package com.techreturners.teama.healthyfood.api.ui;

import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.util.Json;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipePanel extends JPanel implements ActionListener {
    Meal meal;
    Font labelFont = new Font("Arial", Font.BOLD, 16);

    JLabel titleLabel = new JLabel();
    JLabel picLabel = new JLabel();
    JLabel prepLabel = new JLabel();
    JLabel servLabel = new JLabel();
    JLabel ingLabel = new JLabel();
    JButton saveButton = new JButton("Save");

    public RecipePanel(Meal meal) {
        super(new GridLayout(6, 1));
        this.meal = meal;

        setBorder(new LineBorder(Color.green, 4));
        setOpaque(false);
        setPreferredSize(new Dimension(300, 400));
        titleLabel.setOpaque(false);
        titleLabel.setFont(labelFont);
        add(titleLabel);
        picLabel.setOpaque(false);
        add(picLabel);
        prepLabel.setOpaque(false);
        prepLabel.setFont(labelFont);
        add(prepLabel);
        servLabel.setFont(labelFont);
        servLabel.setOpaque(false);
        add(servLabel);
        ingLabel.setOpaque(false);
        ingLabel.setFont(labelFont);
        add(ingLabel);

        saveButton.setOpaque(false);
        saveButton.addActionListener(this);
        add(saveButton);

        update(meal);
    }


    public void update(Meal meal) {
        this.meal = meal;
        titleLabel.setText(meal.getName());
      try {
            picLabel.setIcon(new ImageIcon(Json.decodeImage(meal.getPhoto())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        prepLabel.setText("Prep Time: " + meal.getPrepTime());
        servLabel.setText("Serve: " + meal.getServings());
        ingLabel.setText(meal.getIngredients());
    }

    public void clear() {
        this.meal = null;
        titleLabel.setText("");

        picLabel.setIcon(null);

        prepLabel.setText("");
        servLabel.setText("");
        ingLabel.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //save meal to plan
        Json.saveMealToPlan(meal);

    }
}
