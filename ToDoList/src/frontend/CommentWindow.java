package frontend;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import backend.Comment;
import backend.HistoryItem;
import backend.Task;

public class CommentWindow {
	private JFrame mainFrame;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JTextField userText;
	private Task userTask = null;
	private Comment userComment = null;

	public CommentWindow(Task task){
		prepareGUI_ONLYtask();
		userTask = task;
	}
	
	public CommentWindow(Task task, Comment commentToEdit){
		prepareGUI();
		userTask = task;
		userComment = commentToEdit;
	}
	public static void main(String[] args){
		CommentWindow swingControlDemo = new CommentWindow(/*DUMMY DATA GOES HERE*/);      
	}
	private void prepareGUI(){
		mainFrame = new JFrame("Comment Window");
		mainFrame.setSize(500,200);
		mainFrame.setLayout(new GridLayout(0,3));      


		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);  
		JLabel  namelabel= new JLabel("Comment", JLabel.RIGHT);
		userText = new JTextField(6); 
		userText.setPreferredSize( new Dimension(200,24));

		JButton commit = new JButton("Commit Comment");
		commit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				String commandName = event.getActionCommand();
				if(commandName.equals("Commit Comment")){
					String g1 = userText.getText();
					
					userTask.addComment(g1);
				}
			}
		});
		JButton delete = new JButton("Delete Comment");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				String commandName = event.getActionCommand();
				if(commandName.equals("Delete Comment")){
					String g1 = userText.getText();
					
					userTask.deleteComment(userComment);
				}
			}
		});
		controlPanel.add(namelabel);
		controlPanel.add(userText);
		controlPanel.add(commit);
		controlPanel.add(delete);
		mainFrame.setVisible(true);  
	}
	
	private void prepareGUI_ONLYtask(){
		mainFrame = new JFrame("Comment Window");
		mainFrame.setSize(500,200);
		mainFrame.setLayout(new GridLayout(0,3));      


		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);  
		JLabel  namelabel= new JLabel("Comment", JLabel.RIGHT);
		userText = new JTextField(6); 
		userText.setPreferredSize( new Dimension(200,24));

		JButton commit = new JButton("Commit Comment");
		commit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				String commandName = event.getActionCommand();
				if(commandName.equals("Commit Comment")){
					String g1 = userText.getText();
					
					userTask.addComment(g1);
				}
			}
		});
		/*JButton delete = new JButton("Delete Comment");
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				String commandName = event.getActionCommand();
				if(commandName.equals("Delete Comment")){
					String g1 = userText.getText();
					
					userTask.deleteComment(userComment);
				}
			}
		});*/
		controlPanel.add(namelabel);
		controlPanel.add(userText);
		controlPanel.add(commit);
		//controlPanel.add(delete);
		mainFrame.setVisible(true);  
	}
}
