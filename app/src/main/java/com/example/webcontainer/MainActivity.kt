class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webView)
        val prefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val savedUrl = prefs.getString("saved_url", "")

        // Configurazione WebView
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient()

        if (!savedUrl.isNullOrEmpty()) {
            webView.loadUrl(savedUrl)
        } else {
            // Se non c'è URL salvato, torna alla setup
            startActivity(Intent(this, SetupActivity::class.java))
            finish()
        }
    }
}