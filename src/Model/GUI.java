package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class GUI {

	/*
	 * main panel is the base for the three main panels menu: option to quit or
	 * start new game game: grid of locations; shows the board info: gives feed back
	 * about whose turn, clue, count
	 */
	private Driver _windowHolder;
	private JPanel _mainPanel;
	private JPanel _menuPanel;
	private JPanel _gamePanel;
	private JPanel _infoPanel;
	private JPanel _displayPanel;
	private Model _model;
	private Board _board;
	private JPanel _graphicPanel;
	private boolean isFirstTurnOfTheGame = true;

	public GUI(JPanel _mainPanel, Driver driver, Model _model) {

		this._mainPanel = _mainPanel;
		this._windowHolder = driver;
		this._model = _model;
		_board = _model.getCurrentBoard();

		updateSpyMaster();
		updateJFrameIfNotHeadless();
		effects();
		eggPic();
	}

	/** Called to update GUI when it is the SpyMasters Turn **/
	public void updateSpyMaster() {
		_mainPanel.removeAll();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.PAGE_AXIS));
		menuPanel();
		gamePanel(true);
		infoPanel(true);
		updateJFrameIfNotHeadless();
		eggPic();
	}

	
	/**
	 * Called to update GUI when it is not the SpyMasters Turn 
	 */
	public void updateTeam() {
		_mainPanel.removeAll();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.PAGE_AXIS));
		menuPanel();
		gamePanel(false);
		infoPanel(false);
		updateJFrameIfNotHeadless();
		eggPic();
	}

	/**
	 * Given Whether it is the SpyMasters turn or not: sets up board goes through
	 * each location and checks whether revealed or not then sets up properties
	 */
	private void gamePanel(boolean SpyMasterTurn) {
		_gamePanel = new JPanel();
		_gamePanel.setLayout(new GridLayout(6, 6));

		if (SpyMasterTurn == true) {
			for (Location tempLoc : _board.getLocations()) {

				if (tempLoc.isRevealed() == true) {
					JLabel revealed = new JLabel(tempLoc.getPerson().getPersonType());
					setLabelProperties(revealed, tempLoc.getPerson().getPersonType(), true);
					_gamePanel.add(revealed);

				} else {
					JLabel notrevealed = new JLabel("<html>"+tempLoc.getCodeName()+"<br>"+tempLoc.getPerson().getPersonType()+"</html>");
					setLabelProperties(notrevealed, tempLoc.getPerson().getPersonType(), false);
					_gamePanel.add(notrevealed);
				}

			}
		} else {
			for (Location tempLoc : _board.getLocations()) {

				if (tempLoc.isRevealed() == true) {
					JLabel revealed = new JLabel(tempLoc.getPerson().getPersonType());
					setLabelProperties(revealed, tempLoc.getPerson().getPersonType(), true);
					_gamePanel.add(revealed);

				} else {
					JButton notrevealed = new JButton(tempLoc.getCodeName());
					setButtonProperties(notrevealed);
					notrevealed.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							guessCheck(tempLoc);

						}
					});
					_gamePanel.add(notrevealed);
				}

			}
		}

		_mainPanel.add(_gamePanel);
		
	}

	/**
	 * Method to Create a drop down at the top of the gui the options are New Game
	 * and Exit which call corresponding methods is added to the main panel at the
	 * end of the method so must be called before game and info panel are added
	 */
	private void menuPanel() {
		_menuPanel = new JPanel();
		JLabel turn = new JLabel();
		JFrame popWindow = new JFrame("Game Type");
		JPanel bottonPanel = new JPanel();
		JButton twoPersonGame = new JButton("New 2-Team Game");
		JButton threePersonGame = new JButton("New 3-Team Game");
		twoPersonGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				_windowHolder.newGameTwo();
				popWindow.dispose();
			}
			
		});
		threePersonGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				_windowHolder.newGameThree();
				 popWindow.dispose();
			}
			
		});
		JLabel message = new JLabel("Please choose game type");
		message.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		JPanel messagePanel = new JPanel();
		
		messagePanel.add(message);
		bottonPanel.add(twoPersonGame);
		bottonPanel.add(threePersonGame);
		
		JPanel all =new JPanel(); 
		all.add(messagePanel,BorderLayout.NORTH);
		all.add(bottonPanel, BorderLayout.SOUTH);
		all.setLayout(new GridLayout(2, 1));
		popWindow.add(all);
		
		
		
		
		JComboBox<String> dropdown = new JComboBox<>();
		_menuPanel.setPreferredSize(new Dimension(50, 30));
		_menuPanel.setLayout(new BoxLayout(_menuPanel, BoxLayout.X_AXIS));
		
		dropdown.addItem("File");
		dropdown.addItem("New Game");
		dropdown.addItem("Exit");
		dropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dropdown.getSelectedIndex() == 1) {
					popWindow.setVisible(true);
					popWindow.pack();
					popWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					
				} else if (dropdown.getSelectedIndex() == 2) {
					_windowHolder.endGame();
				}
			}
		});

		setLabelPropertiesOther(turn);
		if (_board.isBlueTurn() == true) {
			turn.setText("Blue Turn");

		} else {
			turn.setText("Red Turn");
		}

		dropdown.setAlignmentX(Component.LEFT_ALIGNMENT);
		_menuPanel.add(dropdown);
		_menuPanel.add(turn);
		_mainPanel.add(_menuPanel);
		
	}

		
	

	/**
	 * method called to update infopanel given whether it is the spymasters turn or
	 * not
	 * 
	 */

	private void infoPanel(boolean SpyMasterTurn) {
		_infoPanel = new JPanel();
		_infoPanel.setPreferredSize(new Dimension(50, 30));
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.X_AXIS));

		if (SpyMasterTurn == true) {

			CountandClueSpyMaster();

		} else {
			CountandClueTeam();
		}

		_mainPanel.add(_infoPanel);
	}

	/**
	 * when a location is clicked, checks if guess is correct and updates
	 * accordingly also checks if in winning state
	 * 
	 * @param guess
	 */
	
	public void guessCheck(Location guess) {
		boolean correct = _board.guessCheck(guess.getCodeName());
		boolean winningState = _board.winningState();
		if (winningState == true)
		{
			winningUpdate(guess);
		}
		else
		{
		if (correct == true) {
			if(_board.getCount() < 0)
			{
				if (_board.isBlueTurn() == false) {
					_board.setBlueTurn(true);
					_board.setRedTurn(false);
					switchTurns(true);
					
				} else {
					_board.setBlueTurn(false);
					_board.setRedTurn(true);
					switchTurns(true);
					
				}
				
			}
			else
			{
			updateTeam();
			}
		} else {
			if (_board.isBlueTurn() == false) {
				_board.setBlueTurn(true);
				_board.setRedTurn(false);
				switchTurns(true);
				
			} else {
				_board.setBlueTurn(false);
				_board.setRedTurn(true);
				switchTurns(true);
				
			}
		}

	}
	}
	
	
	/**code called to give display w/ whose turn it will be next and updates when ok is clicked
	 * 
	 * @param switchToSpyMaster
	 */
	public void switchTurns(boolean switchToSpyMaster) {
		_mainPanel.removeAll();
		

		JPanel _switchPanel = new JPanel();
		_mainPanel.add(_switchPanel);
		_switchPanel.setLayout(new BoxLayout(_switchPanel, BoxLayout.Y_AXIS));
		
		JLabel _turnTxtPanel = new JLabel();
		
		if(switchToSpyMaster == true) {
			if(_board.isBlueTurn() == false) {
				_turnTxtPanel.setText("It will now be Red spymaster's turn");
			}
			else {
				_turnTxtPanel.setText("It will now be blue spymaster's turn");
			}	
		}
		else {
			if(_board.isBlueTurn()  == false)
			{
				_turnTxtPanel.setText("It will now be Red team's turn");
			}
			else {
				_turnTxtPanel.setText("It will now be blue team's turn");
			}	
		}
		//code to set text indicating correct team/spymaster turn
		setLabelPropertiesOther(_turnTxtPanel);
		_turnTxtPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton _close = new JButton("OK!");
		setButtonProperties(_close);
		_close.setAlignmentX(Component.CENTER_ALIGNMENT);
		_close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(switchToSpyMaster == true) {
					updateSpyMaster();
				}
				else {
					updateTeam();	
				}
			}
		});
		
		_switchPanel.add(_turnTxtPanel);
		
		displayPanel();
		_switchPanel.add(_displayPanel);
		_switchPanel.add(_close);
		
		_switchPanel.setVisible(true);
		updateJFrameIfNotHeadless();

	}
	
	
	
	/**
	 * Method to display current state of game
	 * 
	 */
	public void displayPanel()
	{
		
		_displayPanel = new JPanel();
		_displayPanel.setLayout(new GridLayout(6, 6));

			for (Location tempLoc : _board.getLocations()) {

				if (tempLoc.isRevealed() == true) {
					JLabel revealed = new JLabel(tempLoc.getPerson().getPersonType());
					setLabelProperties(revealed, tempLoc.getPerson().getPersonType(), true);
					_displayPanel.add(revealed);

				} else {
					JLabel notrevealed = new JLabel(tempLoc.getCodeName());
					setLabelPropertiesDisplay(notrevealed);
					_displayPanel.add(notrevealed);
				}

			}
		
		
	}

	/**
	 * If guessCheck() returns true for winningState, winningUpdate is called to
	 * end the game by creating a popup displaying which team wins and gives
	 * the user the option to start a new game or to close out the applicaton.
	 * 
	 * This method calls on the board class' getWinner() method to know which team wins,
	 * winningState() sets winner to: blue if blueCount = 8, red if redCount = 9, or if
	 * assassin revealed will call assassinWin() to set winner.
	 * @param guess (The location clicked on by the user)
	 */

	public void winningUpdate(Location guess) {
		String winner = _board.getWinner();
		
		JFrame _gameOver = new JFrame("GAME OVER");
		JPanel _gameOverPanel = new JPanel();
		_gameOver.getContentPane().add(_gameOverPanel);
		_gameOverPanel.setLayout(new BoxLayout(_gameOverPanel, BoxLayout.Y_AXIS));
		
		JLabel _winnerTextPanel = new JLabel("The " + winner + " team has won the game!");
		_winnerTextPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		_winnerTextPanel.setFont(new Font("", Font.BOLD, 30));
		_gameOverPanel.add(_winnerTextPanel);
		
		JButton _playAgain = new JButton ("Play Again!");
		_playAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
		_playAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_windowHolder.newGameTwo();
				_gameOver.dispose();}});
		_gameOverPanel.add(_playAgain);
		
		JButton _endGame = new JButton ("Exit Game!");
		_endGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		_endGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_windowHolder.endGame();
				_gameOver.dispose();}});
		_gameOverPanel.add(_endGame);
		
		_gameOver.pack();
		_gameOver.setVisible(true);
		_gameOver.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		_mainPanel.removeAll();
		displayPanel();
		_mainPanel.add(_menuPanel);
		_mainPanel.add(_displayPanel);
		updateJFrameIfNotHeadless();
		
	}

	/**
	 * Method Which displays the current count and clue for the team
	 */
	public void CountandClueTeam() {

		JLabel _Clue = new JLabel("    Clue: " + _model.getClue());
		JLabel _space = new JLabel("              ");
		JLabel _Count = new JLabel("Count: " + _board.getCount());
		JButton _Pass = new JButton("Pass Turn");
		_Pass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(_board.isBlueTurn() == true) {
					_board.setRedTurn(true);
				} else {
					_board.setBlueTurn(true);
				}
				switchTurns(true);
			}

		});
		_infoPanel.add(_Pass);
		setButtonProperties(_Pass);
		_infoPanel.add(_Clue);
		setLabelPropertiesOther(_Clue);
		_infoPanel.add(_space);
		_infoPanel.add(_Count);
		setLabelPropertiesOther(_Count);

	}

	/**
	 * Method for adding count and clue text box if spymaster turn trys to read
	 * count and clue and if count is not a int or is< 0 or clue is invalid sends
	 * error message
	 */

	public void CountandClueSpyMaster() {
		JTextField txtFieldClue = new JTextField("Clue");
		JTextField txtFieldCount = new JTextField("Count");
		_infoPanel.add(txtFieldClue);
		_infoPanel.add(txtFieldCount);
		JButton submit = new JButton("Submit");
		setButtonProperties(submit);
		_infoPanel.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean badcount = false;
				int count = 0;
				try {
					count = Integer.parseInt(txtFieldCount.getText());
				} catch (Exception x) {
					badcount = true;
				}

				if (_model.checkClue(txtFieldClue.getText()) == false || txtFieldClue.getText() == ""
						|| badcount == true || count <= 0 || count > 9) {

					txtFieldClue.setText("Clue");

					txtFieldCount.setText("Count");
					invalidTxt();

				}
				else if (txtFieldClue.getText().toLowerCase().equals("pandas"))
				{
					easterEgg();
					
				}
					else {
				
					_model.setClue(txtFieldClue.getText());
					_board.setCount(count);
					switchTurns(false);

				}
			}

		});

	}


	/**
	 * Method if clue or count is invalid
	 */
	public void invalidTxt() {
		JFrame _error = new JFrame("Error");

		JPanel _errorPanel = new JPanel();
		_error.getContentPane().add(_errorPanel);
		_errorPanel.setLayout(new BoxLayout(_errorPanel, BoxLayout.Y_AXIS));

		JLabel _errorTxtPanel = new JLabel("Please enter a valid clue and count");
		setLabelPropertiesOther(_errorTxtPanel);
		_errorTxtPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton _close = new JButton("OK!");
		setButtonProperties(_close);
		_close.setAlignmentX(Component.CENTER_ALIGNMENT);
		_close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				_error.dispose();
			}
		});
		_errorPanel.add(_errorTxtPanel);
		_errorPanel.add(_close);
		_error.pack();
		_error.setVisible(true);
		_error.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	/**
	 *  Repacks driver
	 */
	public void updateJFrameIfNotHeadless() {

		_windowHolder.updateJFrame();

	}

	/**
	 * Method defined to set properties for a given JButton
	 * 
	 * @param button
	 */
	
	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, 15));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	public void easterEgg()
	{
		JFrame _hertz = new JFrame("Inspirational Message!");
		JPanel _hertzPanel = new JPanel();
		ImageIcon hertz = new ImageIcon("hertz.jpg");
		JLabel icon = new  JLabel(hertz);
		hertz.setImage(hertz.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
		
		_hertz.getContentPane().add(_hertzPanel);
		_hertzPanel.add(icon);
		_hertz.pack();
		_hertz.setLocationRelativeTo(null);
		_hertz.setVisible(true);
		
	}
	
	public void eggPic()
	{
		
		
		JPanel eggPic = new JPanel();
		eggPic.setPreferredSize(new Dimension(100, 100));
		eggPic.setLayout(new BoxLayout(eggPic, BoxLayout.X_AXIS));
		
		
		ImageIcon egg2 = new ImageIcon("Egg2.png");
		egg2.setImage(egg2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel icon = new  JLabel(egg2);
		icon.setBorder(new EmptyBorder(0, 30, 0, 0));
		eggPic.add(icon,BorderLayout.CENTER); 
		
		
		ImageIcon egg3 = new ImageIcon("Egg3.jpg");
		egg3.setImage(egg3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		JLabel icon2 = new  JLabel(egg3);
		icon2.setBorder(new EmptyBorder(0, 30, 0, 30));
		eggPic.add(icon2,BorderLayout.CENTER); 
		
		
		
		JLabel icon3 = new  JLabel(egg2);
		icon.setBorder(new EmptyBorder(0, 0, 0, 30));
		eggPic.add(icon3,BorderLayout.CENTER);
		eggPic.setPreferredSize(null);
		_mainPanel.add(eggPic);
		updateJFrameIfNotHeadless();
	}
	/**
	 * This method places two Gif pictures of easter eggs and a welcome to the new game 
	 * 
	 */
	public void effects() {
		_graphicPanel = new JPanel();
		_graphicPanel.setPreferredSize(new Dimension(100, 100));
		_graphicPanel.setLayout(new BoxLayout(_graphicPanel, BoxLayout.X_AXIS));
		ImageIcon egg = new ImageIcon("Egg.gif");
		egg.setImage(egg.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		JLabel icon = new  JLabel(egg);
		icon.setBorder(new EmptyBorder(0, 30, 0, 0));
		_graphicPanel.add(icon,BorderLayout.CENTER); 
		
		JLabel welcome = new JLabel("Welcome To CodeNames!"); 
		welcome.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		welcome.setBorder(new EmptyBorder(0, 30, 0, 30));
		_graphicPanel.add(welcome); 
		
		JLabel icon2 = new  JLabel(egg);
		icon2.setBorder(new EmptyBorder(0, 0, 0, 30));
		_graphicPanel.add(icon2,BorderLayout.CENTER); 
		_graphicPanel.setPreferredSize(null);
		_mainPanel.add( _graphicPanel);
		
	}

	/**
	 * 	 
	 *  Method defined to set properties for a given JLabel
	 *  
	 * @param label
	 * @param type
	 * @param revealed
	 */

	public void setLabelProperties(JLabel label, String type, boolean revealed) {

		if (revealed == false) {
			label.setForeground(Color.BLACK);

			if (type.toLowerCase().equals("red")) {
				label.setBackground(Color.decode("#ff354d"));
			} else if (type.toLowerCase().equals("blue")) {
				label.setBackground(Color.decode("#84D0FB"));
			} else if (type.toLowerCase().equals("innocent")) {
				label.setBackground(Color.getHSBColor(202, 60, 59 ));
			} else if (type.toLowerCase().equals("assassin")) {
				label.setBackground(Color.GREEN);
			}
		} else {
			label.setBackground(Color.WHITE);
			if (type.toLowerCase().equals("red")) {
				label.setForeground(Color.RED);
			} else if (type.toLowerCase().equals("blue")) {
				label.setForeground(Color.BLUE);
			} else if (type.toLowerCase().equals("innocent")) {
				label.setForeground(Color.MAGENTA);
			} else if (type.toLowerCase().equals("assassin")) {
				label.setForeground(Color.GREEN);
			}
		}

		label.setFont(new Font("Courier", Font.BOLD, 15));

		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	//
	public void setLabelPropertiesDisplay(JLabel label) {

		label.setFont(new Font("Courier", Font.BOLD, 15));
		label.setBackground(Color.WHITE);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}

	/**
	 * * Method defined to set properties for a given JLabel, without colored
	 * background
	 * 
	 * @param label
	 */
	
	public void setLabelPropertiesOther(JLabel label) {

		label.setFont(new Font("Courier", Font.BOLD, 20));

		label.setForeground(Color.BLACK);
		label.setOpaque(true);

	}
}
