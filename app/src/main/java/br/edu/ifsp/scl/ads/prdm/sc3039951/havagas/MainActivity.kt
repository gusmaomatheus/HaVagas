package br.edu.ifsp.scl.ads.prdm.sc3039951.havagas

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import br.edu.ifsp.scl.ads.prdm.sc3039951.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.addMobileCheckbox.setOnCheckedChangeListener { _, isChecked ->
            binding.mobileLayout.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        binding.educationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                binding.elementaryHighSchoolLayout.visibility = View.GONE
                binding.undergradSpecializationLayout.visibility = View.GONE
                binding.mastersPhdLayout.visibility = View.GONE

                when (position) {
                    1, 2 -> {
                        binding.elementaryHighSchoolLayout.visibility = View.VISIBLE
                    }
                    3, 4 -> {
                        binding.undergradSpecializationLayout.visibility = View.VISIBLE
                    }
                    5, 6 -> {
                        binding.mastersPhdLayout.visibility = View.VISIBLE
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.clearButton.setOnClickListener {
            clearForm()
        }

        binding.saveButton.setOnClickListener {
            buildAndShowSummaryDialog()
        }

        binding.birthDateEditText.addTextChangedListener(MaskWatcher(binding.birthDateEditText, "##/##/####"))
        binding.phoneEditText.addTextChangedListener(MaskWatcher(binding.phoneEditText, "(##) #####-####"))
        binding.mobileEditText.addTextChangedListener(MaskWatcher(binding.mobileEditText, "(##) #####-####"))
    }

    private fun clearForm() {
        val rootLayout = binding.rootLayout as ViewGroup
        rootLayout.children.filterIsInstance<EditText>().forEach { it.text.clear() }

        binding.phoneTypeRadioGroup.clearCheck()
        binding.genderRadioGroup.clearCheck()
        binding.receiveEmailsCheckbox.isChecked = false
        binding.addMobileCheckbox.isChecked = false
        binding.educationSpinner.setSelection(0)
    }

    private fun buildAndShowSummaryDialog() {
        val summaryBuilder = StringBuilder()

        summaryBuilder.append("Nome: ${binding.fullNameEditText.text}\n")
        summaryBuilder.append("E-mail: ${binding.emailEditText.text}\n")
        summaryBuilder.append("Receber E-mails: ${if (binding.receiveEmailsCheckbox.isChecked) "Sim" else "Não"}\n\n")

        summaryBuilder.append("Telefone: ${binding.phoneEditText.text}\n")
        val phoneTypeId = binding.phoneTypeRadioGroup.checkedRadioButtonId
        if (phoneTypeId != -1) {
            val phoneType = if (phoneTypeId == R.id.commercialRadioButton) "Comercial" else "Residencial"
            summaryBuilder.append("Tipo do Telefone: $phoneType\n")
        }

        if (binding.addMobileCheckbox.isChecked) {
            summaryBuilder.append("Celular: ${binding.mobileEditText.text}\n\n")
        }

        val genderId = binding.genderRadioGroup.checkedRadioButtonId
        if (genderId != -1) {
            val gender = if (genderId == R.id.maleRadioButton) "Masculino" else "Feminino"
            summaryBuilder.append("Sexo: $gender\n")
        }
        summaryBuilder.append("Data de Nascimento: ${binding.birthDateEditText.text}\n\n")

        val selectedEducation = binding.educationSpinner.selectedItem.toString()
        if (binding.educationSpinner.selectedItemPosition > 0) {
            summaryBuilder.append("Formação: $selectedEducation\n")
            when (binding.educationSpinner.selectedItemPosition) {
                1, 2 -> {
                    summaryBuilder.append("Ano de Formatura: ${binding.graduationYearEditText.text}\n")
                }
                3, 4 -> {
                    summaryBuilder.append("Ano de Conclusão: ${binding.undergradCompletionYearEditText.text}\n")
                    summaryBuilder.append("Instituição: ${binding.undergradInstitutionEditText.text}\n")
                }
                5, 6 -> {
                    summaryBuilder.append("Ano de Conclusão: ${binding.mastersCompletionYearEditText.text}\n")
                    summaryBuilder.append("Instituição: ${binding.mastersInstitutionEditText.text}\n")
                    summaryBuilder.append("Título da Monografia: ${binding.thesisTitleEditText.text}\n")
                    summaryBuilder.append("Orientador: ${binding.advisorEditText.text}\n")
                }
            }
        }
        summaryBuilder.append("\nVagas de Interesse: ${binding.jobsInterestEditText.text}")

        AlertDialog.Builder(this)
            .setTitle(getString(R.string.registered_data_title))
            .setMessage(summaryBuilder.toString())
            .setPositiveButton(getString(R.string.ok_button), null)
            .show()
    }
}