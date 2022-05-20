package com.ita.speakukrainian.ui.tests;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    @org.testng.annotations.Factory
    public Object[] factoryMethod() {
        return new Object[] { new TestVerifiesThatErrorMessage177(dataProvider1500Symbols()), new TestVerifiesThatErrorMessage177(dataProviderLess1500Symbols()) };
    }

    private String dataProvider1500Symbols() {

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 1500; i++) {
            list.add("a");
        }
        System.out.println(list.size());

        return String.join("", list);
    }

    public String dataProviderLess1500Symbols() {

        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 1400; i++) {
            list.add("a");
        }
        System.out.println(list.size());

        return String.join("", list);
    }
}
