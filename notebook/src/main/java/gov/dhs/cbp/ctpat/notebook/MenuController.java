package gov.dhs.cbp.ctpat.notebook;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

public class MenuController implements Initializable, IContentListener {

	@FXML
	private MenuBar menuBar;
	private TreeView<String> tree;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			BufferedImage iconImgSheet = ImageIO.read(this.getClass().getResource("iconsheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleExitAction(final ActionEvent event) {
		Platform.exit();
	}
	
	@FXML
	private void handleOpenAction(final ActionEvent event) {
		System.out.println("Lets open something.");
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open File");
		File iFile = chooser.showOpenDialog(menuBar.getScene().getWindow());
		if (iFile instanceof File) {
			TreeItem<String> rootItem = new TreeItem<String>("Worksheet");

			try {
				CTPATWSContent task = null;
				task = new CTPATWSContent(new FileInputStream(iFile), this);
				task.setDefaultHandler (task.new CTPATWSContentSummary());
				// separate non-FX thread
				new Thread(task).start();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			tree = new TreeView<String>(rootItem);
			
			StackPane root = new StackPane();

			BorderPane borderPane = (BorderPane) menuBar.getParent();
			root.getChildren().add(tree);
			borderPane.setLeft(root);

		}
	}
	@Override
	public void summary(ObservableList list) {
		System.out.println("Opened.");
		
		tree.getRoot().getChildren().clear();
		
		tree.getRoot().getChildren().add((TreeItem)list.get(0));
		tree.refresh();
		
		BorderPane borderPane = (BorderPane) menuBar.getParent();
		URL url = this.getClass().getResource("summarypane.fxml");
        FXMLLoader loader = new FXMLLoader(url);

        try {
        	borderPane.setCenter(loader.load());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
	}
	@FXML
	private void handleAboutAction(final ActionEvent event) {
		provideAboutFunctionality();
	}

	/**
	 * Perform functionality associated with "About" menu selection or CTRL-A.
	 */
	private void provideAboutFunctionality() {
		System.out.println("You clicked on About!");
	}

	/**
	 * build sprites
	 */
	private BufferedImage[] buildSprites(BufferedImage iconImgSheet) {

		final int width = 32;
		final int height = 32;
		final int rows = 20;
		final int cols = 23;
		BufferedImage[] sprites = new BufferedImage[rows * cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sprites[(i * cols) + j] = iconImgSheet.getSubimage(j * width, i * height, width, height);
			}
		}
		return sprites;
	}

}
