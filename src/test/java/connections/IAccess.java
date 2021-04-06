package connections;

public interface IAccess {
	int MAX_REGISTER = 10;
	
	void insert();
	
	void read();
	
	void update();
	
	void delete();
}
