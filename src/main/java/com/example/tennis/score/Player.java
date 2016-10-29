package com.example.tennis.score;

public enum Player {
    A(1),
    B(-1),
    NO_ONE(0);

    private int nameAsNumber;

    Player(int nameAsNumber) {
        this.nameAsNumber = nameAsNumber;
    }

    public int nameAsNumber() {
        return nameAsNumber;
    }
}
