package stepDefinitions;

import utils.BaseDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void before(){

    }
    @After
    public void after(){
        BaseDriver.DriverQuit();
    }
}
