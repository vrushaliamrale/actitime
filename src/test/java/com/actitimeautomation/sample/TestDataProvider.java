package com.actitimeautomation.sample;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public String[][] getSampleData() {

        String[][] obj = new String[][]{
                {"Pune", "Mumbai", "Solapur"},
                {"Nagpur", "Delhi", ""}
        };
        return obj;
    }


}
