import java.awt.BorderLayout;
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
	private JButton button;
	private String filename;
	
	public OpenImage() {

		button = new JButton("Press this to Find an Image");
		button.addActionListener(e -> openImage());
		imageLabel = new JLabel("Press the button to select an Image");
		imagePanel = new JPanel(new BorderLayout());
		imagePanel.add(imageLabel, BorderLayout.NORTH);
		imagePanel.add(button, BorderLayout.SOUTH);

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
            Image newimg = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
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