import java.time.*;
import java.util.*;
class iFriend{
	public static Scanner input=new Scanner(System.in);
	public static int cusID =1,index=0;
	public static String[] cusIDarr=new String[0],namearr=new String[0],phonearr=new String[0],Cnamearr=new String[0],dobarr=new String[0];
	public static double[] salaryarr=new double[0];
	public static String method,tempphone,tempname,tempCname,tempcusID,tempdob;
	public static double tempsalary;
	public static boolean in=false;
	
	public static String[]  inserts(String[] ar,String add){
		String[] temp=new String[ar.length+1];
		for (int i=0;i<ar.length;i++){
			temp[i]=ar[i];
		}
		temp[temp.length-1]=add;
		return temp;
	}
	public static double[]  insertd(double[] ar,double  add){
		double[] temp=new double[ar.length+1];
		for (int i=0;i<ar.length;i++){
			temp[i]=ar[i];
		}
		temp[temp.length-1]=add;
		return temp;
	}
	public static void main(String args[]){
		homepage();
	}
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
		homepageopt();
	}
	public static void homepageopt(){
		System.out.print(" Enter an otion to continue -> ");
		int opt=input.nextInt();
		switch (opt){
			case 1: clearConsole(); addcontact();break;
			case 2: clearConsole(); updatecontact();break;
			case 3: clearConsole(); deleteContact();break;
			case 4: clearConsole(); searchContact();break;
			case 5: clearConsole(); sortContact();break;
			case 6: System.exit(0);break;
			default:
				method="input option again";
				System.out.printf("\n%10sInvalid phone number...\n\n"," ");
				again(method);
				break;
		}
	}
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	public static void again(String method){
		System.out.printf(" Do you want to %s (Y/N): ",method);
		char yn=input.next().charAt(0);
		switch (yn){
			case 'y':
			case 'Y':
				switch (method){
					case "add another Contact" :
						clearConsole();
						addcontact();
						break;
					case "input birthday again":
						System.out.print("\033[4A");
						System.out.print("\033[0J");
						dobcheck();
						break;
					case "add phone number again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						phonecheck();
						break;
					case "input salary again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						salarycheck();
						break;
					case "update another Contact":
						clearConsole();
						updatecontact();
						break;
					case "input update option again":
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						updateopt();
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
				break;
			case 'n':
			case 'N':
				switch (method){
					case "go Home Page":
						clearConsole();sortContact();break;
					default:
						clearConsole();
						homepage();
						break;
				}
			default:
				System.out.print("\033[4A");
				System.out.print("\033[0J");
				System.out.printf("\n%10sInvalid input...\n\n"," ");
				again(method);
				break;
		}
	}
	public static void dobcheck(){
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
	public static void phonecheck(){
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
	public static void salarycheck(){
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
	public static void addcontact(){
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
		phonecheck();
		input.nextLine();
		System.out.print(" Company Name     : ");
		String Cname=input.nextLine();
		tempCname=Cname;
		salarycheck();
		dobcheck();
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
	public static int search(String[] ar, String name){
		for (int i = 0; i < ar.length; i++){
			if(name.toLowerCase().equals(ar[i].toLowerCase())){
				return i;
			}
		}
		return -1;
	 }
	public static int namesearch(String[] ar, String name){
		int place=-1;
		for (int i=0;i<ar.length;i++){
			if(name.toLowerCase().equals(ar[i].toLowerCase())){
				place=i;
			}
		}
		return place;
	}
	public static void printContact(){
		System.out.printf("%10sContact ID        : %s\n"," ",cusIDarr[index]);
		System.out.printf("%10sName              : %s\n"," ",namearr[index]);
		System.out.printf("%10sPhone Number      : %s\n"," ",phonearr[index]);
		System.out.printf("%10sCompany Name      : %s\n"," ",Cnamearr[index]);
		System.out.printf("%10sSalary            : %.1f\n"," ",salaryarr[index]);
		System.out.printf("%10sB'Day(YYYY-MM-DD) : %s\n\n"," ",dobarr[index]);
	}
	public static void updateopt(){
		System.out.print(" Enter an option to continue -> ");
		int option=input.nextInt();
		in=true;
		switch (option) {
			case 1:
				System.out.println("  Update Name \n =============\n");
				System.out.print("Input new name - ");
				input.nextLine();
				tempname=input.nextLine();
				namearr[index]=tempname;
				in=false;
				break;
			case 2:
				System.out.println("  Update Phone Number \n =====================\n");
				phonecheck();
				phonearr[index]=tempphone;
				in=false;
				break;
			case 3:
				System.out.println("  Update Company Name \n =====================\n");
				System.out.print("Input new company name - ");
				input.nextLine();
				tempCname=input.nextLine();
				Cnamearr[index]=tempCname;
				in=false;
				break;
			case 4:
				System.out.println("  Update Salary \n ===============\n");
				salarycheck();
				salaryarr[index]=tempsalary;
				in=false;
				break;
			default:
				method="input update option again";
				System.out.printf("\n%10sInvalid phone number...\n\n"," ");
				again(method);
				in=false;
				break;
		}
	}
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
	public static void searchContact(){
		method="search another Contact";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                SEARCH Contact                        |");
		System.out.println(" +------------------------------------------------------+\n\n");
		searchC();
		again(method);
	}
	public static String[] removed(String[] ar){
		String[] temp=new String[ar.length-1];
		for (int i=0;i<index;i++){
			temp[i]=ar[i];
		}
		for (int i=index;i<temp.length;i++){
			temp[i]=ar[i+1];
		}
		return temp;
	}
	public static double[] removed(double[] ar){
		double[] temp=new double[ar.length-1];
		for (int i=0;i<index;i++){
			temp[i]=ar[i];
		}
		for (int i=index;i<temp.length;i++){
			temp[i]=ar[i+1];
		}
		return temp;
	}
	public static void deleteContact(){
		method="delete another Contact";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                DELETE Contact                        |");
		System.out.println(" +------------------------------------------------------+\n\n");
		searchC();
		method="delete this contact";
		again(method);
	}
	public static void updatecontact(){
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
		updateopt();
		method="update another Contact";
		in=false;
		System.out.printf("\n%9s Contact has been added Successfully...\n\n\n"," " );
		again(method);
	}
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
	public static void sortContact(){
		method="input sorting option again";
		System.out.println(" +------------------------------------------------------+");
		System.out.println(" |                    SORT Contact                      |");
		System.out.println(" +------------------------------------------------------+\n\n");
		System.out.printf("\n%10s[01] Sorting by Name\n\n"," ");
		System.out.printf("%10s[02] Sorting by Salary\n\n"," ");
		System.out.printf("%10s[03] Sorting by Birthday\n\n"," ");
		System.out.print(" Enter an otion to continue -> ");
		int opt=input.nextInt();
		switch (opt){
			case 1: clearConsole(); nameSort();break;
			case 2: clearConsole(); salarySort();break;
			case 3: clearConsole(); dobSort();break;
			default:
				System.out.printf("\n%10sInvalid option input...\n\n"," ");
				again(method);
				break;
		}
	}
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
	public static void cusIDSort(){
		for (int i = 1; i < cusIDarr.length; i++){
			for(int j=0; j<i; j++){
				if(Integer.parseInt(cusIDarr[i].substring(1,cusIDarr[i].length()))<Integer.parseInt(cusIDarr[j].substring(1,cusIDarr[j].length()))){
					sort(i,j);
				}
			}
		}
	}
	public static void nameSort(){
		System.out.printf("%8s+------------------------------------------------------+\n"," ");
		System.out.printf("%8s|              List Contact by Name                    |\n"," ");
		System.out.printf("%8s+------------------------------------------------------+\n\n\n\n"," ");
		method="go Home Page";
		int len=0;
		do{
				for (int i = 1; i < namearr.length; i++){
				L2:for(int j=0; j<i; j++){
					if (namearr[i].length()>namearr[j].length()){
						len=namearr[j].length();
					}else{
						len=namearr[i].length();
					}
					L1:for (int k = 0; k < len; k++)
					{
						if(namearr[i].toLowerCase().charAt(k)<namearr[j].toLowerCase().charAt(k)){
							sort(i,j);
							continue L2;
						}else if(namearr[i].toLowerCase().charAt(k)==namearr[j].toLowerCase().charAt(k)) {
							continue L1;
						}else{
							break L1;
						}
					}
				}
			}
			break;
		}while(true);
		printSort();
		cusIDSort();
		again(method);
	}
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
