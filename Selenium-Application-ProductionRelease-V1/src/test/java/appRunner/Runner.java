package appRunner;

import userInterfaceCode.GuiCode;

public class Runner 
{
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run()
			{
				GuiCode.createAndShowGui();
			}
		});
	}
}
