package pad_src;

import java.util.ArrayList;
import java.util.Scanner;

//the bank class contains a listing of monsters currently in that bank
public class bank {
	
	static ArrayList<monster> monster_bank = new ArrayList<monster>();
	static ArrayList<monster> monster_queue = new ArrayList<monster>();
	public static final int MAX_PLUS = 99;

	public int get_queue_total_hp(){
		int result = 0;
		for (int i = 0; i < monster_queue.size(); i++) {
			result =+ monster_queue.get(i).getHp();
		}
		return result;
	}
	public int get_queue_total_atk(){
		int result = 0;
		for (int i = 0; i < monster_queue.size(); i++) {
			result =+ monster_queue.get(i).getAtk();
		}		
		return result;
	}
	public int get_queue_total_rcv(){
		int result = 0;
		for (int i = 0; i < monster_queue.size(); i++) {
			result =+ monster_queue.get(i).getRcv();
		}
		return result;
	}
	
	
	//function will return false if adding two monsters together will not work. 
	//return true if combining is successful
	public boolean add_monster_to_queue(monster input_monster){
		int result = 0;
		if((result = input_monster.getHp() + get_queue_total_hp()) > MAX_PLUS){
			System.err.println("$result is too many HP plug eggs");
			return false;
		}
		else if((result = input_monster.getAtk() + get_queue_total_atk()) > MAX_PLUS){
			System.err.println("$result is too many ATK plug eggs");
			return false;
		}
		else if((result = input_monster.getRcv() + get_queue_total_rcv()) > MAX_PLUS){
			System.err.println("$result is too many RCV plug eggs");
			return false;
		}
		
		//if passes all checks
		else{
			monster_queue.add(input_monster);
			return true;
		}
	}
	
	//function will add monster to the bank.  
	//monster will be placed sorted by the total plus eggs
	public static void add_monster_to_bank(monster input_monster){
		for (int i = 0; i < monster_bank.size(); i++) {
			if(monster_bank.get(i).getTotalPlus() < input_monster.getTotalPlus())
				monster_bank.add(i, input_monster);
		}	
	}
	
	//function will remove monster from bank.  
	//monster will be placed sorted by the total plus eggs
	public static void remove_monster_from_bank(int index_remove){
		monster_bank.remove(index_remove);
	}
	

	//function system.out.println() what is currently in the queue
	public static void display_queue(){
		for (int i = 0; i < monster_queue.size(); i++) {
			System.out.println("Monster #$i: " + monster_queue.get(i).getName());
			System.out.println("Monster ID: " + monster_queue.get(i).getId());
			System.out.println("Monster ATK: +" + monster_queue.get(i).getHp());
			System.out.println("Monster ATK: +" + monster_queue.get(i).getAtk());
			System.out.println("Monster ATK: +" + monster_queue.get(i).getRcv());
			System.out.println(""); //formatting
		}
	}
	
	//function system.out.println() what is currently in the queue
	public static void display_bank(){
		for (int i = 0; i < monster_queue.size(); i++) {
			System.out.println("Monster #$i: " + monster_bank.get(i).getName());
			System.out.println("Monster ID: " + monster_bank.get(i).getId());
			System.out.println("Monster ATK: +" + monster_bank.get(i).getHp());
			System.out.println("Monster ATK: +" + monster_bank.get(i).getAtk());
			System.out.println("Monster ATK: +" + monster_bank.get(i).getRcv());
			System.out.println(""); //formatting
		}
	}
	
	//function gets user input for a new monster to add to bank
	public static monster get_monster_from_user(){
		Scanner user_input = new Scanner(System.in);

		System.out.println("Monster name?");
		String input_name = user_input.nextLine(); 
		System.out.println("Monster ID?");
		int input_id = user_input.nextInt();
		System.out.println("Monster HP?");
		int input_hp = user_input.nextInt();
		System.out.println("Monster ATK?");
		int input_atk = user_input.nextInt();
		System.out.println("Monster RCV?");
		int input_rcv = user_input.nextInt();

		monster new_monster = new monster(input_name, input_id, input_hp, input_atk, input_rcv);

		return new_monster;
	}
	
	
	//function initializes the bank
	public static void setup_bank (){
		int input_continue = 1;
		int monster_counter =  0;
		Scanner user_input = new Scanner(System.in);
	
		while (input_continue == 1){
			//retrieve monster information from user
			System.out.println("Monster name?");
			String input_name = user_input.nextLine(); 
			System.out.println("Monster ID?");
			int input_id = user_input.nextInt();
			System.out.println("Monster HP?");
			int input_hp = user_input.nextInt();
			System.out.println("Monster ATK?");
			int input_atk = user_input.nextInt();
			System.out.println("Monster RCV?");
			int input_rcv = user_input.nextInt();

			
			monster input_monster = new monster(input_name, input_id, input_hp, input_atk, input_rcv);
			monster_counter++;
			add_monster_to_bank(input_monster);
			System.out.println("Another monster? Input 1 to continue.  Input 0 to exit");
			input_continue = user_input.nextInt();
			
			//make sure user only inputs 1 or 0
			while (input_continue != 0 || input_continue != 1){
				input_continue = user_input.nextInt();
			}
		user_input.close();
		}
		System.out.println("You have inputted " +  monster_counter + " monsters");
	}
	
	public static void main (String[] args){
		
		Scanner user_input = new Scanner(System.in);

		
		//setup the initial bank	
		setup_bank();
		

		System.out.println("Welcome to PADBank Calculator.");
		
		int input_continue = 1;
		//loop the user interface.  exit app = 0
		while (input_continue != 0){
			System.out.println("Main Menu:");
			System.out.println("1 - Display bank");
			System.out.println("2 - Add monster to bank");
			System.out.println("3 - Remove monster from bank");
			System.out.println("4 - Display pending queue");
			System.out.println("5 - Calculate Max eggs");
			System.out.println("0 - Exit");
			input_continue = user_input.nextInt();
		
			if (input_continue == 1){
				display_bank();
			}
			else if (input_continue == 2){
				add_monster_to_bank(get_monster_from_user());
			}
			else if (input_continue == 3){
				System.out.println("Which monster do you want to remove? (index)");
				remove_monster_from_bank(user_input.nextInt());
			}
			else if (input_continue == 4){
				display_queue();
			}
			else if (input_continue == 5){
				//make the calculator!
			}
			else if (input_continue == 0){
				break;
			}
			else
				System.err.println("Error 1.  System should not reach this point");
		}
		
		user_input.close();
	}
}

