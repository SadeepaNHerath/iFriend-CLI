import java.time.*;
import java.util.*;

/**
 * iFriend Contact Management System
 * 
 * A command-line application for managing contacts including adding,
 * updating, deleting, searching and sorting functionality.
 * 
 * @version 1.0.0
 * @author ICET Project Team
 */
class iFriend{
	public static Scanner input=new Scanner(System.in);
	public static int cusID =1,index=0;
	public static String[] cusIDarr=new String[0],namearr=new String[0],phonearr=new String[0],Cnamearr=new String[0],dobarr=new String[0];
	public static double[] salaryarr=new double[0];
	public static String method,tempphone,tempname,tempCname,tempcusID,tempdob;
	public static double tempsalary;
	public static boolean in=false;
	
	/**
	 * Inserts a new element at the end of a String array
	 * 
	 * @param ar The original String array
	 * @param add The element to be added
	 * @return A new array with the added element
	 */
	public static String[] inserts(String[] ar, String add) {
		String[] temp = new String[ar.length+1];
		System.arraycopy(ar, 0, temp, 0, ar.length);
		temp[temp.length-1] = add;
		return temp;
	}
	
	/**
	 * Inserts a new element at the end of a double array
	 * 
	 * @param ar The original double array
	 * @param add The element to be added
	 * @return A new array with the added element
	 */
	public static double[] insertd(double[] ar, double add) {
		double[] temp = new double[ar.length+1];
		System.arraycopy(ar, 0, temp, 0, ar.length);
		temp[temp.length-1] = add;
		return temp;
	}
	
	/**
	 * Application entry point
	 * 
	 * @param args Command line arguments (not used)
	 */
	public static void main(String args[]){
		homepage();
	}
	
	/**
	 * Displays the main menu/homepage of the application
	 */
	public static void homepage(){
		System.out.println("          /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$");
		System.out.println("          |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
		System.out.println("           /$$| $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$");
		System.out.println("          | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$");
		System.out.println("          | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$");
		System.out.println("          | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$");
		System.out.println("          | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
		System.out.println("          |__/|__/      |__/  |__/|______/|________/|__/  \\__/|________/\n\n\n");
		System.out.println("   _____            _             _          ____                        _");
		System.out.println("  / ____|          | |           | |        / __ \\                      (_)");
		System.out.println(" | |     ___  _ __ | |_ __ _  ___| |_ ___  | |  | |_ __ __ _  __ _ _ __  _ _______ _ __");
		System.out.println(" | |    / _ \\| '_ \\| __/ _` |/ __| __/ __| | |  | | '__/ _` |/  ` | '  \\| |_  / _ \\ '__|");
		System.out.println(" | |___| (_) | | | | || |_| | |__| |_\\__ \\ | |__| | | | |_| | |_| | | | | |/ /  __/ |");
		System.out.println("  \\_____\\___/|_| |_|\\__\\__,_||___|\\__|___/  \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|");
		System.out.println("                                                        __/ |");
		System.out.println("                                                       |___/\n\n");
		System.out.println("============================================================================================\n\n");
		System.out.println("        [01] ADD Contacts\n");
		System.out.println("        [02] UPDATE Contacts\n");
		System.out.println("        [03] DELETE Contacts\n");
		System.out.println("        [04] SEARCH Contacts\n");
		System.out.println("        [05] LIST Contacts\n");
		System.out.println("        [06] Exit\n\n");
		homepageOpt();
	}
	
	/**
	 * Handles user selection from the main menu
	 */
	public static void homepageOpt(){
		System.out.print(" Enter an option to continue -> ");
		int opt=input.nextInt();
		switch (opt) {
			case 1 -> { clearConsole(); addContact(); }
			case 2 -> { clearConsole(); updateContact(); }
			case 3 -> { clearConsole(); deleteContact(); }
			case 4 -> { clearConsole(); searchContact(); }
			case 5 -> { clearConsole(); sortContact(); }
			case 6 -> System.exit(0);
			default -> {
				method="input option again";
				System.out.printf("\n%10sInvalid option selection...\n\n"," ");
				again(method);
			}
		}
	}
	
	/**
	 * Clears the console screen for better user experience
	 * Handles both Windows and Unix-based systems
	 */
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final InterruptedException e) {
			Thread.currentThread().interrupt();
			System.err.println("Console clear operation was interrupted");
		} catch (final java.io.IOException e) {
			System.err.println("Error clearing console: " + e.getMessage());
		}
	}
	
	/**
	 * Handles user confirmation for various operations
	 * Controls application workflow based on user's response
	 * 
	 * @param method The operation being performed
	 */
	public static void again(String method){
		System.out.printf(" Do you want to %s (Y/N): ",method);
		char yn=input.next().charAt(0);
		switch (yn) {
			case 'y', 'Y' -> {
				switch (method) {
					case "add another Contact" :
						clearConsole();
						addContact();
						break;
					case "input birthday again":
						System.out.print("\033[4A");
						System.out.print("\033[0J");
						dobCheck();
						break;
					case "add phone number again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						phoneCheck();
						break;
					case "input salary again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						salaryCheck();
						break;
					case "update another Contact":
						clearConsole();
						updateContact();
						break;
					case "input update option again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						updateOpt();
						break;
					case "input option again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						homepage();
						break;
					case "search another Contact":
						clearConsole();
						searchContact();
						break;
					case "delete another Contact":
						clearConsole();
						deleteContact();
						break;
					case "input sorting option again" :
						clearConsole();
						sortContact();
						break;
					case "delete this contact":
						System.out.printf("\n%9s Customer has been deleted Successfully...\n\n\n"," " );
						cusIDarr=removed(cusIDarr);
						namearr=removed(namearr);
						phonearr=removed(phonearr);
						Cnamearr=removed(Cnamearr);
						dobarr=removed(dobarr);
						salaryarr=removed(salaryarr);
						method="delete another Contact";
						again(method);
						break;
					default:
						clearConsole();
						homepage();
						break;
				}
			}
			case 'n', 'N' -> {
				switch (method) {
					case "go Home Page":
						clearConsole();
						sortContact();
						break;
					default:
						clearConsole();
						homepage();
						break;
				}
			}
			default -> {
				System.out.print("\033[4A");
				System.out.print("\033[0J");
				System.out.printf("\n%10sInvalid input...\n\n"," ");
				again(method);
			}
		}
	}
	
	/**
	 * Validates user input for date of birth in YYYY-MM-DD format
	 */
	public static void dobCheck(){
		method="input birthday again";
		System.out.print(" B'Day(YYYY-MM-DD): ");
		if (in==true){
			System.out.print("\033[1A");
			System.out.print("\033[0J");
		}
		input.nextLine();
		String dob=input.nextLine();
		if (dob.length()!=10 ){
			System.out.printf("\n%10sInvalid Birthday...\n"," ");
			again(method);
		}else {
			int year= Integer.parseInt(dob.substring(0,4));
			int month= Integer.parseInt(dob.substring(5,7));
			int date= Integer.parseInt(dob.substring(8,10));
			LocalDate currentDate = LocalDate.now();
			if ((currentDate.getYear()==year && currentDate.getMonthValue()==month && currentDate.getDayOfMonth()<date ) || year>2024 || year<=0 || month>12 || month<1 || ((year%4)!=0 && month==2 && (date>28 || date<=0 ) ) || ((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (date>31 || date<0)) || ((month==4 || month==6 || month==9 || month==11) && (date>30 || date<0)) || (month==2 && (date>29 || date<=0))){
				System.out.printf("\n%10sInvalid Birthday...\n"," ");
				again(method);
			}else {
				tempdob=dob;
			}
		}
	}		
	
	/**
	 * Validates phone number input - must be 10 digits and start with '0'
	 * Also checks for duplicate phone numbers
	 */
	public static void phoneCheck(){
		method="add phone number again";
		System.out.print(" Phone Number     : ");
		if (in==true){
			System.out.println();
			System.out.print("\033[1A");
			System.out.print("\033[0J");
			System.out.print("Input new phone number - ");
		}
		String phone=input.next();
		if ((phone.charAt(0)!='0' || phone.length()!=10)){
			System.out.printf("\n%10sInvalid phone number...\n\n"," ");
			again(method);
		}else if (search(phonearr,phone)!=-1){
			System.out.printf("\n%10sDuplicate phone number input...\n\n"," ");
			again(method);
		}else{
			tempphone=phone;
		}
	}
	
	/**
	 * Validates salary input - must be greater than zero
	 */
	public static void salaryCheck(){
		method="input salary again";
		System.out.print(" Salary           : ");
		if (in==true){
			System.out.println();
			System.out.print("\033[1A");
			System.out.print("\033[0J");
			System.out.print("Input new salary - ");
		}
		double salary=input.nextDouble();
		if (salary<=0){
			System.out.printf("\n%10sInvalid Salary...\n\n"," ");
			again(method);
		}else{
			tempsalary=salary;
		}	
	}
	
	/**
	 * Handles the contact addition process
	 * Collects and validates all required contact information
	 */
	public static void addContact(){
		input.nextLine();
		method="add another Contact";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |             Add Contact to the list                  |");
		System.out.println(" +------------------------------------------------------+\n\n");
		tempcusID=String.format("C%04d",cusID);
		System.out.printf("C%04d\n=======\n\n",cusID);
		System.out.print(" Name             : ");
		String name=input.nextLine();
		tempname=name;
		phoneCheck();
		input.nextLine();
		System.out.print(" Company Name     : ");
		String Cname=input.nextLine();
		tempCname=Cname;
		salaryCheck();
		dobCheck();
		System.out.printf("\n%9s Contact has been added Successfully...\n\n\n"," " );
		method="add another Contact";
		cusIDarr=inserts(cusIDarr,tempcusID);
        namearr=inserts(namearr,tempname);
        phonearr=inserts(phonearr,tempphone);
        Cnamearr=inserts(Cnamearr,tempCname);
        salaryarr=insertd(salaryarr,tempsalary);
        dobarr=inserts(dobarr,tempdob);
        cusID++;
        again(method);
	}
	
	/**
	 * Searches for an exact match in a String array
	 * 
	 * @param ar The array to search in
	 * @param name The value to search for
	 * @return Index of the first match, or -1 if not found
	 */
	public static int search(String[] ar, String name){
		for (int i = 0; i < ar.length; i++){
			if(name.toLowerCase().equals(ar[i].toLowerCase())){
				return i;
			}
		}
		return -1;
	 }
	
	/**
	 * Searches for an exact match in a String array, returning the last match position
	 * Used to check for multiple records with the same name
	 * 
	 * @param ar The array to search in
	 * @param name The value to search for
	 * @return Index of the last match, or -1 if not found
	 */
	public static int namesearch(String[] ar, String name){
		int place=-1;
		for (int i=0;i<ar.length;i++){
			if(name.toLowerCase().equals(ar[i].toLowerCase())){
				place=i;
			}
		}
		return place;
	}
	
	/**
	 * Displays contact details for the current index
	 */
	public static void printContact(){
		System.out.printf("%10sContact ID        : %s\n"," ",cusIDarr[index]);
		System.out.printf("%10sName              : %s\n"," ",namearr[index]);
		System.out.printf("%10sPhone Number      : %s\n"," ",phonearr[index]);
		System.out.printf("%10sCompany Name      : %s\n"," ",Cnamearr[index]);
		System.out.printf("%10sSalary            : %.1f\n"," ",salaryarr[index]);
		System.out.printf("%10sB'Day(YYYY-MM-DD) : %s\n\n"," ",dobarr[index]);
	}
	
	/**
	 * Handles the contact update options
	 */
	public static void updateOpt(){
		System.out.print(" Enter an option to continue -> ");
		int option=input.nextInt();
		in=true;
		switch (option) {
			case 1 -> {
				System.out.println("  Update Name \n =============\n");
				System.out.print("Input new name - ");
				input.nextLine();
				tempname=input.nextLine();
				namearr[index]=tempname;
				in=false;
			}
			case 2 -> {
				System.out.println("  Update Phone Number \n =====================\n");
				phoneCheck();
				phonearr[index]=tempphone;
				in=false;
			}
			case 3 -> {
				System.out.println("  Update Company Name \n =====================\n");
				System.out.print("Input new company name - ");
				input.nextLine();
				tempCname=input.nextLine();
				Cnamearr[index]=tempCname;
				in=false;
			}
			case 4 -> {
				System.out.println("  Update Salary \n ===============\n");
				salaryCheck();
				salaryarr[index]=tempsalary;
				in=false;
			}
			default -> {
				method="input update option again";
				System.out.printf("\n%10sInvalid option selection...\n\n"," ");
				again(method);
				in=false;
			}
		}
	}
	
	/**
	 * Common search functionality used by multiple operations
	 */
	public static void searchC(){
		input.nextLine();
		System.out.print("Search Contact by Name or Phone Number - ");
		String check=input.nextLine();
		if (namesearch(namearr,check)==search(namearr,check)){
			if (search(namearr,check)==-1 && search(phonearr,check)!=-1){
				index=search(phonearr,check);
			}else if (search(namearr,check)!=-1 && search(phonearr,check)==-1){
				index=search(namearr,check);
			}else{
				System.out.printf("\n%10sNo contact found for %s...\n\n"," ",check);
				again(method);
			}
			System.out.println("\n\n");
			printContact();
		}else{
			System.out.printf("\n%10sThere are more than one customer named %s. Try again by entering phone number.\n\n"," ",check);
				again(method);
		}
	}
	
	/**
	 * Handles the contact search process
	 */
	public static void searchContact(){
		method="search another Contact";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                SEARCH Contact                        |");
		System.out.println(" +------------------------------------------------------+\n\n");
		searchC();
		again(method);
	}
	
	/**
	 * Removes an element from a String array at the current index
	 * 
	 * @param ar The array to modify
	 * @return A new array with the element removed
	 */
	public static String[] removed(String[] ar){
		String[] temp = new String[ar.length-1];
		System.arraycopy(ar, 0, temp, 0, index);
		System.arraycopy(ar, index+1, temp, index, temp.length-index);
		return temp;
	}
	
	/**
	 * Removes an element from a double array at the current index
	 * 
	 * @param ar The array to modify
	 * @return A new array with the element removed
	 */
	public static double[] removed(double[] ar){
		double[] temp = new double[ar.length-1];
		System.arraycopy(ar, 0, temp, 0, index);
		System.arraycopy(ar, index+1, temp, index, temp.length-index);
		return temp;
	}
	
	/**
	 * Handles the contact deletion process
	 */
	public static void deleteContact(){
		method="delete another Contact";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                DELETE Contact                        |");
		System.out.println(" +------------------------------------------------------+\n\n");
		searchC();
		method="delete this contact";
		again(method);
	}
	
	/**
	 * Handles the contact update process
	 */
	public static void updateContact(){
		method="update another Contact";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                UPDATE Contact                        |");
		System.out.println(" +------------------------------------------------------+\n\n");
		searchC();
		System.out.println(" What do you want update...\n");
		System.out.printf("%10s[01] Name\n"," ");
		System.out.printf("%10s[02] Phone Number\n"," ");
		System.out.printf("%10s[03] Company Name\n"," ");
		System.out.printf("%10s[04] Salary\n\n"," ");
		updateOpt();
		method="update another Contact";
		in=false;
		System.out.printf("\n%9s Contact has been updated Successfully...\n\n\n"," " );
		again(method);
	}
	
	/**
	 * Displays all contacts in a formatted table
	 */
	public static void printSort(){
		System.out.println("+-------------------------------------------------------------------------------------------------+");
		System.out.println("| Contact ID |       Name       | Phone Number |     Company     |     Salary     |    Birthday   |");
		System.out.println("+-------------------------------------------------------------------------------------------------+");
		for (int i = 0; i < cusIDarr.length; i++)
		{
			System.out.printf("| %-10s | %-16s |  %s  | %-15s |  %-12.1f  |   %s  |\n",cusIDarr[i],namearr[i],phonearr[i],Cnamearr[i],salaryarr[i],dobarr[i]);
		}
		System.out.println("+-------------------------------------------------------------------------------------------------+\n\n");
		
		
	}
	
	/**
	 * Handles contact sorting options
	 */
	public static void sortContact(){
		method="input sorting option again";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                    SORT Contact                      |");
		System.out.println(" +------------------------------------------------------+\n\n");
		System.out.printf("\n%10s[01] Sorting by Name\n\n"," ");
		System.out.printf("%10s[02] Sorting by Salary\n\n"," ");
		System.out.printf("%10s[03] Sorting by Birthday\n\n"," ");
		System.out.print(" Enter an option to continue -> ");
		int opt=input.nextInt();
		switch (opt) {
			case 1 -> { clearConsole(); nameSort(); }
			case 2 -> { clearConsole(); salarySort(); }
			case 3 -> { clearConsole(); dobSort(); }
			default -> {
				System.out.printf("\n%10sInvalid option input...\n\n"," ");
				again(method);
			}
		}
	}
	
	/**
	 * Swaps two contact records for sorting purposes
	 * 
	 * @param i First record index
	 * @param j Second record index
	 */
	public static void sort(int i,int j){
		double tempd=salaryarr[i];
		salaryarr[i]=salaryarr[j];
		salaryarr[j]=tempd;
		String temps=namearr[i];
		namearr[i]=namearr[j];
		namearr[j]=temps;
		temps=phonearr[i];
		phonearr[i]=phonearr[j];
		phonearr[j]=temps;
		temps=Cnamearr[i];
		Cnamearr[i]=Cnamearr[j];
		Cnamearr[j]=temps;
		temps=dobarr[i];
		dobarr[i]=dobarr[j];
		dobarr[j]=temps;
		temps=cusIDarr[i];
		cusIDarr[i]=cusIDarr[j];
		cusIDarr[j]=temps;
	}
	
	/**
	 * Sorts contacts by their customer ID
	 */
	public static void cusIDSort(){
		for (int i = 1; i < cusIDarr.length; i++){
			for(int j=0; j<i; j++){
				if(Integer.parseInt(cusIDarr[i].substring(1,cusIDarr[i].length()))<Integer.parseInt(cusIDarr[j].substring(1,cusIDarr[j].length()))){
					sort(i,j);
				}
			}
		}
	}
	
	/**
	 * Sorts contacts alphabetically by name
	 */
	public static void nameSort(){
		System.out.printf("%8s+------------------------------------------------------+\n"," ");
		System.out.printf("%8s|              List Contact by Name                    |\n"," ");
		System.out.printf("%8s+------------------------------------------------------+\n\n\n\n"," ");
		method="go Home Page";
		int len=0;
		for (int i = 1; i < namearr.length; i++) {
			for(int j=0; j<i; j++) {
				if (namearr[i].length() > namearr[j].length()) {
					len = namearr[j].length();
				} else {
					len = namearr[i].length();
				}
				
				boolean shouldContinueOuter = false;
				for (int k = 0; k < len; k++) {
					if(namearr[i].toLowerCase().charAt(k) < namearr[j].toLowerCase().charAt(k)) {
						sort(i,j);
						shouldContinueOuter = true;
						break;
					} else if(namearr[i].toLowerCase().charAt(k) == namearr[j].toLowerCase().charAt(k)) {
						continue;
					} else {
						break;
					}
				}
				
				if (shouldContinueOuter) {
					continue;
				}
			}
		}
		printSort();
		cusIDSort();
		again(method);
	}
	
	/**
	 * Sorts contacts by salary (ascending order)
	 */
	public static void salarySort(){
		System.out.printf("%8s+------------------------------------------------------+\n"," ");
		System.out.printf("%8s|              List Contact by Salary                  |\n"," ");
		System.out.printf("%8s+------------------------------------------------------+\n\n\n"," ");
		for (int i = 1; i < salaryarr.length; i++){
			for(int j=0; j<i; j++){
				if(salaryarr[i]<salaryarr[j]){
					sort(i,j);
				}
			}
		}
		method="go Home Page";
		printSort();
		cusIDSort();
		again(method);
	}
	
	/**
	 * Sorts contacts by date of birth (chronological order)
	 */
	public static void dobSort(){
		System.out.printf("%8s+------------------------------------------------------+\n"," ");
		System.out.printf("%8s|            List Contact by Birthday                  |\n"," ");
		System.out.printf("%8s+------------------------------------------------------+\n\n\n\n"," ");
		method="go Home Page";
		for (int i = 1; i < cusIDarr.length; i++){
			for(int j=0; j<i; j++){
				String dobs1=dobarr[i].substring(0,4)+dobarr[i].substring(5,7)+dobarr[i].substring(8,10);
				int dobi1=Integer.parseInt(dobs1);
				String dobs2=dobarr[j].substring(0,4)+dobarr[j].substring(5,7)+dobarr[j].substring(8,10);
				int dobi2=Integer.parseInt(dobs2);
				if(dobi1<dobi2){
					sort(i,j);
				}
			}
		}
		printSort();
		cusIDSort();
		again(method);
	}
}
