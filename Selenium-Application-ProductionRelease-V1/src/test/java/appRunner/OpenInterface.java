package appRunner;

import org.junit.Test;

import userInterfaceCode.GuiCode;

public class OpenInterface 
{
	@Test
	public void runGui()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				GuiCode.createAndShowGui();
			}
		});
	}
}
