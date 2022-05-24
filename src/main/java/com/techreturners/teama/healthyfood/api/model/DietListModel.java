package com.techreturners.teama.healthyfood.api.model;

import com.techreturners.teama.healthyfood.api.util.Json;

import javax.swing.*;
import java.util.List;

public class DietListModel extends DefaultComboBoxModel {
    List<Diet> list;

    public DietListModel() {
        try {
            list = Json.geDietList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getSize() {
        if (list != null)
            return list.size();
        return 0;
    }

    @Override
    public Object getElementAt(int index) {
        if (list != null)
            return list.get(index);

        return null;
    }


}
