package br.edu.ifsp.scl.ads.prdm.sc3039951.havagas

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class MaskWatcher(private val editText: EditText, private val mask: String) : TextWatcher {
    private var isUpdating = false
    private var oldText = ""

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        val str = s.toString().replace("[^\\d]".toRegex(), "")
        var result = ""

        if (isUpdating || str == oldText) {
            return
        }

        isUpdating = true
        var i = 0
        for (m in mask.toCharArray()) {
            if ((m != '#') && (str.length > oldText.length)) {
                result += m
                continue
            }
            try {
                result += str[i]
            } catch (e: Exception) {
                break
            }
            i++
        }

        editText.setText(result)
        editText.setSelection(result.length)

        isUpdating = false
    }

    override fun afterTextChanged(s: Editable) {}
}