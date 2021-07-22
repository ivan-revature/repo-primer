package fixtures;

public abstract class Fixture {
	// a short name / title for the fixture
	String name;
	
	// a one-sentence-long description of a
	// fixture used to briefly mention the
	// fixture
	String shortDescription;
	
	// a paragraph-long description of the 
	// thing displayed when the player
	// investigates the fixture thoroughly
	// (looks at it or enters a room)
	String longDescription;
	
	public Fixture(String rmName, String sD, String lD) {
		this.name = rmName;
		this.shortDescription = sD;
		this.longDescription = lD;
	}
}
