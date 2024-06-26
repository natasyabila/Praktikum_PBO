package org.example;
class Bird {
    // Fields
    private String eyes;
    private String beak;
    private String feathers;
    private String ears;
    private String color;

    // Constructor
    public Bird(String eyes, String beak, String feathers, String ears, String color) {
        this.eyes = eyes;
        this.beak = beak;
        this.feathers = feathers;
        this.ears = ears;
        this.color = color;
    }

    // Method 1
    public void displayFace() {
        System.out.println("Bird:");
        System.out.println("   __  __");
        System.out.println("  ( " + eyes + " " + eyes + " )");
        System.out.println("   \\ - /");
        System.out.println("   | | |");
        System.out.println("   | | |");
        System.out.println("  / |_| \\");
        System.out.println("    |_|");

        System.out.println("Beak: " + beak);
        System.out.println("Feathers: " + feathers);
        System.out.println("Ears: " + ears);
        System.out.println("Color: " + color);
    }

    // Method 2
    public void hoot() {
        System.out.println("Bird is hooting!");
    }

    public static void main(String[] args) {
        // Example usage
        Bird bird = new Bird("o", "Sharp", "Soft and fluffy", "Pointed", "Brown");
        bird.displayFace();

        bird.hoot();
    }
}