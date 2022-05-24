package com.techreturners.teama.healthyfood.api;

import com.techreturners.teama.healthyfood.api.model.DietListModel;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.model.User;
import com.techreturners.teama.healthyfood.api.ui.RecipePanel;
import com.techreturners.teama.healthyfood.api.ui.TPanel;
import com.techreturners.teama.healthyfood.api.util.Json;

import javax.swing.*;
import java.awt.*;


public class App extends JFrame {
    User user = Json.defaultUser;
    Color leafColor = new Color(51, 104, 51);
    Color lightLeafColor = leafColor.brighter();
    TPanel northPanel = new TPanel(leafColor, new FlowLayout(FlowLayout.LEFT));
    TPanel mainPanel = new TPanel(leafColor, new BorderLayout());
    TPanel homePanel = new TPanel(leafColor, new BorderLayout());
    TPanel calendarPanel = new TPanel(leafColor);
    TPanel recipePanel = new TPanel(leafColor);
    TPanel dailyPlanPanel = new TPanel(leafColor);
    TPanel recipeItemPanel = new TPanel(leafColor);
    TPanel statusPanel = new TPanel(leafColor);

    Font labelFont = new Font("Arial", Font.BOLD, 20);

    java.util.List<Meal> mealList;

    {
        try {
            mealList = Json.getMealList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    RecipePanel recipePanel1 = new RecipePanel(mealList.get(0));
    RecipePanel recipePanel2 = new RecipePanel(mealList.get(0));
    RecipePanel recipePanel3 = new RecipePanel(mealList.get(0));

    public App() {
        super("HealthyFoodFrame v1");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        // Center it on the screen
        this.setLocationRelativeTo(null);

        this.getContentPane().setLayout(new GridLayout(0, 1));
        TPanel panel = new TPanel(Color.RED);
        panel.setLayout(new BorderLayout());
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);
        panel.add(statusPanel, BorderLayout.SOUTH);


        JLabel label = new JLabel("Name: " + user.getName());
        label.setFont(labelFont);
        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());

        label = new JLabel("Carbs: " + user.getCarbohydrates());
        label.setFont(labelFont);
        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());

        label = new JLabel("Fat: " + user.getFat());
        label.setFont(labelFont);
        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());

        label = new JLabel("Protein: " + user.getProtein());
        label.setFont(labelFont);
        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());


        JTabbedPane tab = new JTabbedPane();
        mainPanel.add(tab, BorderLayout.CENTER);


        tab.add("Home", homePanel);
        tab.add("Calendar", calendarPanel);
        tab.add("Recipe", recipePanel);

        tab.setBackgroundAt(0, Color.black);
        tab.setForegroundAt(0, Color.white);

        tab.setBackgroundAt(1, Color.orange);
        tab.setForegroundAt(1, Color.white);

        tab.setBackgroundAt(2, leafColor);
        tab.setForegroundAt(2, Color.white);


        TPanel tp = new TPanel(lightLeafColor, new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Diet: ");
        label.setFont(labelFont);
        tp.add(label);

        JComboBox box = new JComboBox((ComboBoxModel) new DietListModel());
        tp.add(box);

        homePanel.add(tp, BorderLayout.NORTH);

        tp = new TPanel(lightLeafColor, new FlowLayout(FlowLayout.LEFT));
        tp.add(recipePanel1);
        tp.add(recipePanel2);
        tp.add(recipePanel3);
        homePanel.add(tp, BorderLayout.CENTER);


        this.add(panel);

    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(() -> {
            new App().setVisible(true);

        });
    }


}
