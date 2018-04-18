import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpenImage {
	private JPanel imagePanel;
	private JLabel imageLabel;
	private String filename;
	
	public OpenImage() {
		imageLabel = new JLabel("Press the button to select an Image", JLabel.CENTER);
		imageLabel.setFont(new Font("Century", Font.BOLD, 18));
		imageLabel.setForeground(new Color(102, 205, 170)); 
		imagePanel = new JPanel(new BorderLayout());
		imagePanel.add(imageLabel, BorderLayout.CENTER);
		imagePanel.setBackground(new Color(47, 79, 79));

	}
	
	public void openImage() {
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            filename = file.getAbsolutePath();
            System.out.println(filename);
            ImageIcon imageIcon = new ImageIcon(filename);
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(900, 800, Image.SCALE_SMOOTH);
            imagePanel.removeAll();
            imageLabel = new JLabel("", new ImageIcon(newimg), JLabel.CENTER);
            imagePanel.add(imageLabel, BorderLayout.CENTER);
            imagePanel.revalidate();
            imagePanel.repaint();
        }
	}
	
	public JPanel getPanel() {
		return imagePanel;
	}
	
	public String getFileName() {
		return filename;
	}
        
}
