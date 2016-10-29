package com.example.tennis.score;

public enum PointCall {
    LOVE,             // 0
    FIFTEEN,          // 1
    THIRTY,           // 2 --> FORTY | DEUCE
    FORTY,            // 3 --> GAME
                      // 
    
    ADVANTAGE,        // 4 --> DEUCE | GAME
    DEUCE,            // 5 --> ADVANTAGE
    GAME;             // 6
    
    
//    private int next;
//    
//    PointCall(int next) {
//        this.next = next;
//    }
//    
//    public PointCall addPoint(PointCall opponentPoint) {
//        return null;
//    }
}

/*

2:2
3:2
4:2 WIN         (one>3, diff=+2)

2:2
3:2
3:3 deuce       (sum>5, equal)
4:3 advantage   (sum>6, diff=+1) advantage A
5:3 WIN         (one>3, diff=+2)

2:2
3:2
3:3 deuce       (sum>5, equal)
4:3 advantage   (sum>6, diff=+1) advantage A
4:4 deuce       (sum>5, equal)
4:5 advantage   (sum>6, diff=-1) advantage B
4:6 WIN         (one>3, diff=+2)



(BIGGER, SUM, DIFF)


    kill process if ok:
GAME        is(A, B) --> A>3 && A-B>=2
GAME        is(B, A) --> B>3 && B-A>=2

    return if it:
DEUCE       is(A, B) --> A+B>5 && A==B

    return if it:
ADVANTAGE A is(A, B) --> A+B>6 && A-B=1
ADVANTAGE B is(B, A) --> B+A>6 && B-A=1

    else 
    translate by ordinarity

*/


/*




*/