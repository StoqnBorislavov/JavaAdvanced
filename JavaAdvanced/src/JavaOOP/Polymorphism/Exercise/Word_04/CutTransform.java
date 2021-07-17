package JavaOOP.Polymorphism.Exercise.Word_04;

public class CutTransform implements TextTransform{

    private StringBuilder lastCut;

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut = new StringBuilder();
        lastCut.append(text, startIndex, endIndex);
        text.delete(startIndex, endIndex);

    }

    public StringBuilder getLastCut() {
        return lastCut;
    }
}
