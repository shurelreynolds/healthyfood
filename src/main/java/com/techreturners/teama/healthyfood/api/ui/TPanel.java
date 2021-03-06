package com.techreturners.teama.healthyfood.api.ui;

import javax.swing.*;
import java.awt.*;

public class TPanel extends JPanel {
    private int red = 240;
    private int green = 240;
    private int blue = 240;

    boolean reverse;

    public TPanel(Color bgColor, LayoutManager layout, boolean reverse) {
        this(bgColor, layout);
        this.reverse = reverse;
    }


    public TPanel(Color bgColor, LayoutManager layout) {

        this(bgColor);
        setLayout(layout);
    }

    public TPanel(Color bgColor, boolean reverse) {
        this(bgColor);
    }

    public TPanel(Color bgColor) {
        this.red = bgColor.getRed();
        this.green = bgColor.getGreen();
        this.blue = bgColor.getBlue();
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = this.getWidth();
        int height = this.getHeight();
        float startPointX = 0.0f;
        float startPointY = 0.0f;
        float endPointX = width;
        float endPointY = 0.0f;
        Color startColor = new Color(red, green, blue, 255);
        Color endColor = Color.green;

        Paint paint = new GradientPaint(startPointX, startPointY, reverse ? endColor : startColor,
                endPointX, endPointY, reverse ? startColor : endColor);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(paint);
        g2D.fillRect(0, 0, width, height);

    }
}

