package org.talend.mdm.web.test.itemsbrowser;

import org.talend.mdm.web.test.Checkable;
import org.talend.mdm.web.test.WebTestBase;

public class SearchCriteriaTest extends WebTestBase{
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		login("jennifer", "jennifer");
		setLanguage();
		setConfiguration();
	}
	
	public void testDateType() throws InterruptedException {
		
		selenium.open("/talendmdm/secure/?language=en");
		selenium.click("//a[.//text()='Browse Records']/span");
		waitForCheck(new Checkable() {
			
			@Override
			public boolean doCheck() {
				return selenium.isElementPresent("//option[@value='Browse_items_Agent']");
			}
		});
		selenium.select("viewItemsSelect", "label=Agent");
		selenium.click("//option[@value='Browse_items_Agent']");
		selenium.click("item-search-btn");
		selenium.select("itemsSearchField1", "label=Start date");
		selenium.select("itemsSearchOperator1", "label=is after");
		assertTrue(selenium.isElementPresent("itemSearchCalendar1"));
		selenium.click("itemSearchCalendar1");
		selenium.type("itemsSearchValue1", "2008-08-08");
		selenium.click("item-search-btn");

	}
	
	@Override
	public void tearDown() throws Exception {
		logout();
		super.tearDown();
	}

}
