package org.talend.mdm.studio.test;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.finder.SWTEclipseBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.junit.AfterClass;
import org.junit.BeforeClass;

@SuppressWarnings("deprecation")
public class StudioTest {
	protected static SWTEclipseBot	bot;
	
	static {
		bot = new SWTEclipseBot();
		bot.view("Welcome").close();
		login();
	}
	
	private static void login() {
		bot.menu("Window").menu("Show View").menu("Other...").click();
		final SWTBotShell shellShowView=bot.shell("Show View");
		shellShowView.widget.getDisplay().syncExec(new Runnable() {
			

			public void run() {
				shellShowView.widget.setSize(new Point(300,800));
				
			}
		});
		shellShowView.activate();
		bot.tree().expandNode("Talend").select("MDM Server");
		bot.tree().select("MDM Server");
		bot.button("OK").click();
		bot.viewByTitle("MDM Server").show();
		bot.viewByTitle("MDM Server").toolbarButton("Add MDM Server Location").click();
		SWTBotShell shell=bot.shell("Talend MDM Studio Login");
		shell.activate();
		bot.textWithLabel("Username").setText("admin");
		bot.textWithLabel("Password").setText("talend");
		bot.button("OK").click();
		
//		bot.menu("File").menu("New").menu("Project...").click();
//		
//		SWTBotShell shell = bot.shell("New Project");
//		shell.activate();
//		bot.tree().select("Java Project");
//		bot.button("Next >").click();
//
//		bot.textWithLabel("Project name:").setText("MyFirstProject");
//
//		bot.button("Finish").click();
		// FIXME: assert that the project is actually created, for later

	}
	@BeforeClass
	public static void beforeClass() throws Exception {
		
	}

	

	@AfterClass
	public static void sleep() {
		bot.sleep(2000);
	}

}
