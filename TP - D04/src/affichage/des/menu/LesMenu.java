package affichage.des.menu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;

import javax.sound.sampled.*;
import javax.swing.*;

public class LesMenu {

	protected static JButton[][] buttonsMoi = new JButton[10][10]; // tableau du buttons moi
	protected static JButton[][] buttonsAdversaire = new JButton[10][10]; // tableau du buttons adversaire
	static JButton[] lesBoutonsNameAdversaire = new JButton[100];
	static JButton[] lesBoutonsNameMoi = new JButton[100];

	// methode pour creer un tableau de 100 buttons dans un panel (Moi)
	protected static JPanel buttonPanelMoi() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(10, 10));
		MyButtonListnerTwo listener = new MyButtonListnerTwo();

		Image background = Toolkit.getDefaultToolkit().createImage("Waves.jpg");
		Graphics graphic = null;
		// graphic.drawImage(background, 0, 0, null);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttonsMoi[i][j] = new JButton();
				lesBoutonsNameMoi[MyInteger.incrementMoiButton] = buttonsMoi[i][j];
				lesBoutonsNameMoi[MyInteger.incrementMoiButton].setName(String.valueOf(55));
				p.add(buttonsMoi[i][j]).setBackground(Color.LIGHT_GRAY);
				MyInteger.incrementMoiButton++;
			}
		}
		p.setPreferredSize(new Dimension(450, 450));
		return p;
	}

	// methode pour creer un tableau de 100 buttons dans un panel (adversaire)

	protected static JPanel buttonPanelAdversaire() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(10, 10));
		MyButtonListnerTwo listener = new MyButtonListnerTwo();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buttonsAdversaire[i][j] = new JButton();
				lesBoutonsNameAdversaire[MyInteger.incrementAdversaireButton] = buttonsAdversaire[i][j];
				lesBoutonsNameAdversaire[MyInteger.incrementAdversaireButton].setName(String.valueOf(55));
				p.add(buttonsAdversaire[i][j]).setBackground(Color.LIGHT_GRAY);
				buttonsAdversaire[i][j].addActionListener(listener);
				MyInteger.incrementAdversaireButton++;
			}
		}
		p.setPreferredSize(new Dimension(450, 450));
		return p;
	}

	// methode pour cree Label
	private static JPanel addLabel(String label) {
		JPanel p = new JPanel();
		p.add(new Label(label));
		return p;
	}

	// methode pour ajouter les bateaux aléatoirement (moi)
	public static void bateauxAleatoireMoi(int caseBateau, Color c, String typeBateau) {
		int i = (int) (Math.random() * 10);
		int j = (int) (Math.random() * 10);

		int verticalHorizontal = (int) (Math.random() * 2);

		for (int k = 0; k < caseBateau; k++) {

			if (verticalHorizontal == 0) {

				if (j == 7 || j == 8 || j == 9) {

					(buttonsMoi[i][j - k]).setBackground(c);

					if (typeBateau == "SousMarin") {

						buttonsMoi[i][j - k].setName(String.valueOf(1));
					} else {
						buttonsMoi[i][j - k].setName(String.valueOf(caseBateau));
					}
				} else {
					(buttonsMoi[i][j + k]).setBackground(c);
					if (typeBateau == "SousMarin") {
						buttonsMoi[i][j + k].setName(String.valueOf(1));
					} else {
						buttonsMoi[i][j + k].setName(String.valueOf(caseBateau));
					}
				}
			} else {
				if (i == 7 || i == 8 || i == 9) {
					(buttonsMoi[i - k][j]).setBackground(c);
					if (typeBateau == "SousMarin") {
						buttonsMoi[i - k][j].setName(String.valueOf(1));
					} else {
						buttonsMoi[i - k][j].setName(String.valueOf(caseBateau));
					}
				} else {
					(buttonsMoi[i + k][j]).setBackground(c);
					if (typeBateau == "SousMarin") {
						buttonsMoi[i + k][j].setName(String.valueOf(1));
					} else {
						buttonsMoi[i + k][j].setName(String.valueOf(caseBateau));
					}
				}
			}

		}

		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 10; b++) {
				if (Integer.valueOf(LesMenu.buttonsMoi[a][b].getName()) != 55) {
					MyInteger.repeatBateauMoi++;

				}

			}
		}
	}

	// methode pour ajouter les bateaux aléatoirement adversaire
	public static void bateauxAleatoireAdversaire(int caseBateau, Color c, String typeBateau) {
		int i = (int) (Math.random() * 10);
		int j = (int) (Math.random() * 10);

		int verticalHorizontal = (int) (Math.random() * 2);

		for (int k = 0; k < caseBateau; k++) {

			if (verticalHorizontal == 0) {

				if (j == 7 || j == 8 || j == 9) {

					(buttonsAdversaire[i][j - k]).setBackground(c);

					if (typeBateau == "SousMarin") {

						buttonsAdversaire[i][j - k].setName(String.valueOf(1));
					} else {
						buttonsAdversaire[i][j - k].setName(String.valueOf(caseBateau));
					}
				} else {
					(buttonsAdversaire[i][j + k]).setBackground(c);
					if (typeBateau == "SousMarin") {
						buttonsAdversaire[i][j + k].setName(String.valueOf(1));
					} else {
						buttonsAdversaire[i][j + k].setName(String.valueOf(caseBateau));
					}
				}
			} else {
				if (i == 7 || i == 8 || i == 9) {
					(buttonsAdversaire[i - k][j]).setBackground(c);
					if (typeBateau == "SousMarin") {
						buttonsAdversaire[i - k][j].setName(String.valueOf(1));
					} else {
						buttonsAdversaire[i - k][j].setName(String.valueOf(caseBateau));
					}
				} else {
					(buttonsAdversaire[i + k][j]).setBackground(c);
					if (typeBateau == "SousMarin") {
						buttonsAdversaire[i + k][j].setName(String.valueOf(1));
					} else {
						buttonsAdversaire[i + k][j].setName(String.valueOf(caseBateau));
					}
				}
			}

		}

		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 10; b++) {

				if (Integer.valueOf(LesMenu.buttonsAdversaire[a][b].getName()) != 55) {
					MyInteger.repeatBateauAdversaire++;
				}
			}
		}
	}

	// methode pour restart
	public static void reset() {
		MyInteger.incrementAdversaireButton = 0;
		MyInteger.incrementMoiButton = 0;
		MyInteger.sousMarinEnnemis = 0;
		MyInteger.destroyerEnnemis = 0;
		MyInteger.portAvionEnnemis = 0;
		MyInteger.bPatrouilleEnnemis = 0;
		MyInteger.sousMarinMoi = 0;
		MyInteger.destroyerMoi = 0;
		MyInteger.portAvionMoi = 0;
		MyInteger.bPatrouilleMoi = 0;
		MyInteger.repeatBateauMoi = 0;
		MyInteger.repeatBateauAdversaire = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				LesMenu.buttonsMoi[i][j].setBackground(Color.lightGray);
				LesMenu.buttonsMoi[i][j].setIcon(null);
				LesMenu.buttonsAdversaire[i][j].setBackground(Color.lightGray);
				LesMenu.buttonsAdversaire[i][j].setIcon(null);
				lesBoutonsNameAdversaire[MyInteger.incrementAdversaireButton].setName(String.valueOf(55));
				lesBoutonsNameMoi[MyInteger.incrementMoiButton].setName(String.valueOf(55));
				MyInteger.incrementAdversaireButton++;
				MyInteger.incrementMoiButton++;
			}
		}
	}

	public static void creationDeBateaux() {

		do {
			reset();
			LesMenu.bateauxAleatoireMoi(4, novColor(255, 67, 238), "PorteAvion");
			LesMenu.bateauxAleatoireMoi(3, novColor(76, 143, 255), "Destroyer");
			LesMenu.bateauxAleatoireMoi(3, novColor(164, 255, 64), "SousMarin");
			LesMenu.bateauxAleatoireMoi(2, novColor(255, 116, 61), "BateauPatrouille");

			LesMenu.bateauxAleatoireAdversaire(4, novColor(192, 192, 192), "PorteAvion");
			LesMenu.bateauxAleatoireAdversaire(3, novColor(192, 192, 192), "Destroyer");
			LesMenu.bateauxAleatoireAdversaire(3, novColor(192, 192, 192), "SousMarin");
			LesMenu.bateauxAleatoireAdversaire(2, novColor(192, 192, 192), "BateauPatrouille");
		} while (MyInteger.repeatBateauMoi != 33 || MyInteger.repeatBateauAdversaire != 33);

	}

	static JFrame menuFrame = new JFrame("BattleShip Game");
	static String textStringTest = "CONSOLE DE JEUX";
	static JTextArea textInformation = new JTextArea(textStringTest);

	public static void fenetre(int tailleX, int tailleY) {

		// Creating main Window
		menuFrame.setSize(1200, 700);
		menuFrame.setLocationRelativeTo(null);

		JPanel menuJPanel = new JPanel();
		menuJPanel.setBackground(Color.GRAY);

		MyButtonListner myListener = new MyButtonListner();

		// Adding game panel

		// Player A & Player B
		JPanel topMenu = new JPanel();
		topMenu.setOpaque(false);
		topMenu.setLayout(new GridLayout(1, 3));

		String playerString = "Player.png";
		ImageIcon playerIcon = new ImageIcon(playerString);

		JLabel PlayerA = new JLabel(playerIcon, SwingConstants.CENTER);
		PlayerA.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		PlayerA.setBackground(novColor(0, 0, 0));
		PlayerA.setOpaque(true);
		topMenu.add(PlayerA);

		String[] buttonNames = { "Reset", "Aleatoire", "Accueil", "Quitter" };
		String[] actionCommands = { "reset", "aleatoire", "accueil", "sortie" };

		JPanel lesButtonDemarrageJPanel = new JPanel();
		lesButtonDemarrageJPanel.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < buttonNames.length; i++) {
			JButton button = new JButton(buttonNames[i]);
			button.setBackground(Color.DARK_GRAY);
			button.setActionCommand(actionCommands[i]);
			button.addActionListener(myListener);
			lesButtonDemarrageJPanel.add(button).setForeground(Color.white);
		}
		topMenu.add(lesButtonDemarrageJPanel);

		String aIString = "AI.png";
		ImageIcon aIIcon = new ImageIcon(aIString);

		JLabel PlayerB = new JLabel(aIIcon, SwingConstants.CENTER);
		PlayerB.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		PlayerB.setBackground(novColor(0, 0, 0));
		PlayerB.setOpaque(true);
		topMenu.add(PlayerB);

		topMenu.setPreferredSize(new Dimension(1100, 100));

		// menuFrame.setLayout(new GridLayout(3, 1));
		menuJPanel.setLayout(new FlowLayout());

		// Game Buttons
		JPanel lesButtonJPanel = new JPanel();
		lesButtonJPanel.setOpaque(true);
		lesButtonJPanel.setBackground(Color.GRAY);
		lesButtonJPanel.setPreferredSize(new Dimension(1100, 50));
		;
		lesButtonJPanel.setLayout(new FlowLayout());
		lesButtonJPanel.add(addLabel("Porte avion")).setBackground(novColor(255, 67, 238));
		lesButtonJPanel.add(addLabel("Destroyer")).setBackground(novColor(76, 143, 255));
		lesButtonJPanel.add(addLabel("Sous-marin")).setBackground(novColor(164, 255, 64));
		lesButtonJPanel.add(addLabel("Bateau patrouille")).setBackground(novColor(255, 116, 61));

		menuJPanel.add(topMenu);
		menuJPanel.add(lesButtonJPanel);

		// Add Game Level
		JPanel etageDuJeuxJPanel = new JPanel();
		etageDuJeuxJPanel.setOpaque(false);
		etageDuJeuxJPanel.setLayout(new FlowLayout());

		etageDuJeuxJPanel.add(buttonPanelMoi());

		// Add Distance between Game Grids
		JPanel separationJPanel = new JPanel();
		separationJPanel.setOpaque(false);
		separationJPanel.setLayout(new GridLayout(5, 1));
		separationJPanel.add(new JLabel("           <<< Information >>>           "));
		separationJPanel.add(new JLabel(" ------------------------------------------- "));
		textInformation.setOpaque(false);
		textInformation.setEditable(false);
		textInformation.setPreferredSize(new Dimension(20, 60));
		textInformation.setFont(new Font("Cambria", Font.BOLD, 12));
		separationJPanel.add(textInformation);
		separationJPanel.add(new JLabel(" ------------------------------------------- "));
		separationJPanel.add(new JLabel("       <<< Bonne Chance >>>     "));

		etageDuJeuxJPanel.add(separationJPanel);

		etageDuJeuxJPanel.add(buttonPanelAdversaire());

		menuJPanel.add(etageDuJeuxJPanel);

		// Add bottom layer
		JPanel bottomLayerJPanel = new JPanel();
		bottomLayerJPanel.setPreferredSize(new Dimension(1100, 40));
		bottomLayerJPanel.setBackground(Color.DARK_GRAY);
		bottomLayerJPanel.add(new JLabel(" Antoine Ouellet /// Taoufik Boussemousse ")).setForeground(Color.white);

		menuJPanel.add(bottomLayerJPanel);

		// show window and force close of program

		menuFrame.add(menuJPanel);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setVisible(true);
	}

	public static Color novColor(int R, int G, int B) {
		Color p = new Color(R, G, B);
		return p;
	}

	public static void Music() {

		File file = new File("PC.mid");
		AudioInputStream sound = null;

		try {
			sound = AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException e2) {
			System.out.println(" Unsuported file ");
			e2.printStackTrace();
		} catch (IOException e2) {
			System.out.println(" IO Exception ");
			e2.printStackTrace();
		}

		Clip clip = null;

		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			System.out.println(" LineUnavailable  getCLip ");
			e1.printStackTrace();
		}

		try {
			clip.open(sound);
		} catch (LineUnavailableException e) {
			System.out.println(" LineUnavailable openCLip ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(" Erreur ");
			e.printStackTrace();
		}

	}

	public static void AfficherRetirer(boolean yN) {
		menuFrame.setVisible(yN);
	}
}

class MyButtonListner extends LesMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		String action = button.getActionCommand();

		switch (action) {
		case "reset":
			reset();

			break;
		case "aleatoire":
			creationDeBateaux();
			break;
		case "accueil":
			menuFrame.setVisible(false);
			affichage.des.menu.MenuPrincipale.AfficherRetirer(true);
			break;

		case "sortie":
			System.exit(0);
			break;
		}
	}
}

class MyButtonListnerTwo extends LesMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String name = button.getName();
		int val = Integer.valueOf(name);

		JButton randomAdversaire;
		do {
			randomAdversaire = lesBoutonsNameMoi[(int) (Math.random() * 100)];
		} while (Integer.valueOf(randomAdversaire.getName()) == -1 || Integer.valueOf(randomAdversaire.getName()) == 0);

		String waveString = "Waves.jpg";
		ImageIcon waveIcon = new ImageIcon(waveString);

		String boomString = "boom.jpg";
		ImageIcon boomIcon = new ImageIcon(boomString);
		String messageConsole;

		switch (val) {
		case 1:
			button.setIcon(boomIcon);
			messageConsole = "Sous-marin ennemis : \n toucher";
			MyInteger.sousMarinEnnemis++;
			if (MyInteger.sousMarinEnnemis == 3) {
				messageConsole = "NIIICEE !! Sous-marin ennemis : \n couler";
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.BLUE);
			button.setName("-1");

			break;
		case 2:
			button.setIcon(boomIcon);
			messageConsole = ("Bateau patrouille \n ennemis a ete : \n toucher");
			MyInteger.bPatrouilleEnnemis++;
			if (MyInteger.bPatrouilleEnnemis == 2) {
				messageConsole = ("NIIICEE !! Bateau patrouille \n ennemis a ete : \n couler");
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.BLUE);
			button.setName("-1");

			break;
		case 3:
			button.setIcon(boomIcon);
			messageConsole = ("Destroyer ennemis : \n toucher");
			MyInteger.destroyerEnnemis++;
			if (MyInteger.destroyerEnnemis == 3) {
				messageConsole = ("NIIICEE !! Destroyer ennemis : \n couler");
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.BLUE);
			button.setName("-1");

			break;
		case 4:
			button.setIcon(boomIcon);
			messageConsole = ("Porte avion ennemis : \n toucher");
			MyInteger.portAvionEnnemis++;
			if (MyInteger.portAvionEnnemis == 4) {
				messageConsole = ("NIIICEE !! Porte avion ennemis : \n couler");
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.BLUE);
			button.setName("-1");
			break;

		default:
			if (val == -1) {
				button.setIcon(boomIcon);
			} else {
				button.setIcon(waveIcon);
			}
		}

		switch (Integer.valueOf(randomAdversaire.getName())) {
		case 1:
			randomAdversaire.setIcon(boomIcon);
			messageConsole = ("Sous-marin : \n toucher");
			MyInteger.sousMarinMoi++;
			if (MyInteger.sousMarinMoi == 3) {
				messageConsole = ("ATTENTION !! Sous-marin : \n couler");
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.RED);
			randomAdversaire.setName("0");
			break;
		case 2:
			randomAdversaire.setIcon(boomIcon);
			messageConsole = ("Bateau patrouille : \n toucher");
			MyInteger.bPatrouilleMoi++;
			if (MyInteger.bPatrouilleMoi == 2) {
				messageConsole = ("ATTENTION !! Bateau patrouille : \n couler");
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.RED);
			randomAdversaire.setName("0");
			break;
		case 3:
			randomAdversaire.setIcon(boomIcon);
			messageConsole = ("Destroyer : \n toucher");
			MyInteger.destroyerMoi++;
			if (MyInteger.destroyerMoi == 3) {
				messageConsole = ("ATTENTION !! Destroyer : \n couler");
			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.RED);
			randomAdversaire.setName("0");
			break;
		case 4:
			randomAdversaire.setIcon(boomIcon);
			messageConsole = ("Porte avion : \n toucher");
			MyInteger.portAvionMoi++;
			if (MyInteger.portAvionMoi == 4) {
				messageConsole = ("ATTENTION !! Porte avion : \n couler");

			}
			textInformation.setText(messageConsole);
			textInformation.setForeground(Color.RED);
			randomAdversaire.setName("0");
			break;

		default:
			if (Integer.valueOf(randomAdversaire.getName()) == 0) {
				randomAdversaire.setIcon(boomIcon);
			} else {
				randomAdversaire.setIcon(waveIcon);
				randomAdversaire.setName("-1");
			}
		}
		if (MyInteger.bPatrouilleMoi == 2 && MyInteger.destroyerMoi == 3 && MyInteger.sousMarinMoi == 3
				&& MyInteger.portAvionMoi == 4) {
			// System.err.println("GAMEOVER !! Vous avez perdu !");
			MenuPrincipale.menuGagnerPerdu.add(MenuPrincipale.affichageSiPerduGagner("GAMEOVER !! Vous avez perdu !"))
					.setBackground(Color.black);
			MenuPrincipale.menuGagnerPerdu.setVisible(true);

		} else if (MyInteger.bPatrouilleEnnemis == 2 && MyInteger.destroyerEnnemis == 3
				&& MyInteger.sousMarinEnnemis == 3 && MyInteger.portAvionEnnemis == 4) {
			// System.out.println("BRAVO !! Vous avez gagner !");
			MenuPrincipale.menuGagnerPerdu.add(MenuPrincipale.affichageSiPerduGagner("BRAVO !! Vous avez gagner !"))
					.setBackground(Color.black);
			MenuPrincipale.menuGagnerPerdu.setVisible(true);
		}
	}
}

class MyInteger {
	public static int incrementAdversaireButton = 0;
	public static int incrementMoiButton = 0;
	public static int sousMarinEnnemis = 0;
	public static int destroyerEnnemis = 0;
	public static int portAvionEnnemis = 0;
	public static int bPatrouilleEnnemis = 0;
	public static int sousMarinMoi = 0;
	public static int destroyerMoi = 0;
	public static int portAvionMoi = 0;
	public static int bPatrouilleMoi = 0;
	public static int repeatBateauMoi = 0;
	public static int repeatBateauAdversaire = 0;

}
