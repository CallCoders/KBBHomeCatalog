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
		setTitle("������ �������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 360);
		Dimension sizeOfFields = new Dimension(100, 10);
		
		//Image img = new ImageIcon("d:\\JavaLearning\\KBB\\res\\icon.png").getImage();
		//setIconImage(img);
		
		//------------------------����� ������-----------------------------------------------------------------------------------------------------
				
				//������ �������������� ������ "������ ������"
				Box box1 = Box.createHorizontalBox();
				JLabel wProema = new JLabel("������, ��: ");
				wProema.setPreferredSize(sizeOfFields);
				widthDoorway_InField = new JTextField("2075", 10);
				box1.add(wProema);
				box1.add(Box.createHorizontalStrut(6));
				box1.add(widthDoorway_InField);
				
				//������ �������������� ������ "������ ������)
				Box box2 = Box.createHorizontalBox();
				JLabel hProema = new JLabel("������, ��: ");
				hProema.setPreferredSize(sizeOfFields);
				heigthDoorway_InField = new JTextField("2500", 10);
				box2.add(hProema);
				box2.add(Box.createHorizontalStrut(6));
				box2.add(heigthDoorway_InField);
				
				//����� ������ ��� ����� �������� ������
				Box razmeriProema = Box.createVerticalBox();
				razmeriProema.add(Box.createVerticalStrut(6));
				razmeriProema.setBorder(setMyBodrer("�����"));
				razmeriProema.add(box1);
				razmeriProema.add(Box.createVerticalStrut(6));
				razmeriProema.add(box2);	
				
				//������ �������������� ������ "���� �������"
				Box box3 = Box.createHorizontalBox();
				JLabel colorLabel = new JLabel("���� �������: ");
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
				
				//����� ���-�� �������
				Box box4 = Box.createHorizontalBox();
				JLabel leafAmountLabel = new JLabel("���-�� �������: ");
				leafAmountLabel.setPreferredSize(sizeOfFields);
				JComboBox leafAmountChoice = new JComboBox();
				leafAmountChoice.addItem("2");
				leafAmountChoice.addItem("1");
				box4.add(leafAmountLabel);
				box4.add(Box.createHorizontalStrut(6));
				box4.add(leafAmountChoice);
				
				//���������� ��� �-���
				Box pristenniy = Box.createHorizontalBox();
				JLabel dopProfileLabel = new JLabel("�������������: ");
				dopProfileLabel.setPreferredSize(sizeOfFields);
				JComboBox dopProfileChoice = new JComboBox();
				dopProfileChoice.addItem("��. 20�20");
				dopProfileChoice.addItem("��������");
				pristenniy.add(dopProfileLabel);
				pristenniy.add(Box.createHorizontalStrut(6));
				pristenniy.add(dopProfileChoice);
				
				//����� ������ ��� ������ ���������� �������
				Box leafParamsPanel = Box.createVerticalBox();
				leafParamsPanel.add(Box.createVerticalStrut(6));
				leafParamsPanel.setBorder(setMyBodrer("��������� �������"));
				leafParamsPanel.add(box3);
				leafParamsPanel.add(Box.createVerticalStrut(6));
				leafParamsPanel.add(box4);
				leafParamsPanel.add(Box.createVerticalStrut(6));
				leafParamsPanel.add(pristenniy);

				//������� ������ ������ �����
				box5 = Box.createHorizontalBox();
				JLabel zamokLabel = new JLabel("������������������� �����: ");
				lockNeed = new JCheckBox("");
				lockNeed.setSelected(false);
				box5.add(zamokLabel);
				box5.add(Box.createHorizontalGlue());
				box5.add(lockNeed);
				lockNeed.addActionListener(listener);
								
				//����� ������ ��� �������
				Box barahloPanel = Box.createVerticalBox();
				TitledBorder borderBarahloPanel = new TitledBorder("");
				borderBarahloPanel.setTitleJustification(2);
				barahloPanel.setBorder(setMyBodrer("���. �������������"));
				barahloPanel.add(box5);
					
				//������� ������ "���������"
				btnSolve = new JButton("���������");
				btnSolve.setFocusPainted(false);
				JPanel btnPanel = new JPanel();
				btnPanel.setAlignmentX(CENTER_ALIGNMENT);
				btnPanel.add(btnSolve);
				btnSolve.addActionListener(listener);
							
				//------------------------------------������ ������ -----------------------------------------------------------------------------------------
			
				
				//������ ������ - ������ �������
				widthLeafOut = Box.createHorizontalBox();
				JLabel wLeafLabel = new JLabel("������ �������, ��: ");
				widthLeafOutField = new JLabel();
				widthLeafOut.add(wLeafLabel);
				widthLeafOut.add(Box.createHorizontalGlue());
				widthLeafOut.add(widthLeafOutField);
				
				//������ ������ - ������ �������
				Box heightLeafOut = Box.createHorizontalBox();
				JLabel hLeafLabel = new JLabel("������ �������, ��: ");
				hieghtLeafOutField = new JLabel();
				heightLeafOut.add(hLeafLabel);
				heightLeafOut.add(Box.createHorizontalGlue());
				heightLeafOut.add(hieghtLeafOutField);
				
				//������ ������ - ���� �������
				Box boxLeafColor = Box.createHorizontalBox();
				JLabel coloLeafOut = new JLabel("���� �������: ");
				colorLeafRALOut = new JLabel();
				boxLeafColor.add(coloLeafOut);
				boxLeafColor.add(Box.createHorizontalGlue());
				boxLeafColor.add(colorLeafRALOut);
				
				//����� ������ ������ ����� - ������ ������������
				Box widthGPOut = Box.createHorizontalBox();
				JLabel wGlassPackLabel = new JLabel("������ ������������, ��:  ");
				widthGlassPack_OutField = new JLabel();
				widthGPOut.add(wGlassPackLabel);
				widthGPOut.add(Box.createHorizontalGlue());
				widthGPOut.add(widthGlassPack_OutField);
				
				//������ ������ ������ ����� - ������ ������������
				Box heightGPOut = Box.createHorizontalBox();
				JLabel hGlassPackLabel = new JLabel("������ ������������, ��:  ");
				heieghtGlassPack_OutField = new JLabel();
				heightGPOut.add(hGlassPackLabel);
				heightGPOut.add(Box.createHorizontalGlue());
				heightGPOut.add(heieghtGlassPack_OutField);
				
				//������� ������ - ������ ������
				Box lengthRailOut = Box.createHorizontalBox();
				JLabel sizeRailLabel = new JLabel("�����, ��: ");
				sizeRail = new JLabel();
				lengthRailOut.add(sizeRailLabel);
				lengthRailOut.add(Box.createHorizontalGlue());
				lengthRailOut.add(sizeRail);
				
				//������� ������ - ������
				Box lengthCoverOut = Box.createHorizontalBox();
				JLabel sizeCoverLabel = new JLabel("������, ��: ");
				sizeCover = new JLabel();
				lengthCoverOut.add(sizeCoverLabel);
				lengthCoverOut.add(Box.createHorizontalGlue());
				lengthCoverOut.add(sizeCover);

				
				//������ ������ - ���� ������
				Box boxCoverColor = Box.createHorizontalBox();
				JLabel coloCoverOut = new JLabel("���� ������: ");
				colorCoverRALOut = new JLabel();
				
				boxCoverColor.add(coloCoverOut);
				boxCoverColor.add(Box.createHorizontalGlue());
				boxCoverColor.add(colorCoverRALOut);
				
				Box resultsPanel = Box.createVerticalBox();
				resultsPanel.setBorder(setMyBodrer("� ������������"));
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
				
				//-----------------------------------����������� ��� ��������� � ��� ������ (����� � ������) ------------------------------------------------
				
				//������� ������� ������ ��� ����� �����
				Box leftBox = Box.createVerticalBox();
				leftBox.add(razmeriProema);
				leftBox.add(Box.createVerticalStrut(17));
				leftBox.add(leafParamsPanel);
				leftBox.add(Box.createVerticalStrut(17));
				leftBox.add(barahloPanel);
				
				//������� ������� ������ ��� ������ �����
				Box rightBox = Box.createVerticalBox();
				rightBox.add(resultsPanel);
				
		//������� ������� ������ 
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(setMyBodrer(""));
		//�������� ����� � ������ ������ � �������
		JPanel mainBox = new JPanel();
		mainBox.setLayout(new GridLayout(0, 2));
		mainBox.add(leftBox);
		mainBox.add(rightBox);
		
		mainPanel.add(mainBox, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		//-------------------------------------------------------------����-----------------------------------------------------
		menuBar = new JMenuBar();
		
		// ����
		menuFile = new JMenu();
		menuFile.setText("����");
		
			// ������ ���� "����"
			mItemSave = new JMenuItem("��������� ���");
			mItemPrint = new JMenuItem("������");
				mItemPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, "���! ���� ��� �� ��������...");
					}
				});
				
				
			mItemClose = new JMenuItem("�������");
				//	��������� ���������� ��� ���� "��������"
				mItemClose.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int isExit = JOptionPane.showConfirmDialog(null, "��, ������� ������ ����������?", "������ �� ��������", JOptionPane.YES_NO_OPTION);
							if (isExit==0){
							System.exit(isExit);
							}
						}
					});
				
		menuFile.add(mItemSave);
		menuFile.add(mItemPrint);
		menuFile.addSeparator();
		menuFile.add(mItemClose);
		
		// ������
		menuHelp = new JMenu();
		menuHelp.setText("� ���������");
		
			// ������ ���� "������"
			mItemHowToUse = new JMenuItem("��� ������������");
			mItemAbout = new JMenuItem("� ���������");
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
		//������� ������ �� �����
		setContentPane(mainPanel);
		pack();
		setResizable(false);
		
		
	}
	//------------------------------------------- ����� ����---------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------------------------
	
	// ����� ������������� �������� ����� � ����� "���������"
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
		
	// ���������� ������ "���������"
	public void solve(){
		int widthProema = 0;
		int heigthProema = 0;
		
		//�������� ������� � ����� �����
		widthDoorway_InField.setText(widthDoorway_InField.getText().trim());
		heigthDoorway_InField.setText(heigthDoorway_InField.getText().trim());
		
		try{
			widthProema = Integer.parseInt(widthDoorway_InField.getText());
			heigthProema = Integer.parseInt(heigthDoorway_InField.getText());
			
			if (widthProema > 2100 || heigthProema > 2500) 
				{
				JOptionPane.showMessageDialog(null, "������� ������ �������������!");
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
							numberOfCovers = "2 ����� �� ";
						} 
							else
							{
								lengthOfCover = lengthOfRail-82;
								numberOfCovers = "������� ";
							}
					setResutOutFields(wL, hL, wGP, hGP, lengthOfRail, numberOfCovers, lengthOfCover);
					
					//������������� �������� ����� �������� � ������, ������ �� �� ����� �����
					String ralColor = (String) colorChoice.getSelectedItem();
					colorLeafRALOut.setText(ralColor); 
					colorCoverRALOut.setText(ralColor);
				}
		} catch (Exception ex){
			JOptionPane.showMessageDialog(null, "������������ ���� ������!");
		}
	}
	
	//����� � ��������
	private Border setMyBodrer(String title){
		Border line = BorderFactory.createLineBorder(Color.GRAY);
		Border emptyborder = BorderFactory.createEmptyBorder(0, 6, 6, 6);
		Border comboborder = BorderFactory.createCompoundBorder(line, emptyborder);
		Border border = BorderFactory.createTitledBorder(comboborder, title, TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY);
		return border;
	}
	
	//���������� �������
	public class LeafHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			solve();
			}
	
		}		
	
	public void about(){
		
		String aboutText = "���������: ������� �����.";
		JOptionPane.showConfirmDialog(null, "��");
	}
}
