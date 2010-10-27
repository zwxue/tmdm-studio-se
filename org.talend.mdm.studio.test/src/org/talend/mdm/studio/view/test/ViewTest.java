package org.talend.mdm.studio.view.test;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Test;
import org.talend.mdm.studio.test.StudioTest;

public class ViewTest extends StudioTest{
	@Test
	public void canCreateView() throws Exception {
		bot.sleep(2000);
		SWTBotView view=bot.viewByTitle("MDM Server");
		view.show();
		view.setFocus();
		//SWTBotTree tree=bot.treeWithLabel("http://localhost:8080/talend/TalendPort[HEAD] admin");
		
		bot.tree(0).select("View[HEAD]").contextMenu("New").click();
		bot.sleep(2000);
		bot.shell("New View").activate();
		bot.button("...").click();
		
	}
}
