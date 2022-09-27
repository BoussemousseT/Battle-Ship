package affichage.des.menu;

import java.awt.*;
import java.awt.event.*;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MenuPrincipale extends LesMenu {

	static JFrame menuAcceuilFrame = new JFrame("Menu Principale");
	static JPanel menuMenuJPanel = new JPanel();
	static JPanel menuHelpJPanel = new JPanel();
	static JPanel menuOptionJPanel = new JPanel();
	static JFrame menuGagnerPerdu = new JFrame();

	int valeurX = 0;
	int valuerY = 0;
	
	public static JPanel affichageSiPerduGagner(String txt) {
		JPanel AffichageTxt = new JPanel();
		AffichageTxt.setOpaque(false);
		AffichageTxt.setLayout(new GridBagLayout());
		AffichageTxt.add(new JLabel(txt));
		return AffichageTxt;
	}

	public static void menuAcceuil() {
		menuAcceuilFrame.setSize(1000, 600);
		menuAcceuilFrame.setLocationRelativeTo(null);
		menuAcceuilFrame.setResizable(false);
		menuAcceuilFrame.setLayout(new GridLayout(2, 1));

		MyButtonListnerAcceuil myListener = new MyButtonListnerAcceuil();

		/////////////////////// Menu Gagner / Perdu
		menuGagnerPerdu.setSize(450, 250);
		menuGagnerPerdu.setLocationRelativeTo(null);
		menuGagnerPerdu.setResizable(false);
		menuGagnerPerdu.setLayout(new  GridLayout(3,1));

		JButton Accueil = new JButton("Accueil");
		Accueil.setName("returnToAccueil");
		Accueil.addActionListener(myListener);
		menuGagnerPerdu.add(Accueil).setBackground(Color.lightGray);

		//Accueil.setPreferredSize(new Dimension(100, 40));
		Accueil.setLayout(new GridBagLayout());

		JButton Replay = new JButton("Replay");
		Replay.setName("replay");
		Replay.addActionListener(myListener);
		menuGagnerPerdu.add(Replay).setBackground(Color.lightGray);

	//	Replay.setPreferredSize(new Dimension(100, 40));
		Replay.setLayout(new GridBagLayout());

		
		menuGagnerPerdu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		////////////////////////////////

		String jouerString = "Jouer.png";
		ImageIcon jouerIcon = new ImageIcon(jouerString);

		String helpString = "Help.png";
		ImageIcon helpIcon = new ImageIcon(helpString);

		String optionString = "Option.png";
		ImageIcon optionIcon = new ImageIcon(optionString);

		String quitterString = "Quitter.png";
		ImageIcon quitterIcon = new ImageIcon(quitterString);

		JPanel backgroundJPanel = new JPanel();
		backgroundJPanel.setBackground(novColor(0, 0, 0));

		JLabel titreJLabel = new JLabel("BATTLE SHIP", SwingConstants.CENTER);
		titreJLabel.setFont(new Font("Impact", Font.BOLD, 72));

		JLabel auteurJLabel = new JLabel(" Antoine Ouellet & Taoufik Boussemousse ", SwingConstants.CENTER);
		auteurJLabel.setFont(new Font("Cambria", Font.BOLD, 16));

		backgroundJPanel.setForeground(novColor(255, 255, 255));
		backgroundJPanel.setLayout(new GridLayout(2, 1));
		backgroundJPanel.add(titreJLabel);
		backgroundJPanel.add(auteurJLabel);

		JButton jouerButton = new JButton(jouerIcon);
		jouerButton.setName("JOUER");
		jouerButton.addActionListener(myListener);
		jouerButton.setBorder(new LineBorder(Color.WHITE));
		menuMenuJPanel.add(jouerButton).setBackground(Color.BLACK);

		JButton paraButton = new JButton(optionIcon);
		paraButton.setName("OPTION");
		paraButton.addActionListener(myListener);
		paraButton.setBorder(new LineBorder(Color.WHITE));
		menuMenuJPanel.add(paraButton).setBackground(Color.BLACK);

		JButton commentJouerButton = new JButton(helpIcon);
		commentJouerButton.setName("COMMENT JOUER");
		commentJouerButton.addActionListener(myListener);
		commentJouerButton.setBorder(new LineBorder(Color.WHITE));
		menuMenuJPanel.add(commentJouerButton).setBackground(Color.BLACK);

		JButton quitterButton = new JButton(quitterIcon);
		quitterButton.setName("QUITTER");
		quitterButton.addActionListener(myListener);
		quitterButton.setBorder(new LineBorder(Color.WHITE));
		menuMenuJPanel.add(quitterButton).setBackground(Color.BLACK);
		menuMenuJPanel.setLayout(new GridLayout(2, 2));

		JButton smallButton = new JButton("SMALL");
		smallButton.setName("SMALL");
		smallButton.addActionListener(myListener);
		JButton medButton = new JButton("MEDIUM Default");
		medButton.setName("MED");
		medButton.addActionListener(myListener);
		JButton largeButton = new JButton("LARGE");
		largeButton.setName("LARGE");
		largeButton.addActionListener(myListener);

		menuOptionJPanel.setBackground(Color.BLACK);
		menuOptionJPanel.setLayout(new FlowLayout());
		menuOptionJPanel.add(smallButton);
		menuOptionJPanel.add(medButton);
		menuOptionJPanel.add(largeButton);

		String infoDuJeux = " Bonjour et Bienvenue Au Battle Ship \n le but du jeux est tres simple Coulee les bateaux enemie pour dominer le monde \n"
				+ " 1. Choisir une case pour tirer a cette emplacement \n"
				+ " 2. le but est de coule tout les bateaux enemie \n"
				+ " 3. si tout vos bateux ont ete Toucher et couler vous avez perdu \n";

		JTextArea textAide = new JTextArea(infoDuJeux);
		textAide.setForeground(Color.WHITE);
		textAide.setBorder(new LineBorder(Color.WHITE));
		menuHelpJPanel.add(textAide).setBackground(Color.BLACK);

		JButton retourButton = new JButton("Retour");
		retourButton.setName("RETOUR");
		retourButton.addActionListener(myListener);

		menuHelpJPanel.add(retourButton).setBackground(Color.BLACK);
		menuHelpJPanel.setLayout(new GridLayout(2, 1));
		menuHelpJPanel.setBackground(Color.BLACK);

		menuAcceuilFrame.add(backgroundJPanel);
		menuAcceuilFrame.add(menuMenuJPanel);
		menuAcceuilFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuAcceuilFrame.setVisible(true);
	}

	public static void AfficherRetirer(boolean yN) {
		menuAcceuilFrame.setVisible(yN);
	}
}

class MyButtonListnerAcceuil extends MenuPrincipale implements ActionListener {

	static int cpt = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		String name = button.getName();

		if (button.getName() == "JOUER") {

			if (cpt == 0) {
				fenetre(valeurX, valuerY);
			}
			cpt++;
			LesMenu.AfficherRetirer(true);
			menuAcceuilFrame.setVisible(false);
		}

		if (button.getName() == "OPTION") {
			menuAcceuilFrame.remove(menuMenuJPanel);
			menuAcceuilFrame.setVisible(false);
			menuAcceuilFrame.add(menuOptionJPanel);
			menuAcceuilFrame.setVisible(true);
		}

		if (button.getName() == "COMMENT JOUER") {
			menuAcceuilFrame.remove(menuMenuJPanel);
			menuAcceuilFrame.setVisible(false);
			menuAcceuilFrame.add(menuHelpJPanel);
			menuAcceuilFrame.setVisible(true);
		}

		if (button.getName() == "QUITTER") {
			menuAcceuilFrame.dispose();
		}

		if (button.getName() == "SMALL") {
			valeurX = 1;
			valuerY = 1;
			menuAcceuilFrame.remove(menuOptionJPanel);
			menuAcceuilFrame.setVisible(false);
			menuAcceuilFrame.add(menuMenuJPanel);
			menuAcceuilFrame.setVisible(true);
		}
		if (button.getName() == "MED") {
			valeurX = 0;
			valuerY = 0;
			menuAcceuilFrame.remove(menuOptionJPanel);
			menuAcceuilFrame.setVisible(false);
			menuAcceuilFrame.add(menuMenuJPanel);
			menuAcceuilFrame.setVisible(true);
		}
		if (button.getName() == "LARGE") {
			valeurX = 1600;
			valuerY = 900;
			menuAcceuilFrame.remove(menuOptionJPanel);
			menuAcceuilFrame.setVisible(false);
			menuAcceuilFrame.add(menuMenuJPanel);
			menuAcceuilFrame.setVisible(true);
		}
		if (button.getName() == "RETOUR") {
			menuAcceuilFrame.remove(menuHelpJPanel);
			menuAcceuilFrame.setVisible(false);
			menuAcceuilFrame.add(menuMenuJPanel);
			menuAcceuilFrame.setVisible(true);
		}
		if (button.getName() == "returnToAccueil") {
			reset();
			menuFrame.setVisible(false);
			menuGagnerPerdu.setVisible(false);
			menuAcceuilFrame.setVisible(true);

		}
		if (button.getName() == "replay") {
			menuGagnerPerdu.setVisible(false);
			creationDeBateaux();
		}

	}
}
