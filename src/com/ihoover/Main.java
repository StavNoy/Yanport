package com.ihoover;

public class Main {
    public static void main(String[] args) {
        String[][] uses = new String[][]{
            args,
            // example: new String[]{"10", "10", "5", "5", "N", "ADAGGA"}
        };

        for (String[] use : uses) {
            launch(use);
        }
    }

    private static void launch(String[] args) {
        if (args.length < 6) {
            printUse();
            return;
        }

        int totalX;
        int totalY;
        int startX;
        int startY;
        char startDirection;

        try {
            totalX = Integer.parseInt(args[0]);
            totalY = Integer.parseInt(args[1]);
            startX = Integer.parseInt(args[2]);
            startY = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            printUse();
            return;
        }

        for (int i : new int[]{totalX, totalY, startX, startY}) {
            if (i < 0) {
                printUse();
                return;
            }
        }

        String directionString = args[4].toUpperCase();
        switch (directionString) {
            case "N":
            case "E":
            case "S":
            case "W":
                startDirection = directionString.charAt(0);
                break;
            default:
                printUse();
                return;
        }

        String instructions = args[5].toUpperCase();

        if (instructions.matches("[^NESW]")) {
            printUse();
            return;
        }

        System.out.println(
            new Vacuum(totalX, totalY, startX, startY, startDirection)
                .calc(instructions)
        );
    }

    private static void printUse() {
        System.out.println(
            "Use: grid-x grid-y start-x start-y start-direction instructions"
        );
        System.out.println("Example: 10 10 0 0 N ADAGGA");
    }
}
