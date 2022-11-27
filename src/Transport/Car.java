package Transport;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Car {
    private final String brand;
    private final String model;
    private final int productionYear;
    private final String productionCountry;
    private final String carBodyType;
    private final int numberOfSeats;
    private double engineVolume;
    private String color;
    private String transmission;
    private String registrationNumber;
    private static String seasonalTire;
    private String сhangingTires_Y_N;

    private Key key;
    private Insurance insurance;


    public class Key {
        private String remoteEngineStart;
        private String keylessAccess;

        public Key(String remoteEngineStart, String keylessAccess) {
            this.remoteEngineStart = validateCorrectData(remoteEngineStart);
            this.keylessAccess = validateCorrectData(keylessAccess);
        }

        public String getRemoteEngineStart() {
            return remoteEngineStart;
        }

        public void setRemoteEngineStart(String remoteEngineStart) {
            this.remoteEngineStart = validateCorrectData(remoteEngineStart);
        }

        public String getKeylessAccess() {
            return keylessAccess;
        }

        public void setKeylessAccess(String keylessAccess) {
            this.keylessAccess = validateCorrectData(keylessAccess);
        }

        public String validateCorrectData(String value) {
            return value == null || value.isBlank() || value.isEmpty() ? "Введите корректные данные" : value;
        }
    }

    public class Insurance {

        private final LocalDate insuranceValidityPeriod;
        private final double costOfInsurance;
        private final String insuranceNumber;

        public Insurance(LocalDate insuranceValidityPeriod, double costOfInsurance, String insuranceNumber) {
            this.insuranceValidityPeriod = checkDuration (insuranceValidityPeriod);
            this.costOfInsurance = validateCostOfInsurance(costOfInsurance);
            this.insuranceNumber = validateInsuranceNumber(insuranceNumber) ? insuranceNumber: "Номер страховки не корректный";
        }

        public double validateCostOfInsurance(double value) {
            return value <= 0 ? 1000 : value;
        }

        private boolean validateInsuranceNumber(String value) {
            if (Pattern.matches("[а-яА-Яa-zA-Z0-9]{9}",value)){
                return true;
            } else {
                System.out.println("Номер страховки корректный");
                return false;
            }
        }

        public LocalDate checkDuration (LocalDate insuranceValidityPeriod) {
            if (LocalDate.now().isAfter(insuranceValidityPeriod)) {
                System.out.println("Нужно срочно ехать оформлять новую страховку");
                return LocalDate.now();
            }else {
                return insuranceValidityPeriod;
            }
        }


    }


    public Car(String brand, String model, double engineVolume, String color, int productionYear, String productionCountry,
               String transmission, String carBodyType, int numberOfSeats, String seasonalTire, String registrationNumber,
               String сhangingTires_Y_N) {

        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateColor(color);
        this.transmission = validateTransmission(transmission);
        this.seasonalTire = validateSeasonalTire(seasonalTire);
        this.brand = validateDefault(brand);
        this.model = validateDefault(model);
        this.productionCountry = validateDefault(productionCountry);
        this.productionYear = validateYear(productionYear);
        this.carBodyType = validateBodyType(carBodyType);
        this.numberOfSeats = validateNum(numberOfSeats);
        this.сhangingTires_Y_N = сhangingTires_Y_N;
        setRegistrationNumber(registrationNumber);
    }

    // region getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getCarBodyType() {
        return carBodyType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getColor() {
        return color;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public static String getSeasonalTire() {
        return seasonalTire;
    }

    public String getСhangingTires_Y_N() {
        return сhangingTires_Y_N;
    }

    public Key getKey() {
        return key;
    }

    public Insurance getInsurance() {
        return insurance;
    }
    //endregion

    // region setters

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = validateEngineVolume(engineVolume);
    }

    public void setColor(String color) {
        this.color = validateColor(color);
    }

    public void setTransmission(String transmission) {
        this.transmission = validateTransmission(transmission);
    }

    public void setSeasonalTire(String seasonalTire) {
        this.seasonalTire = validateSeasonalTire(seasonalTire);
    }

    public void setRegistrationNumber(String registrationNumber) {

        String correctNumber = registrationNumber.toLowerCase(); // (х000хх000)
        correctNumber = correctNumber.replace(" ", "");

        if (correctNumber == null || correctNumber.isBlank() || correctNumber.isEmpty()) {
            this.registrationNumber = "отсутствует";
        } else if (Pattern.matches("^[АВЕКМНОРСТУХавекмнорстух]{1}[0-9]{3}[АВЕКМНОРСТУХавекмнорстух]{2}[0-9]{3}", correctNumber) == true) {
            this.registrationNumber = correctNumber;
        } else if (Pattern.matches("^[АВЕКМНОРСТУХавекмнорстух]{1}[0-9]{3}[АВЕКМНОРСТУХавекмнорстух]{2}[0-9]{3}", correctNumber) == false) {
            this.registrationNumber = "введен не корректно (Таких номеров не существует)";
        } else {
            this.registrationNumber = correctNumber;
        }
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    //endregion

    // region validation


    public static String validateChangingTires(String value) {
        if (value == "Y") {
            if (seasonalTire == null || seasonalTire.isBlank() || seasonalTire.isEmpty() || getSeasonalTire().equals("Лысая")) {
                value = " Установили сезонную резину";
            }
            if (getSeasonalTire() == "Зимняя" || getSeasonalTire() == "Зима" || getSeasonalTire() == "Winter") {
                if (LocalDate.now().getMonthValue() >= 5 && LocalDate.now().getMonthValue() <= 9) {
                    value = " Установили летнюю резину";
                } else {
                    value = "Резина установлена по сезону и не требует замены";
                }
            } else if (getSeasonalTire() == "Летняя" || getSeasonalTire() == "Лето" || getSeasonalTire() == "Summer") {
                if (LocalDate.now().getMonthValue() <= 5 || LocalDate.now().getMonthValue() >= 9) {
                    value = " Установили зимнюю резину";
                } else {
                    value = "Резина установлена по сезону и не требует замены";
                }
            }
        } else {
            value = "";
        }
        return value;
    }

    public static double validateEngineVolume(double value) {
        return value <= 0 ? 1.5 : value;
    }

    public static String validateColor(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "Белый" : value;
    }

    public static String validateTransmission(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "Снята" : value;
    }

    public static String validateBodyType(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "Седан" : value;
    }

    public static String validateDefault(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "default" : value;
    }

    public static String validateSeasonalTire(String value) {
        return value == null || value.isBlank() || value.isEmpty() ? "Лысая" : value;
    }

    public static Integer validateNum(Integer value) {
        return value == null || value < 0 ? 0 : value;
    }

    public static Integer validateYear(Integer value) {
        return value == null || value < 0 ? 2000 : value;
    }
//endregion


    @Override
    public String toString() {
        return "Автомобиль : " + getBrand() + "  " + getModel() + ", " + getProductionYear() + " года выпуска, сборка: "
                + getProductionCountry() + ". " + getColor() + " цвет, объем двигателя - " + getEngineVolume() + " л., коробка передач: "
                + getTransmission() + ", тип кузова: " + getCarBodyType() + ", мест: " + getNumberOfSeats() + ", резина: " + getSeasonalTire() +
                ". ГРЗ: " + getRegistrationNumber() + ". " + validateChangingTires(getСhangingTires_Y_N());
    }
}


