import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Test the MusicModel class
 */
public class MusicModelTest
{ 
  @Test
  public void testGetInfo1()
  {
    MusicModel m = new MusicModel();
    assertEquals(true, m.getInfo("michael jackson"));
  }

  @Test
  public void testGetInfo2()
  {
    MusicModel m = new MusicModel();
    assertEquals(false, m.getInfo("bleh"));
  }

  @Test
  public void testGetName()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("Michael Jackson", m.getName());
    }
  }
  
  @Test
  public void testGetCountry()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("Indiana, USA", m.getCountry());
    }
  }
  
  @Test
  public void testGetBornYear1()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("1958", m.getBornYear());
    }
  }
  
  @Test
  public void testGetDiedYear1()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("2009", m.getDiedYear());
    }
  }
  
  @Test
  public void testGetBornYear2()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("the beatles")) {
        assertEquals("1957", m.getBornYear());
    }
  }
  
  @Test
  public void testGetDiedYear2()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("the beatles")) {
        assertEquals("1970", m.getDiedYear());
    }
  }
  
  @Test
  public void testGetGenre()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("Pop", m.getGenre());
    }
  }
  
  @Test
  public void testGetWebsite()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("www.michaeljackson.com", m.getWebsite());
    }
  }
  
  @Test
  public void testGetLabel()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("michael jackson")) {
        assertEquals("Epic", m.getLabel());
    }
  }
  
  @Test
  public void testGetBio()
  {
    MusicModel m = new MusicModel();
    if (m.getInfo("billie eilish")) {
        assertEquals("\"Billie Eilish\"  (born December 18, 2001)", m.getBio().substring(0, 41));
    }
  }


}
