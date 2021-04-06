package connections;

public class SQL implements IAccess {

	@Override
	public void insert() {
		System.out.println("insert from SQL");

	}

	@Override
	public void read() {
		System.out.println("read from SQL");

	}

	@Override
	public void update() {
		System.out.println("update from SQL");

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}