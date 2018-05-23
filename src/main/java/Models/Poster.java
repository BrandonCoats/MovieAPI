package Models;

import java.io.File;

//annotate for mongo later
public class Poster {
public String id;
public File image;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public File getImage() {
	return image;
}
public void setImage(File image) {
	this.image = image;
}
}
