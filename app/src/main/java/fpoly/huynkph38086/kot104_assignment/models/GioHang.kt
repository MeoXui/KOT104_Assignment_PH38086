package fpoly.huynkph38086.kot104_assignment.models

data class GioHang(
    var list: ArrayList<ChiTietGioHang> = arrayListOf()
) {
    fun getTongTien(): Double {
        var tt = 0.0
        for (item in list)
            tt += item.noiThat.gia * item.soLuong
        return tt
    }
}
