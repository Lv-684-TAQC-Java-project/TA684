package com.ita.speakukrainian.api;

import com.ita.speakukrainian.utils.ValueProvider;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class BaseApiTestRunner {
    protected static ValueProvider valueProvider;


    @BeforeSuite
    public void beforeSuite() throws IOException {

        if (valueProvider == null) {
            valueProvider = new ValueProvider();
        }
    }
}
