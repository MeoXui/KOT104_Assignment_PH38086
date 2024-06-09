package fpoly.huynkph38086.kot104_assignment.models

data class TaiKhoan(
    var un: String,
    private var pw: String
) {
    fun check(pw: String): Boolean {
        return pw == this.pw
    }

    fun isNaN(): Boolean {
        return this == NaNUser
    }

    companion object {
        val NaNUser = TaiKhoan("", "")
    }
}
