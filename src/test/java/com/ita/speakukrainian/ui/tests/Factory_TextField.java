package com.ita.speakukrainian.ui.tests;

import java.util.ArrayList;
import java.util.List;

public class Factory_TextField {
    @org.testng.annotations.Factory
    public Object[] factoryMethod() {
        return new Object[] { new TestVerifiesThatErrorMessage177Factory(dataProvider1500Symbols()) };
    }

    private String dataProvider1500Symbols() {

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 1550; i++) {
            list.add("a");
        }
        System.out.println(list.size());

        return String.join("", list);
    }

}
