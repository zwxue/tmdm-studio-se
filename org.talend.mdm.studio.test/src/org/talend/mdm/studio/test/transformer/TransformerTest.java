package org.talend.mdm.studio.test.transformer;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.talend.mdm.studio.test.StudioTest;

public class TransformerTest  extends StudioTest{
	@BeforeClass
	public static void beforeClass() throws Exception {
		initServerView();
	}
	@Test
	public void canCreateJobTransformer() throws Exception {
		
		SWTBotTreeItem node=serverTree.expandNode("http://localhost:8080/talend/TalendPort [HEAD] admin").getNode("Job Repository");
		if(!node.isExpanded())node.expand();
		node.expandNode("Deployed Jobs");
		final SWTBotTreeItem[] items=node.getNode("Deployed Jobs").getItems();
		if(items.length>0) {
			bot.getDisplay().syncExec(new Runnable() {
				
				public void run() {
					System.out.println(items[0].getText());		
					SWTBotMenu menu=items[0].contextMenu("Generate Talend Job Caller Process");
		
					if(!menu.widget.isDisposed()) {
						menu.click();
						final SWTBotShell shell=bot.shell("Which schema do you want?");
						shell.activate();
						bot.button("OK").click();
					}
				}
			});
		}
		
	}

}
