@echo off
REM Run Assignment 3 ETL (requires javac and java in PATH)
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -classpath src -d out src\org\howard\edu\lsp\assignment3\*.java
if errorlevel 1 exit /b 1
java -classpath out org.howard.edu.lsp.assignment3.ETLApp
pause
