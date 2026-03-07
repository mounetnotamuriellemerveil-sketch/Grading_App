# Session 2 – Assignments (Flutter)

> Conversion fidèle de `Session_2_Assignments.kt` en projet Flutter/Dart complet.

---

## 📋 Contenu des exercices

| # | Exercice Kotlin | Équivalent Dart |
|---|---|---|
| 1 | `isEven`, `isOdd`, `isPrime` + `processList()` | Prédicats `bool Function(int)` + `where()` |
| 2 | `transforming(words)` – filter + forEach | `where()` + `forEach()` sur `List<String>` |
| 3 | `data class Person` + `complexDataManip()` | Classe Dart avec `==`, `hashCode`, `copyWith()` |

---

## 🗂️ Structure du projet

```
session2_assignments/
├── lib/
│   ├── main.dart                  # Point d'entrée Flutter
│   ├── models/
│   │   ├── person.dart            # Exo 3 – data class Person
│   │   ├── predicates.dart        # Exo 1 – isEven / isOdd / isPrime / processList()
│   │   ├── transforming.dart      # Exo 2 – transforming()
│   │   └── complex_data.dart      # Exo 3 – complexDataManip() + données par défaut
│   ├── screens/
│   │   ├── home_screen.dart       # Écran d'accueil (liste des 3 exercices)
│   │   ├── exo1_screen.dart       # Interface interactive Exercice 1
│   │   ├── exo2_screen.dart       # Interface interactive Exercice 2
│   │   └── exo3_screen.dart       # Interface interactive Exercice 3
│   └── widgets/
│       ├── result_card.dart       # Widget carte de résultat réutilisable
│       └── section_header.dart    # Widget en-tête de section
├── android/                       # Configuration Android (prête pour Android Studio)
│   ├── app/
│   │   ├── build.gradle
│   │   └── src/main/
│   │       ├── AndroidManifest.xml
│   │       ├── kotlin/com/example/session2_assignments/MainActivity.kt
│   │       └── res/values/styles.xml
│   ├── build.gradle
│   ├── gradle.properties
│   └── settings.gradle
├── ios/                           # (dossier vide – généré par flutter create)
├── pubspec.yaml                   # Dépendances Flutter
├── analysis_options.yaml          # Règles lint
└── README.md                      # Ce fichier
```

---

##  Comment ouvrir dans Android Studio

### Prérequis
- **Flutter SDK** ≥ 3.0.0 installé ([flutter.dev](https://flutter.dev/docs/get-started/install))
- **Android Studio** avec le plugin Flutter installé
- **Dart SDK** (inclus avec Flutter)

### Étapes

1. **Cloner / copier** tous les fichiers dans un dossier `session2_assignments/`

2. **Ouvrir le projet** dans Android Studio :
   - `File → Open` → sélectionner le dossier `session2_assignments/`
   - Android Studio détecte automatiquement le projet Flutter

3. **Installer les dépendances** (terminal intégré) :
   ```bash
   flutter pub get
   ```

4. **Lancer l'application** :
   - Connecter un appareil Android ou démarrer un émulateur
   - Cliquer sur ▶ **Run** ou appuyer sur `Shift+F10`
   - Ou depuis le terminal :
     ```bash
     flutter run
     ```

5. **Build APK** (optionnel) :
   ```bash
   flutter build apk --debug
   ```

---

## 🔄 Correspondances Kotlin → Dart

### Exo 1 – Prédicats

| Kotlin | Dart |
|--------|------|
| `val isEven: (Int) -> Boolean = { it % 2 == 0 }` | `bool Function(int) isEven = (n) => n % 2 == 0;` |
| `numbers.filter(predicate)` | `numbers.where(predicate).toList()` |
| `Math.sqrt(n)` | `sqrt(n)` (package `dart:math`) |
| `(2..n).none { ... }` | boucle `for` avec `return false` |

### Exo 2 – Transformation

| Kotlin | Dart |
|--------|------|
| `.filter { it.length < 4 }` | `.where((w) => w.length < 4)` |
| `.forEach { word -> println(...) }` | `.forEach((word) => print(...))` |

### Exo 3 – Data class

| Kotlin | Dart |
|--------|------|
| `data class Person(val name: String, val age: Int)` | `class Person` avec `==`, `hashCode`, `copyWith()` |
| `it.name[0] == 'A'` | `p.name[0] == 'A'` |
| Auto-generated `toString()` | Méthode `toString()` manuelle |

---

## ✅ Bugs corrigés du fichier Kotlin original

| Ligne | Bug original | Correction |
|-------|-------------|------------|
| 5 | `it%2=0` (affectation) | `it % 2 == 0` (comparaison) |
| 9 | `else(2..Math.sqrt(n).none{...}=0)` – syntaxe invalide | Boucle `for` correcte |
| 43 | `ListOf(...)` (majuscule) | `listOf(...)` |
| 28 | `complexDataManip` est une méthode d'instance de `Person` (illogique) | Fonction standalone |

---

## 📱 Aperçu de l'interface

```
┌─────────────────────────────┐
│   Session 2 – Assignments   │
│   Kotlin → Flutter          │
│   Lambdas, Predicates       │
│   & Data Classes            │
├─────────────────────────────┤
│  [01] Predicates &          │
│       processList()  ›      │
├─────────────────────────────┤
│  [02] Word                  │
│       Transformations  ›    │
├─────────────────────────────┤
│  [03] Data Classes &        │
│       Manipulation  ›       │
└─────────────────────────────┘
```

Chaque écran est **interactif** : vous pouvez modifier les données d'entrée et voir les résultats en temps réel.
