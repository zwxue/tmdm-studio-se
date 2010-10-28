package org.talend.mdm.studio.test.view;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.StudioTest;

public class ViewTest extends StudioTest{
	@BeforeClass
	public static void beforeClass() throws Exception {
		initServerView();
	}
	@Test
	public void canCreateView() throws Exception {
		
		SWTBotTreeItem viewNode=serverTree.expandNode("http://localhost:8080/talend/TalendPort [HEAD] admin").getNode("View [HEAD]");
		viewNode.contextMenu("New").click();
		//bot.sleep(1000);
		bot.shell("New View").activate();		
		bot.buttonWithLabel("...").click();	
		bot.shell("Select one Entity").activate();
	}
}
