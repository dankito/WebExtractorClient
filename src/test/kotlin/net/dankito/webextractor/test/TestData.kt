package net.dankito.webextractor.test

object TestData {

    val Url = "https://www.heise.de/news/Privacy-Guardrail-Chrome-Erweiterung-will-sensible-Daten-vor-Chatbots-schuetzen-11303231.html"

    val Html = """
                      <html>
          <body>
            <h1>Privacy Guardrail: Chrome-Erweiterung will sensible Daten vor Chatbots schützen</h1>
            <p>Wer Texte in KI-Chatbots einfügt, gibt oft unbeabsichtigt sensible Daten weiter. Eine neue Chrome-Erweiterung des DFKI soll das verhindern.</p>
            <graphic src="https://heise.cloudimg.io/width/610/q85.png-lossy-85.webp-lossy-85.foil1/_www-heise-de_/imgs/18/5/0/8/7/0/9/1/1779371373521-821ebd7266a52f28.png" alt="Screenshot &quot;Privacy Guardrail&quot;"/>
            <p>(Bild: DFKI)</p>
            <p>Wer personenbezogene Daten vor dem Einfügen in <a href="https://www.heise.de/thema/Kuenstliche-Intelligenz">KI-Chatdienste</a> schützen möchte, kann eine neue Erweiterung für Chromium-basierte Webbrowser wie Google Chrome einsetzen. Sie heißt Privacy Guardrail und stammt vom Deutschen Forschungszentrum für Künstliche Intelligenz (DFKI) und der RPTU Kaiserslautern-Landau. Die Erweiterung soll personenbezogene Daten lokal im Browser erkennen und anonymisieren. Privacy Guardrail befindet sich derzeit in einem öffentlichen Betatest (Version 0.2.0).</p>
            <h3>Platzhalter statt Klardaten</h3>
            <p><a href="https://www.dfki.de/web/news/privacy-guardrail-fuer-ki-prompts-direkt-im-browser">Beim Einfügen eines Textes</a> fängt die Erweiterung das Paste-Ereignis der Zwischenablage ab und analysiert den Inhalt lokal. Als schützenswert erkannte Informationen ersetzt das System anschließend – noch vor dem Absenden an den KI-Dienst. In den Einstellungen können Nutzer zwischen zwei Ersetzungsmodi wählen: Entweder werden sensible Stellen durch typisierte Platzhalter wie <pre>[EMAIL_1]</pre> oder<pre> [PERSON_1]</pre> ersetzt, oder das System setzt synthetische, realistische aber eindeutig fiktive Werte ein – etwa neutrale Fantasienamen oder standardisierte Testwerte für Kreditkartennummern, IBANs oder IP-Adressen. Der Vorteil synthetischer Werte: Der KI-Dienst erhält natürlich lesbaren Text statt auffälliger Platzhalter-Token.</p>
            <p/>
            <p>Für besonders sensible Kategorien wie Passwörter, URLs und Datumsangaben greift der synthetische Modus laut Quellcode bewusst auf Platzhalter zurück, da die Generierung realistischer Fake-Passwörter oder -URLs als zu riskant eingestuft wird. Die Zuordnung zwischen Originalwert und Ersatzwert verwaltet die Erweiterung in einem lokalen „Identity Vault“ im Browser-Profil – ohne Synchronisierung über Chrome Sync. Dadurch sollen sich KI-Antworten später lokal wieder de-anonymisieren lassen, und Ersetzungen sitzungs- und plattformübergreifend konsistent bleiben.</p>
            <h3>Zwei Erkennungsebenen</h3>
            <p>Technisch kombiniert Privacy Guardrail zwei Verfahren. Eine regelbasierte Engine – in Rust implementiert und zu WebAssembly kompiliert – erkennt strukturierte Daten wie E-Mail-Adressen, Kreditkartennummern, IBANs oder IP-Adressen. Optional ergänzt ein lokales KI-Modell die Erkennung um kontextabhängige Informationen wie Namen, Organisationen oder Adressen. Dabei kommt laut Repository ein multilinguales NER-Modell auf Basis von XLM-RoBERTa zum Einsatz, das 24 europäische Sprachen und 36 Entity-Klassen abdecken soll. Das Modell läuft über ONNX Runtime Web direkt im Browser und nutzt WebGPU zur Beschleunigung, falls verfügbar. Ohne GPU-Unterstützung erfolgt die Ausführung über CPU beziehungsweise WASM, was laut DFKI deutlich langsamer sein kann.</p>
            <p>Videos by heise</p>
            <h3>Hohe Hardwareanforderungen</h3>
            <p>Die lokale KI-Komponente stellt vergleichsweise hohe Anforderungen an die Hardware. Das DFKI empfiehlt mindestens 16 GByte RAM sowie eine WebGPU-fähige GPU. Unter 8 GByte Arbeitsspeicher deaktiviert die Erweiterung die KI-Erkennung automatisch und arbeitet nur noch mit der regelbasierten Mustererkennung.</p>
            <p>Das DFKI weist ausdrücklich auf Einschränkungen hin. Die Erkennung könne sensible Inhalte übersehen oder harmlose Inhalte fälschlich markieren. Kurze Namen, mehrdeutige Begriffe, Tabellen, Codeblöcke oder ungewöhnliche Formatierungen reduzierten die Erkennungsqualität. Privacy Guardrail sei daher keine DLP- oder Compliance-Lösung, sondern eine assistive Schutzschicht.</p>
            <p>Zudem ist die Erweiterung in der aktuellen Beta auf drei Plattformen beschränkt: ChatGPT, Claude und Gemini. Andere KI-Chatdienste, browserbasierte Werkzeuge oder interne Unternehmensanwendungen werden nicht unterstützt.</p>
            <p>Das Entwicklungsteam plant, kleinere Modelle, effizientere Inferenzpfade für ressourcenschwache Geräte sowie weitere Browser und mobile Plattformen zu unterstützen. Der Quellcode der Browsererweiterung <a href="https://github.com/dfki-dsa/pii-guardrail-browser-extension">„Privacy Guardrail“</a> ist auf GitHub unter Apache-2.0-Lizenz verfügbar; die fertige Erweiterung lässt sich direkt aus dem <a href="https://chromewebstore.google.com/detail/privacy-guardrail/mcfmihbghefbeeaapopamagaalkbanmp">Chrome Web Store</a> installieren.</p>
            <p>Siehe auch:</p>
            <ul>
              <li><a href="https://www.heise.de/download/product/privacy-guardrail?wt_mc=intern.red.download.tickermeldung.ho.link.link">Privacy Guardrail</a>bei heise download</li>
            </ul>
            <p>


        (<a href="mailto:vza@heise.de">vza</a>)

        </p>
          </body>
        </html>
    """.trimIndent()

}