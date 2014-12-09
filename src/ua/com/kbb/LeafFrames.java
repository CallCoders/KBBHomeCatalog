package ua.com.kbb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class LeafFrames extends JFrame{

	JMenuBar menuBar;
	JMenu menuFile, menuHelp;
	JMenuItem mItemSave, mItemPrint, mItemClose, mItemHowToUse, mItemAbout;
	
	JTextField widthDoorway_InField, heigthDoorway_InField;
	
	JLabel widthLeafOutField, hieghtLeafOutField, widthGlassPack_OutField, heieghtGlassPack_OutField, sizeRail, sizeCover;
	JLabel colorLeafRALOut, colorCoverRALOut;
	
	JButton btnSolve;
	JCheckBox lockNeed;
	
	JComboBox colorChoice;
	
	Box widthLeafOut, box5;
	LeafHandler listener = new LeafHandler();
		
	
	public LeafFrames() {
		setTitle("Расчет створок");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 360);
		Dimension sizeOfFields = new Dimension(100, 10);
		
		//Image img = new ImageIcon("d:\\JavaLearning\\KBB\\res\\icon.png").getImage();
		//setIconImage(img);
		
		//------------------------ЛЕВАЯ ПАНЕЛЬ-----------------------------------------------------------------------------------------------------
				
				//Первая горизонтальная панель "Ширина проема"
				Box box1 = Box.createHorizontalBox();
				JLabel wProema = new JLabel("Ширина, мм: ");
				wProema.setPreferredSize(sizeOfFields);
				widthDoorway_InField = new JTextField("2075", 10);
				box1.add(wProema);
				box1.add(Box.createHorizontalStrut(6));
				box1.add(widthDoorway_InField);
				
				//Вторая горизонтальная панель "Высота проема)
				Box box2 = Box.createHorizontalBox();
				JLabel hProema = new JLabel("Высота, мм: ");
				hProema.setPreferredSize(sizeOfFields);
				heigthDoorway_InField = new JTextField("2500", 10);
				box2.add(hProema);
				box2.add(Box.createHorizontalStrut(6));
				box2.add(heigthDoorway_InField);
				
				//Общая панель для ввода размеров проема
				Box razmeriProema = Box.createVerticalBox();
				razmeriProema.add(Box.createVerticalStrut(6));
				razmeriProema.setBorder(setMyBodrer("Проем"));
				razmeriProema.add(box1);
				razmeriProema.add(Box.createVerticalStrut(6));
				razmeriProema.add(box2);	
				
				//Третья горизонтальная панель "Цвет створок"
				Box box3 = Box.createHorizontalBox();
				JLabel colorLabel = new JLabel("Цвет створок: ");
				colorLabel.setPreferredSize(sizeOfFields);
				colorChoice = new JComboBox();
				colorChoice.setEditable(true);
				colorChoice.addItem("");
				colorChoice.addItem("RAL9006");
				colorChoice.addItem("RAL9016");
				
				colorLabel.setPreferredSize(sizeOfFields);
				box3.add(colorLabel);
				box3.add(Box.createHorizontalStrut(6));
				box3.add(colorChoice);
				
				//Выбор кол-ва створок
				Box box4 = Box.createHorizontalBox();
				JLabel leafAmountLabel = new JLabel("Кол-во створок: ");
				leafAmountLabel.setPreferredSize(sizeOfFields);
				JComboBox leafAmountChoice = new JComboBox();
				leafAmountChoice.addItem("2");
				leafAmountChoice.addItem("1");
				box4.add(leafAmountLabel);
				box4.add(Box.createHorizontalStrut(6));
				box4.add(leafAmountChoice);
				
				//Пристенный или П-шка
				Box pristenniy = Box.createHorizontalBox();
				JLabel dopProfileLabel = new JLabel("Дополнительно: ");
				dopProfileLabel.setPreferredSize(sizeOfFields);
				JComboBox dopProfileChoice = new JComboBox();
				dopProfileChoice.addItem("Шв. 20х20");
				dopProfileChoice.addItem("Заглушка");
				pristenniy.add(dopProfileLabel);
				pristenniy.add(Box.createHorizontalStrut(6));
				pristenniy.add(dopProfileChoice);
				
				//Общая панель для выбора параметров створок
				Box leafParamsPanel = Box.createVerticalBox();
				leafParamsPanel.add(Box.createVerticalStrut(6));
				leafParamsPanel.setBorder(setMyBodrer("Параметры створок"));
				leafParamsPanel.add(box3);
				leafParamsPanel.add(Box.createVerticalStrut(6));
				leafParamsPanel.add(box4);
				leafParamsPanel.add(Box.createVerticalStrut(6));
				leafParamsPanel.add(pristenniy);

				//Создаем панель выбора замка
				box5 = Box.createHorizontalBox();
				JLabel zamokLabel = new JLabel("Электромеханический замок: ");
				lockNeed = new JCheckBox("");
				lockNeed.setSelected(false);
				box5.add(zamokLabel);
				box5.add(Box.createHorizontalGlue());
				box5.add(lockNeed);
				lockNeed.addActionListener(listener);
								
				//Общая панель для барахла
				Box barahloPanel = Box.createVerticalBox();
				TitledBorder borderBarahloPanel = new TitledBorder("");
				borderBarahloPanel.setTitleJustification(2);
				barahloPanel.setBorder(setMyBodrer("Доп. комплектующие"));
				barahloPanel.add(box5);
					
				//Создаем кнопку "Расчитать"
				btnSolve = new JButton("Расчитать");
				btnSolve.setFocusPainted(false);
				JPanel btnPanel = new JPanel();
				btnPanel.setAlignmentX(CENTER_ALIGNMENT);
				btnPanel.add(btnSolve);
				btnSolve.addActionListener(listener);
							
				//------------------------------------ПРАВАЯ ПАНЕЛЬ -----------------------------------------------------------------------------------------
			
				
				//Правая панель - Ширина створки
				widthLeafOut = Box.createHorizontalBox();
				JLabel wLeafLabel = new JLabel("Ширина створки, мм: ");
				widthLeafOutField = new JLabel();
				widthLeafOut.add(wLeafLabel);
				widthLeafOut.add(Box.createHorizontalGlue());
				widthLeafOut.add(widthLeafOutField);
				
				//Правая панель - Высота створки
				Box heightLeafOut = Box.createHorizontalBox();
				JLabel hLeafLabel = new JLabel("Высота створки, мм: ");
				hieghtLeafOutField = new JLabel();
				heightLeafOut.add(hLeafLabel);
				heightLeafOut.add(Box.createHorizontalGlue());
				heightLeafOut.add(hieghtLeafOutField);
				
				//Правая панель - Цвет створок
				Box boxLeafColor = Box.createHorizontalBox();
				JLabel coloLeafOut = new JLabel("Цвет створок: ");
				colorLeafRALOut = new JLabel();
				boxLeafColor.add(coloLeafOut);
				boxLeafColor.add(Box.createHorizontalGlue());
				boxLeafColor.add(colorLeafRALOut);
				
				//Пятая панель правой части - Ширина стеклопакета
				Box widthGPOut = Box.createHorizontalBox();
				JLabel wGlassPackLabel = new JLabel("Ширина стеклопакета, мм:  ");
				widthGlassPack_OutField = new JLabel();
				widthGPOut.add(wGlassPackLabel);
				widthGPOut.add(Box.createHorizontalGlue());
				widthGPOut.add(widthGlassPack_OutField);
				
				//Шестая панель правой части - Высота стеклопакета
				Box heightGPOut = Box.createHorizontalBox();
				JLabel hGlassPackLabel = new JLabel("Высота стеклопакета, мм:  ");
				heieghtGlassPack_OutField = new JLabel();
				heightGPOut.add(hGlassPackLabel);
				heightGPOut.add(Box.createHorizontalGlue());
				heightGPOut.add(heieghtGlassPack_OutField);
				
				//Восьмая панель - Размер рельса
				Box lengthRailOut = Box.createHorizontalBox();
				JLabel sizeRailLabel = new JLabel("Рельс, мм: ");
				sizeRail = new JLabel();
				lengthRailOut.add(sizeRailLabel);
				lengthRailOut.add(Box.createHorizontalGlue());
				lengthRailOut.add(sizeRail);
				
				//Деватая панель - Крышка
				Box lengthCoverOut = Box.createHorizontalBox();
				JLabel sizeCoverLabel = new JLabel("Крышка, мм: ");
				sizeCover = new JLabel();
				lengthCoverOut.add(sizeCoverLabel);
				lengthCoverOut.add(Box.createHorizontalGlue());
				lengthCoverOut.add(sizeCover);

				
				//Правая панель - Цвет крышки
				Box boxCoverColor = Box.createHorizontalBox();
				JLabel coloCoverOut = new JLabel("Цвет крышки: ");
				colorCoverRALOut = new JLabel();
				
				boxCoverColor.add(coloCoverOut);
				boxCoverColor.add(Box.createHorizontalGlue());
				boxCoverColor.add(colorCoverRALOut);
				
				Box resultsPanel = Box.createVerticalBox();
				resultsPanel.setBorder(setMyBodrer("В производство"));
				resultsPanel.add(Box.createVerticalGlue());
				resultsPanel.add(widthLeafOut);
				resultsPanel.add(Box.createVerticalStrut(6));
				resultsPanel.add(heightLeafOut);
				resultsPanel.add(Box.createVerticalStrut(6));
				resultsPanel.add(boxLeafColor);
				resultsPanel.add(Box.createVerticalGlue());
				resultsPanel.add(widthGPOut);
				resultsPanel.add(Box.createVerticalStrut(6));
				resultsPanel.add(heightGPOut);
				resultsPanel.add(Box.createVerticalGlue());
				resultsPanel.add(lengthRailOut);
				resultsPanel.add(Box.createVerticalStrut(6));
				resultsPanel.add(lengthCoverOut);
				resultsPanel.add(Box.createVerticalStrut(6));
				resultsPanel.add(boxCoverColor);
				resultsPanel.add(Box.createVerticalGlue());
				
				//-----------------------------------УПАКОВЫВАЕМ ВСЕ КОПОНЕНТЫ В ДВЕ ПАНЕЛИ (ЛЕВУЮ И ПРАВУЮ) ------------------------------------------------
				
				//Создаем главную панель для левой части
				Box leftBox = Box.createVerticalBox();
				leftBox.add(razmeriProema);
				leftBox.add(Box.createVerticalStrut(17));
				leftBox.add(leafParamsPanel);
				leftBox.add(Box.createVerticalStrut(17));
				leftBox.add(barahloPanel);
				
				//Создаем главную панель для правой части
				Box rightBox = Box.createVerticalBox();
				rightBox.add(resultsPanel);
				
		//Создаем главную панель 
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(setMyBodrer(""));
		//Помещаем левую и правую панели в главную
		JPanel mainBox = new JPanel();
		mainBox.setLayout(new GridLayout(0, 2));
		mainBox.add(leftBox);
		mainBox.add(rightBox);
		
		mainPanel.add(mainBox, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		//-------------------------------------------------------------Меню-----------------------------------------------------
		menuBar = new JMenuBar();
		
		// Файл
		menuFile = new JMenu();
		menuFile.setText("Файл");
		
			// Пункты меню "Файл"
			mItemSave = new JMenuItem("Сохранить как");
			mItemPrint = new JMenuItem("Печать");
				mItemPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, "Упс! Пока что не работает...");
					}
				});
				
				
			mItemClose = new JMenuItem("Закрыть");
				//	Добавляем обработчик для меню "Закарыть"
				mItemClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int isExit = JOptionPane.showConfirmDialog(null, "Че, внатуре закыть приложение?", "Ответь на галимого", JOptionPane.YES_NO_OPTION);
							if (isExit==0){
							System.exit(isExit);
							}
						}
					});
				
		menuFile.add(mItemSave);
		menuFile.add(mItemPrint);
		menuFile.addSeparator();
		menuFile.add(mItemClose);
		
		// Помощь
		menuHelp = new JMenu();
		menuHelp.setText("О программе");
		
			// Пункты меню "Помощь"
			mItemHowToUse = new JMenuItem("Как пользоваться");
			mItemAbout = new JMenuItem("О программе");
				mItemAbout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					about();						
					}
				});
		
		menuHelp.add(mItemHowToUse);
		menuHelp.add(mItemAbout);
		
		menuBar.add(menuFile);
		menuBar.add(menuHelp);
		
		setJMenuBar(menuBar);
		//Выводим панель во фрейм
		setContentPane(mainPanel);
		pack();
		setResizable(false);
		
		
	}
	//------------------------------------------- Конец Меню---------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------------------------
	
	// Метод устанавливает значение полей в блоке "результат"
	private void setResutOutFields (int widthOfLeaf, int heightOfLeaf, int widthOfGlassPack, int heightOfGlassPack, int lengthOfRail, String numberOfCovers, int lengthOfCover){
		
		if (widthOfLeaf != 0) {widthLeafOutField.setText("" + widthOfLeaf);}
		else{widthLeafOutField.setText("");}
		hieghtLeafOutField.setText("" + heightOfLeaf);
		widthGlassPack_OutField.setText(""+ widthOfGlassPack);
		heieghtGlassPack_OutField.setText("" + heightOfGlassPack);
		sizeRail.setText(""+ lengthOfRail);
		sizeCover.setText(numberOfCovers + lengthOfCover);
		colorLeafRALOut.setText(colorChoice.getToolTipText());
	}
		
	// Обработчик кнопки "Расчитать"
	public void solve(){
		int widthProema = 0;
		int heigthProema = 0;
		
		//Отсекаем пробелы в полях ввода
		widthDoorway_InField.setText(widthDoorway_InField.getText().trim());
		heigthDoorway_InField.setText(heigthDoorway_InField.getText().trim());
		
		try{
			widthProema = Integer.parseInt(widthDoorway_InField.getText());
			heigthProema = Integer.parseInt(heigthDoorway_InField.getText());
			
			if (widthProema > 2100 || heigthProema > 2500) 
				{
				JOptionPane.showMessageDialog(null, "Размеры проема нестандартные!");
				setResutOutFields(0, 0, 0, 0, 0, "", 0);
				}
			else{
					int wL = widthProema/2+16;
					int hL = heigthProema-3;
					int wGP = widthProema/2-25;
					int hGP = heigthProema-129;
					int lengthOfRail = widthProema*2+150;
										
					int lengthOfCover;
					String numberOfCovers;
					if(lockNeed.isSelected())
						{
							lengthOfCover = lengthOfRail/2-75-41;
							numberOfCovers = "2 части по ";
						} 
							else
							{
								lengthOfCover = lengthOfRail-82;
								numberOfCovers = "цельная ";
							}
					setResutOutFields(wL, hL, wGP, hGP, lengthOfRail, numberOfCovers, lengthOfCover);
					
					//устанавливаем значения цвета профилей и крышки, считав их из левой части
					String ralColor = (String) colorChoice.getSelectedItem();
					colorLeafRALOut.setText(ralColor); 
					colorCoverRALOut.setText(ralColor);
				}
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Некорректный ввод данных!");
		}
	}
	
	//Рамка с надписью
	private Border setMyBodrer(String title){
		Border line = BorderFactory.createLineBorder(Color.GRAY);
		Border emptyborder = BorderFactory.createEmptyBorder(0, 6, 6, 6);
		Border comboborder = BorderFactory.createCompoundBorder(line, emptyborder);
		Border border = BorderFactory.createTitledBorder(comboborder, title, TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY);
		return border;
	}
	
	//Обработчик событий
	public class LeafHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			solve();
			}
	
		}		
	
	public void about(){
		
		String aboutText = "Создатель: Осипнко Павел.";
		JOptionPane.showConfirmDialog(null, "Да");
	}
}
