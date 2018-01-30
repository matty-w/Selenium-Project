package userInterfaceCode;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;


import appRunner.RunTests;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import fileCreator.CreateExcelWorkbook;
import loggingCode.RunningLogger;
import loggingCode.RunningLoggerStringValues;

public class GuiCode 
{
	private static String logFileLocationSaved = "";
	public static String featureLocationSaved = "";
	
	public static String defaultFeaturePath = "";
	
	public static String defaultLogPath = "";
	
	
	public static void createAndShowGui()
	{
		try 
		{
			RunningLogger runningLogger = new RunningLogger();
			runningLogger.createRunLog();
			JPanel panel = new JPanel();
			
			runningLogger.writeToLog("Create Panel");
			runningLogger.writeToLog("Create Default Log Folder Location");
			
			
			String f = new File("").getAbsolutePath();
			
			String logLocation = f+"\\logFolder";
			String featureLocation = f+"\\features";
			defaultLogPath = logLocation;
			defaultFeaturePath = featureLocation;
			
			runningLogger.writeToLog("Default Log Folder Location Created");
			
			BufferedImage cmsLogo = ImageIO.read(new File(f+"//Misc//image//cmsLogo.png"));
			JLabel picLabel = new JLabel(new ImageIcon(cmsLogo));
			runningLogger.writeToLog("Image Added");
	
			JLabel logFileTitle = new JLabel("Log File Location:");
			logFileTitle.setBounds(11, 85, 100, 20);
			JTextField logFileTextField = new JTextField();
			logFileTextField.setBounds(10, 105, 340, 20);
			logFileTextField.setEditable(false);
			JButton browseButtonLogFile = new JButton("Browse");
			browseButtonLogFile.setBounds(350, 105, 80, 20);
			runningLogger.writeToLog("JButtons Created");
			
			
			JLabel featureFilesLocation = new JLabel("Feature File Location:");
			featureFilesLocation.setBounds(11, 150, 180, 20);
			JTextField featureTestsLocationField = new JTextField();
			featureTestsLocationField.setBounds(10, 170, 340, 20);
			featureTestsLocationField.setEditable(false);
			JButton featureBrowse = new JButton("Browse");
			featureBrowse.setBounds(350, 170, 80, 20);
			
			JLabel featuresTitle = new JLabel("Feature Tests:");
			featuresTitle.setBounds(440, 30, 100, 20);
			JTextArea testList = new JTextArea();
			testList.setEditable(false);
			JScrollPane scrollPane = new JScrollPane(testList);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setBounds(440, 50, 245, 150);
			

			
			
			panel.setLayout(null);
			JFrame frame = new JFrame("Selenium Testing - Production (v1.0)");
			JButton exitButton = new JButton("Exit");
			JButton configureButton = new JButton("Configure Tests");
			configureButton.setEnabled(false);
			JButton startButton = new JButton("Start");
			exitButton.setVisible(true);
			startButton.setEnabled(false);
			startButton.setVisible(true);
			configureButton.setVisible(true);
			exitButton.setBounds(10, 220, 80, 40);
			startButton.setBounds(605, 220, 80, 40);
			configureButton.setBounds(440, 220, 155, 40);

			picLabel.setBounds(-15, -10, 300, 100);
			panel.add(exitButton);
			panel.add(startButton);
			panel.add(configureButton);
			panel.add(picLabel);
			panel.add(logFileTextField);
			panel.add(browseButtonLogFile);
			panel.add(featureTestsLocationField);
			panel.add(featureBrowse);
			panel.add(logFileTitle);
			panel.add(featureFilesLocation);
			panel.add(featuresTitle);
			panel.add(scrollPane);
			
			logFileTextField.setText(getLogFileLocationSaved());
			featureTestsLocationField.setText(featureLocationSaved);
		
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setSize(700, 300);
			frame.add(panel);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
			
			List<JTextField> textFieldList = new ArrayList<JTextField>();
			textFieldList.add(logFileTextField);
			textFieldList.add(featureTestsLocationField);
			
			logFileTextField.setText(defaultLogPath);
			featureTestsLocationField.setText(defaultFeaturePath);
			
			boolean canEnable = false;
			for(JTextField tf : textFieldList)
			{
				if(tf.getText().isEmpty())
				{
					canEnable = false;
				}
			}
			for(String line : testList.getText().split("\\n"))
			{
				if(line.endsWith(".feature"))
					canEnable = true;
			}
			startButton.setEnabled(canEnable);
			
			runningLogger.writeToLog("Gui Created");
			
			
			populateFeatureField(featureTestsLocationField, testList);
			
			startButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					runningLogger.writeToLog("Test Run Started");
					ClassLoader classLoader = getClass().getClassLoader();
					ResourceLoader resourceLoader = new MultiLoader(classLoader);
					RuntimeOptionsFactory roFactory = new RuntimeOptionsFactory(RunTests.class);
					RuntimeOptions ro = roFactory.create();
					ro.getFeaturePaths().clear();
					runningLogger.writeToLog("Feature Location Set To: "+featureLocationSaved);
					ro.getFeaturePaths().add(featureLocationSaved);
					ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
					cucumber.runtime.Runtime runtime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader, ro);
					RunningLogger runningLogger = new RunningLogger();
					runningLogger.writeToLog("Run Feature Tests");
					
					CreateExcelWorkbook workbookCreator = new CreateExcelWorkbook();
					
					String workbookLocation  = getLogFileLocationSaved();
					runningLogger.writeToLog("Create Excel Workbook");
					workbookCreator.createExcelWorkbook(workbookLocation);
					runningLogger.writeToLog("Excel Workbook Created");
					
					try 
					{
						runtime.run();
						
						runningLogger.writeToLog("Rename Excel Workbook");
						workbookCreator.replaceFile(workbookLocation);
						runningLogger.writeToLog("Excel Workbook Renamed");
						runningLogger.writeToLog("Renaming Running Log File - Ending Test Run");
						runningLogger.replaceFile();
					} 
					catch (IOException e1)
					{
						runningLogger.writeToLog(e1.getMessage());
					}
				}
			});
			
			exitButton.addActionListener(new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					runningLogger.replaceFile();
					frame.dispose();
				}
			});
			
			configureButton.addActionListener(new ActionListener() 
			{
				
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					frame.dispose();
					configureTestsFrame();
				}
			});
			
			browseButtonLogFile.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					JFileChooser fileChooser = new JFileChooser(defaultLogPath);
					
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					fileChooser.setAcceptAllFileFilterUsed(false);
					
					int rVal = fileChooser.showOpenDialog(null);
					if(rVal == JFileChooser.APPROVE_OPTION)
					{
						logFileTextField.setText(fileChooser.getSelectedFile().toString());
						setLogFileLocationSaved(fileChooser.getSelectedFile().toString());
						defaultLogPath = fileChooser.getSelectedFile().toString();
						
						startButton.setEnabled(enableStart(logFileTextField, featureTestsLocationField, testList));
					}
				}
			});
			
			featureBrowse.addActionListener(new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					JFileChooser fileChooser = new JFileChooser(defaultFeaturePath);
					
					fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
					FileNameExtensionFilter filter = new FileNameExtensionFilter(".feature", "(*.feature)","feature");
					fileChooser.setFileFilter(filter);
					fileChooser.setAcceptAllFileFilterUsed(false);
					
					int rVal = fileChooser.showOpenDialog(null);
					if(rVal == JFileChooser.APPROVE_OPTION)
					{
						String selectedPath = fileChooser.getSelectedFile().toString();
						if(selectedPath.endsWith(".feature"))
							selectedPath = selectedPath.substring(0 ,selectedPath.lastIndexOf("\\"));
						featureTestsLocationField.setText(selectedPath);
						defaultFeaturePath = selectedPath;
						featureLocationSaved = selectedPath;
						
						populateFeatureField(featureTestsLocationField, testList);
						startButton.setEnabled(enableStart(logFileTextField, featureTestsLocationField, testList));
					}
				}
			});
			
			frame.addWindowListener(new WindowListener() 
			{
				
				@Override
				public void windowOpened(WindowEvent e) 
				{
					setLogFileLocationSaved(logFileTextField.getText());
					featureLocationSaved = featureTestsLocationField.getText();
					boolean canEnable = false;
					for(JTextField tf : textFieldList)
					{
						if(tf.getText().isEmpty())
						{
							canEnable = false;
						}
					}
					for(String line : testList.getText().split("\\n"))
					{
						if(line.endsWith(".feature"))
							canEnable = true;
					}
					startButton.setEnabled(canEnable);
				}
				
				@Override
				public void windowIconified(WindowEvent e) 
				{
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) 
				{
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) 
				{
				}
				
				@Override
				public void windowClosing(WindowEvent e) 
				{
				}
				
				@Override
				public void windowClosed(WindowEvent e) 
				{
				}
				
				@Override
				public void windowActivated(WindowEvent e) 
				{
				}
			});
		} 
		catch (IOException e1) 
		{
			try 
			{
				RunningLogger runningLogger = new RunningLogger();
				RunningLoggerStringValues loggerValues = new RunningLoggerStringValues();
				runningLogger.writeToLog(loggerValues.errorString+e1.getMessage());
				String f = new File("").getAbsolutePath();
				String line1 = "An Error Has Occurred";
				String line2 = "Please Check '"+f+"\\Misc\\GuiLogging' For Further Information.";
				JLabel heading = new JLabel(line1);
				JLabel description = new JLabel(line2);
				final JFrame parent = new JFrame();
				final JPanel panel = new JPanel();
				JButton button = new JButton("Ok");
				button.setBounds(267, 80, 100, 30);
				heading.setBounds(260, 20, 200, 20);
				description.setBounds(35, 40, 600, 20);
				panel.setLayout(null);
				panel.add(button);
				panel.add(heading);
				panel.add(description);
				parent.add(panel);
				parent.setSize(650, 150);
				parent.setLocationRelativeTo(null);
				parent.setVisible(true);
				parent.setResizable(false);
				
				button.addActionListener(new ActionListener() 
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
						parent.dispose();
					}
				});
				
				GuiLogging.createExceptionLog(e1);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	private static void populateFeatureField(JTextField featureTestsLocationField, JTextArea testList) 
	{
		if(featureTestsLocationField.getText().isEmpty())
		{
			testList.setText("");
			testList.setText("No Feature Test Location Selected.");
		}
		else
		{
			String filePath = featureTestsLocationField.getText().toString();
			File directory = new File(filePath);
			File[] fileList = directory.listFiles();
			List<File> featureList = new ArrayList<File>();
			
			for(File f : fileList)
			{
				if(f.isFile())
					if(f.getName().endsWith(".feature"))
						featureList.add(f);
			}
			
			if(featureList.isEmpty())
			{
				testList.setText("");
				testList.setText("There were no Feature Files located in:\n '"+filePath+"'");
			}
			else
			{
				testList.setText("");
				for(File feature : featureList)
				{
					testList.append(feature.getName()+"\n");
				}
			}
		}
	}
	
	public static void configureTestsFrame()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			@Override
			public void run() 
			{
				configurePage();
			}
		});
	}
	
	public static void configurePage()
	{
		JRadioButton allTests = new JRadioButton("   -   Run All Available Tests");
		JRadioButton groupTests = new JRadioButton("   -   Run Selected Test Groups");
		JRadioButton selectedTests = new JRadioButton("   -   Specify Specific Tests");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(allTests);
		bg.add(groupTests);
		bg.add(selectedTests);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JFrame frame = new JFrame("Selenium Testing (v0.1)");
		
		
		allTests.setBounds(10, 50, 250, 40);
		groupTests.setBounds(10, 100, 250, 40);
		selectedTests.setBounds(10, 250, 250, 40);
		
		
		panel.add(allTests);
		panel.add(groupTests);
		panel.add(selectedTests);
		
		
		
		
		
		JButton returnButton = new JButton("Return");
		JButton resetButton = new JButton("Reset To Default");
		JButton confirmButton = new JButton("Confirm");
		returnButton.setVisible(true);
		confirmButton.setVisible(true);
		resetButton.setVisible(true);
		returnButton.setBounds(10, 420, 80, 40);
		confirmButton.setBounds(505, 420, 80, 40);
		resetButton.setBounds(315, 420, 180, 40);
		panel.add(returnButton);
		panel.add(confirmButton);
		panel.add(resetButton);
	
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(600, 500);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		returnButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				EventQueue.invokeLater(new Runnable() 
				{
					@Override
					public void run() 
					{
						frame.dispose();
						createAndShowGui();
					}
				});
			}
		});
	}

	public static String getLogFileLocationSaved() 
	{
		return logFileLocationSaved;
	}

	public static void setLogFileLocationSaved(String logFileLocationSaved) 
	{
		GuiCode.logFileLocationSaved = logFileLocationSaved;
	}
	
	public static String getFeatureLocationVariable()
	{
		return featureLocationSaved;
	}
	
	public static boolean enableStart(JTextField log, JTextField feature, JTextArea testList)
	{
		boolean enableStartButton = false;
		
		if(!(log.getText().isEmpty()))
			if(!(feature.getText().isEmpty()))
			{
				for(String line : testList.getText().split("\\n"))
				{
					if(line.endsWith(".feature"))
						enableStartButton = true;
				}
			}
		
		return enableStartButton;
	}
}
