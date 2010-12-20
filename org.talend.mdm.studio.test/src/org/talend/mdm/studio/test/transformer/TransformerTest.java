package org.talend.mdm.studio.test.transformer;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

@RunWith(SWTBotJunit4ClassRunner.class)
public class TransformerTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem jobItem;

    @Before
    public void runBeforeEveryTest() {
        jobItem = serverItem.getNode("Job Repository");
        jobItem.expand();
    }

    @After
    public void runAfterEveryTest() {

    }

    @Test
    public void canCreateJobTransformer() throws Exception {

        jobItem.expandNode("Deployed Jobs");
        final SWTBotTreeItem[] items = jobItem.getNode("Deployed Jobs").getItems();
        if (items.length > 0) {
            bot.getDisplay().syncExec(new Runnable() {

                public void run() {
                    System.out.println(items[0].getText());
                    SWTBotMenu menu = items[0].contextMenu("Generate Talend Job Caller Process");

                    if (!menu.widget.isDisposed()) {
                        menu.click();
                        final SWTBotShell shell = bot.shell("Which schema do you want?");
                        shell.activate();
                        bot.button("OK").click();
                    }
                }
            });
        }

    }

}
