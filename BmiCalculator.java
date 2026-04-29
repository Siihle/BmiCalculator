import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		char repeat = 0;
		
		do{
			
			System.out.println("******************************************\n");
			System.out.println("====== ENTER YOUR PRERSONAL DETAILS ======\n");
			System.out.println("******************************************");
			System.out.print("Enter your first name: ");
			String firstname = scanner.nextLine();
			System.out.print("Enter your last name: ");
			String lastname = scanner.nextLine();
			System.out.print("Enter your age: ");
			int age = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Enter your gender: ");
			String gender = scanner.nextLine();
			System.out.println("******************************************");
		
			int unitChoice = getUnitChoice(scanner);
			
			double weight = (unitChoice == 1)? getValidInput(scanner, "Enter your weight in kilograms: ", 10, 1600)
					: getValidInput(scanner, "Enter your weight in pounds", 22, 1300);
					
			double height = (unitChoice == 1)? getValidInput(scanner, "Enter your height in meters: ", 0.5, 2.5)
					:getValidInput(scanner, "Enter your weight in inches", 20, 100);
					
			double bmi = calculateBMI(unitChoice, weight, height);
			System.out.printf("BMI is %.2f\n", bmi);
			
			//repeat = askToRepeat(scanner);
			
			if(bmi < 18.5){
				System.out.println("Underweight");
			}
			else if(bmi < 25){
				System.out.println("Normal weight ");
			}
			else if(bmi < 30){
				System.out.println("Overweight");
			}
			else if(bmi < 35){
				System.out.println("Obese");
			}
			else if(bmi >= 35){
				System.out.println("Severely obese");
			}
			
			System.out.println("******************************************");
			System.out.println("******************************************\n");
			System.out.println("============== YOUR DETAILS ==============\n");
			System.out.println("******************************************");
			System.out.println("Names: " + firstname + " " + lastname);
			System.out.println("Age : " + age);
			System.out.println("Gender: " + gender);
			System.out.println("Weight: " + weight);
			System.out.println("Height: " + height);
			System.out.printf("BMI is %.2f\n", bmi);
			System.out.println("******************************************");
			
			System.out.print("Do you want to repeat (Y or N): ");
			repeat = scanner.next().charAt(0);
			System.out.println("******************************************");
		}while(repeat == 'Y' || repeat == 'y');
		
		System.out.println("******************************************\n");
		System.out.println("THANK YOU FOR USING MY CALCULATOR. GOODBYE!\n");
		System.out.println("******************************************");
	}
	
	public static int getUnitChoice(Scanner scanner){
		int choice;
		
		while(true){
			System.out.println("******************************************\n");
			System.out.println("############# BMI CALCULATOR #############\n");
			System.out.println("******************************************");
			System.out.println("Select a preferred unit:\n" 
					+ "1. Metric (kg, m)\n"
					+ "2. Imperial (1bs, in)\n"
					+ "Please select either option 1 or option 2");
					
			if(scanner.hasNextInt()){
				choice = scanner.nextInt();
				if(choice == 1 || choice == 2){
					break;
				} else{
					System.out.println("Invalid choice. Please enter either 1 or 2");
				}
			} else{
				System.out.println("Invalid input. Please enter a number(1 or 2)");
				scanner.next();
			}
			System.out.println("******************************************");
		}
		
		return choice;
	}
	
	public static double getValidInput(Scanner scanner, String prompt, double min, double max){
		double value;
		
		while(true){
			System.out.println(prompt);
			
			if(scanner.hasNextDouble()){
				value = scanner.nextDouble();
				if(value >= min && value <= max){
					break;
				}else{
					System.out.printf("Please enter a value between %.f and %.1f.\n", min, max);
				}
			}else{
				System.out.println("Invalid input. Please enter a value");
				scanner.next();
			}
		}
		return value;
	}
	
	public static double calculateBMI(int unitChoice, double weight, double height){
		double totalBMI;
		
		if(unitChoice == 1){
			totalBMI = weight / (height * height);
		} else {
			totalBMI = (703 * weight) / (height / height);
		}
		
		return totalBMI;
	}
}

//System.out.println("Welcome Mr " + firstname.charAt(0) + " " + lastname);