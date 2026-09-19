class AttendanceSheet {
    private String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int maxStudents) {
        presentStudents = new String[maxStudents];
        presentCount = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
        }
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}