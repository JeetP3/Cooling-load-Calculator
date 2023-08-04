import java.util.Scanner;

public class CoolingLoadCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter area of the building (in square meters): ");
        double area = scanner.nextDouble();

        System.out.print("Enter number of occupants in the building: ");
        int numOccupants = scanner.nextInt();

        System.out.print("Enter type of building (residential, commercial, etc.): ");
        scanner.nextLine(); // Consume the newline character
        String buildingType = scanner.nextLine();

        System.out.print("Enter outdoor temperature (in Celsius): ");
        double outdoorTemp = scanner.nextDouble();

        System.out.print("Enter indoor desired temperature (in Celsius): ");
        double indoorTemp = scanner.nextDouble();

        double coolingLoad;
        if (buildingType.equalsIgnoreCase("residential")) 
        {
            coolingLoad = 100 * numOccupants;
        } 
        else if (buildingType.equalsIgnoreCase("commercial")) 
        {
            coolingLoad = 150 * numOccupants;
        } else 
        {
            System.out.println("Invalid building type. Using default cooling load of 0.");
            coolingLoad = 0;
        }

        double u = 30; // Overall heat transfer coefficient in W/m²°C
        double qConduction = u * area * (outdoorTemp - indoorTemp);
        double sensibleCoolingLoad = qConduction + coolingLoad;

        System.out.println("Cooling Load Calculation:");
        System.out.println("Cooling Load: " + coolingLoad + " W");
        System.out.println("Heat Transfer due to Conduction: " + qConduction + " W");
        System.out.println("Sensible Cooling Load: " + sensibleCoolingLoad + " W");

        scanner.close();
    }
}
