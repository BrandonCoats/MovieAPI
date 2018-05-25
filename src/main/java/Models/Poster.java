package Models;


import org.springframework.data.annotation.Transient;

//annotate for mongo later
public class Poster {

@Transient
public String id;

public String title;

public String image;

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
