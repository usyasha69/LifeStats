package com.example.pk.lifestats;

public class LifeStatsInspector {
    /**
     * This method checked correctly date.
     *
     * @return - result of checked
     */
    public static boolean dateIsCorrectly(String day, String month, String year) {
        boolean result = true;

        //checked day
        if (day.isEmpty()) {
            result = false;
        }

        if (!day.isEmpty() && (Integer.parseInt(day) <= 0 || Integer.parseInt(day) > 31)) {
            result = false;
        }

        //checked month
        if (month.isEmpty()) {
            result = false;
        }

        if (!month.isEmpty() && (Integer.parseInt(month) <= 0 || Integer.parseInt(month) > 12)) {
            result = false;
        }

        //checked year
        if (year.isEmpty()) {
            result = false;
        }

        if (!year.isEmpty() && Integer.parseInt(year) > LifeStatsCalculator.getCurrentYear()) {
            result = false;
        }

        return result;
    }
}
