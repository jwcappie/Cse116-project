package Model;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Driver implements Runnable {

	private JFrame _window;
	private JPanel _mainPanel;
	private Model _model;

	public Driver(Model _model) {

		this._model = _model;

	}

	/* creates new Model & executes runnable */

	public static void main(String[] args) {

		Model _model = new Model("GameWords.txt");
		SwingUtilities.invokeLater(new Driver(_model));

	}

	/* when called creates a new Gui and Model thus starting a new game */
	public void newGame() {
		_mainPanel.removeAll();
		GUI newGui = new GUI(_mainPanel, this, new Model("GameWords.txt"));
		newGui.switchTurns(true);
		updateJFrame();

	}

	/* can be called to end the game and exit the window */
	public void endGame() {
		_window.dispose();

	}

	/*
	 * Setup for the GUI; creates base frame and Panel, Creates new GUI instance
	 * which is sent the main panel, this Driver instance as well as the model
	 */
	@Override
	public void run() {
		_window = new JFrame("Codenames");
		_mainPanel = new JPanel();
		_window.getContentPane().add(_mainPanel);
		firstOpen();
		_window.pack();
		_window.setLocationRelativeTo(null);
		_window.setVisible(true);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/*
	 * Creates the Menu for when the game is first started, allows to start new Game
	 * or Exit JButtons are created for each option including anonymous action
	 * listeners which call methods
	 */
	private void firstOpen() {

		JPanel _startPanel = new JPanel();
		_startPanel.setLayout(new GridLayout(1, 2));
		JButton _newGame = new JButton("New Game");
		_newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});

		JButton _exit = new JButton("Exit Game");
		_exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				endGame();
			}
		});

		_startPanel.add(_newGame);
		_startPanel.add(_exit);
		_mainPanel.add(_startPanel);

	}
	

	/* called to update the window, redraws it and fixes window size */
	public void updateJFrame() {
		_window.pack();
		_window.isLocationByPlatform();
		_window.repaint();
	}
}
