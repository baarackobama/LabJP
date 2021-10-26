import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
	private static final String MENU = 
			"    M E N U   G £ Ó W N E  		\n" +
			"1 - Dodaj osoby 					\n" +
			"2 - U¿yj domyœlnej bazy osób		\n"	+
			"3 - Wyœwietl kolekcje				\n" +
			"4 - Próba usuwania osoby poprzez dopasowanie niezdefiniowan¹ metod¹ equales()\n" +
			"5 - Próba usuwania osoby poprzez dopasowanie porównuj¹c wartoœci uzyskane niezdefiniowan¹ metod¹ hashCode() \n"+
			"6 - Próba usuwania osoby poprzez dopasowanie zdefiniowan¹ metod¹ equales()\n" +
			"7 - Próba usuwania osoby poprzez dopasowanie porównuj¹c wartoœci uzyskane zdefiniowan¹ metod¹ hashCode() \n"+
			"0 - Zakoñcz program        		\n";	
	
	 public static void main(String[] args) {
		 Main aplication = new Main();
		 aplication.runMainLoop();
	 }
	 
	
	

		
ArrayList<Person> aL ;
LinkedList<Person> lL;
HashMap<Person,Integer> hM;
TreeMap<Person,Integer> tM;
HashSet<Person> hS;
TreeSet<Person> tS;
Scanner scan = new Scanner(System.in);

private void runMainLoop(){
	aL = new ArrayList<>();
	lL = new LinkedList<>();
	hM = new HashMap<>();
	tM = new TreeMap<>();
	hS = new HashSet<>();
	tS = new TreeSet<>();
	
	while (true) {
		try {
			System.out.println(MENU);
			switch (scan.nextInt()) {
			case 1:
				
				addPerson();
				break;

			case 2:
				defK();
				break;
				
				
			case 3:
				printK();
				break;
				
		    	
			case 4:
				delNdE();
				break;
				

			case 5:
				delNdH();
				break;
				
			case 6:
				delDE();
				break;
			case 7:
				delDH();
				break;

				
			case 0:
				System.out.println("Zakoñczono program");
				System.exit(0);
			}}catch(InputMismatchException e) {
			System.out.println("Z³e dane");
			scan.nextLine();
		}
	}
}
//Dodawanie osoby
private void addPerson() {
	scan.nextLine();
	System.out.println("Imie: ");
	String imie = scan.nextLine();
	System.out.println("Nazwisko: ");
	String naziwsko = scan.nextLine();
	Person person = new Person(imie,naziwsko);
	aL.add(person);
	lL.add(person);
	hM.put(person,person.hashCode());
	tM.put(person,person.hashCode());
	hS.add(person);
	tS.add(person);}
//Domyœlne osoby aby nie trzeba by³o dodawaæ rêcznie
private void defK(){
	Person[] def = {new Person("Barrack","Obama"),new Person("Wojciech","Cejrowski"),new Person("Magda","Gessler"),new Person("Werener","Herzog")};
	for(Person p : def) {
		aL.add(p);
		lL.add(p);
		hM.put(p,p.hashCode());
		tM.put(p,p.hashCode());
		hS.add(p);
		tS.add(p);	
	}
}
//Wypisywanie kolekcji
private void printK() {
	System.out.println("ArrayList: ");
	for(int i = 0;i<aL.size();i++) {
		System.out.print(aL.get(i).toString()+" | ");
	}
	System.out.println();
	System.out.println("LinkedList: ");
	for(int i = 0;i<lL.size();i++) {
		System.out.print(lL.get(i).toString()+" | ");
	}
	System.out.println();
	System.out.println("HashMap: ");
    for (Person value : hM.keySet()) {
        System.out.print(value.toString()+" | ");
	
    }
    System.out.println();
    System.out.println("TreeMap: ");	
    for (Person value : tM.keySet()) {
        System.out.print(value.toString()+" | ");
    	}
    System.out.println();
    System.out.println("HashSet");
    for (Person value : hS) {
        System.out.print(value.toString()+" | ");
    	}
	System.out.println();
	System.out.println("TreeSet");
    	for(Person value :tS) {
    		System.out.print(value+ " | ");}
    	System.out.println();
}
//Wybieranie osoby do usuniêcia
private Person toDel() {
	try {
	scan.nextLine();
	System.out.println("Podaj imie");
	String delImie = scan.nextLine();
	System.out.println("Podaj naziwsko");
	String delNaziwsko = scan.nextLine();
	Person delPerson = new Person(delImie,delNaziwsko);
	return delPerson;
	}catch(InputMismatchException e ) {
		System.out.println("Z³e dane");
		scan.nextLine();}
	return null;
		
	}


//Usuwanie dla niezdefiniowanego equals
private void delNdE() {

	Person delPerson = toDel();
	for(Person p: aL) {
		if(delPerson.equals(p)) {
			lL.remove(p);
			break;
		}
	}
	for(Person p: lL) {
		if(delPerson.equals(p)) {
			lL.remove(p);
			break;
		}
	}
	for(Person p: hM.keySet()) {
		if(delPerson.equals(p)) {
			hM.remove(p);
			break;
		}
	}
	for(Person p: tM.keySet()) {
		if(delPerson.equals(p)) {
			tM.remove(p);
			break;
		}
	}
	for(Person p: hS) {
		if(delPerson.equals(p)) {
			hS.remove(p);
			break;
		}
	}
	for(Person p: tS) {
		if(delPerson.equals(p)) {
			tS.remove(p);
			break;
			}
	}	
	
}
//Usuwanie dla niezdefiniowanego getHash
private void delNdH() {
	Person delPerson = toDel();
	
	for(Person p: aL) {
		if(delPerson.hashCode() == p.hashCode()) {
			lL.remove(p);
			break;
		}
	}
	for(Person p: lL) {
		if(delPerson.hashCode() == p.hashCode()) {
			lL.remove(p);
			break;
		}
	}
	for(Person p: hM.keySet()) {
		if(delPerson.hashCode() == p.hashCode()) {
			hM.remove(p);
			break;
		}
	}
	for(Person p: tM.keySet()) {
		if(delPerson.hashCode() == p.hashCode()) {
			tM.remove(p);
			break;
		}
	}
	for(Person p: hS) {
		if(delPerson.hashCode() == p.hashCode()) {
			hS.remove(p);
			break;
		}
	}
	for(Person p: tS) {
		if(delPerson.hashCode() == p.hashCode()) {
			tS.remove(p);
			break;
			}
	}	
}
//Usuwanie dla zdefiniowanego equals()
private void delDE() {
	Person delPerson = toDel();
	
	for(Person p: aL) {
		if(delPerson.equals(p,true)) {
			aL.remove(p);
			break;
		}
	}
	for(Person p: lL) {
		if(delPerson.equals(p,true)) {
			lL.remove(p);
			break;
		}
	}
	for(Person p: hM.keySet()) {
		if(delPerson.equals(p,true)) {
			hM.remove(p);
			break;
		}
	}
	for(Person p: tM.keySet()) { 
		if(delPerson.equals(p,true)) {
			tM.remove(p);
			break;
		}
	}
	for(Person p: hS) {
		if(delPerson.equals(p,true)) {
			hS.remove(p);
			break;
		}
	}
	for(Person p: tS) {
		if(delPerson.equals(p,true)) {
			tS.remove(p);
			break;
			}
	}	
	
}

//Usuwanie dla zdefiniowanego getHash
private void delDH() {
	Person delPerson = toDel();
	
	for(Person p: aL) {
		if(delPerson.hashCode(true) == p.hashCode(true)) {
			aL.remove(p);
			break;
		}
	}
	for(Person p: lL) {
		if(delPerson.hashCode(true) == p.hashCode(true)) {
			lL.remove(p);
			break;
		}
	}
	for(Person p: hM.keySet()) {
		if(delPerson.hashCode(true) == p.hashCode(true)) {
			hM.remove(p);
			break;
		}
	}
	for(Person p: tM.keySet()) { 
		if(delPerson.hashCode(true) == p.hashCode(true)) {
			tM.remove(p);
			break;
		}
	}
	for(Person p: hS) {
		if(delPerson.hashCode(true) == p.hashCode(true)) {
			hS.remove(p);
			break;
		}
	}
	for(Person p: tS) {
		if(delPerson.hashCode(true) == p.hashCode(true)) {
			tS.remove(p);
			break;
			}
	}	
	
}
}

