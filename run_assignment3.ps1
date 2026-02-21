# Run Assignment 3 ETL (requires javac and java in PATH)
Set-Location $PSScriptRoot
if (-not (Test-Path out)) { New-Item -ItemType Directory -Path out | Out-Null }
& javac -encoding UTF-8 -classpath src -d out src\org\howard\edu\lsp\assignment3\*.java
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
& java -classpath out org.howard.edu.lsp.assignment3.ETLApp
