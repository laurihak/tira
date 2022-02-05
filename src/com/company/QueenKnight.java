import java.lang.reflect.Constructor;
import java.util.Arrays;

public class QueenKnight {
    public int count(int n) {
        int safeSpaces = 0;
        Queen q = new Queen();
        Knight k = new Knight();


        for (int kx = 0; kx < n; kx++) {
            for (int ky = 0; ky < n; ky++) {
//                Knight loop

                for (int qx = 0; qx < n; qx++) {
                    for (int qy = 0; qy < n; qy++) {
//                        Queen loop
                        k.setXAndY(kx, ky);
                        q.setXAndY(qx, qy);

                        boolean qCanAttack = q.canAttack(k.x, k.y);
                        boolean kCanAttack = k.canAttack(q.x, q.y);

                        if (qCanAttack == false & kCanAttack == false) safeSpaces++;
                    }
                }
            }
        }

        return safeSpaces;

    }


    public class Queen {
        int x;
        int y;

        public Queen() {

        }

        public void setXAndY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canAttack(int targetX, int targetY) {
//            same x
            if (this.x == targetX) return true;
//            same y
            if (this.y == targetY) return true;

//            diagonal
            int target = Math.abs(this.x - targetX);
            int own = Math.abs(this.y - targetY);


            if (target == own) {
                return true;
            }
            return false;
        }
    }

    public class Knight {
        int x;
        int y;

        public Knight() {

        }

        public void setXAndY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean canAttack(int targetX, int targetY) {
            int xDiff = Math.abs(this.x - targetX);
            int yDiff = Math.abs(this.y - targetY);

            if (xDiff == 2 && yDiff == 1) return true;
            if (xDiff == 1 && yDiff == 2) return true;

            return false;
        }

    }

    public static void main(String[] args) {
        QueenKnight q = new QueenKnight();
        System.out.println(q.count(3)); // 0
        System.out.println(q.count(4)); // 40
        System.out.println(q.count(5)); // 184
    }
}