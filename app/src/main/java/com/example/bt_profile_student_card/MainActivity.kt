package com.example.bt_profile_student_card

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bt_profile_student_card.databinding.ActivityMainBinding
import com.example.bt_profile_student_card.model.Student
import com.example.bt_profile_student_card.utils.toast
import com.example.bt_profile_student_card.utils.toAcademicRanking
import com.example.bt_profile_student_card.utils.trimmedText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentStudent = Student(
        id        = "23115053122201",
        name      = "Lê Viết An",
        className = "23T2",
        email     = "23115053122201@ute.udn.vn",
        gpa       = 3.4
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Gán dữ liệu ban đầu lên các Views
        bindStudentData(currentStudent)
        binding.btnUpdateGpa.setOnClickListener {
            val inputStr = binding.edtNewGpa.trimmedText()
            val newGpa   = inputStr.toDoubleOrNull()
            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.edtNewGpa.error = "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"
                toast("Điểm GPA không hợp lệ!")
                return@setOnClickListener
            }
            currentStudent = currentStudent.copy(gpa = newGpa)
            bindStudentData(currentStudent)
            toast("Cập nhật điểm thành công!")
        }
    }


    private fun bindStudentData(student: Student) {
        with(binding) {
            tvName.text      = student.name
            tvStudentId.text = "MSSV: ${student.id} • Lớp: ${student.className}"
            tvGpaBadge.text  = "${student.gpa} GPA (${student.gpa.toAcademicRanking()})"
            edtNewGpa.setText(student.gpa.toString())
        }
    }
}
