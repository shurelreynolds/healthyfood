package com.techreturners.teama.healthyfood.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techreturners.teama.healthyfood.api.model.Meal;
import com.techreturners.teama.healthyfood.api.util.Json;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest


{

    @Test
    public void testHealth(){
        int expected=200;
        try {
            assertEquals(expected, Json.getHealth());
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testMealResponse()   {
        ObjectMapper m=new ObjectMapper();
        Meal meal= null;
        try {
            meal = m.readValue("{\"mealId\":\"1\",\"name\":\"Mac & Cheese\"}".getBytes(), Meal.class);
            assertEquals("1",meal.getMealId());
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

        System.out.println(meal.getMealId());
        assertTrue( true );
    }
}
