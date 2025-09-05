package br.edu.ifsp.scl.ads.prdm.sc3039951.havagas

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class MaskWatcher(private val editText: EditText, private val mask: String) : TextWatcher {
    private var isUpdating = false

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable) {}

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (isUpdating) {
            return
        }

        val unmasked = s.toString().replace("[^\\d]".toRegex(), "")
        val formatted = StringBuilder()
        isUpdating = true

        var unmaskedIndex = 0
        for (maskChar in mask.toCharArray()) {
            if (unmaskedIndex >= unmasked.length) {
                break
            }
            if (maskChar == '#') {
                formatted.append(unmasked[unmaskedIndex])
                unmaskedIndex++
            } else {
                formatted.append(maskChar)
            }
        }

        editText.setText(formatted.toString())
        editText.setSelection(formatted.length)

        isUpdating = false
    }
}