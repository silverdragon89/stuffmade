package pad_src;

//Class contains the buildings of a monster's enhanced stat
//Does not handle errors for adding over MAX_STAT plug eggs

public class monster {
	private int hp;
	private int atk;
	private int rcv;
	private String name;
	private int id;
	
	public monster(){
		//empty constructor
	}
	
	public monster(String input_name, int input_id, int input_hp, int input_atk, int input_rcv){
		setName(input_name);
		setId(input_id);
		setHp(input_hp);
		setAtk(input_atk);
		setRcv(input_rcv);
		
	}
	//set functions
	public void setHp(int input_hp){
		hp = input_hp;
	}
	public void setAtk(int input_atk){
		atk = input_atk;
	}
	public void setRcv(int input_rcv){
		rcv = input_rcv;
	}
	public void setName(String input_name){
		name = input_name;
	}
	public void setId(int input_id){
		id = input_id;
	}
	
	//get functions
	public int getHp(){
		return hp;
	}
	public int getAtk(){
		return atk;
	}
	public int getRcv(){
		return rcv;
	}
	public String getName(){
		return name;
	}
	public int getId(){
		return id;
	}
	public int getTotalPlus(){
		return hp + atk + rcv;
	}

}
