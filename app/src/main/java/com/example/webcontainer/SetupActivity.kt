class SetupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup)

        val urlInput = findViewById<EditText>(R.id.urlInput)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val url = urlInput.text.toString().trim()
            if (URLUtil.isValidUrl(url)) {
                // Salva l'URL nelle preferenze
                val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
                prefs.edit().putString("saved_url", url).apply()

                // Avvia la main activity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "URL non valido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}