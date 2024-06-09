package fpoly.huynkph38086.kot104_assignment.nav

import androidx.lifecycle.ViewModel
import fpoly.huynkph38086.kot104_assignment.R
import fpoly.huynkph38086.kot104_assignment.models.ChiTietGioHang
import fpoly.huynkph38086.kot104_assignment.models.GioHang
import fpoly.huynkph38086.kot104_assignment.models.NoiThat
import fpoly.huynkph38086.kot104_assignment.models.TaiKhoan

class VModel : ViewModel() {
    val uesrs: ArrayList<TaiKhoan> = arrayListOf(TaiKhoan("admin", "admin"))
    val products: ArrayList<NoiThat> = arrayListOf(
        NoiThat("0", R.drawable.ghe, "Ghế", 1200.0, "Siêu thoải mái, chất lượng cao"),
        NoiThat("1", R.drawable.ban, "Bàn", 2200.0, "Siêu bàn"),
        NoiThat("2", R.drawable.quat, "Quạt", 300.0, "Siêu mái lạnh... thấu xương"),
        NoiThat("3", R.drawable.den, "Đèn", 123456.7, "Siêu mạnh, nhìn vô là mù"),
        NoiThat("4", R.drawable.giuong, "Giường", 5335521.98, "Tặng còm một con ma dười gầm"),
        NoiThat("5", R.drawable.ban_ghe, "Bàn ghế nguyên bộ", 30000.0, "3 lạng 1 cần, ko thiểu ko lấy tiền")
    )
    var gioHang: GioHang = GioHang()

    fun getUserBy(un: String): TaiKhoan? {
        for(i in uesrs)
            if (i.un == un) return i
        return null
    }

    fun addUser(un: String, pw: String): Boolean {
        if (getUserBy(un) != null) return false
        uesrs.add(TaiKhoan(un, pw))
        return true
    }

    fun getProductBy(id: String?): NoiThat? {
        for (i in products)
            if (i.id == id) return i
        return null
    }

    fun addProduct(item: NoiThat): Boolean {
        item.id = "${products.size}"
        products.add(item)
        return true
    }

    fun updateProduct(newItem: NoiThat): Boolean {
        val oldItem = getProductBy(newItem.id) ?: return false
        val index = products.indexOf(oldItem)
        products[index].anh = newItem.anh
        products[index].ten = newItem.ten
        products[index].gia = newItem.gia
        return true
    }

    fun deleteProduct(id: String): Boolean {
        val item = getProductBy(id) ?: return false
        products.remove(item)
        return true
    }

    fun addCart(item: NoiThat) {
        gioHang.list.add(ChiTietGioHang(item))
    }

    fun newCart() {
        gioHang = GioHang()
    }
}