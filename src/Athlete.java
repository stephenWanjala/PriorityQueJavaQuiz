public record Athlete(String name, int wins) {

    @Override
    public String toString() {
        return name();
    }

}
