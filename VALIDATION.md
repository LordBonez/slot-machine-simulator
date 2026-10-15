# Validation — October 15, 2026

- Windows x64, JDK 24, Maven 3.9.11; Java compiler target 17.
- `mvn clean package`: successful.
- All four Java source files compile, and all 11 PNG resources are present in the resulting JAR.
- The portfolio copy replaces personal class identifiers with neutral names, adds a Maven launcher, and loads images from the classpath. The original payout and randomization logic is retained.
- The desktop interface has not been manually exercised during this preparation; no gameplay test-suite pass rate is claimed.
- Source filenames, source text, image metadata, and commit identity are checked before publication. Generated binaries and IDE files are excluded from Git.
