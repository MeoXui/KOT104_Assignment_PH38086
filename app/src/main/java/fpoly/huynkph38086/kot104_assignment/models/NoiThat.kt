package fpoly.huynkph38086.kot104_assignment.models

import fpoly.huynkph38086.kot104_assignment.R

data class NoiThat(
    var id: String = "0",
    var anh: Any? = R.drawable.ghe,
    var ten: String = "ghe",
    var gia: Double = 3000.0,
    var mota: String = "Mô tả các thứ..."
)