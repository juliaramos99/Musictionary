/*
 * MusicController
 * This is the controller for the FXML document that contains the view. 
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MusicController implements Initializable {

  @FXML
  private Button btnSearch;

  @FXML
  private TextField txtName;

  @FXML
  private Label lblName;

  @FXML
  private Label lblBorn;

  @FXML
  private Label lblDied;

  @FXML
  private Label lblCountry;

  @FXML
  private Label lblGenre;

  @FXML
  private Label lblWebsite;

  @FXML
  private Label lblLabel;
  
  @FXML
  private Label lblBio;

  @FXML
  private ImageView icon;

  @FXML
  private void handleButtonAction(ActionEvent e) {
    
    // Create object to access the Model
    MusicModel music = new MusicModel();
  
    // Get artist name
    String name = txtName.getText();
    
    // Use the model to get the artist's information
    if (!name.equals("") && music.getInfo(name))
    {
       lblName.setText(music.getName());
       lblBorn.setText(music.getBornYear());
       lblDied.setText(music.getDiedYear());
       lblCountry.setText(music.getCountry());
       lblGenre.setText(music.getGenre());
       lblWebsite.setText(music.getWebsite());
       lblLabel.setText(music.getLabel());
       lblBio.setText(music.getBio());
       icon.setImage(music.getImage());
    }
    else
    {
        lblName.setText("Artist not found!");
        lblBorn.setText("");
        lblDied.setText("");
        lblCountry.setText("");
        lblGenre.setText("");
        lblWebsite.setText("");
        lblLabel.setText("");
        lblBio.setText("");
        icon.setImage(new Image("badartistname.png"));
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }    

}
