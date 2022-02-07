import java.util.Arrays;

public class Rectangles {
    public long area(int rec1[], int rec2[], int rec3[]) {
        Rec rec1A = new Rec(rec1[0], rec1[1], rec1[2], rec1[3]);
        Rec rec2A = new Rec(rec2[0], rec2[1], rec2[2], rec2[3]);
        Rec rec3A = new Rec(rec3[0], rec3[1], rec3[2], rec3[3]);

        long totalArea = rec1A.getArea() + rec2A.getArea() + rec3A.getArea();


        long overlap1 = calculateOverLap(rec1A, rec2A);
        long overlap2 = calculateOverLap(rec1A, rec3A);
        long overlap3 = calculateOverLap(rec2A, rec3A);


        long totalOverlap = overlap1 + overlap2 + overlap3;


        long overLapInMany = calculateOverLap3(rec1A, rec2A, rec3A);

        System.out.println("totalArea: " + totalArea);
        System.out.println("totalOverLap: " + totalOverlap);
        System.out.println("overlapInMany: " + overLapInMany);

        return totalArea - (totalOverlap - overLapInMany);
    }

    public class Rec {
        int x1;
        int y1;
        int x2;
        int y2;

        public Rec(int x1,
                   int y1,
                   int x2,
                   int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public long getArea() {
            long height = Math.abs(this.x1 - this.x2);
            long width = Math.abs(this.y1 - this.y2);

            return height * width;
        }


    }

    public boolean overlaps(Rec rec1A, Rec rec2A) {
        if (
                rec2A.x2 < rec1A.x1 ||
                        rec1A.x2 < rec2A.x1 ||
                        rec2A.y1 < rec1A.y2 ||
                        rec1A.y1 < rec2A.y2) {
            return false;
        }

        return true;
    }

    public long calculateOverLap(Rec r1, Rec r2) {
        if (!overlaps(r1, r2)) {
            return 0;
        }
        long x1Max = Arrays.asList(r1.x1, r2.x1).stream().max(Integer::compare).get();
        long x2Min = Arrays.asList(r1.x2, r2.x2).stream().min(Integer::compare).get();

        long y1Min = Arrays.asList(r1.y1, r2.y1).stream().min(Integer::compare).get();
        long y2Max = Arrays.asList(r1.y2, r2.y2).stream().max(Integer::compare).get();

        long width = Math.abs(x1Max - x2Min);
        long height = Math.abs(y1Min - y2Max);

        long overlap = width * height;

        System.out.println("overlap: " + overlap);

        return overlap;
    }

    public long calculateOverLap3(Rec r1, Rec r2, Rec r3) {
        if (!overlaps(r1, r2) || !overlaps(r1, r3) || !overlaps(r2, r3)) {
            return 0;
        }
        long x1Max = Arrays.asList(r1.x1, r2.x1, r3.x1).stream().max(Integer::compare).get();
        long x2Min = Arrays.asList(r1.x2, r2.x2, r3.x2).stream().min(Integer::compare).get();

        long y1Min = Arrays.asList(r1.y1, r2.y1, r3.y1).stream().min(Integer::compare).get();
        long y2Max = Arrays.asList(r1.y2, r2.y2, r3.y2).stream().max(Integer::compare).get();

        long width = Math.abs(x1Max - x2Min);
        long height = Math.abs(y1Min - y2Max);

        long overlap = width * height;

        return overlap;
    }


    public static void main(String[] args) {
        Rectangles r = new Rectangles();
        int[] rec1 = {-1, 1, 1, -1};
        int[] rec2 = {0, 3, 2, 0};
        int[] rec3 = {0, 2, 3, -2};
        System.out.println(r.area(rec1, rec2, rec3)); // 16

        int[] rec4 = {-3, 1, 0, -1};
        int[] rec5 = {-2, 3, 2, -1};
        int[] rec6 = {-2, -2, 3, -3};
        System.out.println(r.area(rec4, rec5, rec6)); // 20

        int[] rec7 = {-1, 3, 3, -2};
        int[] rec8 = {0, 3, 1, 1};
        int[] rec9 = {2, 2, 3, 0};
        System.out.println(r.area(rec7, rec8, rec9)); // 23

        int[] rec11 = {421578540, 912771945, 808983183, 30579641};
        int[] rec12 = {71370178, -171698484, 442211407, -180513665};
        int[] rec13 = {-301817202, 444395221, 657943253, 118275404};

        System.out.println(r.area(rec11, rec12, rec13)); //  580948114143984135
    }
}