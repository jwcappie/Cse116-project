package Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

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
	private Model _model;
	private Board _board;

	public GUI(JPanel _mainPanel, Driver driver, Model _model) {

		this._mainPanel = _mainPanel;
		this._windowHolder = driver;
		this._model = _model;
		_board = _model.getCurrentBoard();
		updateSpyMaster();

	}

	/** Called to update GUI when it is the SpyMasters Turn **/
	public void updateSpyMaster() {
		_mainPanel.removeAll();
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.PAGE_AXIS));
		menuPanel();
		gamePanel(true);
		infoPanel(true);

	}

	/* Called to update GUI when it is not the SpyMasters Turn */
	public void updateTeam() {
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.PAGE_AXIS));
		menuPanel();
		gamePanel(false);
		infoPanel(false);

	}

	/* Given Whether it is the SpyMasters turn or not: sets up board 
	 * goes through each location and checks whether revealed or not then
	 * sets up properties*/
	private void gamePanel(boolean SpyMasterTurn) {
		_gamePanel = new JPanel();
		_gamePanel.setLayout(new GridLayout(5, 5));

		if (SpyMasterTurn == true) {
			for (Location tempLoc : _board.getLocations()) {
				
				if(tempLoc.isRevealed() == true)
				{
					JLabel revealed = new JLabel(tempLoc.getPerson().getPersonType());
					setLabelProperties(revealed,tempLoc.getPerson().getPersonType());
					_gamePanel.add(revealed);
					
				}
				else
				{
					JLabel notrevealed = new JLabel(tempLoc.getCodeName()+ " : " + tempLoc.getPerson().getPersonType());
					setLabelProperties(notrevealed,tempLoc.getPerson().getPersonType());
					_gamePanel.add(notrevealed);
				}

			}
		} else {
			for (Location tempLoc : _board.getLocations()) {
				
				if(tempLoc.isRevealed() == true)
				{
					JLabel revealed = new JLabel(tempLoc.getPerson().getPersonType());
					_gamePanel.add(revealed);
					
				}
				else
				{
					JLabel notrevealed = new JLabel(tempLoc.getCodeName());
					_gamePanel.add(notrevealed);
				}

			}
		}

		_mainPanel.add(_gamePanel);
	}

	/*
	 * Method to Create a drop down at the top of the gui the options are New Game
	 * and Exit which call corresponding methods is added to the main panel at the
	 * end of the method so must be called before game and info panel are added
	 */
	private void menuPanel() {
		_menuPanel = new JPanel();
		JComboBox<String> dropdown = new JComboBox<>();
		_menuPanel.setPreferredSize(new Dimension(50,30));
		_menuPanel.setLayout(new BoxLayout(_menuPanel, BoxLayout.X_AXIS));
		
		dropdown.addItem("File");
		dropdown.addItem("New Game");
		dropdown.addItem("Exit");
		dropdown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (dropdown.getSelectedIndex() == 1) {
					_windowHolder.newGame();
				} else if (dropdown.getSelectedIndex() == 2) {
					_windowHolder.endGame();
				}
			}
		});
		
		dropdown.setAlignmentX(Component.LEFT_ALIGNMENT);
		_menuPanel.add(dropdown);
		_mainPanel.add(_menuPanel);

	}
	
	/*method called to update infopanel given whether it is the spymasters turn or not
	 * 
	 */
	
	private void infoPanel(boolean SpyMasterTurn) {
		_infoPanel = new JPanel();
		_infoPanel.setLayout(new BoxLayout(_infoPanel, BoxLayout.X_AXIS));
		JTextField txtField = new JTextField();
			_infoPanel.add(txtField);
		JButton submit = new JButton("Submit");
			setButtonProperties(submit);
			_infoPanel.add(submit);
			submit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (_model.checkClue(txtField.getText())) {
						_model.setClue(txtField.getText());
						
					} else{
						
					}
				}
			});
		
		
		_mainPanel.add(_infoPanel);
	}
	
	/*Method defined to set properties for a given JButton*/
	public void setButtonProperties(JButton button) {
		button.setFont(new Font("Courier", Font.BOLD, 44));
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
		button.setOpaque(true);
		button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
	
	/*Method defined to set properties for a given JLabel*/
	public void setLabelProperties(JLabel label, String type) {
		
		if(type.toLowerCase().equals("red"))
		{
			label.setBackground(Color.RED);
		}
		else if(type.toLowerCase().equals("blue"))
		{
			label.setBackground(Color.BLUE);
		}
		else if(type.toLowerCase().equals("innocent"))
		{
			label.setBackground(Color.MAGENTA);
		}
		else if(type.toLowerCase().equals("assassin"))
		{
			label.setBackground(Color.GREEN);
		}
		
		label.setFont(new Font("Courier", Font.BOLD, 15));
		
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}
}
