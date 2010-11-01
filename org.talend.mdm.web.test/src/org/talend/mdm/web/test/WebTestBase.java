package org.talend.mdm.web.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

public class WebTestBase extends SeleneseTestCase {
	
	protected Selenium selenium;

	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 1234, "*iexploreproxy","http://localhost:8080/");
		selenium.start();

	}
	
	protected void setLanguage() {
		selenium.open("/talendmdm/secure/?language=en");
	}
	
	protected void setConfiguration() throws InterruptedException {
		
		selenium.click("actions-xcollapsed");
		selenium.clickAt("datacluster-select", "");
		waitForCheck(new Checkable(){
			@Override
			public boolean doCheck() {
				return selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and @qtip='DStar Demo Container' and text()='DStar' ]");
			}
        });

		selenium.click("//div[contains(@class,'x-combo-list-item')  and @qtip='DStar Demo Container' and text()='DStar' ]");
		selenium.click("actions-xcollapsed");
		selenium.clickAt("datamodel-select", "");		
		waitForCheck(new Checkable(){
			@Override
			public boolean doCheck() {
				return selenium.isElementPresent("//div[contains(@class,'x-combo-list-item') and @qtip='D-Star Demo Model' and text()='DStar' ]");
			}
        });

		selenium.click("//div[contains(@class,'x-combo-list-item') and @qtip='D-Star Demo Model' and text()='DStar' ]");
		selenium.click("actions-xcollapsed");
		selenium.click("//button[text()='Save']");

		waitForCheck(new Checkable(){
			@Override
			public boolean doCheck() {
				return selenium.isElementPresent("//button[text()='OK']");
			}
        });

		selenium.click("//button[text()='OK']");
	}
	
	protected void logout() throws InterruptedException {
		logout(selenium);
	}

	protected void logout(final Selenium selenium) throws InterruptedException {
		waitForCheck(new Checkable(){
			@Override
			public boolean doCheck() {
				return selenium.isElementPresent("//button[contains(text(),'Logout')]");
			}
        });
        selenium.click("//button[contains(text(),'Logout')]");
        selenium.waitForPageToLoad("");
	}
	
	protected void login(String username, String password)
	throws InterruptedException{
		login(username,password,selenium);
	}

	protected void login(String username, String password, final Selenium selenium)
			throws InterruptedException {
		selenium.open("/talendmdm/secure/");
        assertEquals("", selenium.getTitle());
        selenium.type("j_username", username);
        selenium.type("j_password", password);
        selenium.click("login");
        waitForCheck(new Checkable(){
			@Override
			public boolean doCheck() {
				return "Talend MDM".equals(selenium.getTitle());
			}
        });
        assertEquals("Talend MDM", selenium.getTitle());
	}

	protected void waitForCheck(Checkable checkable) throws InterruptedException {
		waitForCheck(checkable,-1);
	}
	
	protected void waitForCheck(Checkable checkable,int limitSeconds) throws InterruptedException {
		
		//use default value
		if(limitSeconds==-1)limitSeconds=60;
		
		for (int second = 0;; second++) {
            if (second >= limitSeconds)
                fail("timeout");
            try {
                if (checkable.doCheck())
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }
	}

	public void tearDown() throws Exception {
		selenium.stop();
	}

}
