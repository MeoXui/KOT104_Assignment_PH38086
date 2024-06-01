package fpoly.huynkph38086.kot104_assignment.thu_vien_rieng

public infix fun Int.upTo(to: Int): IntProgression {
    return IntProgression.fromClosedRange(this, to, 1)
}