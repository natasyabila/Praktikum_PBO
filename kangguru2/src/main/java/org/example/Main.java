package org.example;

class AnimalFace {
    // Fields
    private final String eyes;
    private String nose;
    private String mouth;
    private String ears;
    private String furColor;

    // Constructor
    public AnimalFace(String eyes, String nose, String mouth, String ears, String furColor) {
        this.eyes = eyes;
        this.nose = nose;
        this.mouth = mouth;
        this.ears = ears;
        this.furColor = furColor;
    }

    // Method 1
    public void displayFace() {
        System.out.println("Kangguru Face:");
        System.out.println("  \\     /");
        System.out.println("   .---.");
        System.out.println("  |  _  |");
        System.out.println("  | "  + "    |");
        System.out.println("    \\-/");

        System.out.println("Nose: " + nose);
        System.out.println("Mouth: " + mouth);
        System.out.println("Ears: " + ears);
        System.out.println("Fur Color: " + furColor);
    }

    // Method 2
    public void makeSound() {
        System.out.println("Animal is making a sound!");
    }

    public static void main(String[] args) {
        // Example usage
        AnimalFace animalFace = new AnimalFace("Round eyes", "Small nose", "Wide mouth", "Pointy ears", "Furry");

        // Display the animal face details
        animalFace.displayFace();

        // Make the animal sound
        animalFace.makeSound();
    }
}