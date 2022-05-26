package com.techreturners.teama.healthyfood.api;

import com.techreturners.teama.healthyfood.api.model.DietListModel;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.model.User;
import com.techreturners.teama.healthyfood.api.ui.RecipePanel;
import com.techreturners.teama.healthyfood.api.ui.TPanel;
import com.techreturners.teama.healthyfood.api.util.Json;
import com.techreturners.teama.healthyfood.api.util.Util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.techreturners.teama.healthyfood.api.util.Util.leafColor;


public class App extends JFrame {
    private User user = Util.defaultUser;

    private Color lightLeafColor = leafColor.brighter();
    private TPanel northPanel = new TPanel(leafColor, new FlowLayout(FlowLayout.LEFT));
    private TPanel mainPanel = new TPanel(leafColor, new BorderLayout(), true);
    private TPanel homePanel = new TPanel(leafColor, new BorderLayout());
    private TPanel calendarPanel = new TPanel(leafColor);
    private TPanel recipePanel = new TPanel(leafColor);
    private TPanel helpPanel = new TPanel(leafColor);
    private TPanel dailyPlanPanel = new TPanel(leafColor);
    private TPanel recipeItemPanel = new TPanel(leafColor);
    private TPanel statusPanel = new TPanel(leafColor);
    private JLabel statusLabel = new JLabel();

    private Font labelFont = new Font("Arial", Font.BOLD, 20);
    private Font label1Font = new Font("Arial", Font.BOLD, 18);
    private Color northLabelColor = new Color(215, 215, 215);


    private java.util.List<Meal> mealList;

    {
        try {
            mealList = Json.getMealList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RecipePanel recipePanel1 = new RecipePanel(mealList.get(0));
    private RecipePanel recipePanel2 = new RecipePanel(mealList.get(1));
    private RecipePanel recipePanel3 = new RecipePanel(mealList.get(2));

    public App() throws Exception {
        super("HealthyFood v1");
        setIconImage(Util.decodeImage(Util.frameIcon));
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

        northPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        JLabel label = new JLabel("Name: " + user.getName());
        label.setFont(labelFont);
        label.setForeground(northLabelColor);

        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());

        label = new JLabel("Carbs: " + user.getCarbohydrates());
        label.setFont(labelFont);
        label.setForeground(northLabelColor);

        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());

        label = new JLabel("Fat: " + user.getFat());
        label.setForeground(northLabelColor);

        label.setFont(labelFont);
        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());

        label = new JLabel("Protein: " + user.getProtein());
        label.setFont(labelFont);
        label.setForeground(northLabelColor);

        northPanel.add(label);
        northPanel.add(new JToolBar.Separator());


        JTabbedPane tab = new JTabbedPane();
        mainPanel.add(tab, BorderLayout.CENTER);
        mainPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        tab.add("Home", homePanel);
        tab.add("Calendar", calendarPanel);
        tab.add("Recipes", recipePanel);
        tab.add("Help", helpPanel);

        tab.setBackgroundAt(0, Color.black);
        tab.setForegroundAt(0, Color.white);

        tab.setBackgroundAt(1, Color.orange);
        tab.setForegroundAt(1, Color.white);

        tab.setBackgroundAt(2, leafColor);
        tab.setForegroundAt(2, Color.white);

        tab.setBackgroundAt(3, Color.blue);
        tab.setForegroundAt(3, Color.white);

        tab.setTabComponentAt(0, new TabLabel("Home"));

        TPanel tp = new TPanel(lightLeafColor, new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Diet: ");
        label.setForeground(northLabelColor);
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

        statusLabel = new JLabel("7 Diets");
        statusLabel.setFont(label1Font);
        statusPanel.add(statusLabel);
        this.add(panel);

    }

    public static void main(String[] a) {
        SwingUtilities.invokeLater(() -> {
            try {
                new App().setVisible(true);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    class TabLabel extends JLabel {

        TabLabel(String text) {
            super(text);
            setOpaque(false);
            setPreferredSize(new Dimension(80, 40));
        }
    }

}
