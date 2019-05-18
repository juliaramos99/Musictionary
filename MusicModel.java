import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;

import java.io.IOException;

import java.util.Date;
import java.util.Calendar;
import java.text.DecimalFormat;
import java.lang.Math; 

import com.google.gson.*;

public class MusicModel
{
    private JsonElement jse;
	public boolean getInfo(String name)
	{
        try
		{
			// Construct AudioDB API URL
			name = name.replaceAll(" ", "_").toLowerCase();
            URL url = new URL("https://theaudiodb.com/api/v1/json/1/search.php?s=" + name);
                        
            // Open the URL
			InputStream is = url.openStream(); // throws an IOException
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			// Read the result into a JSON Element
			jse = new JsonParser().parse(br);
      
			// Close the connection
			is.close();
			br.close();
		}
        catch (java.io.UnsupportedEncodingException uee)
        {
            return false;
        }
        catch (java.net.MalformedURLException mue)
        {
            return false;
        }
        catch (java.io.IOException ioe)
        {
            return false;
        }
        catch (java.lang.NullPointerException npe)
        {
            return false;
        }
        
        // Check to see if the artist name was valid.
        return isValid();
        
    }
    
    public boolean isValid()
    {
        // If the name is valid we can access idArtist
        try {
            String error = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("idArtist").getAsString();
            return true;
        }

        catch (java.lang.IllegalStateException npe)
        {
            // We could not access idArtist, so this is an invalid name and error
            return false;
        }
    }
    
    
    public String getName()
    {
        try {
            return jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strArtist").getAsString();
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getCountry()
    {
        try {
            String country = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strCountry").getAsString();
            if (country.equals(""))
                return "N/A";
            else
                return country;
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getBornYear()
    {
        try {
            if (Integer.parseInt(jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("intMembers").getAsString()) > 1)
                return jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("intFormedYear").getAsString();
            else
                return jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("intBornYear").getAsString();
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getDiedYear()
    {
        try {
            String year = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("intDiedYear").getAsString();
            if (year.equals("0") || year.equals(""))
                return "Present";
            else
                return year;
        } catch (java.lang.UnsupportedOperationException npe) {
            if (getBornYear().equals("N/A"))
                return "N/A";
            else
                return "Present";
        }
    }
    
    public String getGenre()
    {
        try {
            String genre = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strGenre").getAsString();
            if (genre.equals(""))
                return "N/A";
            else
                return genre;
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getWebsite()
    {
        try {
            String website = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strWebsite").getAsString();
            if (website.equals(""))
                return "N/A";
            else
                return website;
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }    
    }
    
    public String getLabel()
    {
        try {
            String label = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strLabel").getAsString();
            if (label.equals(""))
                return "N/A";
            else
                return label;
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    public String getBio()
    {
        try {
            String bio = jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strBiographyEN").getAsString();
            if (bio.equals(""))
                return "N/A";
            else
                return bio;
        } catch (java.lang.UnsupportedOperationException npe) {
            return "N/A";
        }
    }
    
    
    public Image getImage()
    {   
        BufferedImage image = null;
        try {
            URL url = new URL(jse.getAsJsonObject().get("artists").getAsJsonArray().get(0).getAsJsonObject().get("strArtistThumb").getAsString());
            image = ImageIO.read(url);
        } catch (IOException e) {
        	return new Image("badartistname.png");
        } catch (java.lang.UnsupportedOperationException npe) {
            return new Image("badartistname.png");
        }
        Image icon = SwingFXUtils.toFXImage(image, null);
        return icon;
        
    }
        
}
