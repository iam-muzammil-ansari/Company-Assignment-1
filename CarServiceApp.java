import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CarService {
    private String carType;
    private List<String> serviceCodes;

    public CarService(String carType, List<String> serviceCodes) {
        this.carType = carType;
        this.serviceCodes = serviceCodes;
    }

    public String getCarType() {
        return carType;
    }

    public List<String> getServiceCodes() {
        return serviceCodes;
    }
}

class ServiceStation {
    private Map<String, Integer> servicePrices;

    public ServiceStation() {
        servicePrices = new HashMap<>();
        // Initialize service prices for different car types
        servicePrices.put("BS01H", 2000); // Basic Servicing for Hatchback
        servicePrices.put("BS01S", 4000); // Basic Servicing for Sedan
        servicePrices.put("BS01U", 5000); // Basic Servicing for SUV
        servicePrices.put("EF01H", 5000); // Engine Fixing for Hatchback
        servicePrices.put("EF01S", 8000); // Engine Fixing for Sedan
        servicePrices.put("EF01U", 10000); // Engine Fixing for SUV
        servicePrices.put("CF01H", 2000); // Clutch Fixing for Hatchback
        servicePrices.put("CF01S", 4000); // Clutch Fixing for Sedan
        servicePrices.put("CF01U", 6000); // Clutch Fixing for SUV
        servicePrices.put("BF01H", 1000); // Brake Fixing for Hatchback
        servicePrices.put("BF01S", 1500); // Brake Fixing for Sedan
        servicePrices.put("BF01U", 2500); // Brake Fixing for SUV
        servicePrices.put("GF01H", 3000); // Gear Fixing for Hatchback
        servicePrices.put("GF01S", 6000); // Gear Fixing for Sedan
        servicePrices.put("GF01U", 8000); // Gear Fixing for SUV
    }

    public int calculateTotalBill(CarService carService) {
        int totalBill = 0;

        for (String serviceCode : carService.getServiceCodes()) {
            String key = serviceCode + carService.getCarType().charAt(0);
            if (servicePrices.containsKey(key)) {
                totalBill += servicePrices.get(key);
            }
        }

        return totalBill;
    }

    public boolean provideComplimentaryCleaning(int totalBill) {
        return totalBill > 10000;
    }
}

public class CarServiceApp {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Create a car service station
        ServiceStation serviceStation = new ServiceStation();

        // Get the car type from the user
        System.out.println("Enter the car type: ");
        String carType = scanner.nextLine();

        // Get the service codes from the user
        System.out.println("Enter the service codes: ");
        String serviceCodes = scanner.nextLine();

        // Create a car service request
        CarService carService = new CarService(carType, List.of(serviceCodes.split(" ")));

        // Calculate the total bill
        int totalBill = serviceStation.calculateTotalBill(carService);

        // Check if complimentary cleaning is provided
        boolean complimentaryCleaning = serviceStation.provideComplimentaryCleaning(totalBill);

        // Display the bill
        System.out.println("Type of Car: " + carService.getCarType());
        System.out.println("Service Codes: " + carService.getServiceCodes());
        System.out.println("Total Bill: ₹" + totalBill);

        if (complimentaryCleaning) {
            System.out.println("Complimentary Cleaning Provided.");
        }
    }
}
