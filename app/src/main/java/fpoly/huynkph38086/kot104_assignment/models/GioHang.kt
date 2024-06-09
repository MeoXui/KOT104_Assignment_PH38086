package fpoly.huynkph38086.kot104_assignment.models

import fpoly.huynkph38086.kot104_assignment.models.TaiKhoan.Companion.NaNUser

data class GioHang(
    var list: ArrayList<ChiTietGioHang> = arrayListOf(),
    var ngMua: TaiKhoan = NaNUser
) {
    fun getTongTien(): Double {
        var tt = 0.0
        for (item in list)
            tt += item.noiThat.gia * item.soLuong
        return tt
    }
}
