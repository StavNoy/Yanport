package com.ihoover;

public class Vacuum {
    private static final String directions = "NESW";

    private final int maxX;
    private final int maxY;

    private int x;
    private int y;
    private int dirI;

    public Vacuum(int totalX, int totalY, int x, int y, char direction) {
        this.maxX = totalX - 1;
        this.maxY = totalY - 1;
        this.x = x;
        this.y = y;
        this.dirI = directions.indexOf(direction);
    }

    String calc(String instructions) {
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'A':
                    move();
                    break;
                case 'D':
                    pivotR();
                    break;
                case 'G':
                    pivotL();
            }
        }

        return "x: " + x + " y: " + y + " direction: " + directions.charAt(dirI);
    }

    void move() {
        switch (directions.charAt(dirI)) {
            case 'N':
                if (y < maxY) {
                    y++;
                }
                return;
            case 'S':
                if (y > 0) {
                    y--;
                }
                return;
            case 'E':
                if (x + 1 < maxX) {
                    x++;
                }
                return;
            case 'W':
                if (x > 0) {
                    x--;
                }
        }
    }

    void pivotR() {
        dirI++;

        if (dirI >= directions.length()) {
            dirI = 0;
        }
    }

    void pivotL() {
        dirI = (dirI > 0) ? dirI - 1 : directions.length() - 1;
    }
}
