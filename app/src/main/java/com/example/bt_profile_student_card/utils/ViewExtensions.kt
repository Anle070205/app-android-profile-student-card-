package com.example.bt_profile_student_card.utils

import android.content.Context
import android.widget.EditText
import android.widget.Toast



// Extension xếp loại học lực từ điểm GPA
fun Double.toAcademicRanking(): String = when {
    this >= 3.6 -> "Xuất sắc"
    this >= 3.2 -> "Giỏi"
    this >= 2.5 -> "Khá"
    else        -> "Trung bình"
}

// Extension hiển thị Toast cho Context
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// Extension lấy text từ EditText đã trim() sẵn
fun EditText.trimmedText(): String = text.toString().trim()
